package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.DoctorEntity;

public interface IDoctorRepositoryP extends PagingAndSortingRepository<DoctorEntity, Integer> {

}
