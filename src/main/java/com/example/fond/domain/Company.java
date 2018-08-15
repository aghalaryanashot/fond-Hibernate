package com.example.fond.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@ApiModel(description="О компание")
public class Company {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @NotNull
    @ApiModelProperty(notes="Названия компаний должна быть больше 1 символа")
    @Size(min=2, message="Названия должно содержать не менее двух символов")
    private String name;

    public Company() {
    }

    public Company(@NotNull String name) {
        this.name = name;
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
}
