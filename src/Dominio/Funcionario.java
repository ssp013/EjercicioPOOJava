package Dominio;
import Logica.*;
public abstract class Funcionario{
	private String rut;
	private String nombre;
	private String direccion;
	private int sueldoBase;
	private int tipo;
	private ListaProyecto LP;
	public Funcionario(String rut , String nombre, String direccion, int sueldoBase , int tipo) {
		this.rut = rut;
		this.nombre = nombre;
		this.direccion = direccion;
		this.sueldoBase = sueldoBase;
		this.tipo = tipo;
		LP = new ListaProyecto(5);
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getdireccion() {
		return direccion;
	}
	public void setdireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getsueldoBase() {
		return sueldoBase;
	}
	public void setsueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public ListaProyecto getListaProyecto() {
		return LP;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	abstract public double calcularSueldo();
}