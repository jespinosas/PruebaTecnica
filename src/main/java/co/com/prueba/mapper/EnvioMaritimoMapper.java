package co.com.prueba.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import co.com.prueba.common.EnvioMaritimoDTO;
import co.com.prueba.model.Cliente;
import co.com.prueba.model.EnvioMaritimo;

public class EnvioMaritimoMapper {

	public EnvioMaritimo convertirAEntidad(EnvioMaritimoDTO dto, Cliente cliente) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioMaritimo entidad = new EnvioMaritimo();
		entidad.setTipoProducto(dto.getTipoProducto());
		entidad.setCantidadProducto(dto.getCantidadProducto());
		entidad.setFechaRegistro(dateFormat.parse(dto.getFechaRegistro()));
		entidad.setFechaEntrega(dateFormat.parse(dto.getFechaEntrega()));
		entidad.setPuertoEntrega(dto.getPuertoEntrega());
		entidad.setPrecioEnvio(dto.getPrecioEnvio());
		entidad.setNumeroFlota(dto.getNumeroFlota());
		entidad.setNumeroGuia(dto.getNumeroGuia());
		entidad.setIdClienteMaritimo(cliente);
		
		return entidad;
	}
	
	public EnvioMaritimoDTO convertirADTO(EnvioMaritimo entidad) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioMaritimoDTO dto = new EnvioMaritimoDTO();
		dto.setTipoProducto(entidad.getTipoProducto());
		dto.setCantidadProducto(entidad.getCantidadProducto());
		dto.setFechaRegistro(dateFormat.format(entidad.getFechaRegistro()));
		dto.setFechaEntrega(dateFormat.format(entidad.getFechaEntrega()));
		dto.setPuertoEntrega(entidad.getPuertoEntrega());
		dto.setPrecioEnvio(entidad.getPrecioEnvio());
		dto.setNumeroFlota(entidad.getNumeroFlota());
		dto.setNumeroGuia(entidad.getNumeroGuia());
		dto.setPrecioTotal(entidad.getPrecioTotal());
		dto.setDescuento(entidad.getDescuento());
		dto.setPrecioDescuento(entidad.getPrecioDescuento());
		dto.setIdClienteMaritimo(entidad.getIdClienteMaritimo().getId());
		
		return dto;
	}
}
