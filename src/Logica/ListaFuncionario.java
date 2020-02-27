package Logica;
import Dominio.*;
public class ListaFuncionario {

	private int cant;
	private int max;
	private Funcionario []LF;
	public ListaFuncionario(int max) {
		// TODO Auto-generated constructor stub
		LF = new Funcionario[1000];
		this.cant=0;
		this.max = max;
	}
	public boolean ingresarFuncionario(Funcionario F) {
		boolean resp = false;
		if(cant < max) {
			LF[cant]=F;
			cant++;
			resp = true;
		}
		return resp;
	}
	public int getCantidadFuncionario() {
		return cant;
	}
	public Funcionario getFuncionarioI(int i) {
		if(i>=0 && i<cant) {
			return LF[i];
		}else {
			return null;
		}
	}
	public Funcionario buscarFuncionario(String rut) {
		int i;
		for(i=0;i<cant;i++) {
			if(LF[i].getRut().equals(rut)) {
				break;
			}
		}
		if(i==cant) {
			return null;
		}else {
			return LF[i];
		}
	}
}
