package com.microservice.ctitzenservice.Repository;

import com.microservice.ctitzenservice.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

      List<Citizen> findByVaccinationCenterId(Integer id);
}
