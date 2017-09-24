package com.votchenko.hibTest.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Driver")
public class Driver {


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "driver_car",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> carSet = new HashSet<>();

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public void addCar(Car car){
        carSet.add(car);
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "driverLicenseNumber")
    private long driverLicenseNumber;


    public Driver(String name, String lastName, long driverLicenseNumber) {
        this.name = name;
        this.lastName = lastName;
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(long driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (id != driver.id) return false;
        if (driverLicenseNumber != driver.driverLicenseNumber) return false;
        if (carSet != null ? !carSet.equals(driver.carSet) : driver.carSet != null) return false;
        if (name != null ? !name.equals(driver.name) : driver.name != null) return false;
        return lastName != null ? lastName.equals(driver.lastName) : driver.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = carSet != null ? carSet.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (driverLicenseNumber ^ (driverLicenseNumber >>> 32));
        return result;
    }
}
