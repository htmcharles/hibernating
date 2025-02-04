package mymis.rca.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mymis.rca.models.Student;
import mymis.rca.services.StudentService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentService service = StudentService.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch all students and set as request attribute
        List<Student> students = service.getAllStudents();
        request.setAttribute("students", students);

        // Forward to the JSP page
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String namef = request.getParameter("fname");
        String namel = request.getParameter("lname");
        String email = request.getParameter("email");

        // Validate the form data
        if (namef != null && namel != null && email != null && !namef.isEmpty() && !namel.isEmpty() && !email.isEmpty()) {
            // Set a fixed date for demonstration
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = "2005-02-20";
            LocalDate dob = LocalDate.parse(date, pattern);

            // Create a student and add to service
            Student student1 = new Student(namef, namel, email, 12, dob);
            service.addStudent(student1);
        } else {
            request.setAttribute("error", "All fields are required.");
        }

        // Fetch all students and set as request attribute
        List<Student> students = service.getAllStudents();
        request.setAttribute("students", students);

        // Forward to the JSP page
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }
}
