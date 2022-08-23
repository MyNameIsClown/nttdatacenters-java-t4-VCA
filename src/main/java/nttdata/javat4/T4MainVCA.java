package nttdata.javat4;

import nttdata.javat4.business.ManagmentServiceImp;
import nttdata.javat4.business.School;
import nttdata.javat4.business.Student;

/**
 * Clase main
 * 
 * @author Victor Carrasco
 *
 */
public class T4MainVCA {
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Creacion de escuelas---------------------------------------------------------
		School e1 = new School("IES hnosMachado", 41089, "C/San fernando 3");//--------
		School e2 = new School("IES Luis Hernandez", 41013, "C/Hermita blanca 11");//41212
		School e3 = new School("IES Salesianas", 41013, "C/Juan Perez de Guzman 2");
		
		//Creacion de estudiantes------------------------------------------------------
		Student s1 = new Student("12345678A", "Laura", e1);
		Student s2 = new Student("81276423R", "Mario", e2);//e1 IES hnosMachado
		Student s3 = new Student("91823412A", "Luis", e1);
		Student s4 = new Student("80345345E", "Raul", e3);//-----
		Student s5 = new Student("09283423Y", "Luna", e2);
		
		//Creacion del Servicio
		ManagmentServiceImp service = new ManagmentServiceImp();
		
		//Almacenamiento de Escuelas
		service.add(e1);
		service.add(e2);
		service.add(e3);
		
		//Almacenamiento de Alumnos
		service.add(s1);
		service.add(s2);
		service.add(s3);
		service.add(s4);
		service.add(s5);
		
		//Modificacion de datos
		service.modify("81276423R");
		service.modify("IES Salesianas");
		
		//Eliminacion de datos
		service.delete("80345345E");
		service.delete("IES hnosMachado");
		
		//Mostrar Datos
		System.out.println(service.listSchools());
		System.out.println(service.listStudents());
		
		
		//Mostrar Detalles
		System.out.println(service.showDetails("IES Salesianas"));
		System.out.println(service.showDetails("80345345E"));
		System.out.println(service.showDetails("81276423R"));
		System.out.println(service.showDetails("IES Luis Hernandez"));
	}

}
