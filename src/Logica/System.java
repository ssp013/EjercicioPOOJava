package Logica;

import Dominio.Funcionario;

public interface System{
	public boolean ingresarProyectos(String nombre,String codigo,int meses,int costoTotal,Funcionario Analista, Funcionario Programador, Funcionario Ingeniero);
	public boolean ingresarProgramador(String rut , String nombre, String direccion, int sueldoBase , 
	int tipo,String lenguaje, int hora, int nivel);
	public boolean ingresarAnalista(String rut, String nombre,String direccion, int sueldoBase,int tipo,int añosExpe);
	public boolean ingresarIngeniero(String rut , String nombre, String direccion, int sueldoBase , int tipo,String titulo, int cantidadFamiliares );
	public String desplegarListaProyectoCosto();
	public String desplegarListadoFuncionarios();
	public String listadoPersonalporProyecto(String codigo);
	public String listadoProyectoporPersonal(String rut);
	public void asociarFunciarioProyecto(String codigoProyecto, String rut);
}