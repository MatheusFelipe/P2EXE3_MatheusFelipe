package exe03;

import java.lang.reflect.InvocationTargetException;

public class MVCPatternDemo {	
	public static void main(String[] args) {
		Student assignedStudent = retrieveStudentFromDatabase();
		Professor assignedProfessor = retrieveProfessorFromDatabase();
		StudentView studentView = new StudentView();
		ProfessorView professorView = new ProfessorView();
		Controller studentController;
		Controller professorController;
		
		
		try {
			System.out.println("Teste com buildController");
			studentController = ControllerFactory.buildController("Student");
			studentController.setName(assignedStudent.getName());
			studentController.setRollNo(assignedStudent.getRollNo());
			studentController.updateView();
			System.out.println();

			// update model data
			studentController.setName("John");

			studentController.updateView();
			System.out.println();
			
			professorController = ControllerFactory.buildController("Professor");
			professorController.setName(assignedProfessor.getName());
			professorController.setRollNo(assignedProfessor.getRollNo());
			professorController.updateView();
			System.out.println();
			
			// update model data
			professorController.setName("Downey Jr.");

			professorController.updateView();
			
			System.out.println("\nTeste com setController");
			studentController = ControllerFactory.setController(assignedStudent, studentView);
			studentController.updateView();
			System.out.println();
			
			professorController = ControllerFactory.setController(assignedProfessor, professorView);
			professorController.updateView();
			System.out.println();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Student retrieveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}
	
	private static Professor retrieveProfessorFromDatabase() {
		Professor professor = new Professor();
		professor.setName("Langdon");
		professor.setRollNo("07");
		return professor;
	}

}
