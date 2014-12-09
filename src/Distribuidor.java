
public class Distribuidor {

	// Propiedades
	private String nombre;
	private String cif;
	private Direccion direccion;
	private Contacto personaContacto;

	// Métodos Getter y Setter de nombre
	public void setNombre (String nombreIntro){
		this.nombre = nombreIntro;
	}
	public String getNombre() {
		return this.nombre;
	}

	// Métodos Getter y Setter de cif
	public void setCif (String cifIntro){
		this.cif = cifIntro;
	}
	public String getCif() {
		return this.cif;
	}

	// Métodos Getter y Setter de direccion
	public void setDireccion (Direccion direccionIntro){
		this.direccion = direccionIntro;
	}
	public Direccion getDireccion() {
		return this.direccion;
	}

	// Métodos Getter y Setter de personaContacto
	public void setPersonaContacto (Contacto personaContactoIntro){
		this.personaContacto = personaContactoIntro;
	}
	public Contacto getPersonaContacto() {
		return this.personaContacto;
	}

}
