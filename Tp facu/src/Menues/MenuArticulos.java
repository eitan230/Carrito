package Menues;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Scanner;

import Usuario.ArtCarrito;
import Usuario.Articulo;
import Usuario.Usuario;

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
	
	public void agregarArticulos(){
		System.out.println("Ingrese el codigo del articulo");
		int codigoArt = sc.nextInt();
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
				codigoArt = sc.nextInt();
			} else {
				continuar = false;
			}
			
		} while (continuar);
		
		
		System.out.println("Ingrese el nombre del articulo");
		String nombreArt = sc.next().toLowerCase();
		
		System.out.println("Ingrese el precio del articulo");
		double precioArt = sc.nextDouble();
		continuar = true;
		do {
			if(precioArt <= 0) {
				System.out.println("Ingrese un precio superior a 0");
				precioArt = sc.nextDouble();
			} else {
				continuar = false;
			}
			
		} while (continuar);
		
		
		System.out.println("Ingrese el stock del articulo");
		int stockArt = sc.nextInt();
		continuar = true;
		do {
			if(stockArt <= 0) {
				System.out.println("Ingrese un stock superior a 0");
				stockArt = sc.nextInt();
			} else {
				continuar = false;
			}
			
		} while (continuar);
		
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
		int opcion = sc.nextInt();
		
		for (Articulo articulo : articulos) {
			if(articulo.getNombre().equals(artBorrar)) {
				switch (opcion) {
				case 1:
					articulo.setCodArticulo(sc.nextInt());
					break;
				case 2:
					articulo.setNombre(sc.next());
					break;
				case 3:
					articulo.setPrecio(sc.nextDouble());
					break;
				case 4:
					articulo.setStock(sc.nextInt());
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
						int opcion = sc.nextInt();
						switch (opcion) {
						case 1:
							System.out.println("\nIngrese la cantidad del producto que desea agregar");
							int cantAgregar = sc.nextInt();							
							do {
								if(articulo.getArt().corroborarStock(cantAgregar)) {
									articulo.agregarCantidad(cantAgregar);
									continuar = false;
								} else {
									System.out.println("El stock solicitado del producto no es suficiente, ingrese una cantidad menor o igual a " + articulo.getArt().getStock());
									cantAgregar = sc.nextInt();
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
					int cantidad = sc.nextInt();
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
							cantidad = sc.nextInt();
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
