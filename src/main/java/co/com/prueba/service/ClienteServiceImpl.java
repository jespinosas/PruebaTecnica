package co.com.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.prueba.common.ClienteDTO;
import co.com.prueba.mapper.ClienteMapper;
import co.com.prueba.model.Cliente;
import co.com.prueba.repo.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	private ClienteMapper mapper;
	private ClienteDTO nuevoDTO;
	
	@Override
	public ClienteDTO registrar(ClienteDTO dto) {
		Cliente cliente = mapper.convertirAEntidad(dto);
		Cliente nuevo = repo.save(cliente);
		nuevoDTO = new ClienteDTO();
		if(nuevo != null) {
			nuevoDTO = mapper.convertirADTO(nuevo);
		}
		return nuevoDTO;
	}

	@Override
	public boolean inicioSesion(ClienteDTO dto) {
		Cliente cliente = repo.buscarPorUsuarioYContraseña(dto.getUsuario(), dto.getContraseña());
		if(cliente != null) {
			return true;
		}
		return false;
	}

}
