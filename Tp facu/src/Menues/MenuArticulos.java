package Menues;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Clases.ArtCarrito;
import Clases.Articulo;
import Clases.Usuario;

public class MenuArticulos {
	
	private Scanner sc;
	private ArrayList<Articulo> articulos;
	private ArrayList<ArtCarrito> carrito;
	private Usuario usuLogueado;
	
	public MenuArticulos (Scanner sc, ArrayList<Articulo> articulos, ArrayList<ArtCarrito> carrito) {
		super();
		this.sc = sc;
		this.articulos = articulos;
		this.carrito = carrito;
		
	}
	
	public int ingresarNumInt() {
		int numero = 0;
		boolean numValido = false;
		do {
			try {
				numero = sc.nextInt();
				numValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un numero, vuelva a intentarlo");
				sc.nextLine();
				numValido = false;
			}
		} while (!numValido);
		
		return numero;
	}
	
	public int ingNumIntMayor0(){
		int numero = ingresarNumInt();
		boolean numValido = false;
		do {
			if(numero <= 0) {
				System.out.println("El numero a ingresar debe ser mayor a 0");
				numero = ingresarNumInt();
			} else {
				numValido = true;
			}
		} while (!numValido);
		
		return numero;
	}
	
	public double ingNumDoubMayor0(){
		double numero = ingresarNumDouble();
		boolean numValido = false;
		do {
			if(numero <= 0) {
				System.out.println("El numero a ingresar debe ser mayor a 0");
				numero = ingresarNumDouble();
			} else {
				numValido = true;
			}
		} while (!numValido);
		
		return numero;
	}
	
	public double ingresarNumDouble() {
		double numero = 0;
		boolean numValido = false;
		do {
			try {
				numero = sc.nextDouble();
				numValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Error: Debe ingresar un numero, vuelva a intentarlo");
				sc.nextLine();
				numValido = false;
			}
		} while (!numValido);
		
		return numero;
	}
	
	public void agregarArticulos(){
		System.out.println("Ingrese el codigo del articulo");
		int codigoArt = ingresarNumInt();

		boolean continuar = true;
		
		do {
		boolean existe = false;
			for (Articulo articulo : articulos) {
				if(articulo.getCodArticulo() == codigoArt) {
					existe = true;
					break;
				}
			}
		
			if(existe) {
				System.out.println("Ya existe un articulo con ese codigo, ingresa un codigo de articulo distinto");
				codigoArt = ingresarNumInt();
			} else {
				continuar = false;
			}
			
		} while (continuar);
		
		
		System.out.println("Ingrese el nombre del articulo");
		String nombreArt = sc.next().toLowerCase();
		continuar = true;
		
		do {
			boolean existe = false;
				for (Articulo articulo : articulos) {
					if(articulo.getNombre().equals(nombreArt)) {
						existe = true;
						break;
					}
				}
			
				if(existe) {
					System.out.println("Ya existe un articulo con ese nombre, ingrese un nombre distinto");
					nombreArt = sc.next();
				} else {
					continuar = false;
				}
				
			} while (continuar);
		
		
		System.out.println("Ingrese el precio del articulo");
		double precioArt = ingNumDoubMayor0();		
		
		System.out.println("Ingrese el stock del articulo");
		int stockArt = ingNumIntMayor0();

		
		Articulo art = new Articulo(codigoArt, nombreArt, precioArt, stockArt);
		
		articulos.add(art);
		
	}
	
	public void eliminarArticulo() {
		System.out.println("Ingrese el nombre del articulo a borrar");
		String artBorrar = sc.next();
		boolean continuar = true;
		do {
			boolean existe = false;
			for (Articulo articulo : articulos) {
				if(articulo.getNombre().equals(artBorrar)) {
					articulos.remove(articulo);
					continuar = false;
					existe = true;
					System.out.println("\nArticulo eliminado exitosamente!\n");
					break;
					}
					
				}
			
			if(!existe) {
				System.out.println("\nEl articulo no existe o el nombre no es correcto, vuelva a intentarlo\n");
				artBorrar = sc.next();
				} 
		} while (continuar);
		
		
	}
	
	public void editarArticulo() {
		System.out.println("Ingrese el nombre del articulo que desea editar");
		String artBorrar = sc.next();
		
		System.out.println("Ingrese el atributo del articulo que desea editar");
		System.out.println("1 - Codigo de articulo");
		System.out.println("2 - Nombre");
		System.out.println("3 - Precio");
		System.out.println("4 - Stock");
		int opcion = ingresarNumInt();
		
		for (Articulo articulo : articulos) {
			if(articulo.getNombre().equals(artBorrar)) {
				switch (opcion) {
				case 1:
					articulo.setCodArticulo(ingresarNumInt());
					break;
				case 2:
					articulo.setNombre(sc.next());
					break;
				case 3:
					articulo.setPrecio(ingresarNumDouble());
					break;
				case 4:
					articulo.setStock(ingresarNumInt());
					break;
				default:
					System.out.println("Opcion incorrecta");
					break;
				}
				break;
			}
		}
	}
	
	public void mostrarArticulos() {
		if (articulos.size() == 0) {
			System.out.println("No hay articulos disponibles");
		} else {
			for (Articulo articulo : articulos) {
			System.out.println("------------------------------------");	
			System.out.println(articulo);
			}
			System.out.println("------------------------------------");
		}
		
	}
	
