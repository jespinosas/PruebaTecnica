package co.com.prueba.service;

import co.com.prueba.common.ClienteDTO;

public interface IClienteService {

	public ClienteDTO registrar(ClienteDTO dto);
	public boolean inicioSesion(ClienteDTO dto);
}
