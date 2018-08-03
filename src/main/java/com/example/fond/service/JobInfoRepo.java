package com.example.fond.service;

import com.example.fond.domain.JobInfo;
import org.springframework.data.repository.CrudRepository;

public interface JobInfoRepo extends CrudRepository<JobInfo,Long> {
}
