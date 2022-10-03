package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyễn Đặng Sơn Lâm", "10-03-2000", "Đà Nẵng", ""));
        customerList.add(new Customer(1, "Nguyễn Đặng Sơn Lâm", "10-03-2000", "Đà Nẵng", ""));
        customerList.add(new Customer(1, "Nguyễn Đặng Sơn Lâm", "10-03-2000", "Đà Nẵng", ""));
        customerList.add(new Customer(1, "Nguyễn Đặng Sơn Lâm", "10-03-2000", "Đà Nẵng", ""));
        customerList.add(new Customer(1, "Nguyễn Đặng Sơn Lâm", "10-03-2000", "Đà Nẵng", ""));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
