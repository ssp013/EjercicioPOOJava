package Logica;
import Dominio.*;
public class ListaProyecto {
	private Proyecto [] LP;
	private int cantidad;
	private int max;
	public ListaProyecto(int max) {
		LP = new Proyecto[100];
		this.cantidad=0;
		this.max = max;
	}
	public boolean ingresarProyecto(Proyecto p) {
		boolean resp = false;
		if(cantidad <max) {
			LP[cantidad]=p;
			cantidad++;
			resp = true;
		}		
		return resp;
	}
	public Proyecto getProyectoI(int i) {
		if(i>=0 && i<cantidad) {
			return LP[i];			
		}else {
			return null;
		}
	}
	public Proyecto BuscarProyecto(String codigo) {
		int i;
		for(i=0;i<cantidad;i++) {
			if(LP[i].getcodigo().equals(codigo)) {
				break;
			}
		}
		if(i==cantidad) {
			return null;
		}else {
			return LP[i];
		}
	}
	public int getCantidadProyecto() {
		return cantidad;
	}
}
