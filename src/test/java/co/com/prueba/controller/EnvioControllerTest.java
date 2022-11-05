package co.com.prueba.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.prueba.common.EnvioMaritimoDTO;
import co.com.prueba.common.EnvioTerrestreDTO;
import co.com.prueba.service.IEnvioMaritimoService;
import co.com.prueba.service.IEnvioTerrestreService;

@ExtendWith(MockitoExtension.class)
public class EnvioControllerTest {

	@Mock
	private IEnvioTerrestreService serviceTerrestre;
	@Mock
	private IEnvioMaritimoService serviceMaritimo;
	@InjectMocks
	private EnvioController controller;
	
	@Test
	public void registrarEnvioTerrestre() throws ParseException {
		EnvioTerrestreDTO dto = new EnvioTerrestreDTO();
		dto.setTipoProducto("test");
		dto.setCantidadProducto(3);
		dto.setFechaRegistro("2022-11-04");
		dto.setFechaEntrega("2022-11-04");
		dto.setBodegaEntrega("abc");
		dto.setPrecioEnvio(20000);
		dto.setPlacaVehiculo("abc123");
		dto.setNumeroGuia("abcd1234ajh");
		dto.setIdCliente(1);
		
		when(serviceTerrestre.registrarEnvio(dto)).thenReturn(dto);
		
		EnvioTerrestreDTO actual = controller.registrarEnvioTerrestre(dto);
		
		assertEquals(actual, dto);
	}
	
	@Test
	public void registrarEnvioMaritimo() {
		
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
		
		when(serviceMaritimo.registrarEnvio(dto)).thenReturn(dto);
		
		EnvioMaritimoDTO actual = controller.registrarEnvioMaritimo(dto);
		
		assertEquals(actual, dto);
	}
	
	@Test
	public void buscarEnvioMaritimoPorGuia() {
		
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
		dto.setPrecioTotal(3000);
		dto.setDescuento(1000);
		dto.setPrecioDescuento(2000);
		
		when(serviceMaritimo.buscarPorNumeroDeGuia("abc1234ajh")).thenReturn(dto);
		
		EnvioMaritimoDTO actual = controller.buscarEnvioMaritimoPorGuia("abc1234ajh");
		
		assertEquals(actual, dto);
	}
	
	@Test
	public void buscarEnvioTerrestrePorGuia() {
		EnvioTerrestreDTO dto = new EnvioTerrestreDTO();
		dto.setTipoProducto("test");
		dto.setCantidadProducto(3);
		dto.setFechaRegistro("2022-11-04");
		dto.setFechaEntrega("2022-11-04");
		dto.setBodegaEntrega("abc");
		dto.setPrecioEnvio(20000);
		dto.setPlacaVehiculo("abc123");
		dto.setNumeroGuia("abcd1234ajh");
		dto.setIdCliente(1);
		dto.setPrecioTotal(3000);
		dto.setDescuento(1000);
		dto.setPrecioDescuento(2000);
		
		when(serviceTerrestre.buscarPorNumeroDeGuia("abc1234ajh")).thenReturn(dto);
		
		EnvioTerrestreDTO actual = controller.buscarEnvioTerrestrePorGuia("abc1234ajh");
		
		assertEquals(actual, dto);
	}
}
