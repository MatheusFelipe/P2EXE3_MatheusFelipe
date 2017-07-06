package exe03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Controller {
	/*Como eh tudo Object, o controller nao sabe o que foi passado, mas consegue chamar as funcoes mesmo assim*/
	private Object model;
	private Object view;

	public Controller(Object model, Object view) {
		this.model = model;
		this.view = view;
	}

	public void setName(String name) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = model.getClass().getMethod("setName",String.class);
		method.invoke(model, name);
	}

	public String getName() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = model.getClass().getMethod("getName");
		return (String) method.invoke(model);
	}

	public void setRollNo(String rollNo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = model.getClass().getMethod("setRollNo", String.class);
		method.invoke(model, rollNo);
	}

	public String getRollNo() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = model.getClass().getMethod("getRollNo");
		return (String) method.invoke(model);
	}

	public void updateView() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = view.getClass().getMethod("printDetails", String.class, String.class);
		method.invoke(view, getName(), getRollNo());
	}

}
