package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Clases.ArtCarrito;
import Clases.Articulo;
import Clases.Usuario;
import Menues.MenuArticulos;
import Menues.MenuUsuarios;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		ArrayList<ArtCarrito> carrito = new ArrayList<ArtCarrito>();
		
		Articulo papa = new Articulo(450, "papa", 100, 20); 
		Articulo banana = new Articulo(454, "banana", 130, 40);
		Articulo manzana = new Articulo(500, "manzana", 150, 80); 
		
		Usuario eitan = new Usuario("eitan", "eit", 123, "Empleado");
		Usuario cliente = new Usuario("cliente", "client", 123, "Cliente");
		usuarios.add(eitan);
		usuarios.add(cliente);
		
		
		articulos.add(papa);
		articulos.add(banana);
		articulos.add(manzana);
		
		MenuUsuarios menuUsu = new MenuUsuarios(sc, usuarios, 54321);
		MenuArticulos menuArts = new MenuArticulos(sc, articulos, carrito);
		String tipoUsu = null;
		boolean continuar = true;
		boolean conti = true;
		
		
		
		while(conti){
			
		
		while(!menuUsu.isLogueado()) {
			System.out.println("Desea:\n 1 - Iniciar sesion\n 2 - Registrarse\n 3 - Salir\n");
		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			menuUsu.iniciarSesion();
			tipoUsu = menuUsu.getTipoUsuario();
			menuArts.setUsuLogueado(menuUsu.getUsuLogueado());
			System.out.println("\n Bienvenido " + menuArts.getUsuLogueado().getNombre() + "!");
			continuar = true;
			break;

		case 2:
			menuUsu.registrar();
			break;
		
		case 3:
			menuUsu.setLogueado(true);
			conti=false;
			continuar = false;
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}				
		}
					
		if(tipoUsu == "Empleado") {
			while(continuar) {
			System.out.println("\nSeleccione la opcion que desea realizar\n");
			System.out.println("1 - Agregar un articulo");
			System.out.println("2 - Eliminar un articulo");
			System.out.println("3 - Editar un articulo");
			System.out.println("4 - Ver la lista de articulos");
			System.out.println("5 - Salir\n");
			
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				menuArts.agregarArticulos();
				break;
			case 2:
				menuArts.eliminarArticulo();
				break;
			case 3:
				menuArts.editarArticulo();
				break;
			case 4:
				menuArts.mostrarArticulos();
				break;
			case 5:
				menuUsu.setLogueado(false);
				continuar = false;
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;

			}
		}
			
		} else if (tipoUsu == "Cliente") {
			while(continuar) {
			
			System.out.println("\n0 - Ver listado de articulos");
			System.out.println("1 - Agregar articulo al carrito");
			System.out.println("2 - Eliminar articulo del carrito");			
			System.out.println("3 - Ver carrito");
			System.out.println("4 - Ver total");
			System.out.println("5 - Imprimir Factura");
			System.out.println("6 - Realizar compra");
			System.out.println("7 - Transferir dinero");
			System.out.println("8 - Ver saldo disponible");
			System.out.println("9 - Depositar dinero");
			System.out.println("10 - Salir\n");
			int op = sc.nextInt();
			
			switch (op) {
			case 0:
				menuArts.mostrarArticulos();
				break;
			case 1:
				menuArts.agregarAlCarrito();
				break;
			case 2:
				menuArts.eliminarArtCarrito();
				break;
			case 3:
				menuArts.mostrarCarrito();
				break;
			case 4:
				menuArts.imprimirTotal();
				break;
			case 5:
				menuArts.imprimirFactura();
				break;
			case 6:
				menuArts.realizarCompra();
				break;
			case 7:
				menuUsu.transferir();
				break;
			case 8:
				menuUsu.verSaldo();;
				break;
			case 9:
				menuUsu.depositarDinero();
			    break;
			case 10:
				continuar = false;
				menuUsu.setLogueado(false);
				menuArts.limpiarCarrito();
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}
		}
		}
		
	}

	

    	
    
}
