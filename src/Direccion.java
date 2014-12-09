
public class Direccion {

	// Propiedades
	private String calle;
	private int numero;
	private String piso;
	private String ciudad;
	private String provincia;
	private int codigoPostal;

	// Métodos Getter y Setter de calle
	public void setCalle (String calleIntro){
		this.calle = calleIntro;
	}
	public String getCalle() {
		return this.calle;
	}

	// Métodos Getter y Setter de piso
	public void setPiso (String pisoIntro){
		this.piso = pisoIntro;
	}
	public String getPiso() {
		return this.piso;
	}

	// Métodos Getter y Setter de ciudad
	public void setCiudad (String ciudadIntro){
		this.ciudad = ciudadIntro;
	}
	public String getCiudad() {
		return this.ciudad;
	}

	// Métodos Getter y Setter de provincia
	public void setProvincia (String provinciaIntro){
		this.provincia = provinciaIntro;
	}
	public String getProvincia() {
		return this.provincia;
	}

	// Métodos Getter y Setter de numero
	public void setNumero (int numeroIntro){
		this.numero = numeroIntro;
	}
	public int getNumero() {
		return this.numero;
	}

	// Métodos Getter y Setter de codigoPostal
	public void setCodigoPostal (int codigoPostalIntro){
		this.codigoPostal = codigoPostalIntro;
	}
	public int getCodigoPostal() {
		return this.codigoPostal;
	}

}
