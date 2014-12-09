
public class Leche {

	// Propiedades
	private String tipoLeche;
	private String procedencia;
	private Double eurosLitro;
	private Distribuidor distribuidor;

	// Métodos Getter y Setter de tipoLeche
	public void setTipoLeche (String tipoLecheIntro){
		this.tipoLeche = tipoLecheIntro;
	}
	public String getTipoLeche() {
		return this.tipoLeche;
	}

	// Métodos Getter y Setter de procedencia
	public void setProcedencia (String procedenciaIntro){
		this.procedencia = procedenciaIntro;
	}
	public String getProcedencia() {
		return this.procedencia;
	}

	// Métodos Getter y Setter de eurosLitro
	public void setEurosLitro (double eurosLitroIntro){
		this.eurosLitro = eurosLitroIntro;
	}
	public double getEurosLitro() {
		return this.eurosLitro;
	}

	// Métodos Getter y Setter de distribuidor
	public void setDistribuidor (Distribuidor distribuidorIntro){
		this.distribuidor = distribuidorIntro;
	}
	public Distribuidor getDistribuidor() {
		return this.distribuidor;
	}

}