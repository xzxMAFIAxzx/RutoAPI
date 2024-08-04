package bean;

import lombok.Data;
import lombok.SneakyThrows;

import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import static javax.management.remote.JMXConnectorFactory.connect;

public class User {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date brithDate;
    private Nationality nationality;
    private Nationality birthPlace;

    public User() {
    }

    public User(int id, String name, String surname, String phone, String email, Date brithDate, Nationality nationality, Nationality birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.brithDate = brithDate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Nationality getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Nationality birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", brithDate=" + brithDate +
                ", nationality=" + nationality +
                ", birthPlace=" + birthPlace +
                '}';
    }
}
