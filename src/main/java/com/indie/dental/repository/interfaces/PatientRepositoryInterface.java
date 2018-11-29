package com.indie.dental.repository.interfaces;

import com.google.gson.JsonObject;
import com.indie.dental.entity.PatientDetail;

import java.util.List;

public interface PatientRepositoryInterface {
    List<PatientDetail> getAllPatient();
    List<PatientDetail> getPatientByCriteria(JsonObject jsonObject);
    PatientDetail getPatientByIdPk(Long idPk);
    int savePatientData(JsonObject jsonObject);
}
