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
import java.util.List;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentService service = StudentService.getInstance();

    public StudentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch all students and set as request attribute
        List<Student> students = service.getAllStudents();
        request.setAttribute("students", students);

        // Forward to the JSP page
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String namef = request.getParameter("fname");
        String namel = request.getParameter("lname");
        String email = request.getParameter("email");
        String dobString = request.getParameter("dob");

        // Validate input
        if (namef != null && namel != null && email != null && dobString != null &&
                !namef.isEmpty() && !namel.isEmpty() && !email.isEmpty() && !dobString.isEmpty()) {

            // Parse the date of birth
            LocalDate dob = LocalDate.parse(dobString);
            int age = LocalDate.now().getYear() - dob.getYear();

            // Create and add the student
            Student student1 = new Student(namef, namel, email, age, dob);
            service.addStudent(student1);
        } else {
            request.setAttribute("error", "All fields are required.");
        }

        // Fetch all students and update request attribute
        List<Student> students = service.getAllStudents();
        request.setAttribute("students", students);

        // Forward to the JSP page
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }
}
