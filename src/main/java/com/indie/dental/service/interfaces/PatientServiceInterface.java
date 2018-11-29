package com.indie.dental.service.interfaces;

import com.google.gson.JsonObject;
import com.indie.dental.entity.PatientDetail;

import java.util.List;

public interface PatientServiceInterface {
    List<PatientDetail> getAllPatient();
    PatientDetail getPatientByIdPk(Long idPk);
    List<PatientDetail> getPatientByCri(JsonObject jsonObject);
    void savePatientData(JsonObject jsonObject);
}
