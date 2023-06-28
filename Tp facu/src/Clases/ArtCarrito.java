package Clases;

public class ArtCarrito {
	private Articulo art;
	private int cantidad;
	
	public ArtCarrito() {
		
	}
	
	public ArtCarrito(Articulo art, int cantidad) {
		this.art = art;
		this.cantidad = cantidad;
	}
	
	public Articulo getArt() {
		return art;
	}
	public void setArt(Articulo art) {
		this.art = art;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void agregarCantidad(int cantidad) {
		this.cantidad += cantidad;
		art.comprar(cantidad);
	}

	@Override
	public String toString() {
		return "Articulo: " + art.getNombre() + "\nCantidad:" + cantidad + "\n";
	}
	
	
}
