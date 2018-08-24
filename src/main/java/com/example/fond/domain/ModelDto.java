package com.example.fond.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class ModelDto {

    private List<Person> persons;
    private List<Company> companies;
    private List<JobInfo> jobInfos;

    private List<Object> objects;
}
