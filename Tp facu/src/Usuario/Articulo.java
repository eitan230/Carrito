package Usuario;

public class Articulo {
	private int codArticulo;
	private String nombre;
	private double precio;
	private int stock;
	
	public Articulo() {
		
	}
	
	public Articulo (int codArticulo, String nombre, double precio, int stock) {
		super();
		this.codArticulo = codArticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		
	}
	
	public int getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public double setPrecio(double precio) {
		this.precio = precio;
		return this.precio;
	}
	public double getStock() {
		return stock;
	}
	public void reponer(int cantidad) {
		this.stock += cantidad;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public boolean hayStock() {
		boolean stock;
		if(this.stock > 0) {
			stock = true;
		} else {
			stock = false;
		}
		return stock;
	}
	
	public boolean corroborarStock(int cantidad) {
		boolean b;
		if(this.stock < cantidad) {
			b = false;
		} else {
			b = true;
		}
		return b;
		
	}
	
	public void comprar(int cantidad) {
			this.stock -= cantidad;
	}

	@Override
	public String toString() {
		
		String stock = "";
		if(hayStock()) {
			stock = "Stock: " + this.stock;
		} else {
			stock = "NO HAY STOCK";
		}
		
		return "\nArticulo: " + nombre + "\nCodigo de articulo: " + codArticulo + "\nPrecio: " + precio + "\n" + stock ;
	}
	
	
		
}
