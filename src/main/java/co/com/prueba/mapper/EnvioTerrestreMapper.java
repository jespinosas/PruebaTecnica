package co.com.prueba.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import co.com.prueba.common.EnvioTerrestreDTO;
import co.com.prueba.model.Cliente;
import co.com.prueba.model.EnvioTerrestre;

public class EnvioTerrestreMapper {

	public EnvioTerrestre convertirAEntidad(EnvioTerrestreDTO dto, Cliente cliente) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioTerrestre entidad = new EnvioTerrestre();
		entidad.setTipoProducto(dto.getTipoProducto());
		entidad.setCantidadProducto(dto.getCantidadProducto());
		entidad.setFechaRegistro(dateFormat.parse(dto.getFechaRegistro()));
		entidad.setFechaEntrega(dateFormat.parse(dto.getFechaEntrega()));
		entidad.setBodegaEntrega(dto.getBodegaEntrega());
		entidad.setPrecioEnvio(dto.getPrecioEnvio());
		entidad.setPlacaVehiculo(dto.getPlacaVehiculo());
		entidad.setNumeroGuia(dto.getNumeroGuia());
		entidad.setIdCliente(cliente);
		
		return entidad;
	}
	
	public EnvioTerrestreDTO convertirADTO(EnvioTerrestre entidad) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		EnvioTerrestreDTO dto = new EnvioTerrestreDTO();
		dto.setTipoProducto(entidad.getTipoProducto());
		dto.setCantidadProducto(entidad.getCantidadProducto());
		dto.setFechaRegistro(dateFormat.format(entidad.getFechaRegistro()));
		dto.setFechaEntrega(dateFormat.format(entidad.getFechaEntrega()));
		dto.setBodegaEntrega(entidad.getBodegaEntrega());
		dto.setPrecioEnvio(entidad.getPrecioEnvio());
		dto.setPlacaVehiculo(entidad.getPlacaVehiculo());
		dto.setNumeroGuia(entidad.getNumeroGuia());
		dto.setPrecioTotal(entidad.getPrecioTotal());
		dto.setDescuento(entidad.getDescuento());
		dto.setPrecioDescuento(entidad.getPrecioDescuento());
		dto.setIdCliente(entidad.getIdCliente().getId());
		
		return dto;
	}
}
