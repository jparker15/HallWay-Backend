package com.careerdevs.myHalwayLocker.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Developer {
    @Id @GeneratedValue private Long id;

    @OneToOne
    @JoinColumn(name = "locker_id", referencedColumnName = "id")
    private Locker locker;

    private String firstName;
    private String lastName;

    public Developer() {}

    public Developer(Locker locker, String firstName, String lastName) {
        this.locker = locker;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
}
