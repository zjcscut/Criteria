package cn.ppfix.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/18-0:56
 */
@Entity
@Table(name = "employee", catalog = "hibernate3")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int age;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;


    public Employee() {
    }

    public Employee(String name, int age, Date birthday, Department department) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.department = department;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
