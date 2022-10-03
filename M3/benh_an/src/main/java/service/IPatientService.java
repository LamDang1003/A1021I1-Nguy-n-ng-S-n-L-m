package service;

import model.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IPatientService {
    public List<Patient> findAll(String sortField, String sortDir) throws SQLException;
    public void create(Patient patient) throws SQLException;
    public Patient findById(int id);
    public boolean delete(int id) throws SQLException;
    public boolean update(Patient patient) throws SQLException;
    List<Patient> search(String name) throws SQLException;
}
