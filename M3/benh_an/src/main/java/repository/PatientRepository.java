package repository;

import model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements IPatientRepository{

    private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String jdbcUsername = "na";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL = "select * from customer c join category a on c.category= a.idCategory;";
    private static final String INSERT_PATIENT = "insert into customer " + "(name, old, nPhone, email, address, category)value" + "(?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "select * from customer c join category a on c.category= a.idCategory where id = ?;";
    private static final String DELETE = "delete from customer where id = ?";
    private static final String UPDATE = "update customer set name=?, old=?, nPhone=?, email=?, address=?, category=? where id=?;";
    private static final String SEARCH_BY_NAME = "select * from customer c join category a on c.category= a.idCategory where address= ?;";

    public PatientRepository(){

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Patient> findAll(String sortField, String sortDir) throws SQLException {
        List<Patient> patients = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            patients = getPatients(preparedStatement.executeQuery());

        }catch (SQLException e){
            printSQLException(e);
        }

        return patients;
    }

    @Override
    public void create(Patient patient) throws SQLException {
        System.out.println(INSERT_PATIENT);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT)){
            preparedStatement.setString(1, patient.getName());
            .......................
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Patient findById(int id) {
        Patient patient = null;
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String name = rs.getString("name");

                patient = new Patient(id, name, );
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return patient;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Patient patient) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, patient.getName());


            statement.setInt(7, patient.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Patient> search(String name) throws SQLException {
        List<Patient> res = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement statement= connection.prepareStatement(SEARCH_BY_NAME);
            statement.setString(1, name);
            res = getPatients(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    private List<Patient> getPatients(ResultSet rs) throws SQLException{
        List<Patient> res= new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dateIn = rs.getString("dateIn");
            String dateOut = rs.getString("dateOut");
            String reason = rs.getString("reason");
            int medicalRecord = rs.getInt("medicalRecord");
            String nameMedicalRecord = rs.getString("nameMedicalRecord");
            res.add(new Patient(id, name, dateIn, dateOut, reason, medicalRecord, nameMedicalRecord));
        }
        return res;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
