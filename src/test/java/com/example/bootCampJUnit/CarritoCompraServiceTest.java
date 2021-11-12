package com.example.bootCampJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootCampJUnit.bbdd.BaseDatosImpl;
import com.example.bootCampJUnit.bbdd.BaseDatosServiceI;
import com.example.bootCampJUnit.entities.Articulo;
import com.example.bootCampJUnit.services.CarritoCompraServiceI;
import com.example.bootCampJUnit.services.CarritoCompraServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceTest {
	
	
	BaseDatosImpl baseDatosServiceI = Mockito.mock(BaseDatosImpl.class);

	@InjectMocks
	CarritoCompraServiceImpl carritoCompraServiceI;

	@BeforeEach
	void BeforeEachtest()
	{
		carritoCompraServiceI.limpiarCesta();
		
		Articulo articulo1 = new Articulo("prueba1", 10.0);
		Articulo articulo2 = new Articulo("prueba2", 5.0);
		
		carritoCompraServiceI.addArticulo(articulo1);
		carritoCompraServiceI.addArticulo(articulo2);

	}

	
	
	@Test
	@Order(4)
	public void testlimpiarCesta() {
		carritoCompraServiceI.limpiarCesta();

		assertEquals(0, carritoCompraServiceI.getArticulos().size());
		
	}

	@Test
	@Order(1)
	public void testaddArticulo() {
		
		Articulo articulo = new Articulo("prueba", 0.0);
		
		carritoCompraServiceI.addArticulo(articulo);
		
		assertTrue(carritoCompraServiceI.getArticulos().contains(articulo));

		
	}

	@Test
	public void testgetNumArticulo() {
		

		assertEquals(carritoCompraServiceI.getArticulos().size(), carritoCompraServiceI.getNumArticulos());
		
	}

	@Test
	public void testgetArticulos() {
		
		
	}

	@Test
	@Order(2)
	public void testtotalPrice() {
		
		Double precio = 0.0;
		
		for (Articulo articulo : carritoCompraServiceI.getArticulos()) {
			
			precio += articulo.getPrecio();
		}

		
		assertEquals(precio, carritoCompraServiceI.totalPrice());
		
		
	}

	@Test
	@Order(3)
	public void testcalcularDescuento() {
		
		
		when(baseDatosServiceI.findArticuloById(any(Integer.class))).thenReturn(new Articulo("camiseta", 10.0));
		

		assertEquals(carritoCompraServiceI.aplicarDescuento(1, 12.0), 8.8);
		
		
		verify(baseDatosServiceI, times(1)).findArticuloById(1);
		
	}

	@Test
	public void testaplicarDescuento() {
		when(baseDatosServiceI.findArticuloById(any(Integer.class))).thenReturn(new Articulo("camiseta", 10.0));
		

		assertEquals(carritoCompraServiceI.aplicarDescuento(1, 12.0), 8.8);
		
		
		verify(baseDatosServiceI, times(1)).findArticuloById(1);
	}
	
	@Test
	public void testInsertarArticuloById() {
		
		Articulo articulo = new Articulo("camiseta", 10.0);
		
		when(baseDatosServiceI.InsertarById(any(Integer.class), any(Articulo.class))).thenReturn(3);
		
		assertEquals(carritoCompraServiceI.addArticuloById(3, articulo), 3);
		assertTrue(carritoCompraServiceI.getArticulos().contains(articulo));
		verify(baseDatosServiceI, atLeast(1)).InsertarById(any(Integer.class), any(Articulo.class));
	

	}
	
	
}
