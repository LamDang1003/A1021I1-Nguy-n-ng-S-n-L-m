package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final String URL = "jdbc:mysql://localhost:3306/product_demo";
    private final String USER_NAME = "root";
    private final String PASSWORD = "40forever";
    private final String FIND_ALL_SQL = "select * from product";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    public List<Product> findAll(){
        List<Product> result = new ArrayList<>();

        try(PreparedStatement st = getConnection().prepareStatement(FIND_ALL_SQL)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name =rs.getString(2);
                String color =rs.getString(3);
                Double price =rs.getDouble(4);
                Product product = new Product(id, name, color, price);
                result.add(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
