
public class Cliente {

	// Propiedades
	private String nombre;
	private String apellidos;
	private String dni;
	private Double numSocio;
	private Double dto;
	private Direccion direccion;

	// Metodos Getter y Setter de nombre
	public void setNombre (String nombreIntro){
		this.nombre = nombreIntro;
	}
	public String getNombre() {
		return this.nombre;
	}

	// Metodos Getter y Setter de apellidos
	public void setApellidos (String apellidosIntro){
		this.apellidos = apellidosIntro;
	}
	public String getApellidos() {
		return this.apellidos;
	}

	// Metodos Getter y Setter de dni
	public void setDni (String dniIntro){
		this.dni = dniIntro;
	}
	public String getDni() {
		return this.dni;
	}

	// Metodos Getter y Setter de direccion
	public void setDireccion (Direccion direccionIntro){
		this.direccion = direccionIntro;
	}
	public Direccion getDireccion() {
		return this.direccion;
	}

	// Metodos Getter y Setter de numSocio
	public void setNumSocio (double numSocioIntro){
		this.numSocio = numSocioIntro;
	}
	public double getNumSocio() {
		return this.numSocio;
	}

	// Metodos Getter y Setter de dto
	public void setDto (double dtoIntro){
		this.dto = dtoIntro;
	}
	public double getDto() {
		return this.dto;
	}

}