package co.com.prueba.mapper;

import co.com.prueba.common.ClienteDTO;
import co.com.prueba.model.Cliente;

public class ClienteMapper {

	public Cliente convertirAEntidad(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setNombre(dto.getNombre());
		cliente.setApellido(dto.getApellido());
		cliente.setUsuario(dto.getUsuario());
		cliente.setContraseña(dto.getContraseña());
		
		return cliente;
	}
	
	public ClienteDTO convertirADTO(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setNombre(cliente.getNombre());
		dto.setApellido(cliente.getApellido());
		dto.setUsuario(cliente.getUsuario());
		dto.setContraseña(cliente.getContraseña());
		
		return dto;
	}
	
}