	public void agregarAlCarrito() {
		System.out.println("\nIngrese el nombre del articulo que desea");
		String artDeseado = sc.next();
		Articulo artAgregar = new Articulo(); 
		boolean continuar = true;
		
		
		for (ArtCarrito articulo : carrito) {
			
				if(articulo.getArt().getNombre().equals(artDeseado)) {
					if(articulo.getArt().hayStock()) {
						System.out.println("\nYa posee este articulo en su carrito, desea agregar mas cantidad del mismo?");
						System.out.println("1 - Si\n2 - No\n");
						int opcion = ingresarNumInt();
						switch (opcion) {
						case 1:
							System.out.println("\nIngrese la cantidad del producto que desea agregar");
							int cantAgregar = ingNumIntMayor0();							
							do {
								if(articulo.getArt().corroborarStock(cantAgregar)) {
									articulo.agregarCantidad(cantAgregar);
									continuar = false;
								} else {
									System.out.println("El stock solicitado del producto no es suficiente, ingrese una cantidad menor o igual a " + articulo.getArt().getStock());
									cantAgregar = ingNumIntMayor0();
									continuar = true;
								}
							} while (continuar);
							
							break;
						case 2:
							continuar = false;
							break;
						default:
							System.out.println("\nOpcion incorrecta\n");
							break;
						}
					} else {
						System.out.println("No hay mas stock del articulo, lo sentimos");
						continuar = false;
						break;
					}
		
				}
			}
			
		
		while(continuar) {
			
		boolean existe = true;
		
		for (Articulo articulo : articulos) {
			if(articulo.getNombre().equals(artDeseado)) {
					System.out.println("Ingrese la cantidad que desea comprar");
					int cantidad = ingNumIntMayor0();
					boolean corroborar = true;
					do {
						if(articulo.corroborarStock(cantidad)) {
							artAgregar = articulo;
							articulo.comprar(cantidad);
							ArtCarrito art = new ArtCarrito(artAgregar, cantidad);
							carrito.add(art);
							corroborar = false;
							continuar = false;
							existe = true;
						} else {
							System.out.println("Lo siento, no poseemos suficiente stock para la cantidad solicitada, ingrese una cantidad menor");
							cantidad = ingNumIntMayor0();
						}
					} while (corroborar);
					break;										
			} else {
				existe = false;
			}
			
		}
		
			if(!existe) {
				System.out.println("El articulo solicitado no existe o su nombre esta mal escrito, vuelva a intentarlo");
				artDeseado = sc.next();
			}
		}
	}
	
	public void eliminarArtCarrito() {
		System.out.println("\nIngrese el nombre del articulo que desea eliminar del carrito");
		String artBorrar = sc.next();
		boolean continuar = true;
		do {
			boolean existe = false;
			for (ArtCarrito articulo : carrito) {
				if(articulo.getArt().getNombre().equals(artBorrar)) {
					
					articulo.getArt().reponer(articulo.getCantidad());
					
					carrito.remove(articulo);
					System.out.println("\nArticulo eliminado exitosamente!\n");
					existe = true;
					continuar = false;
					break;
				}
			}
			
			if(!existe) {
				System.out.println("El articulo no esta en su carrito o su nombre no es el correcto, vuelva a ingresarlo");
				artBorrar = sc.next();
			}
			
		} while (continuar);
	}

	public void mostrarCarrito() {
		if(carrito.size() == 0) {
			System.out.println("\nTodavia no agrego articulos a su carrito\n");
		} else {
			for (ArtCarrito art : carrito) {
				System.out.println(art);
			}
		}	
	}
	
	public void imprimirFactura() {
		double totalDeCompra = calcularTotal();
		System.out.println("------------------------------------");
		System.out.println("|       Factura de compra          |");
		System.out.println("------------------------------------");
		for (ArtCarrito articulo : carrito) {
			double total = articulo.getArt().getPrecio() * (double) articulo.getCantidad();
			System.out.println("  " + articulo.getCantidad() + " x " +  articulo.getArt().getPrecio() + "          ");
			System.out.println("  " + articulo.getArt().getNombre().toUpperCase() + "                   " + total + " \n"  );
		}
		System.out.println("------------------------------------");
		System.out.println("| TOTAL                   " + "$ " + totalDeCompra + " |");
		System.out.println("------------------------------------\n");
	}
	
	
	public double calcularTotal() {
		double total = 0;
		for (ArtCarrito articulo : carrito) {
			double precioTotal = articulo.getArt().getPrecio() * (double) articulo.getCantidad();
			total += precioTotal;
		}		
		return total;
	}
	
	public void imprimirTotal() {
		System.out.println("El total de su compra es de " + calcularTotal());
	}
	
	
	public void realizarCompra() {
		double total = calcularTotal();
		if(usuLogueado.getSaldo() < total) {
			System.out.println("No posee el saldo suficiente para realizar esta compra, elimine algunos articulos del carrito");
		} else {
			for (ArtCarrito articulo : carrito) {
				articulo.getArt().comprar(articulo.getCantidad());
			}
			usuLogueado.retiroEfectivo(total);
			System.out.println("Compra exitosa\n");
			System.out.println("Muchas gracias por su compra!\n\n");
			imprimirFactura();
			limpiarCarrito();
		}
		
	}
	
	public void limpiarCarrito() {
		if(carrito.size() != 0 ) {
			for (ArtCarrito articulo : carrito) {
				articulo.getArt().reponer(articulo.getCantidad());
			}
		}
		
		carrito.clear();
	}
	
	public Usuario getUsuLogueado() {
		return usuLogueado;
	}

	public void setUsuLogueado(Usuario usuLogueado) {
		this.usuLogueado = usuLogueado;
	}
	
	
	
	
	
	
	
	
}
