package com.example.bootCampJUnit.bbdd;

import com.example.bootCampJUnit.entities.Articulo;

public interface BaseDatosServiceI {
	
	void initBD();
	
	Articulo findArticuloById(Integer id);
	
	String InsertarArticulo(Articulo articulo);
	int InsertarById(int id, Articulo articulo);

}
