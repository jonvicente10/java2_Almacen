import java.util.*;

public class Cesta {

	// Propiedades
	private Cliente cliente;
	private ArrayList <Manzana> manzanas;
	private ArrayList <Lechuga> lechugas;
	private ArrayList <Leche> leches;
	private double importe;


	// Metodos Getter y Setter de cliente
	public void setCliente (Cliente clienteIntro){
		this.cliente = clienteIntro;
	}
	public Cliente getCliente() {
		return this.cliente;
	}

	// Metodos Getter y Setter de manzanas
	public void setManzanas (ArrayList <Manzana> manzanasIntro){
		this.manzanas = manzanasIntro;
	}
	public ArrayList <Manzana> getManzanas() {
		return this.manzanas;
	}

	// Metodos Getter y Setter de lechugas
	public void setLechugas (ArrayList <Lechuga> lechugasIntro){
		this.lechugas = lechugasIntro;
	}
	public ArrayList <Lechuga> getLechugas() {
		return this.lechugas;
	}

	// Metodos Getter y Setter de leches
	public void setLeches (ArrayList <Leche> lechesIntro){
		this.leches = lechesIntro;
	}
	public ArrayList <Leche> getLeches() {
		return this.leches;
	}

	// Metodos Getter y Setter de importe
	public void setImporte () {
		double importeManzanas = 0;
		double importeLechugas = 0;
		double importeLeches = 0;
		for (int i=0; i<this.manzanas.size(); i++) {
			importeManzanas = importeManzanas + (this.manzanas.get(i).getEurosKilo() - (this.manzanas.get(i).getEurosKilo() * (this.cliente.getDto() / 100)));
		}
		for (int i=0; i<this.lechugas.size(); i++) {
			importeLechugas = importeLechugas + (this.lechugas.get(i).getEurosUnidad() - (this.lechugas.get(i).getEurosUnidad() * (this.cliente.getDto() / 100)));
		}
		for (int i=0; i<this.leches.size(); i++) {
			importeLeches = importeLeches + (this.leches.get(i).getEurosLitro() - (this.leches.get(i).getEurosLitro() * (this.cliente.getDto() / 100)));
		}
		this.importe = importeManzanas + importeLechugas + importeLeches;
	}
	public double getImporte () {
		return this.importe;
	}
}