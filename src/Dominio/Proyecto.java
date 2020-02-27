package Dominio;

public class Proyecto {
	private String nombre;
	private String codigo;
	private int meses;
	private int costoTotal;
	private Funcionario Analista;
	private Funcionario Programador;
	private Funcionario Ingeniero;
	public Proyecto(String nombre,String codigo,int meses,int costoTotal,Funcionario Analista, Funcionario Programador, Funcionario Ingeniero) {
		this.nombre= nombre;
		this.codigo = codigo;
		this.meses = meses;
		this.costoTotal = costoTotal;
		this.Analista = Analista;
		this.Programador = Programador;
		this.Ingeniero = Ingeniero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getcodigo() {
		return codigo;
	}
	public void setcodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getmeses() {
		return meses;
	}
	public void setmeses(int meses) {
		this.meses = meses;
	}
	public int getcostoTotal() {
		return costoTotal;
	}
	public void setcostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Funcionario getAnalista() {
		return Analista;
	}
	public void setAnalista(Funcionario Analista) {
		this.Analista = Analista;
	}
	public Funcionario getIngeniero() {
		return Ingeniero;
	}
	public void setIngeniero(Funcionario Ingeniero) {
		this.Ingeniero = Ingeniero;
	}
	public Funcionario getProgramador() {
		return Programador;
	}
	public void setProgramador(Funcionario Programador) {
		this.Programador = Programador;
	}
}
