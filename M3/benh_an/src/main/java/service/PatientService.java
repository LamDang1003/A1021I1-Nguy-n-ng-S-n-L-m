package service;

import model.Patient;
import repository.PatientRepository;

import javax.xml.namespace.QName;
import java.sql.SQLException;
import java.util.List;

public class PatientService implements IPatientService{
    private static PatientRepository patientRepository = new PatientRepository();

    @Override
    public List<Patient> findAll(String sortField, String sortDir) throws SQLException {
        return patientRepository.findAll(sortField, sortDir);
    }

    @Override
    public void create(Patient patient) throws SQLException {
        patientRepository.create(patient);
    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return patientRepository.delete(id);
    }

    @Override
    public boolean update(Patient patient) throws SQLException {
        return patientRepository.update(patient);
    }

    @Override
    public List<Patient> search(String name) throws SQLException {
        return patientRepository.search(name);
    }
}
