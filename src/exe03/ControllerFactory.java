package exe03;

public class ControllerFactory {
	public static Controller buildController(String student_or_professor){
		Object model = null;
		Object view = null;
		
		/*Factory normal, recebe um input e decide que tipo de controller criar*/
		switch (student_or_professor) {
        case "Student":
            model = new Student();
            view = new StudentView();
            break;
 
        case "Professor":
        	model = new Professor();
            view = new ProfessorView();
            break;
 
        default:
            throw new IllegalArgumentException();
        }
		
		return new Controller(model, view);		
	}
	
	public static Controller setController(Object Model, Object View){
		/*O controller vai entender que tipo de model e view eh mesmo se a factory nao souber*/
		return new Controller(Model, View);
	}
}
