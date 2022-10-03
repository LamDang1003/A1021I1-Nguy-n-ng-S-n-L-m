package controller;

import model.Category;
import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerRepository customerRepository;
    public void init(){
        customerRepository = new CustomerRepository();
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
                    deleteCustomer(request, response);
                    break;
                case "sort":
                    String sortField= request.getParameter("sortField");
                    String sortDir= request.getParameter("sortDir");
                    List<Customer> customers= customerRepository.findAll(sortField, sortDir);
                    request.setAttribute("listCustomer", customers);
                    String tmp= sortDir.isEmpty() || sortDir.equals("asc")? "desc": "asc";
                    request.setAttribute("sortDir", tmp);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
                    dispatcher.forward(request, response);
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByAddress (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = customerRepository.search(request.getParameter("search"));
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }

    private void findById (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
          List<Customer> listCustomer = customerRepository.findAll("id", "desc");
          List<Category> listCategory = customerRepository.table2();
          request.setAttribute("listCategory", listCategory);
          request.setAttribute("listCustomer", listCustomer);
          RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
          dispatcher.forward(request, response);
    }

    private void showNewForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerRepository.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/update.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }

    private void insertCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        int old = Integer.parseInt(request.getParameter("old"));
        int nPhone = Integer.parseInt(request.getParameter("nPhone"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int category = Integer.parseInt(request.getParameter("category"));
        Customer newCustomer = new Customer(name, old, nPhone, email, address, category);

        customerRepository.create(newCustomer);
        request.setAttribute("isCreate", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int old = Integer.parseInt(request.getParameter("old"));
        int nPhone = Integer.parseInt(request.getParameter("nPhone"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int category = Integer.parseInt(request.getParameter("category"));
        String categoryName = request.getParameter("nameCategory");
        Customer book = new Customer(id, name, old, nPhone, email, address, category, categoryName);
        request.setAttribute("isUpdate", customerRepository.update(book));
        listCustomer(request, response);
    }

    private void  deleteCustomer (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerRepository.delete(id);

        List<Customer> listCustomer  =customerRepository.findAll("id", "desc");
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
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
                    insertCustomer(request, response);
                    break;
                case "update":
                    updateCustomer(request, response);
                    break;
                case "search":
                    searchByAddress(request, response);
                case "findById":
                    findById(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
