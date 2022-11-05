package co.com.prueba.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.prueba.common.ClienteDTO;
import co.com.prueba.mapper.ClienteMapper;
import co.com.prueba.model.Cliente;
import co.com.prueba.repo.IClienteRepo;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {
	
	@Mock
	private IClienteRepo repo;
	@InjectMocks
	private ClienteServiceImpl service;
	@Mock
	private ClienteMapper mapper;
	
	@Test
	public void registrar() {
		ClienteDTO dto = new ClienteDTO();
		dto.setNombre("test");
		dto.setApellido("test");
		dto.setUsuario("test");
		dto.setContraseña("test");
		
		Cliente entidad = new Cliente();
		entidad.setId(1);
		entidad.setNombre("test");
		entidad.setApellido("test");
		entidad.setUsuario("test");
		entidad.setContraseña("test");
		System.out.println("nombre " + entidad.getNombre());
		when(repo.save(entidad)).thenReturn(entidad);
		when(mapper.convertirADTO(entidad)).thenReturn(dto);
		ClienteDTO actual = service.registrar(dto);
		
		assertEquals(actual, dto);
		
	}
	
	@Test
	public void inicioSesion() {
		ClienteDTO dto = new ClienteDTO();
		dto.setNombre("test");
		dto.setApellido("test");
		dto.setUsuario("test");
		dto.setContraseña("test");
		
		Cliente entidad = new Cliente();
		entidad.setNombre("test");
		entidad.setApellido("test");
		entidad.setUsuario("test");
		entidad.setContraseña("test");
		
		when(repo.buscarPorUsuarioYContraseña(dto.getUsuario(), dto.getContraseña())).thenReturn(entidad);
		
		boolean actual = service.inicioSesion(dto);
		
		assertEquals(actual, true);
	}
}
