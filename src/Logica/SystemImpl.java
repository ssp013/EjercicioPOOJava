package Logica;
import Dominio.*;
public class SystemImpl implements System{
	ListaFuncionario listafuncionarios;
	ListaProyecto listaproyectos;
	public SystemImpl() {
		listafuncionarios = new ListaFuncionario(1000);
		listaproyectos = new ListaProyecto(1000);
	}
	@Override
	public boolean ingresarProyectos(
	String nombre,String codigo,int meses,int costoTotal,Funcionario Analista, Funcionario Programador, Funcionario Ingeniero) {
		boolean resp = false;
		Proyecto p = listaproyectos.BuscarProyecto(codigo);
		if(p==null) {
			Proyecto p1= new Proyecto(nombre,codigo,meses,costoTotal,Analista,Programador,Ingeniero);
			resp = listaproyectos.ingresarProyecto(p1);
		}
		return resp;
	}
	@Override
	public boolean ingresarProgramador(String rut , String nombre, String direccion, int sueldoBase,
	int tipo,String lenguaje, int hora, int nivel) {
		boolean resp = false;
		Funcionario f = listafuncionarios.buscarFuncionario(rut);
		if(f==null) {
			Funcionario elProgramador = new Programador(rut,nombre,direccion,sueldoBase,tipo,lenguaje,hora,nivel);
			resp = listafuncionarios.ingresarFuncionario(elProgramador);
		}
		return resp;
	}
	@Override
	public boolean ingresarAnalista(String rut, String nombre,String direccion, int sueldoBase,int tipo,int añosExpe) {
		boolean resp = false;
		Funcionario f = listafuncionarios.buscarFuncionario(rut);
		if( f==null) {
			Funcionario elAnalista = new Analista(rut,nombre,direccion, sueldoBase,tipo,añosExpe);
			resp = listafuncionarios.ingresarFuncionario(elAnalista);
		}
		return resp;	
	}
	@Override
	public boolean ingresarIngeniero(String rut , String nombre, String direccion, int sueldoBase , int tipo,String titulo, int cantidadFamiliares ) {
		boolean resp = false;
		Funcionario f = listafuncionarios.buscarFuncionario(rut);
		if(f==null) {
			Funcionario elIngeniero = new Ingeniero(rut,nombre,direccion,sueldoBase,tipo,titulo,cantidadFamiliares);
			resp = listafuncionarios.ingresarFuncionario(elIngeniero);
		}
		return resp;
	}
	@Override
	public String desplegarListaProyectoCosto() {
		String r="";
		for(int i=0;i<listaproyectos.getCantidadProyecto();i++) {
			Proyecto p = listaproyectos.getProyectoI(i);
			r+="- Nombre: "+p.getNombre()+" ----- Costo Total: "+p.getcostoTotal()+"\n";
		}
		return r;
	}
	@Override
	public String desplegarListadoFuncionarios() {
		String r="";
		for(int i=0;i<listafuncionarios.getCantidadFuncionario();i++){
			Funcionario f = listafuncionarios.getFuncionarioI(i);
			r+="Rut: "+f.getRut()+", Nombre: "+f.getnombre()+", direccion:"+f.getdireccion()+", sueldoBase"+f.getsueldoBase()+"\n";
		}
		return r;	
	}
	@Override
	public String listadoPersonalporProyecto(String codigo) {
		String r="";
		Proyecto p = listaproyectos.BuscarProyecto(codigo);
		if(p!=null) {
			if(p.getIngeniero()!=null) {
				r+="ingeniero: "+p.getIngeniero().getnombre()+"\n";
			}else if(p.getAnalista()!=null) {
				r+="Analista: "+p.getAnalista().getnombre()+"\n";
			}else if(p.getProgramador()!=null) {
				r+="Programador: "+p.getProgramador().getnombre()+"\n";
			}
		}else {
			r+="Proyecto No encontrado!";
		}
		return r;
	}
	@Override
	public String listadoProyectoporPersonal(String rut) {
		String r="";
		Funcionario f = listafuncionarios.buscarFuncionario(rut);
		if(f!=null) {
			r+="Nombre: "+f.getnombre()+"\n";
			ListaProyecto lp= f.getListaProyecto();
			for(int i=0;i<lp.getCantidadProyecto();i++) {
				Proyecto p = lp.getProyectoI(i);
				if(p!=null) {
					int cont = i+1;
					r+="Proyecto Nº"+cont+": "+p.getNombre()+"\n";					
				}
			}			
		}
		return r;
	}
	@Override
	public void asociarFunciarioProyecto(String codigoProyecto, String rut) {
		Proyecto p = listaproyectos.BuscarProyecto(codigoProyecto);
		Funcionario f = listafuncionarios.buscarFuncionario(rut);
		if(p!=null && f!=null) {
			if(f instanceof Programador) {
				p.setProgramador(f);
			}else {
				if(f instanceof Analista) {
					p.setAnalista(f);
				}else {
					p.setIngeniero(f);
				}
				
			}
		}else {
			throw new NullPointerException("no existe el proyecto y/o funcionario");
		}
	}
}