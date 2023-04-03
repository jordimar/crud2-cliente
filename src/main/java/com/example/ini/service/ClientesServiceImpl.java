package com.example.ini.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ini.model.Libro;

@Service
public class ClientesServiceImpl implements ClientesService {

	//comentario
	RestTemplate template;
	
	String url="http://localhost:8080";
	HttpHeaders headers = new HttpHeaders();
	
	String user="admin";
	String pwd="admin";
	String token;  
	
	ClientesServiceImpl(RestTemplate template){
		
		this.template = template; 
	}
	 
	@PostConstruct() //se llama despues de ejecutarse el constructor del controlador
	public void autenticar()
	{
		token = template.postForObject(url+"/login?user="+user+"&pwd="+pwd, null, String.class);
		
		headers.add("Authorization", "Bearer "+token); //se añade el token a la cabecera
		
		System.out.println("--> TOKEN: " + token);
		
	}
	
	@Override
	public List<Libro> getLibros() {
		 
		Libro[] libros = template.exchange("http://localhost:8080/api/libros/lista", HttpMethod.GET, new HttpEntity<>(headers), Libro[].class).getBody();
		
		
		return Arrays.asList(libros);
	}

}
