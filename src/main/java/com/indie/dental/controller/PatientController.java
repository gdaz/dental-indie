package com.indie.dental.controller;

import com.google.gson.JsonParser;
import com.indie.dental.entity.PatientDetail;
import com.indie.dental.exception.MapErrorCode;
import com.indie.dental.exception.PatientNotFound;
import com.indie.dental.exception.PatientNotFoundErrorCode;
import com.indie.dental.service.interfaces.PatientServiceInterface;
import com.indie.dental.utils.ResponseInternalError;
import com.indie.dental.utils.ResponseNoContent;
import com.indie.dental.utils.ResponseOK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
//@Controller
public class PatientController {

    private final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientServiceInterface patientServiceInterface;

//    @RequestMapping("/")
//    public String home(Map<String, Object> model) {
//        model.put("message", "HowToDoInJava Reader !!");
//        return "index";
//    }

//    @CrossOrigin(origins = "*")
//    @ResponseBody
    @RequestMapping(value = "/allPatient",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> getAllPatient() {
        List<PatientDetail> allPatient = patientServiceInterface.getAllPatient();
        try {
//            throw new PatientNotFound();
            if (allPatient.isEmpty()) {
                return new ResponseNoContent().responseBody("ไม่พบข้อมูล");
            } else {
                return new ResponseOK().responseBody(allPatient);
            }
        } catch (PatientNotFound e) {
            int jsonStatus = new MapErrorCode().getErrorDescription(new PatientNotFoundErrorCode());
            logger.info("jsonStatus: " + jsonStatus);
            return new ResponseInternalError().responseBody(jsonStatus);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/patient/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> getPatientByIdPk(@PathVariable("id") Long idPk) {
        logger.debug("idPk: " + idPk);
        PatientDetail patient = patientServiceInterface.getPatientByIdPk(idPk);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/patientCri",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> getPatientByCriteria(@RequestParam(value = "requestMsg") String requestMsg) {
        logger.debug("requestMsg: " + requestMsg);
        JsonParser jsonParser = new JsonParser();
        List<PatientDetail> patient = patientServiceInterface.getPatientByCri(jsonParser.parse(requestMsg).getAsJsonObject());
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/savePatient",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> savePatientData(@RequestParam(value = "requestMsg") String requestMsg) {
        logger.debug("requestMsg: " + requestMsg);
        JsonParser jsonParser = new JsonParser();
        patientServiceInterface.savePatientData(jsonParser.parse(requestMsg).getAsJsonObject());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
