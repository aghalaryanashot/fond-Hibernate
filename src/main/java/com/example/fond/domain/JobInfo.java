package com.example.fond.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class JobInfo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id")
    @NotNull
    private Person person;
    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id")
    @NotNull
    private Company company;

    @NotNull
    private int baseRate;
    @Temporal(TemporalType.DATE)
    private Date dateArrival;
    @Temporal(TemporalType.DATE)
    private Date dateExit;

    public JobInfo() {
    }

    public JobInfo(long id, @NotNull Person person, @NotNull Company company, @NotNull int baseRate, Date dateArrival, Date dateExit) {
        this.id = id;
        this.person = person;
        this.company = company;
        this.baseRate = baseRate;
        this.dateArrival = dateArrival;
        this.dateExit = dateExit;
    }

    public JobInfo(@NotNull Person person, @NotNull Company company, @NotNull int baseRate, Date dateArrival, Date dateExit) {
        this.person = person;
        this.company = company;
        this.baseRate = baseRate;
        this.dateArrival = dateArrival;
        this.dateExit = dateExit;
    }

    public JobInfo(@NotNull Person person, @NotNull Company company, @NotNull int baseRate, Date dateArrival) {
        this.person = person;
        this.company = company;
        this.baseRate = baseRate;
        this.dateArrival = dateArrival;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setDateExit(Date dateExit) {
        this.dateExit = dateExit;
    }
}
