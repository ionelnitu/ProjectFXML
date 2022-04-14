package org.example;


public class Person {


    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer speed;
    private String bandwidth;
    private String duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Person() {

    }

    public Person(String firstName, String lastName, String address, Integer speed, String bandwidth, String duration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speed = speed;
        this.bandwidth = bandwidth;
        this.duration = duration;
    }
    public Person(int id,String firstName, String lastName, String address, Integer speed, String bandwidth, String duration){
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speed = speed;
        this.bandwidth = bandwidth;
        this.duration = duration;
    }

}
