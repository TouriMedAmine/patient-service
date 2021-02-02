package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.service.entity.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	@Query("select p from Patient p where p.cin like :x")
	public Patient chercherPatientParCIN(@Param("x")String cin);
}
