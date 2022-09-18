package com.microservice.vaccinationcenter.Repository;

import com.microservice.vaccinationcenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

}
