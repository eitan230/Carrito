package Menues;

import java.util.ArrayList;
import java.util.Scanner;

import Usuario.Articulo;
import Usuario.Usuario;

public class MenuUsuarios {
	private Scanner sc;
	private ArrayList<Usuario> usuarios;
	private boolean logueado;
	private String tipoUsuario;
	private Usuario usuLogueado;
	private int codigoComercio;
	
	public MenuUsuarios (Scanner sc, ArrayList<Usuario> usuarios, int codigo) {
		super();
		this.sc = sc;
		this.usuarios = usuarios;
		this.logueado = false;
		this.codigoComercio = codigo;
	}
	
	public void registrar() {
    	System.out.println("Que tipo de usuario quiere registrarse");
    	System.out.println("1 - Cliente");
    	System.out.println("2 - Empleado");
    	int opcion = sc.nextInt();
    	String tipoUsuario = "";
    	if(opcion == 1) {
    		tipoUsuario = "Cliente";
    	} else if (opcion == 2){
    		System.out.println("Para registrarse como empleado necesita del codigo de comercio, ingreselo a continuacion: ");
    		int codComercio = sc.nextInt();
    		boolean continuar = true;
    		do {
				if(codComercio != this.codigoComercio) {
					System.out.println("Codigo de comercio incorrecto, vuelva a intentarlo");
					codComercio = sc.nextInt();
				} else {
					continuar = false;
				}
			} while (continuar);
    		tipoUsuario = "Empleado";
    	}
		
    	System.out.println("Ingrese su nombre");
    	String nombre = sc.next();
    	
    	System.out.println("Ingrese un nombre de usuario");
    	String usuario = sc.next().toLowerCase();
    	boolean continuar = true;
		
		do {
		boolean existe = false;
			for (Usuario usu : usuarios) {
				if(usu.getUsuario().equals(usuario)) {
					existe = true;
					break;
				}
			}
		
			if(existe) {
				System.out.println("Ya existe una persona regsitrada con ese nombre de usuario, ingrese uno distinto");
				usuario = sc.next();
			} else {
				continuar = false;
			}
			
		} while (continuar);
    	
    	System.out.println("Ingrese una contraseña");
    	long contraseña = sc.nextLong();
    	continuar = true;
    	do {
			if(contraseña <= 100 || contraseña > 999999999) {
				System.out.println("Ingrese una contraseña de entre 3 a 9 digitos");
				contraseña = sc.nextLong();
			} else {
				continuar = false;
			}
			
		} while (continuar);
    	
    	
    	Usuario u = new Usuario(nombre, usuario, contraseña, tipoUsuario);
    	
    	usuarios.add(u);
    	System.out.println("Registro realizado exitosamente!");
	}
	public void iniciarSesion() {
		System.out.println("Ingrese su usuario");
		String usu = sc.next();
		Usuario usuEncontrado = new Usuario("asd", "asfasd", 23423, "asdasd");
		boolean continuar = true;
		while(continuar == true) {
			
			
			
			boolean encontrado = false;
			for (Usuario usuario : usuarios) {
				if(usuario.getUsuario().equals(usu)) {
					usuEncontrado = usuario;
					encontrado = true;
				}
				
			}
			if(encontrado == true) {
				continuar = false;
			} else {
				System.out.println("\nUsuario no encontrado");
				System.out.println("Por favor, introduzca su usuario nuevamente\n");
				usu = sc.next();
			}
			
		
		}
		
		System.out.println("\nIngrese su contraseña\n");
		int contraseña = sc.nextInt();
		continuar = true;
		while(continuar) {
			if(usuEncontrado.getContraseña() == contraseña) {
				this.tipoUsuario = usuEncontrado.getTipoUsuario();
				System.out.println("\nLogueado exitosamente!\n");
				this.usuLogueado = usuEncontrado;
				this.logueado = true;
				continuar = false;
				
			} else {
				System.out.println("\nContraseña incorrecta vuelva a intentarlo");
				contraseña = sc.nextInt();
			}
		}
		
	}
	
	public void verSaldo() {
		System.out.println("Su saldo actual es de: $" + usuLogueado.getSaldo());
	}
	
	public void depositarDinero() {
		System.out.println("Ingrese el monto que desea depositar");
		double monto = sc.nextDouble();
		if(monto > 0) {
			usuLogueado.deposita(monto);
		} else {
			System.out.println("El monto a depositar debe ser mayor a 0");
		}
		
	}
	
	public void transferir() {
		System.out.println("Ingrese el usuario de la persona a la que desea transferir");
		String usuTransferir = sc.next();
		
		boolean continuar = true;
		
		do {
			boolean existe = false;
			for (Usuario usuario : usuarios) {
				if(usuario.getUsuario().equals(usuTransferir)) {
					System.out.println("Ingrese el monto que desea tranferir");
					double monto = sc.nextDouble();
					usuLogueado.transferir(monto, usuario);
					existe = true;
					continuar = false;
				}
			}
			
			if(!existe) {
				System.out.println("\nEl usuario no existe o no es correcto, vuelva a intentarlo\n");
				usuTransferir = sc.next();
				} 
		} while (continuar);
		
		

		
		
	}
	
	
	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public Usuario getUsuLogueado() {
		return usuLogueado;
	}
	
}
