package co.com.prueba.service;

import co.com.prueba.common.EnvioMaritimoDTO;

public interface IEnvioMaritimoService {

	public EnvioMaritimoDTO registrarEnvio(EnvioMaritimoDTO dto);
	public EnvioMaritimoDTO buscarPorNumeroDeGuia(String numeroGuia);
}
