package co.com.prueba.service;

import co.com.prueba.common.EnvioTerrestreDTO;

public interface IEnvioTerrestreService {

	public EnvioTerrestreDTO registrarEnvio(EnvioTerrestreDTO dto);
	public EnvioTerrestreDTO buscarPorNumeroDeGuia(String numeroGuia);
}
