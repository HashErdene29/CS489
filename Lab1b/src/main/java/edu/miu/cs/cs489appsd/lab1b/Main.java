package edu.miu.cs.cs489appsd.lab1b;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PensionPlan pensionPlan1 = new PensionPlan("EX1089", "2023-01-17", 100.00f);
        PensionPlan pensionPlan2 = new PensionPlan("SM2307", "2019-11-04", 1555.50f);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(0001L, "Daniel", "Agar", "2018-01-17", 105945.50f, pensionPlan1));
        employeeList.add(new Employee(0002L, "Benard", "Shaw", "2018-10-03", 197750.00f));
        employeeList.add(new Employee(0003L, "Carly", "Agar", "2014-05-16", 842000.75f, pensionPlan2));
        employeeList.add(new Employee(0004L, "Wesley", "Schneider", "2018-11-02", 74500f));
        employeeList.add(new Employee(0005L, "Tom", "Smith", "2024-04-11", 54000f ));

        Collections.sort(employeeList, Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));
        printEmployees(employeeList);
        upcomingEnrollees(employeeList);
    }

    public static void printEmployees (List<Employee> employeeList){
         System.out.println("Printed in JSON format");
        System.out.println("[");
        JSONArray jsonArray = new JSONArray(employeeList);
        for(int i =0; i < jsonArray.length(); i++){
            System.out.printf("\t" + "{  ");
            JSONObject innerobj = jsonArray.getJSONObject(i);
            for(Iterator it = innerobj.keys(); it.hasNext(); ){
                String key = (String) it.next();
                System.out.printf("'" + key + "'" + ":" + innerobj.get(key) + ",  ");
            }
            System.out.println("  }" );
        }
        System.out.println("]");
        System.out.println("--------------------------------------------");
    }

    public static void upcomingEnrollees (List<Employee> employeeList){
        LocalDate nextMonthFirstDay = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth().plus(1), 1);
        LocalDate nextMonthLastDay = nextMonthFirstDay.withDayOfMonth(nextMonthFirstDay.lengthOfMonth());

        List<Employee> upcomingEmployees = new ArrayList<>();
        for (Employee e: employeeList){
            LocalDate employmentDate = e.getEmploymentDate().plusYears(5);
            if(employmentDate.isBefore(nextMonthLastDay) &&
                    e.getPensionPlan() == null
            ) {
                upcomingEmployees.add(e);
            }
        }
        Collections.sort(upcomingEmployees, Comparator.comparing(Employee::getEmploymentDate));
        printEmployees(upcomingEmployees);
    }
}