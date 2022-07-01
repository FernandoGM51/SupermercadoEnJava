package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	//atributos
	private List<Cliente> lstCliente = new ArrayList<Cliente>();
	private List<Producto> lstProducto = new ArrayList<Producto>();
	private List<Carrito> lstCarrito = new ArrayList<Carrito>();
	
	public Supermercado() {
	}
	//getter y setters
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}
	
	//toString
	@Override
	public String toString() {
		return "|||lstCliente:\n" + toStringLstCliente() + "|||lstProducto:\n" + toStringLstProducto() + "|||lstCarrito:\n" + toStringLstCarrito();
	}
	
	public String toStringLstCliente() {
		String resultado = "";
		for (Cliente c: lstCliente) {
			resultado += c + "\n";
		}
		return resultado;
	}
	
	public String toStringLstProducto() {
		String resultado = "";
		for (Producto p: lstProducto) {
			resultado += p + "\n";
		}
		return resultado;
	}
	
	public String toStringLstCarrito() {
		String resultado = "";
		for (Carrito c: lstCarrito) {
			resultado += c + "\n";
		}
		return resultado;
	}
	//metodos
	
	public boolean agregarProducto (String producto, float precio)throws Exception {
		int id=1;
		if (this.traerProducto(producto)!=null) 
			throw new Exception("Error, Producto Repetido");
		if (lstProducto.size()>0) {
			id=lstProducto.get(lstProducto.size()-1).getIdProducto()+1;
		}
		Producto nuevoProducto = new Producto(id,producto,precio);
		return lstProducto.add(nuevoProducto);
	}
	
	public Producto traerProducto(String producto) {
		Producto retorno = null;
		int i=0;
		while (retorno==null&&i<this.lstProducto.size()) {
			if (lstProducto.get(i).getProducto().equals(producto)) {
				retorno= lstProducto.get(i);
			}
			i++;
		}
		return retorno;
	}
	
	public Producto traerProducto(int idProducto) {
		Producto retorno = null;
		int i=0;
		while (retorno==null&&i<this.lstProducto.size()) {
			if (lstProducto.get(i).getIdProducto()==idProducto) {
				retorno= lstProducto.get(i);
			}
			i++;
		}
		return retorno;
	}
	
	public boolean modificarProducto (int idProducto, String nombreNuevo, float precioNuevo)throws Exception {
		Producto modificar = traerProducto(idProducto);
		if (modificar==null)
			throw new Exception("No se encuentra Producto con id indicado"); 
		if (traerProducto(nombreNuevo)!=null)
			throw new Exception("Nombre nuevo ya introducido en la lista");
		modificar.setProducto(nombreNuevo);
		modificar.setPrecio(precioNuevo);
		return true;
	}
	
	public boolean eliminarProducto (int idProducto)throws Exception {
		Producto paraEliminar = traerProducto(idProducto);
		if (paraEliminar==null)
			throw new Exception("No se encuentra Producto con id indicado");
		if (buscarProductoEnCarritos(paraEliminar))
			throw new Exception("Producto cargado en carrito");
		return lstProducto.remove(paraEliminar);
	}
	
	public boolean buscarProductoEnCarritos(Producto producto) {
		int i=0;
		boolean resultado = false;
		while (!resultado&&i<lstCarrito.size()) {
			if (lstCarrito.get(i).buscarProductoEnCarrito(producto))
				resultado = true;
			i++;
		}
		return resultado;
	}
	
	public boolean agregarCliente(String producto, long dni, String direccion) throws Exception{
		if (this.traerCliente(dni)!=null) 
			throw new Exception("Cliente con dni repetido");
		int id=1;
		if (lstCliente.size()>0) {
			id=lstCliente.get(lstCliente.size()-1).getIdCliente()+1;
		}
		Cliente nuevoCliente = new Cliente(id, producto, dni , direccion);
		return lstCliente.add(nuevoCliente);
	}
	
	public Cliente traerCliente(long dni) {
		Cliente retorno = null;
		int i=0;
		while (retorno==null&&i<lstCliente.size()) {
			if(lstCliente.get(i).getDni()==dni)
				retorno = lstCliente.get(i);
			i++;
		}
		return retorno;
	}
	
	public boolean agregarCarrito(Cliente cliente, LocalDate fecha, LocalTime hora)throws Exception{
		if (traerCarrito(cliente, fecha, hora)!=null) 
			throw new Exception("Carrito repetido en la lista");
		int id=1;
		if (lstCarrito.size()>0) {
			id=lstCarrito.get(lstCarrito.size()-1).getIdCarrito()+1;
		}
		Carrito nuevoCarrito = new Carrito (id, fecha, hora, cliente);
		return lstCarrito.add(nuevoCarrito);
	}
	
	public Carrito traerCarrito(Cliente cliente, LocalDate fecha, LocalTime hora) {
		Carrito retorno = null;
		Carrito buscado = new Carrito(0, fecha, hora, cliente);
		int i=0;
		while (retorno==null&&i<lstCarrito.size()) {
			if (lstCarrito.get(i).equals(buscado))
				retorno = lstCarrito.get(i);
			i++;
		}
		return retorno;
	}
	public Carrito traerCarritoId(int idCarrito) {
		Carrito retorno = null;
		int i=0;
		while (retorno==null&&i<lstCarrito.size()) {
			if (lstCarrito.get(i).getIdCarrito()==idCarrito)
				retorno = lstCarrito.get(i);
			i++;
		}
		return retorno;
	}
	
	public boolean agregarProductoACarrito (int idCarrito, String nombreProducto, int cantidad)throws Exception {
		Carrito carritoParaAgregar = traerCarritoId(idCarrito);
		if (carritoParaAgregar==null)
			throw new Exception("No se encuentra en la lista carrito con id indicado");
		Producto productoParaAgregar = traerProducto(nombreProducto);
		if (productoParaAgregar==null) 
			throw new Exception("No se encuentra Producto con nombre indicado");
		return carritoParaAgregar.agregarItem(productoParaAgregar, cantidad);
	}
	
	public boolean eliminarProductoDeCarrito(int idCarrito, String nombreProducto, int cantidad)throws Exception {
		Carrito carritoParaEliminar = traerCarritoId(idCarrito);
		if (carritoParaEliminar==null)
			throw new Exception("No se encuentra en la lista carrito con id indicado");
		Producto productoParaEliminar = traerProducto(nombreProducto);
		if (productoParaEliminar==null) 
			throw new Exception("No se encuentra Producto con nombre indicado");
		return carritoParaEliminar.eliminarItem(productoParaEliminar, cantidad);
	}
	
	
	
}

