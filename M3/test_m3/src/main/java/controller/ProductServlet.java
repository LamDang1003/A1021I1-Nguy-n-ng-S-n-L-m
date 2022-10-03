package controller;

import model.Product;
import repository.ProductRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProductRepository productRepository;
    public void init(){
        productRepository = new ProductRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                case "sort":
                    String sortField= request.getParameter("sortField");
                    String sortDir= request.getParameter("sortDir");
                    List<Product> products= productRepository.findAll(sortField, sortDir);
                    request.setAttribute("listProduct", products);
                    String tmp= sortDir.isEmpty() || sortDir.equals("asc")? "desc": "asc";
                    request.setAttribute("sortDir", tmp);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
                    dispatcher.forward(request, response);
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByName (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> listProduct = productRepository.search(request.getParameter("search"));
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);
    }


    private void listProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> listProduct = productRepository.findAll("id", "desc");
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productRepository.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/update.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }

    private void insertProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        Product newProduct = new Product(name, price, amount, color, description, category);

        productRepository.create(newProduct);
        request.setAttribute("isCreate", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int category = Integer.parseInt(request.getParameter("category"));
        String categoryName = request.getParameter("nameCategory");
        Product book = new Product(id, name, price, amount, color, description, category, categoryName);
        request.setAttribute("isUpdate", productRepository.update(book));
        listProduct(request, response);
    }

    private void  deleteProduct (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        productRepository.delete(id);

        List<Product> listProduct  =productRepository.findAll("id", "desc");
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertProduct(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "search":
                    searchByName(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
