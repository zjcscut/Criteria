package cn.ppfix.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/18-0:50
 */
@Entity
@Table(name = "department", catalog = "hibernate3")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {
    }

    public Department(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
