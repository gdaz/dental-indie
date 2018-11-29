package com.indie.dental.repository;

import com.google.gson.JsonObject;
import com.indie.dental.entity.PatientAddress;
import com.indie.dental.entity.PatientDetail;
import com.indie.dental.repository.interfaces.PatientRepositoryInterface;
import com.indie.dental.utils.DateUtils;
import com.indie.dental.utils.HandleEntityManager;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Repository
@Transactional
public class PatientRepositoryImp extends HandleEntityManager implements PatientRepositoryInterface {

    enum PATIENTCOLUMNS {
        firstName,
        lastName,
        age
    }

    private final Logger logger = LoggerFactory.getLogger(PatientRepositoryImp.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PatientDetail> getAllPatient() {
        Session session = getSessionFactory();
//        return jdbcTemplate.query("SELECT * FROM patient_detail", new BeanPropertyRowMapper<>(PatientDetail.class));
        Criteria criteria = session.createCriteria(PatientDetail.class);
        List<PatientDetail> result = criteria.list();
        return result;
    }

    @Override
    public List<PatientDetail> getPatientByCriteria(JsonObject jsonObject) {
        boolean flagFirstElement = true;
        Session session = getSessionFactory();
        StringBuilder sqlStatement = new StringBuilder("SELECT * FROM patient_detail p WHERE");
//        sqlStatement.append(" p.first_name = :firstName");
//        sqlStatement.append(" AND p.last_name = :lastName");
//        sqlStatement.append(" AND p.age = :age");
//
        sqlStatement.append(" p.id = 21");

        SQLQuery query = session.createSQLQuery(sqlStatement.toString());
//        query.setParameter("firstName", jsonObject.get("firstName").getAsString());
//        query.setParameter("lastName", jsonObject.get("lastName").getAsString());
//        query.setParameter("age", jsonObject.get("age").getAsString());
//        query.setRes

//        SQLQuery sqlQuery = session.createSQLQuery(sqlStatement.toString());
//        sqlQuery.setParameter("firstName", jsonObject.get("firstName").getAsString());
//        sqlQuery.setParameter("lastName", jsonObject.get("lastName").getAsString());
//        sqlQuery.setParameter("age", jsonObject.get("age").getAsString());
//        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        savePatientData();

//        updatePatient(session, jsonObject);

        List<PatientDetail> listPatient = query.list();
        return listPatient;
    }

    @Override
    public PatientDetail getPatientByIdPk(Long idPk) {
        String sqlStatement = "SELECT * FROM patient_detail p WHERE p.id = ?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{idPk}, new BeanPropertyRowMapper<>(PatientDetail.class));
    }

    @Override
    public int savePatientData(JsonObject jsonObject) {
        Session session = getSessionFactory();
//        PatientDetail patient = new PatientDetail();
//        patient.setFirstName(jsonObject.get("firstName").getAsString());
//        patient.setLastName(jsonObject.get("lastName").getAsString());
////        patient.setAge(jsonObject.get("age").getAsString());
//        patient.setRemark(jsonObject.get("remark").getAsString());
//        Integer id = (Integer) session.save(patient);

        PatientAddress patientAddress = new PatientAddress();
        patientAddress.setAddressLine1("sai1");
        patientAddress.setAddressLine2("sai2");
        patientAddress.setDistrict("TC");
        patientAddress.setProvince("BKK");
        patientAddress.setZipcode("10000");

        PatientDetail patient1 = new PatientDetail();
        patient1.setFirstName("ddd");
        patient1.setLastName("dddd");
        patient1.setRemark("test hibernate");
        patient1.setPatientAddress(patientAddress);

        Integer id = (Integer) session.save(patient1);
//        session.save(patientAddress);

        return id;
    }

    public int savePatientData() {
        Session session = getSessionFactory();
        PatientDetail patient = new PatientDetail();
        patient.setFirstName("c");
        patient.setLastName("cc");
        Integer id = (Integer) session.save(patient);
        logger.info(String.valueOf(id));
        return id;
    }

    private void updatePatient(Session session, JsonObject jsonObject) {
        Date dateInput = null;
        PatientDetail patient = (PatientDetail) findByIdPk(session, PatientDetail.class, jsonObject.get("id").getAsInt());
        Date compareDate = null;
        try {
            dateInput = DateUtils.covertDateUTCPattern(jsonObject.get("date").getAsString());
            compareDate = DateUtils.covertDatePattern(patient.getDate().toString());
            logger.info(dateInput + "<>" + compareDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (new Timestamp(compareDate.getTime()).equals(new Timestamp(dateInput.getTime()))) {
            // jsonObject.get("date").getAsString()
            logger.debug("equal");
            patient.setFirstName(jsonObject.get("firstName").getAsString());
            patient.setLastName(jsonObject.get("lastName").getAsString());
//            patient.setVersion(Integer.valueOf(1));
            session.persist(patient);
        }
    }

    private Object findByIdPk(Session session, Class<?> entityClass, Integer id) {
        Object o = null;
//        o = session.load(entityClass, id);
//        String sqlStatement = "SELECT * FROM PatientDetail p WHERE p.id = :id";
//        SQLQuery sqlQuery = session.createSQLQuery(sqlStatement)
//                .setParameter("id", id);
//        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//        PatientBean patient = (PatientBean) sqlQuery.uniqueResult();

        Criteria criteria = session.createCriteria(entityClass)
                .add(Restrictions.eq("id", id));
        return criteria.uniqueResult();
//        return session.createCriteria(PatientDetail.class)
//                .add(Restrictions.eq("id", 1L))
//                .uniqueResult();
    }

    private String transformColumnName(String key) {
        switch (PATIENTCOLUMNS.valueOf(key)) {
            case firstName:
                return "first_name";
            case lastName:
                return "last_name";
            case age:
                return PATIENTCOLUMNS.age.toString();
            default:
                throw new RuntimeException("not found");
        }
    }
}
