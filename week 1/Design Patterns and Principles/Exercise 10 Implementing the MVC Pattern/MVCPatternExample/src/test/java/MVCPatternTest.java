import org.example.Student;
import org.example.StudentController;
import org.example.StudentView;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Fetch student record based on ID from database (simulated)
        Student model = retrieveStudentFromDatabase();

        // Create a view to display student details on console
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(model, view);

        // Update the view with student details
        controller.updateView();

        // Update student data
        controller.setStudentName("John Doe");
        controller.setStudentGrade("A");

        // Update the view again to show updated student details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Jane Doe");
        student.setId("12345");
        student.setGrade("B");
        return student;
    }
}

