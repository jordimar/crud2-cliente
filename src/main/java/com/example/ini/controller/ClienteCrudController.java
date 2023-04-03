package com.example.ini.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ini.model.Libro;
import com.example.ini.service.ClientesService;

@RestController
public class ClienteCrudController {
	
	ClientesService service;
	
	
	ClienteCrudController(ClientesService service) {
		
		this.service = service;
	}
	
	
	@GetMapping("/libros")
	ResponseEntity<?> getLibros(){
		
	 List<Libro> libros =	service.getLibros();
		
		return ResponseEntity.ok(libros);
	}
}
