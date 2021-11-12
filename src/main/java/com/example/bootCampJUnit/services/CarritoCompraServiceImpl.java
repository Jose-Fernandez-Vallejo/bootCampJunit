package com.example.bootCampJUnit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootCampJUnit.bbdd.BaseDatosImpl;
import com.example.bootCampJUnit.bbdd.BaseDatosServiceI;
import com.example.bootCampJUnit.entities.Articulo;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraServiceI{
	
	List<Articulo> listaArticulos = new ArrayList<>();
	

	BaseDatosImpl baseDatosServiceI = new BaseDatosImpl();
	

	@Override
	public void limpiarCesta() {
		listaArticulos.clear();
		
	}

	@Override
	public void addArticulo(Articulo articulo) {
		listaArticulos.add(articulo);
		
	}

	@Override
	public int getNumArticulos() {
		// TODO Auto-generated method stub
		return listaArticulos.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		return listaArticulos;
	}

	@Override
	public Double totalPrice() {
		Double precioTotal = 0.0;
		
		for (Articulo articulo : listaArticulos) {
			precioTotal += articulo.getPrecio();
		}
		// TODO Auto-generated method stub
		return precioTotal;
	}

	@Override
	public Double calcularDescuento(Double precio, Double descuento) {
		
		return precio - precio*descuento/100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		Double resultado = null;
		
		Articulo articulo = baseDatosServiceI.findArticuloById(idArticulo);
		
		if (articulo != null) {
			resultado = calcularDescuento(articulo.getPrecio(), porcentaje);
		}
		else {
			System.out.println("no se ha encontrado articulo con ese id");
		}
		
		return resultado;
	}
	

	

}
