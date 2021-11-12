package com.example.bootCampJUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bootCampJUnit.bbdd.BaseDatosServiceI;
import com.example.bootCampJUnit.entities.Articulo;

@SpringBootApplication
public class BootCampJUnitApplication implements CommandLineRunner{

	
	@Autowired
	BaseDatosServiceI baseDatosServiceI;
	
	public static void main(String[] args) {
		SpringApplication.run(BootCampJUnitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		baseDatosServiceI.initBD();
		
		
		Articulo articulo = new Articulo("Calcetines", 5.95);
		
		baseDatosServiceI.InsertarArticulo(articulo);
		
		baseDatosServiceI.findArticuloById(9);
		
	}

}
