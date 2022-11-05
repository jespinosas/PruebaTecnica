package co.com.prueba.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.prueba.common.ClienteDTO;
import co.com.prueba.service.IClienteService;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

	@Mock
	private IClienteService service;
	@InjectMocks
	private ClienteController controller;
	
	@Test
	public void registrarCliente() {
		ClienteDTO dto = new ClienteDTO();
		dto.setNombre("test");
		dto.setApellido("test");
		dto.setUsuario("test");
		dto.setContraseña("test");
		when(service.registrar(dto)).thenReturn(dto);
		
		ClienteDTO actual = controller.registrarCliente(dto);
		
		assertEquals(actual, dto);
	}
	
	@Test
	public void iniciarSesion() {
		ClienteDTO dto = new ClienteDTO();
		dto.setNombre("test");
		dto.setApellido("test");
		dto.setUsuario("test");
		dto.setContraseña("test");
		when(service.inicioSesion(dto)).thenReturn(true);
		
		boolean actual = controller.iniciarSesion(dto);
		
		assertEquals(actual, true);
	}
}
