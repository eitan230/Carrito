import java.util.ArrayList;
import java.util.Scanner;

import Usuario.Usuario;

public class MainnPractica {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
	boolean continuar = true;
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	for(int i= 0; i<3;i++) {
    	
    	}
    while(continuar) {
    	
    	System.out.println("Ingrese una opcion");
    	System.out.println("1 - Borrar un usuario");
    	System.out.println("2 - Mostrar todos los usuarios");
    	
    	int opcion = sc.nextInt();
    	switch (opcion) {
		case 1:
			System.out.println("Ingresar el usuario a borrar");
	    	String oo = sc.next();
	    	Usuario usuEn = new Usuario("sdfs", "asfsd", 3454, "empleado");
	    	int indexUsu = 0;
	    	
	    	for(int i=0; i<usuarios.size(); i++) {
	    		if(usuarios.get(i).getUsuario().equals(oo)) {
	    			usuEn = usuarios.get(i);
	    			indexUsu = (int) usuarios.indexOf(usuEn);
	    			System.out.println(indexUsu);
	    		} else {
	    			System.out.println("no existe tal usuario");
	    		}
	    	}
	    	System.out.println(indexUsu);
	    	
	    	System.out.println("Se eliminara eliminarlo?");
	    	
	    	
	    	usuarios.remove(indexUsu);			
			break;
		case 2:
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getUsuario());
			}
			break;
		case 3:
			
			System.out.println("Ingresar el usuario a borrar");
	    	String usuB = sc.next();
	    	Usuario usuBus = new Usuario("sdfs", "asfsd", 3454, "caca");
	    	int indexUsuBus = 0;
	    	for(int i=0; i<usuarios.size(); i++) {
	    		if(usuarios.get(i).getUsuario().equals(usuB)) {
	    			usuBus = usuarios.get(i);
	    			indexUsuBus = (int) usuarios.indexOf(usuBus);
	    			System.out.println(indexUsuBus);
	    		} else {
	    			System.out.println("no existe tal usuario");
	    		}
	    	}
	    	System.out.println(indexUsuBus);
			break;

		default:
			break;
		}
	}
	
    }
    
}
