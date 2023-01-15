package com.devcarlos.employe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcarlos.employe.entities.Employe;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
