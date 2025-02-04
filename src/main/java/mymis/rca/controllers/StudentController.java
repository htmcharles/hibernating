package mymis.rca.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mymis.rca.models.Student;
import mymis.rca.services.StudentService;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    StudentService service=StudentService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String namef=request.getParameter("fname");
        String namel=request.getParameter("lname");
        String email=request.getParameter("email");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "2005-02-20";
        LocalDate dob = LocalDate.parse(date, pattern);
        Student student1=new Student(namef,namel,email,12,dob);
        service.addStudent(student1);
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);

    }

}
