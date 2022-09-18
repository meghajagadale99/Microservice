package com.microservice.vaccinationcenter.Model;

import com.microservice.vaccinationcenter.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizens;
}
