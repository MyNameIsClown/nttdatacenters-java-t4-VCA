package nttdata.javat4.business;

import java.io.Serializable;

/**
 * Clase encargada de recoger los datos de un estudiante
 * 
 * @author Victor Carrasco
 *
 */
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Se usa como identificador unico para cada estudiante */
	private String dni;
	/** nombre */
	private String name;
	/** escuela a la que pertenece */
	private School school;
	
	/**
	 * Constructor con parametros
	 * 
	 * @param dni
	 * @param name
	 * @param school
	 */
	public Student(String dni, String name, School school) {
		super();
		this.dni = dni;
		this.name = name;
		this.school = school;
	}

	/**
	 * Constructor vacio
	 */
	public Student() {
		super();
	}

	/**
	 * dni getter
	 * 
	 * @return
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * dni setter
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * name getter
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * name setter
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * school getter
	 * 
	 * @return
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * school setter
	 * 
	 * @param school
	 */
	public void setSchool(School school) {
		this.school = school;
	}
	/**
	 * ToString 
	 */
	@Override
	public String toString() {
		return "Student [dni=" + dni + ", name=" + name + ", school=" + school.getName() + "]";
	}
	
	
}
