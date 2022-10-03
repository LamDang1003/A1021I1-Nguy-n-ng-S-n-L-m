package repository;

import model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student?useSSL=false";
    private String jdbcProductname = "na";
    private String jdbcPassword = "123456";

    private final String SELECT_ALL = "select * from student s join address a where s.address_id_address = a.id_address;";
    private final String SELECT_BY_ID = "select * from student  where id = ?;";
    private final String DELETE_BY_ID = "delete from student where id = ?;";
    private final String CREATE = "insert into student (name, old, id_address) values(?, ?, ?);" +
            "insert into address (id_address, address, country) values(?, ?, ?);";
    private final String UPDATE = "update student set name= ?, old= ?, id_address=? where id=?;" +
            "update address set address= ?, country=? where id_address=?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcProductname, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public Student findAll(){
        List<Student> st = new ArrayList<>();
        try ()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
