package co.com.prueba.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.prueba.common.EnvioTerrestreDTO;
import co.com.prueba.mapper.EnvioTerrestreMapper;
import co.com.prueba.model.Cliente;
import co.com.prueba.model.EnvioTerrestre;
import co.com.prueba.repo.IClienteRepo;
import co.com.prueba.repo.IEnvioTerrestreRepo;

@ExtendWith(MockitoExtension.class)
public class EnvioTerrestreServiceImplTest {

	@Mock
	private IEnvioTerrestreRepo repo;
	@InjectMocks
	private EnvioTerrestreServiceImpl service;
	@Mock
	private IClienteRepo repoCliente;
	@Mock
	private EnvioTerrestreMapper mapperTerrestre;
	
	@Test
	public void registrarEnvio() throws ParseException {
		
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("test");
		cliente.setApellido("test");
		cliente.setUsuario("test");
		cliente.setContraseña("test");
		Optional<Cliente> clienteEsperado = Optional.of(cliente);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioTerrestre entidad = new EnvioTerrestre();
		entidad.setTipoProducto("test");
		entidad.setCantidadProducto(11);
		entidad.setFechaRegistro(dateFormat.parse("2022-11-04"));
		entidad.setFechaEntrega(dateFormat.parse("2022-11-04"));
		entidad.setBodegaEntrega("test");
		entidad.setPrecioEnvio(10000);
		entidad.setPlacaVehiculo("abc123");
		entidad.setNumeroGuia("abc1234ajh");
		entidad.setIdCliente(cliente);
		entidad.setPrecioTotal(3000);
		entidad.setDescuento(1000);
		entidad.setPrecioDescuento(2000);
		
		EnvioTerrestreDTO dto = new EnvioTerrestreDTO();
		dto.setTipoProducto("test");
		dto.setCantidadProducto(11);
		dto.setFechaRegistro("2022-11-04");
		dto.setFechaEntrega("2022-11-04");
		dto.setBodegaEntrega("test");
		dto.setPrecioEnvio(10000);
		dto.setPlacaVehiculo("abc123");
		dto.setNumeroGuia("abc1234ajh");
		dto.setIdCliente(1);
		
		EnvioTerrestreDTO esperado = new EnvioTerrestreDTO();
		esperado.setTipoProducto("test");
		esperado.setCantidadProducto(11);
		esperado.setFechaRegistro("2022-11-04");
		esperado.setFechaEntrega("2022-11-04");
		esperado.setBodegaEntrega("test");
		esperado.setPrecioEnvio(10000);
		esperado.setPlacaVehiculo("abc123");
		esperado.setNumeroGuia("abc1234ajh");
		esperado.setIdCliente(1);
		esperado.setPrecioTotal(3000);
		esperado.setDescuento(1000);
		esperado.setPrecioDescuento(2000);
		
		when(repoCliente.findById(dto.getIdCliente())).thenReturn(clienteEsperado);
		when(mapperTerrestre.convertirAEntidad(dto, cliente)).thenReturn(entidad);
		when(repo.save(entidad)).thenReturn(entidad);
		
		EnvioTerrestreDTO actual = service.registrarEnvio(dto);
		
		assertEquals(actual, esperado);
	}
	
	@Test
	public void buscarPorGuia() throws ParseException {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("test");
		cliente.setApellido("test");
		cliente.setUsuario("test");
		cliente.setContraseña("test");
		
		EnvioTerrestreDTO esperado = new EnvioTerrestreDTO();
		esperado.setTipoProducto("test");
		esperado.setCantidadProducto(11);
		esperado.setFechaRegistro("2022-11-04");
		esperado.setFechaEntrega("2022-11-04");
		esperado.setBodegaEntrega("test");
		esperado.setPrecioEnvio(10000);
		esperado.setPlacaVehiculo("abc123");
		esperado.setNumeroGuia("abc1234ajh");
		esperado.setIdCliente(1);
		esperado.setPrecioTotal(3000);
		esperado.setDescuento(1000);
		esperado.setPrecioDescuento(2000);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioTerrestre entidad = new EnvioTerrestre();
		entidad.setTipoProducto("test");
		entidad.setCantidadProducto(11);
		entidad.setFechaRegistro(dateFormat.parse("2022-11-04"));
		entidad.setFechaEntrega(dateFormat.parse("2022-11-04"));
		entidad.setBodegaEntrega("test");
		entidad.setPrecioEnvio(10000);
		entidad.setPlacaVehiculo("abc123");
		entidad.setNumeroGuia("abc1234ajh");
		entidad.setIdCliente(cliente);
		entidad.setPrecioTotal(3000);
		entidad.setDescuento(1000);
		entidad.setPrecioDescuento(2000);
		
		when(repo.buscarEnvioPorGuia("abc1234ajh")).thenReturn(entidad);
		when(mapperTerrestre.convertirADTO(entidad)).thenReturn(esperado);
		
		EnvioTerrestreDTO actual = service.buscarPorNumeroDeGuia("abc1234ajh");
		
		assertEquals(esperado, actual);
	}
}
