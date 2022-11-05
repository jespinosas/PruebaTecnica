package co.com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prueba.common.ClienteDTO;
import co.com.prueba.service.IClienteService;

@RestController
@RequestMapping("/api/ClienteController")
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@PostMapping("/registrar")
	public ClienteDTO registrarCliente(@RequestBody ClienteDTO cliente) {
		return service.registrar(cliente);
	}
	
	@PostMapping("/iniciarsesion")
	public boolean iniciarSesion(@RequestBody ClienteDTO cliente) {
		return service.inicioSesion(cliente);
	}
}
