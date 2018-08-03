package com.example.fond.service;

import com.example.fond.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company,Long> {
}
