package Logica;
import ucn.*;
import java.io.*;
public class App {
	public static void cargarArchivosFuncionarios(System sistema) throws IOException {
		ArchivoEntrada archivo = new ArchivoEntrada("Funcionarios.txt");
		boolean ingreso = true;
		while(!archivo.isEndFile() && ingreso) {
			Registro registro = archivo.getRegistro();
			int tipo = registro.getInt();
			if(tipo==1) {//Programador
				String rut = registro.getString();
				String nombre = registro.getString();
				String direccion = registro.getString();
				int sueldoBase = registro.getInt();
				String lenguaje = registro.getString();
				int hora = registro.getInt();
				int nivel = registro.getInt();
				ingreso = sistema.ingresarProgramador(rut, nombre, direccion, sueldoBase, tipo, lenguaje, hora, nivel);
				if(!ingreso) {
					StdOut.println("No hay más espacio!");
				}
			}else if(tipo ==2) {//Analista
				String rut = registro.getString();
				String nombre = registro.getString();
				String direccion = registro.getString();
				int sueldoBase = registro.getInt();
				int añosExpe = registro.getInt();
				ingreso = sistema.ingresarAnalista(rut, nombre, direccion, sueldoBase, tipo, añosExpe);
				if(!ingreso) {
					StdOut.println("No se presenta más espacio!");
				}
			}else if(tipo==3){//Ingeniero
				String rut = registro.getString();
				String nombre = registro.getString();
				String direccion = registro.getString();
				int sueldoBase = registro.getInt();
				String titulo = registro.getString();
				int cantidadFamiliares=registro.getInt();
				ingreso = sistema.ingresarIngeniero(rut, nombre, direccion, sueldoBase, tipo, titulo, cantidadFamiliares);
				if(!ingreso) {
					StdOut.println("no se presenta más espacio!");
				}
			}
		}
		archivo.close();
		StdOut.println("Terminado de leer el archivo Funcionario");
	}
	public static void cargarArhivosProyectos(System sistema )throws IOException{
		ArchivoEntrada archivo=new ArchivoEntrada("Proyectos.txt");
		boolean ingreso = true;
		while(!archivo.isEndFile() && ingreso) {
			Registro registro = archivo.getRegistro();
			String nombre = registro.getString();
			String codigo = registro.getString();
			int meses = registro.getInt();
			int costoTotal = registro.getInt();
			ingreso = sistema.ingresarProyectos(nombre, codigo, meses, costoTotal, null, null, null);
			if(!ingreso) {
				StdOut.println("No hay más espacio!");
			}
		}
		archivo.close();
		StdOut.println("Terminado de leer el archivo proyectos!");
	}
	public static void leerPersonalProyectos(System sistema) throws IOException {
		ArchivoEntrada archivo = new ArchivoEntrada("FuncionariosProyectos.txt");
		while(!archivo.isEndFile()) {
			Registro registro = archivo.getRegistro();
			String codigoProyecto = registro.getString();
			String rut = registro.getString();
			sistema.asociarFunciarioProyecto(codigoProyecto, rut);
		}
		archivo.close();
		StdOut.println("Terminado deleer Funcionarios Proyectos");
	}
	public static void main(String [] args) throws IOException {
		System sistema = new SystemImpl();
		cargarArchivosFuncionarios(sistema);
		cargarArhivosProyectos(sistema);
		leerPersonalProyectos(sistema);
		StdOut.println(sistema.desplegarListaProyectoCosto());
		StdOut.println(sistema.desplegarListadoFuncionarios());
		StdOut.println("Rut funcionario para ver sus proyectos:");
		String rut = StdIn.readString();
		StdOut.println(sistema.listadoProyectoporPersonal(rut));
		StdOut.println("Codigo proyecto para ver sus funcionarios: ");
		String codigo = StdIn.readString();
		StdOut.println(sistema.desplegarListaProyectoCosto());
		
	}
	
}