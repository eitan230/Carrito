package Menues;

import java.util.ArrayList;
import java.util.Scanner;

import Clases.ArtCarrito;
import Clases.Articulo;

public class MenuCarrito {
	
	private Scanner sc;
	private ArrayList<ArtCarrito> carrito;
	
	public MenuCarrito (Scanner sc, ArrayList<ArtCarrito> carrito) {
		super();
		this.sc = sc;
		this.carrito = carrito;
		
	}

	public ArrayList<ArtCarrito> getCarrito() {
		return carrito;
	}
	
	public void agregarAlCarrito() {
		System.out.println("\nIngrese el nombre del articulo que desea");
		String artDeseado = sc.next();
		ArtCarrito artAgregar = new ArtCarrito(); 
		boolean condition = true;
		
		for (ArtCarrito articulo : carrito) {
			if(articulo.getArt().getNombre().equals(artDeseado)) {
				System.out.println("Ingrese la cantidad que desea comprar");
				int cantidad = sc.nextInt();
				do {
					if(articulo.getArt().corroborarStock(cantidad)) {
						artAgregar = articulo;
						
					}
				} while (condition);
			}
			
		}
	}
}
