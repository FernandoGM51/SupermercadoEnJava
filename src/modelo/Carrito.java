package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	//atributos
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem = new ArrayList<ItemCarrito>();
	private Cliente cliente;
	
	//constructor
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
	}
	//getter y setter
	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//toString
	@Override
	public String toString() {
	return "Carrito N°" + idCarrito + " "+ fecha + "  " + hora + " | Utilizado por: " + cliente + " |\nProductos:\n" + this.toStringLstItems() + "TOTAL: $" + calcularTotal();
	}
	
	public String toStringLstItems() {
		String resultado = "";
		for (ItemCarrito i: lstItem) {
			resultado += i + "\n";
		}
		return resultado;
	}
	//equals
	public boolean equals (Carrito c) {
		return (this.fecha.equals(c.fecha))&&(this.hora.equals(c.hora))&&(this.cliente.equals(c.cliente));
	}
	
	
	//METODOS----------------------
	public boolean buscarProductoEnCarrito(Producto producto) {
		int i=0;
		boolean resultado = false;
		while (!resultado&&i<lstItem.size()) {
			if (lstItem.get(i).getProducto().equals(producto))
				resultado =true;
			i++;
		}
		return resultado;
	}
	
	public ItemCarrito traerItemCarrito (Producto producto) {
		int i=0;
		ItemCarrito retorno = null;
		while (retorno==null&&i<lstItem.size()) {
			if (lstItem.get(i).getProducto().equals(producto))
				retorno=lstItem.get(i);
			i++;
		}
		return retorno;
	}
	
	
	public boolean agregarItem(Producto producto, int cantidad) {
		ItemCarrito itemNuevo = traerItemCarrito(producto);
		if (itemNuevo==null) {
			int id=1;
			if(lstItem.size()>0) {
				id = lstItem.get(lstItem.size()-1).getIdItem()+1;
			}
			itemNuevo = new ItemCarrito (id, producto, cantidad);
			lstItem.add(itemNuevo);
		}else {
			itemNuevo.setCantidad(itemNuevo.getCantidad()+cantidad);
		}
		return true;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad)throws Exception {
		ItemCarrito itemParaEliminar = traerItemCarrito(producto);
		if (itemParaEliminar==null)
			throw new Exception("Producto no se encuentra en carrito");
		if (cantidad<0) {
			throw new Exception("cantidad invalida");
		}
		if (itemParaEliminar.getCantidad()<=cantidad) {
			lstItem.remove(itemParaEliminar);
		}else {
			itemParaEliminar.setCantidad(itemParaEliminar.getCantidad()-cantidad);
		}
		return true;
	}
	
	public float calcularTotal() {
		float total=0;
		for(ItemCarrito i: lstItem) {
			total += i.calcularSubTotal();
		}
		return total;
	}

	
}
