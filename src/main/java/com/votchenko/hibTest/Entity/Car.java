package com.votchenko.hibTest.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;


    public Car() {
    }

    public Car(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
