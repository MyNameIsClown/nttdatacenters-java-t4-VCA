package nttdata.javat4.business;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que implementa los metodos de la interfaz ManagmentService
 * 
 * @author Victor Carrasco
 *
 */
public class ManagmentServiceImp implements ManagmentService {

	/** Mapa que almacena los estudiantes, la clave sera el dni */
	private Map<Integer, Student> students;

	/**
	 * Mapa que almacena los centros educativos, la clave sera el nombre del centro
	 */
	private Map<Integer, School> schools;

	/**
	 * Constructor
	 */
	public ManagmentServiceImp() {
		students = new HashMap<>();
		schools = new HashMap<>();
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(School school) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String identificator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(String identificator) {
		// TODO Auto-generated method stub

	}

	@Override
	public String showDetails(String identificator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listSchools() {
		// TODO Auto-generated method stub
		return null;
	}

}
