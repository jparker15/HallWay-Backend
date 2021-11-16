package com.careerdevs.myHalwayLocker.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Locker {
    @Id @GeneratedValue private Long id;
    private String name;

//    @OneToOne
//    private Student student;

//    @OneToMany
//    @JoinColumn(name = "locker_id", referencedColumnName = "id")
//    private List<Stuff> myStuff;

    public Locker() {
    }

//    public Locker(Student student) {
//        this.student = student;
//    }
    public Locker(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){return name;}

    public void setName(String name) {this.name = name;}


//    public Student getStudent() {
//        return student;
//    }

//    public void setStudent(Student student) {
//        this.student = student;
//    }
}
