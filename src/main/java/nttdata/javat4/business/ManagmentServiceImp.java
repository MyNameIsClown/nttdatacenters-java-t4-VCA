package nttdata.javat4.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que implementa los metodos de la interfaz ManagmentService
 * 
 * @author Victor Carrasco
 *
 */
public class ManagmentServiceImp implements ManagmentService {

	/** Mapa que almacena los estudiantes, la clave sera el dni */
	private Map<String, Student> students;

	/**
	 * Mapa que almacena los centros educativos, la clave sera el nombre del centro
	 */
	private Map<String, School> schools;
	/**
	 * Archivo en el que se guardan los estudiantes
	 */
	private File studentFile = new File("./Files/students.data");
	/**
	 * Archivo en el que se guardan los centros educativos
	 */
	private File schoolFile = new File("./Files/schools.data");
	/**
	 * Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ManagmentServiceImp.class);

	/**
	 * Constructor
	 * 
	 * @throws IOException
	 */
	public ManagmentServiceImp() {
		students = new TreeMap<>();
		schools = new TreeMap<>();
		try {
			if (studentFile.createNewFile()) {
				LOG.info("Archivo estudiante no existente, creado con exito");
			} else {
				LOG.info("Archivo estudiante ya existente");
			}
			if (schoolFile.createNewFile()) {
				LOG.info("Archivo centro no existente, creado con exito");
			} else {
				LOG.info("Archivo centro ya existente");
			}
		} catch (IOException e) {
			LOG.error(e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Student student) {
		if (isFileEmpty(studentFile)) {
			students.put(student.getDni(), student);
		} else {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))) {
				students.clear();
				students = (Map<String, Student>) in.readObject();
				students.put(student.getDni(), student);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentFile))) {
			out.writeObject(students);
		} catch (Exception e) {
			LOG.error(e.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(School school) {
		if (isFileEmpty(studentFile)) {
			schools.put(school.getName(), school);
		} else {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(schoolFile))) {
				schools.clear();
				schools = (Map<String, School>) in.readObject();
				schools.put(school.getName(), school);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(schoolFile))) {
			out.writeObject(schools);
		} catch (Exception e) {
			LOG.error(e.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(String identificator) {
		switch (selector(identificator)) {
		case 0:// estudiante
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))) {
				students.clear();
				students = (Map<String, Student>) in.readObject();
				students.remove(identificator);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentFile))) {
				out.writeObject(students);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
			break;
		case 1:// centro educativo
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(schoolFile))) {
				schools.clear();
				schools = (Map<String, School>) in.readObject();
				schools.remove(identificator);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(schoolFile))) {
				out.writeObject(schools);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
			break;
		default:
			LOG.debug("No se puede eliminar elemento solicitado");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void modify(String identificator) {
		Scanner sc = new Scanner(System.in);
		switch(selector(identificator)) {
		case 0://estudiante
			   try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))){
				students.clear();
				students = (Map<String, Student>) in.readObject();
			   }catch(Exception e) {
				   LOG.error(e.toString());
			   }
				Student student = students.get(identificator);
				boolean incorrectAnswer = true;
				while(incorrectAnswer) {
					System.out.println("DNI, NAME, SCHOOL, N/A");
					System.out.println("¿Que parametro deseas modificar?");
					String answer = "N/A";
					if(sc.hasNext()){
						answer = sc.nextLine();
					}
					switch(answer) {
						case "DNI":
							System.out.println("Dime el nuevo dato");
							student.setDni(sc.nextLine());
							incorrectAnswer = false;
							break;
						case "NAME":
							System.out.println("Dime el nuevo dato");
							student.setName(sc.nextLine());
							incorrectAnswer = false;
							break;
						case "SCHOOL":
							try (ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(schoolFile))) {
								schools.clear();
								schools = (Map<String, School>) in2.readObject();
							} catch (Exception e) {
								LOG.error(e.toString());
							}
							School school;
							System.out.println("Dime el nombre de la escuela");
							do {
								String schoolName = sc.nextLine();
								school = schools.get(schoolName);
								if(school == null) {
									System.out.println("escribe correctamente el nombre del centro");
								}
							}while(school == null);
							student.setSchool(school);
							incorrectAnswer = false;
							break;
						case "N/A":
							incorrectAnswer = false;
							break;
						default:
							incorrectAnswer = true;
					}
				}
			try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentFile))) {
				out.writeObject(students);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
		break;
		case 1://centro educativo
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(schoolFile))){
				schools.clear();
				schools = (Map<String, School>) in.readObject();
			}catch(Exception e) {
				LOG.error(e.toString());
			}
			School school = schools.get(identificator);
			if(school == null) {
				String text = "La escuela seleccionada no existe";
				System.out.println(text);
				LOG.info(text);
			}
			boolean incorrectAnswer2 = true;
			while(incorrectAnswer2) {
				System.out.println("NAME, CP, ADRESS, N/A");
				System.out.println("¿Que parametro deseas modificar?");
				String answer = sc.nextLine();
				switch(answer) {
					case "NAME":
						System.out.println("Dime el nuevo dato");
						school.setName(sc.nextLine());
						incorrectAnswer2 = false;
						break;
					case "CP":
						System.out.println("Dime el nuevo dato");
						int newCp = Integer.parseInt(sc.nextLine());
						LOG.debug("{}",newCp);
						school.setCp(newCp);
						incorrectAnswer2 = false;
						break;
					case "ADRESS":
						System.out.println("Dime el nuevo dato");
						school.setAdress(sc.nextLine());
						incorrectAnswer2 = false;
						break;
					case "N/A":
						incorrectAnswer2 = false;
						break;
					default:
						incorrectAnswer2 = true;
				}
				}
			try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(schoolFile))) {
				out.writeObject(schools);
			} catch (Exception e) {
				LOG.error(e.toString());
			}
		break;
		default:
			LOG.debug("No se puede eliminar elemento solicitado");
		}
	}

	@Override
	public String showDetails(String identificator) {
		String text = null;
		switch (selector(identificator)) {
		case 0:// estudiante
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))) {
				@SuppressWarnings("unchecked")
				Map<String, Student> studentsTemp = (Map<String, Student>) in.readObject();
				Student student = studentsTemp.get(identificator);
				if(student == null) {
					text = "Elemento no encontrado";
					LOG.info(text);
				}else {
					text = student.toString();
				}
			} catch (Exception e) {
				LOG.error(e.toString());
			}
			break;
		case 1:// centro educativo
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(schoolFile))) {
				@SuppressWarnings("unchecked")
				Map<String, School> schoolsTemp = (Map<String, School>) in.readObject();
				School school = schoolsTemp.get(identificator);
				if(school == null) {
					text = "Elemento no encontrado";
					LOG.info(text);
				}else {
					text = school.toString();
				}
			} catch (Exception e) {
				LOG.error(e.toString());
			}
			break;
		default:
			LOG.debug("No se pudo mostrar la informacion requerida");
		}
		return text;
	}

	@Override
	public String listStudents() {
		StringBuilder str = new StringBuilder();
		Set<String> dni = students.keySet();
		for (String i : dni) {
			str.append(i + "\n");
		}
		return str.toString();
	}

	@Override
	public String listSchools() {
		StringBuilder str = new StringBuilder();
		Set<String> centros = schools.keySet();
		for (String i : centros) {
			str.append(i + "\n");
		}
		return str.toString();
	}

	/**
	 * Este metodo devuelve un 0 si el identificador se trata de un Student o un 1
	 * si se trata de una School
	 * 
	 * @param identificator
	 * @return
	 */
	private byte selector(String identificator) {
		byte identity = 1;
		if ((identificator.length() == 9) && (Character.isLetter(identificator.charAt(8)))) {
			identity = 0;
		}
		return identity;
	}

	/**
	 * Este metodo determina si un archivo esta o no vacio
	 * 
	 * @param file
	 * @return
	 */
	private boolean isFileEmpty(File file) {
		boolean isEmpty = false;
		if (file.length() == 0) {
			isEmpty = true;
		}
		return isEmpty;
	}
}
