package Dominio;
import Logica.*;
public class Programador extends Funcionario {
	private String lenguaje;
	private int hora;
	private int nivel;
	public Programador(String rut , String nombre, String direccion, int sueldoBase , 
			int tipo,String lenguaje, int hora, int nivel) {
		super(rut,nombre,direccion,sueldoBase,tipo);
		
		this.lenguaje= lenguaje;
		this.hora = hora;
		this.nivel = nivel;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public double calcularSueldo() {
		double sueldo = hora*5000;
		sueldo+=nivel*30000;
		ListaProyecto lp = getListaProyecto();
		for(int i=0;i<lp.getCantidadProyecto();i++) {
			int costoTotal = lp.getProyectoI(i).getcostoTotal();
			costoTotal = costoTotal/12;
			sueldo+=costoTotal*0.2;
		}
		return sueldo;
	}
}