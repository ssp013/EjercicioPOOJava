package Dominio;
import Logica.*;
public class Analista extends Funcionario{
	private int añosExpe;
	private static int porcentajPorProyecto = 25;
	public Analista(String rut, String nombre,String direccion, int sueldoBase,int tipo,int añosExpe) {
		super(rut,nombre,direccion,sueldoBase,tipo);
		this.añosExpe = añosExpe;
	}
	public int getAñozExpe() {
		return añosExpe;
	}
	public void setañosExpe(int añosExpe) {
		this.añosExpe = añosExpe;
	}
	public double calcularSueldo() {
		double sueldo = this.getsueldoBase() + (5000*añosExpe);
		ListaProyecto lp = getListaProyecto();
		for(int i =0;i<lp.getCantidadProyecto();i++) {
			Proyecto p = lp.getProyectoI(i);
			double costoMensual = p.getcostoTotal()/12;
			double resultado = costoMensual*0.25;
			sueldo+=resultado;
		}
		
		return sueldo;
	}
}