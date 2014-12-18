
public class Lechuga {

	// Propiedades
	private String tipoLechuga;
	private String procedencia;
	private String color;
	private Double eurosUnidad;
	private Distribuidor distribuidor;
	private String codigoBarras;

	// Métodos Getter y Setter de tipoLechuga
	public void setTipoLechuga (String tipoLechugaIntro){
		this.tipoLechuga = tipoLechugaIntro;
	}
	public String getTipoLechuga() {
		return this.tipoLechuga;
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

	// Métodos Getter y Setter de eurosUnidad
	public void setEurosUnidad (double eurosUnidadIntro){
		this.eurosUnidad = eurosUnidadIntro;
	}
	public double getEurosUnidad() {
		return this.eurosUnidad;
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