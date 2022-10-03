package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements  IProductRepository{

    private String jdbcURL = "jdbc:mysql://localhost:3306/testm3?useSSL=false";
    private String jdbcUsername = "na";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL = "select * from product p join category c on p.category= c.idCategory;";
    private static final String INSERT_PRODUCT = "insert into product " + "(name, price, amount, color, description, category)value" + "(?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "select * from product p join category c on p.category= c.idCategory where id = ?;";
    private static final String DELETE = "delete from product where id = ?";
    private static final String UPDATE = "update product set name=?, price=?, amount=?, color=?, description=?, category=? where id=?;";
    private static final String SEARCH_BY_NAME = "select * from product p join category c on p.category= c.idCategory where name= ?;";

    public ProductRepository(){

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
    public List<Product> findAll(String sortField, String sortDir) throws SQLException {
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
            System.out.println(preparedStatement);
            products = getProducts(preparedStatement.executeQuery());

        }catch (SQLException e){
            printSQLException(e);
        }

        return products;
    }

    @Override
    public void create(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Product findById(int id) {

        Product product = null;
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int amount = rs.getInt("amount");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int category = rs.getInt("category");
                String categoryName = rs.getString("nameCategory");
                product = new Product(id, name, price, amount, color, description, category, categoryName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
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
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getAmount());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategory());
            statement.setInt(7, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Product> search(String name) throws SQLException {
        List<Product> res = new ArrayList<>();
        try (Connection connection = getConnection()){
            PreparedStatement statement= connection.prepareStatement(SEARCH_BY_NAME);
            statement.setString(1, name);
            res = getProducts(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    private List<Product> getProducts(ResultSet rs) throws SQLException {
        List<Product> res = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Double price = rs.getDouble("price");
            int amount = rs.getInt("amount");
            String color = rs.getString("color");
            String description = rs.getString("description");
            int category = rs.getInt("category");
            String categoryName = rs.getString("nameCategory");
            res.add(new Product(id, name, price, amount, color, description, category, categoryName));
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
