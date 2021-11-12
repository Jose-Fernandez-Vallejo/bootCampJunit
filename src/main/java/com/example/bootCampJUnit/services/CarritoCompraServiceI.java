package com.example.bootCampJUnit.services;

import java.util.List;

import com.example.bootCampJUnit.entities.Articulo;

public interface CarritoCompraServiceI {
	void limpiarCesta();
	void addArticulo(Articulo articulo);
	int getNumArticulos();
	List<Articulo> getArticulos();
	Double totalPrice();
	Double calcularDescuento(Double precio, Double descuento);
	Double aplicarDescuento(Integer idArticulo, Double porcentaje);

}
