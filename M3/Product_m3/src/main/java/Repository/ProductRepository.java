package Repository;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String URL = "jdbc:mysql://localhost:3306/product";
    private final String USER_NAME = "na";
    private final String PASSWORD = "123456";
    private static final String INSERT_PRODUCT_SQL = "insert into products"+"(id, name, price, amount)values"+"(?, ?, ?, ?);";

    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id = ?;";
    private static final String SELECT_ALL_PRODUCT = "select * from products;";
    private static final String DELETE_PRODUCT_SQL = "delete from products where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update products set name=?, price=?, amount=? where id= ?;";


    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    public List<Product> findAll(){
        List<Product> result = new ArrayList<>();

        try(PreparedStatement st = getConnection().prepareStatement(SELECT_ALL_PRODUCT)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name =rs.getString(2);
                Double price =rs.getDouble(3);
                int amount = rs.getInt(4);
                Product product = new Product(id, name, price, amount);
                result.add(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Product findById() throws SQLException, ClassNotFoundException {
        Product product = null;
        try(PreparedStatement st = getConnection().prepareStatement(SELECT_PRODUCT_BY_ID)) {

        }
        return product;
    }


    public void create(Product product){
        System.out.println(INSERT_PRODUCT_SQL);
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
