package com.indie.dental.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.indie.dental.entity.PatientDetail;
import com.indie.dental.repository.interfaces.PatientRepositoryInterface;
import com.indie.dental.service.interfaces.PatientServiceInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImp implements PatientServiceInterface {

    private final Logger logger = LoggerFactory.getLogger(PatientServiceImp.class);

    @Autowired
    private PatientRepositoryInterface patientRepositoryInterface;

    @Override
    public List<PatientDetail> getAllPatient() {
        List<PatientDetail> listData = patientRepositoryInterface.getAllPatient();
//        for (PatientDetail loop : listData) {
//            logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + loop.getFirstName());
//        }
//        test();
        return listData;
    }

    @Override
    public PatientDetail getPatientByIdPk(Long idPk) {
        return patientRepositoryInterface.getPatientByIdPk(idPk);
    }

    @Override
    public List<PatientDetail> getPatientByCri(JsonObject jsonObject) {
//        JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("ListData", createListData());
//
//        String data = jsonObject1.toString();
//
//        logger.debug("jsonObject1 substring: " + data.substring(1, data.length() - 1));

        return patientRepositoryInterface.getPatientByCriteria(jsonObject);
    }

    @Override
    public void savePatientData(JsonObject jsonObject) {
        patientRepositoryInterface.savePatientData(jsonObject);
    }

    private JSONObject createListData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brCaseId", 13697);
        jsonObject.put("brCasePartyId", 78340);
        jsonObject.put("brCaseDockettId", 26008);
        jsonObject.put("documentDate", "29/12/2561");
        jsonObject.put("personalData", createPersonalData());
        jsonObject.put("getOutKingdom", createGetOutKingdom());
        return jsonObject;
    }

    private JSONObject createPersonalData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("idCard", "0102983716219");
        jsonObject.put("titleCode", "0001");
        jsonObject.put("firstName", "Malcolm");
        jsonObject.put("lastName", "McDart");
        jsonObject.put("birthday", "31/12/2561");
        jsonObject.put("addressDocument", createAddressDocument());

        return jsonObject;
    }

    private JSONObject createAddressDocument() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("addressNo", "43/2");
        jsonObject.put("subDistrictCode", "100204");
        jsonObject.put("districtCOde", "1002");
        jsonObject.put("provinceCode", "10");
        jsonObject.put("zipcode", "10300");
        jsonObject.put("telephone", "0647999211");
        jsonObject.put("emailTxt", "cccc@gmail.com");

        return jsonObject;
    }

    private JSONObject createGetOutKingdom() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("passportNo", "0192Z29233");
        jsonObject.put("passportDate", "20/01/2560");
        jsonObject.put("passportExpDate", "23/03/2564");
        jsonObject.put("nationality", createNationality());
        jsonObject.put("startDate", "01/01/2561");
        jsonObject.put("endDate", "31/01/2561");
        jsonObject.put("objective", "ไปทำธุรกิจ");
        jsonObject.put("investmentFlag", "1");
        jsonObject.put("investmentAmount", 90000.00);
        jsonObject.put("contact", "+066 91928371 Ext 192");

        return jsonObject;
    }

    private List<Map<String, String>> createNationality() {
//        JsonArray jsonElements = new JsonArray();
        List<Map<String, String>> countries = createCountries();
        String jsonCountries = new Gson().toJson(countries);
//        JsonObject jsonObject = parseJson(jsonCountries);

//        JSONObject jsonObject;
//        for(Map<String, String> loop : countries) {
//            jsonObject = new JSONObject();
//            jsonObject.put("code", loop.get("code").toString());
//            jsonObject.put("name", loop.get("name").toString());
//            for (Map.Entry<String, String> entry : loop.entrySet()) {
//                jsonObject.put("code", entry.getValue());
//            }
//        }

        JSONArray objects = new JSONArray();
        objects.put(countries);
//        JSONObject jsonObject = new JSONObject()
        return countries;
    }

    private List<Map<String, String>> createCountries() {
        List<Map<String, String>> countries = new ArrayList<>();
        countries.add(mapCountries("059", "ฝรั่งเศส"));
        countries.add(mapCountries("133", "โปรแลนด์"));

        return countries;
    }

    private Map<String, String> mapCountries(String code, String name) {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("name", name);
        return map;
    }

    private JsonArray parseJson(String jsonPattern) {
        JsonParser jsonParser = new JsonParser();
        return (JsonArray) jsonParser.parse(jsonPattern);
    }

    private void test() {
        String sqlStatement = "INSERT INTO FIN_IMP_CGD_ITEMS (" +
                "    IGD_REF_FILE_FK," +
                "    IGD_CARD_ID," +
                "    IGD_NAME," +
                "    IGD_SUR_NAME," +
                "    IGD_AMOUNT," +
                "    IGD_DEPT_CODE," +
                "    IGD_TRANSFER_DATE,";
        if (true) {
            sqlStatement += "    IGD_CHECK_FLG,";
        }
        sqlStatement += "    IGD_RESULT_KEY," +
                "    IGD_CREATE_BY," +
                "    IGD_CREATE_DATE," +
                "    IGD_UPDATE_BY," +
                "    IGD_UPDATE_DATE" +
                ") VALUES (?, ?, ?, ?, ?, ?," +
                " ?, ";
        if (true) {
            sqlStatement += "?, ";
        }
        sqlStatement += "?, ?, ?, ?, ?)";

        logger.info("sqlStatement: " + sqlStatement);
    }
}
