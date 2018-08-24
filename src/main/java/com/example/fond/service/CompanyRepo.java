package com.example.fond.service;

import com.example.fond.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository <Company, Long> {
}
