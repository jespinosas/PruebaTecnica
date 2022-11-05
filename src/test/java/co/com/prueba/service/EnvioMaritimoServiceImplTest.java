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

import co.com.prueba.common.EnvioMaritimoDTO;
import co.com.prueba.mapper.EnvioMaritimoMapper;
import co.com.prueba.model.Cliente;
import co.com.prueba.model.EnvioMaritimo;
import co.com.prueba.repo.IClienteRepo;
import co.com.prueba.repo.IEnvioMaritimoRepo;

@ExtendWith(MockitoExtension.class)
public class EnvioMaritimoServiceImplTest {

	@Mock
	private IEnvioMaritimoRepo repo;
	@InjectMocks
	private EnvioMaritimoServiceImpl service;
	@Mock
	private IClienteRepo repoCliente;
	@Mock
	private EnvioMaritimoMapper mapperMaritimo;
	
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
		EnvioMaritimo entidad = new EnvioMaritimo();
		entidad.setTipoProducto("test");
		entidad.setCantidadProducto(11);
		entidad.setFechaRegistro(dateFormat.parse("2022-11-04"));
		entidad.setFechaEntrega(dateFormat.parse("2022-11-04"));
		entidad.setPuertoEntrega("test");
		entidad.setPrecioEnvio(10000);
		entidad.setNumeroFlota("abc1234a");
		entidad.setNumeroGuia("abc1234ajh");
		entidad.setIdClienteMaritimo(cliente);
		entidad.setPrecioTotal(3000);
		entidad.setDescuento(1000);
		entidad.setPrecioDescuento(2000);
		
		EnvioMaritimoDTO dto = new EnvioMaritimoDTO();
		dto.setTipoProducto("test");
		dto.setCantidadProducto(11);
		dto.setFechaRegistro("2022-11-04");
		dto.setFechaEntrega("2022-11-04");
		dto.setPuertoEntrega("test");
		dto.setPrecioEnvio(10000);
		dto.setNumeroFlota("abc1234a");
		dto.setNumeroGuia("abc1234ajh");
		dto.setIdClienteMaritimo(1);
		
		EnvioMaritimoDTO esperado = new EnvioMaritimoDTO();
		esperado.setTipoProducto("test");
		esperado.setCantidadProducto(11);
		esperado.setFechaRegistro("2022-11-04");
		esperado.setFechaEntrega("2022-11-04");
		esperado.setPuertoEntrega("test");
		esperado.setPrecioEnvio(10000);
		esperado.setNumeroFlota("abc1234a");
		esperado.setNumeroGuia("abc1234ajh");
		esperado.setIdClienteMaritimo(1);
		esperado.setPrecioTotal(3000);
		esperado.setDescuento(1000);
		esperado.setPrecioDescuento(2000);
		
		when(repoCliente.findById(dto.getIdClienteMaritimo())).thenReturn(clienteEsperado);
		when(mapperMaritimo.convertirAEntidad(dto, cliente)).thenReturn(entidad);
		when(repo.save(entidad)).thenReturn(entidad);
		
		EnvioMaritimoDTO actual = service.registrarEnvio(dto);
		
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
		
		EnvioMaritimoDTO esperado = new EnvioMaritimoDTO();
		esperado.setTipoProducto("test");
		esperado.setCantidadProducto(11);
		esperado.setFechaRegistro("2022-11-04");
		esperado.setFechaEntrega("2022-11-04");
		esperado.setPuertoEntrega("test");
		esperado.setPrecioEnvio(10000);
		esperado.setNumeroFlota("abc1234a");
		esperado.setNumeroGuia("abc1234ajh");
		esperado.setIdClienteMaritimo(1);
		esperado.setPrecioTotal(3000);
		esperado.setDescuento(1000);
		esperado.setPrecioDescuento(2000);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioMaritimo entidad = new EnvioMaritimo();
		entidad.setTipoProducto("test");
		entidad.setCantidadProducto(11);
		entidad.setFechaRegistro(dateFormat.parse("2022-11-04"));
		entidad.setFechaEntrega(dateFormat.parse("2022-11-04"));
		entidad.setPuertoEntrega("test");
		entidad.setPrecioEnvio(10000);
		entidad.setNumeroFlota("abc1234a");
		entidad.setNumeroGuia("abc1234ajh");
		entidad.setIdClienteMaritimo(cliente);
		entidad.setPrecioTotal(3000);
		entidad.setDescuento(1000);
		entidad.setPrecioDescuento(2000);
		
		when(repo.buscarEnvioPorGuia("abc1234ajh")).thenReturn(entidad);
		when(mapperMaritimo.convertirADTO(entidad)).thenReturn(esperado);
		
		EnvioMaritimoDTO actual = service.buscarPorNumeroDeGuia("abc1234ajh");
		
		assertEquals(esperado, actual);
	}
}
