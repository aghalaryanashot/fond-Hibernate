package com.example.fond.service;

import com.example.fond.domain.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobInfoRepo extends JpaRepository <JobInfo, Long> {
}
