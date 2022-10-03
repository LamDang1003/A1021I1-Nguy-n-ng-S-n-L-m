package repository;

import model.Category;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "na";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL = "select * from customer c join category a on c.category= a.idCategory;";
    private static final String INSERT_CUSTOMER = "insert into customer " + "(name, old, nPhone, email, address, category)value" + "(?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "select * from customer c join category a on c.category= a.idCategory where id = ?;";
    private static final String DELETE = "delete from customer where id = ?";
    private static final String UPDATE = "update customer set name=?, old=?, nPhone=?, email=?, address=?, category=? where id=?;";
    private static final String SEARCH_BY_ADDRESS = "select * from customer c join category a on c.category= a.idCategory where address= ?;";

    public CustomerRepository(){

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
    public List<Customer> findAll(String sortField, String sortDir) {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            customers = getCustomers(preparedStatement.executeQuery());

        }catch (SQLException e){
            printSQLException(e);
        }

        return customers;
    }

    @Override
    public void create(Customer customer) {
        System.out.println(INSERT_CUSTOMER);
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getOld());
            preparedStatement.setInt(3, customer.getnPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setInt(6, customer.getCategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            printSQLException(e);
        }

    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                int old = rs.getInt("old");
                int nPhone = rs.getInt("nPhone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int category = rs.getInt("category");
                String categoryName = rs.getString("nameCategory") ;
                customer = new Customer(id, name, old, nPhone, email, address, category, categoryName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
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
    public boolean update(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getOld());
            statement.setInt(3, customer.getnPhone());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getAddress());
            statement.setInt(6, customer.getCategory());
            statement.setInt(7, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> search(String address) {
        List<Customer> res = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement statement= connection.prepareStatement(SEARCH_BY_ADDRESS);
            statement.setString(1, address);
        res = getCustomers(statement.executeQuery());
    } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Category> table2() {
        List<Category> listCategory = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            listCategory = getCategory(preparedStatement.executeQuery());

        }catch (SQLException e){
            printSQLException(e);
        }

        return listCategory;
    }

    private List<Customer> getCustomers(ResultSet rs) throws SQLException{
        List<Customer> res= new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int old = rs.getInt("old");
            int nPhone = rs.getInt("nPhone");
            String email = rs.getString("email");
            String address = rs.getString("address");
            int category = rs.getInt("category");
            String categoryName  = rs.getString("nameCategory");
            res.add(new Customer(id, name, old, nPhone, email, address, category, categoryName));
        }
        return res;
    }

    private List<Category> getCategory(ResultSet rs) throws SQLException{
        List<Category> re = new ArrayList<>();
        while (rs.next()){
            int idCategory  = rs.getInt("idCategory");
            String nameCategory = rs.getString("nameCategory");
            String note = rs.getString("note");
            re.add(new Category(idCategory, nameCategory, note));
        }

        return re;
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
