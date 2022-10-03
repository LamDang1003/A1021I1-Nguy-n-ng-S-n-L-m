package controller;

import model.Patient;
import repository.PatientRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PatientServlet", urlPatterns = "/patients")
public class PatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PatientRepository patientRepository;
    public void init(){
        patientRepository = new PatientRepository();
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
                    deletePatient(request, response);
                    break;
                case "sort":
                    String sortField= request.getParameter("sortField");
                    String sortDir= request.getParameter("sortDir");
                    List<Patient> patients= patientRepository.findAll(sortField, sortDir);
                    request.setAttribute("listPatient", patients);
                    String tmp= sortDir.isEmpty() || sortDir.equals("asc")? "desc": "asc";
                    request.setAttribute("sortDir", tmp);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("patient/list.jsp");
                    dispatcher.forward(request, response);
                default:
                    listPatient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByName (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Patient> listPatient = patientRepository.search(request.getParameter("search"));
        request.setAttribute("listPatient", listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient/list.jsp");
        dispatcher.forward(request,response);
    }

    private void findById (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listPatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Patient> listPatient = patientRepository.findAll("id", "desc");
        request.setAttribute("listPatient", listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient existingPatient = patientRepository.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient/update.jsp");
        request.setAttribute("customer", existingPatient);
        dispatcher.forward(request, response);
    }

    private void insertPatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");

        Patient newPatient = new Patient(name,...............);

        patientRepository.create(newPatient);
        request.setAttribute("isCreare", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updatePatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Patient book = new Patient(id, name, );
        request.setAttribute("isUpdate", patientRepository.update(book));
        listPatient(request, response);
    }

    private void  deletePatient (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        patientRepository.delete(id);

        List<Patient> listPatient  =patientRepository.findAll("id", "desc");
        request.setAttribute("listPatient", listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient/list.jsp");
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
                    insertPatient(request, response);
                    break;
                case "update":
                    updatePatient(request, response);
                    break;
                case "search":
                    searchByName(request, response);
                case "findById":
                    findById(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
