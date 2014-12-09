
public class Contacto {

	// Propiedades
	private String nombre;
	private String apellidos;
	private String telefono;
	private int edad;

	// Métodos Getter y Setter de nombre
	public void setNombre (String nombreIntro){
		this.nombre = nombreIntro;
	}
	public String getNombre() {
		return this.nombre;
	}

	// Métodos Getter y Setter de apellidos
	public void setApellidos (String apellidosIntro){
		this.apellidos = apellidosIntro;
	}
	public String getApellidos() {
		return this.apellidos;
	}

	// Métodos Getter y Setter de telefono
	public void setTelefono (String telefonoIntro){
		this.telefono = telefonoIntro;
	}
	public String getTelefono() {
		return this.telefono;
	}

	// Métodos Getter y Setter de edad
	public void setEdad (int edadIntro){
		this.edad = edadIntro;
	}
	public int getEdad() {
		return this.edad;
	}

}
