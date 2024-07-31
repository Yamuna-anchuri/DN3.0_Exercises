public class TestMVCPattern { 
    public static void main(String[] args) { 
        // Create a new student record 
        Student student = new Student("1", "John Doe", "A"); 
 
        // Create the view to display student details 
        StudentView view = new StudentView(); 
 
        // Create the controller 
        StudentController controller = new StudentController(student, view); 
 
        // Display the initial details 
        controller.updateView(); 
 
        // Update student details 
        controller.setStudentName("Jane Doe"); 
        controller.setStudentGrade("B"); 
 
        // Display the updated details 
        controller.updateView(); 
    } 
} 