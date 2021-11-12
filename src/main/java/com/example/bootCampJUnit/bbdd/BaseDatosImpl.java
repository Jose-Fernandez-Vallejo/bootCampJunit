package com.example.bootCampJUnit.bbdd;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bootCampJUnit.entities.Articulo;

@Service
public class BaseDatosImpl implements BaseDatosServiceI{
	
	Map<Integer, Articulo> storage;
	
	
	

	public BaseDatosImpl() {
		storage = new HashMap<>();
		
		
		
		
		storage.put(1, new Articulo("camiseta", 18.85));
		storage.put(2, new Articulo("Jersey", 28.50));
		storage.put(3, new Articulo("Cinturon", 12.50));
		storage.put(4, new Articulo("Sudadera", 17.50));
		storage.put(5, new Articulo("Pantalon", 23.50));
		storage.put(6, new Articulo("Zapato", 30.50));
		storage.put(7, new Articulo("Chaqueta", 38.50));
		storage.put(8, new Articulo("Chandal", 25.50));
	}

	@Override
	public void initBD() {
		
		storage = new HashMap<>();
		
		
		
		
		storage.put(1, new Articulo("camiseta", 18.85));
		storage.put(2, new Articulo("Jersey", 28.50));
		storage.put(3, new Articulo("Cinturon", 12.50));
		storage.put(4, new Articulo("Sudadera", 17.50));
		storage.put(5, new Articulo("Pantalon", 23.50));
		storage.put(6, new Articulo("Zapato", 30.50));
		storage.put(7, new Articulo("Chaqueta", 38.50));
		storage.put(8, new Articulo("Chandal", 25.50));
		
		
	}

	@Override
	public Articulo findArticuloById(Integer id) {
		
		System.out.println("Buscando articulo con id:" + id);
		
		return storage.get(id);
	}

	@Override
	public String InsertarArticulo(Articulo articulo) {
		System.out.println("Insertado articulo con nombre:" + articulo.getNombre());
		storage.put(storage.size()+1, articulo);
		return articulo.getNombre();
	}
	
	public int getLastIndex()
	{
		return storage.size();
	}

}
