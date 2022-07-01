package test;

import java.time.LocalDate;
import java.time.LocalTime;


import modelo.Supermercado;


public class TestSupermercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supermercado carrefour = new Supermercado();
		
		try {
			carrefour.agregarProducto("Pan comun 1kg", 100);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProducto("Queso de rallar", 300);
			System.out.println(carrefour);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			carrefour.agregarProducto("Pan comun 1kg", 90);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.modificarProducto(1, "Pan comun 1/2Kg" , 60);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.modificarProducto(3, "Carne Picada 500g" , 190);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.modificarProducto(1, "Queso de rallar" , 310);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProducto("Leche 1L", 80);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProducto("Mermelada de Naranja", 220);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarCliente("Francisco Armendariz", 43572117, "Italia 1390");
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			carrefour.agregarCliente("Javier Armendariz", 17400383, "Castillo 1900");
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarCliente("Juan Vivanco", 43572117, "Calle Random 300");
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarCarrito(carrefour.traerCliente(43572117), LocalDate.now(), LocalTime.of(17, 30));
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarCarrito(carrefour.traerCliente(17400383), LocalDate.now(), LocalTime.of(17, 30));
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarCarrito(carrefour.traerCliente(43572117), LocalDate.of(2021, 9, 12), LocalTime.of(17, 30));
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarCarrito(carrefour.traerCliente(43572117), LocalDate.now(), LocalTime.of(17, 30));
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			carrefour.agregarProductoACarrito(1, "Pan comun 1/2Kg", 3);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProductoACarrito(2, "Queso de rallar", 1);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProductoACarrito(1, "Pan comun 1/2Kg", 2);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProductoACarrito(4, "Pan comun 1/2Kg", 3);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProductoACarrito(1, "Pen comun 1/2Kg", 3);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.eliminarProducto(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.eliminarProducto(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.eliminarProductoDeCarrito(2, "Queso de rallar", 1);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.eliminarProductoDeCarrito(1, "Pan comun 1/2Kg", 4);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.eliminarProductoDeCarrito(2, "Quiso de rallar", 1);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			carrefour.eliminarProductoDeCarrito(4, "Queso de rallar", 1);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			carrefour.eliminarProductoDeCarrito(1, "Pan comun 1/2Kg", -1);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			carrefour.eliminarProductoDeCarrito(1, "Queso de rallar", 1);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			carrefour.agregarProductoACarrito(1, "Mermelada de Naranja", 2);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			carrefour.agregarProductoACarrito(1, "Leche 1L", 4);
			System.out.println(carrefour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		
		
	}

