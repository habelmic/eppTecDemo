package epptec.demo.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String position;
    private LocalDate birthday;
    //@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Employee manager;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> managedEmployees = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, String position, LocalDate birthday) {
        this.name = name;
        this.position = position;
        this.birthday = birthday;
    }
}
