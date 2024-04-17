package cs489.apsd.lab9.service.impl;

import cs489.apsd.lab9.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdsDentalSurgeryUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    public AdsDentalSurgeryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found for " + username));
        return userDetails;
    }
}
