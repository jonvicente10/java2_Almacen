
public class Manzana {

	// Propiedades
	private String tipoManzana;
	private String procedencia;
	private String color;
	private Double eurosKilo;
	private Distribuidor distribuidor;
	private String codigoBarras;

	// Métodos Getter y Setter de tipoManzana
	public void setTipoManzana (String tipoManzanaIntro){
		this.tipoManzana = tipoManzanaIntro;
	}
	public String getTipoManzana() {
		return this.tipoManzana;
	}

	// Métodos Getter y Setter de procedencia
	public void setProcedencia (String procedenciaIntro){
		this.procedencia = procedenciaIntro;
	}
	public String getProcedencia() {
		return this.procedencia;
	}

	// Métodos Getter y Setter de color
	public void setColor (String colorIntro){
		this.color = colorIntro;
	}
	public String getColor() {
		return this.color;
	}

	// Métodos Getter y Setter de eurosKilo
	public void setEurosKilo (double eurosKiloIntro){
		this.eurosKilo = eurosKiloIntro;
	}
	public double getEurosKilo() {
		return this.eurosKilo;
	}

	// Métodos Getter y Setter de distribuidor
	public void setDistribuidor (Distribuidor distribuidorIntro){
		this.distribuidor = distribuidorIntro;
	}
	public Distribuidor getDistribuidor() {
		return this.distribuidor;
	}

	// Métodos Getter y Setter de codigoBarras
	public void setCodigoBarras (String codigoBarrasIntro){
		this.codigoBarras = codigoBarrasIntro;
	}
	public String getCodigoBarras() {
		return this.codigoBarras;
	}
	
}