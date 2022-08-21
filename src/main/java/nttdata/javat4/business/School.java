package nttdata.javat4.business;

/**
 * Clase encargada de la recogida de datos de un centro educativos
 * 
 * @author Victor Carrasco
 *
 */
public class School {
	/** nombre del centro escolar */
	private String name;
	/** codigo postal */
	private Integer cp;
	/** direccion completo */
	private String adress;

	/**
	 * Constructor con parametros
	 * 
	 * @param name
	 * @param cp
	 * @param adress
	 */
	public School(String name, Integer cp, String adress) {
		super();
		this.name = name;
		this.cp = cp;
		this.adress = adress;
	}

	/**
	 * Constructor vacio
	 */
	public School() {
		super();
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
	 * Codigo postal getter
	 * 
	 * @return
	 */
	public Integer getCp() {
		return cp;
	}

	/**
	 * Codigo postal setter
	 * 
	 * @param cp
	 */
	public void setCp(Integer cp) {
		this.cp = cp;
	}

	/**
	 * Direccion getter
	 * 
	 * @return
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Direccion setter
	 * 
	 * @param adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

}
