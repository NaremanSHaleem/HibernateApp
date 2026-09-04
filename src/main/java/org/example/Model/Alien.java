package org.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "aliens")
public class Alien {
    @Id
    int id;
    String name;
    int age;
    @Column(name = "technology")
    String tech;
    @Transient
    String gender;

    @OneToOne
    Laptop laptop;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tech='" + tech + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
