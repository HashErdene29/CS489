package cs489.apsd.lab9;

import cs489.apsd.lab9.model.*;
import cs489.apsd.lab9.repository.*;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Lab9Application {
    private UserRepository userRepo;
    private RoleRepository roleRepo;
    private PasswordEncoder passwordEncoder;

    public Lab9Application(UserRepository _userRepo, RoleRepository _roleRepo, PasswordEncoder _passwordEncoder) {
        this.userRepo = _userRepo;
        this.roleRepo = _roleRepo;
        this.passwordEncoder = _passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab9Application.class, args);
    }

    @PostConstruct
    public void init() {
        var adminUser = userRepo.findByUsername("admin");
        if(adminUser.isEmpty()) {
            List<Role> adminRoles = new ArrayList<>();
            var adminRole = roleRepo.findByName("ROLE_ADMIN");
            if(adminRole.isEmpty()) {
                var newAdminRole = new Role("ROLE_ADMIN");
                adminRoles.add(newAdminRole);
            } else {
                adminRoles.add(adminRole.get());
            }
            User newAdminUser = new User(null, "Admin", "Admin", "Admin", "admin",
                    passwordEncoder.encode("test1234"), "admin@fairfieldlibrary.com",
                    true,true, true, true);
            newAdminUser.setRoles(adminRoles);
            userRepo.save(newAdminUser);

        }
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("Hello RESTful Web API");
            System.out.println("CityLibrary WebAPI server. Starting...");
            System.out.println("CityLibrary WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8080");
            System.out.println("To see list of Publishers, send HTTP GET Request to the URI,\nhttp://localhost:8080/citylibrary/api/v1/publisher/list");
        };
    }

}
