package com.example.fond.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "person")
@ApiModel(description="О человеке  ")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @NotNull
    @ApiModelProperty(notes="Имя должно быть как минимум 2 символа")
    @Size(min=2, message="Имя должно содержать не менее двух символов")
    private String firstName;
    @NotNull
    @ApiModelProperty(notes="Фамилия должна иметь по крайней мере 2 символа")
    @Size(min=2, message="Фамилия должно содержать не менее двух символов")
    private String lastName;
    private String patronymic;
    @NotNull
    private long inn;
    @NotNull
    private long snils;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public Person() {
    }

    public Person(long id, @NotNull String firstName, @NotNull String lastName, String patronymic, @NotNull long inn, @NotNull long snils, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.inn = inn;
        this.snils = snils;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(@NotNull String firstName, @NotNull String lastName, String patronymic, @NotNull long inn, @NotNull long snils, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.inn = inn;
        this.snils = snils;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(@NotNull String firstName, @NotNull String lastName, @NotNull long inn, @NotNull long snils, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.inn = inn;
        this.snils = snils;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public long getSnils() {
        return snils;
    }

    public void setSnils(long snils) {
        this.snils = snils;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
