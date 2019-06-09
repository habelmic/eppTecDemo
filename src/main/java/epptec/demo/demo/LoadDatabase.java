package epptec.demo.demo;

import epptec.demo.demo.model.Employee;
import epptec.demo.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Autowired EmployeeRepository repository) {

        // Create Employeees
        Employee micB = new Employee("Michael Brown", "Director", LocalDate.parse("1964-05-01"));
        Employee marB = new Employee("Martin Black", "Team leader", LocalDate.parse("1964-05-01"));
        Employee petW = new Employee("Peter White", "Team leader", LocalDate.parse("1964-05-01"));
        Employee lisB = new Employee("Lisa Blue", "Secretary", LocalDate.parse("1964-05-01"));
        Employee tanR = new Employee("Tanya Red", "Team member", LocalDate.parse("1964-05-01"));
        Employee geoG = new Employee("George Green", "Team member", LocalDate.parse("1964-05-01"));
        Employee marT = new Employee("Mark Twain", "Team member", LocalDate.parse("1964-05-01"));

        // Manage relations
        marB.getManagedEmployees().add(tanR);
        marB.getManagedEmployees().add(geoG);
        petW.getManagedEmployees().add(marT);
        micB.getManagedEmployees().add(marB);
        micB.getManagedEmployees().add(petW);
        micB.getManagedEmployees().add(lisB);

        repository.save(micB);


        return args -> {
            log.info("Preloaded database successfully.");
        };
    }
}
