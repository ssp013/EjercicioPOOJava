package Dominio;
import Logica.*;
public class Ingeniero extends Funcionario{
	private String titulo;
	private int cantidadFamiliares;
	public Ingeniero(String rut , String nombre, String direccion, int sueldoBase , int tipo,String titulo, int cantidadFamiliares ) {
		super(rut,nombre,direccion,sueldoBase,tipo);
		this.titulo = titulo;
		this.cantidadFamiliares = cantidadFamiliares;
	}
	public double calcularSueldo() {
		double sueldoFinal = getsueldoBase() + (8000*cantidadFamiliares);
		ListaProyecto lp = getListaProyecto();
		for(int i =0;i<lp.getCantidadProyecto();i++) {
			int costo = lp.getProyectoI(i).getcostoTotal();
			sueldoFinal+=(costo/12)*0.3;
		}
		return sueldoFinal;
	}
}
