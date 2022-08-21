package nttdata.javat4.business;

/**
 * Interface que implementa las funcionalidades principales de gestion de
 * alumnos y centros educativos
 * 
 * @author Victor Carrasco
 *
 */
public interface ManagmentService {
	/**
	 * Añade un objeto de tipo student
	 * @param student
	 */
	public void add(Student student);
	/**
	 * Añade un objeto de tipo school
	 * @param school
	 */
	public void add(School school);
	/**
	 * Elimina el objeto con el identificador especificado
	 * @param identificator
	 */
	public void delete(String identificator);
	/**
	 * Modifica el objeto con el identificador especificado
	 * @param identificator
	 */
	public void modify(String identificator);
	/**
	 * Muestra la informacion del objeto con el identificador especificado
	 * @param identificator
	 * @return
	 */
	public String showDetails(String identificator);
	/**
	 * Lista los dni de todos los estudiantes dados de alta
	 * @return
	 */
	public String listStudents();
	/**
	 * Lista todos los centros dados de alta
	 * @return
	 */
	public String listSchools();
}
