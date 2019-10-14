package com.sayrunjah.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "age")
    @NotEmpty
    private String age;

    public User() {

    }

    public User(@NotEmpty String name, @NotEmpty String age) {
        this.name = name;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void merge(User user) {
        setName(user.name);
        setAge(user.age);
    }
}
