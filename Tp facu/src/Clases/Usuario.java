package Clases;

public class Usuario {
	
	private String nombre;
	private String usuario;
	private long contraseña;
	private String tipoUsuario;
	private double saldo;
	
	public Usuario(String nombre, String usuario, long contraseña, String tipoUsuario) {
		
		this.nombre = nombre;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.tipoUsuario = tipoUsuario;
		this.saldo = (2000);
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public long getContraseña() {
		return contraseña;
	}
	public void setContraseña(long contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void retiroEfectivo(double cantidad) {
		this.saldo -= cantidad;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public void transferir(double saldo, Usuario usu) {
		
		if(saldo <= 0) {
			System.out.println("El monto a transferir debe ser mayor que 0");
		} else if(this.saldo < saldo) {
			System.out.println("Saldo insuficiente para realizar esta operacion");
		} else {
			this.saldo -= saldo;
			usu.deposita(saldo);;
		}
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", usuario=" + usuario + ", tipoUsuario=" + tipoUsuario + ", saldo="
				+ saldo + "]";
	}
	
	
}
