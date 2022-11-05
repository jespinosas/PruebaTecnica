package co.com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.prueba.common.EnvioMaritimoDTO;
import co.com.prueba.common.EnvioTerrestreDTO;
import co.com.prueba.service.IEnvioMaritimoService;
import co.com.prueba.service.IEnvioTerrestreService;

@RestController
@RequestMapping("/api/envio")
public class EnvioController {

	@Autowired
	private IEnvioTerrestreService serviceTerrestre;
	@Autowired
	private IEnvioMaritimoService serviceMaritimo;
	
	@PostMapping("/registrarenvioterrestre")
	public EnvioTerrestreDTO registrarEnvioTerrestre(@RequestBody EnvioTerrestreDTO dto) {
		return serviceTerrestre.registrarEnvio(dto);
	}
	
	@PostMapping("/registrarEnviomaritimo")
	public EnvioMaritimoDTO registrarEnvioMaritimo(@RequestBody EnvioMaritimoDTO dto) {
		return serviceMaritimo.registrarEnvio(dto);
	}
	
	@GetMapping("/consultarGuiaMaritima")
	public EnvioMaritimoDTO buscarEnvioMaritimoPorGuia(@RequestParam String numeroGuia) {
		return serviceMaritimo.buscarPorNumeroDeGuia(numeroGuia);
	}
	
	@GetMapping("/consultarGuiaTerrestre")
	public EnvioTerrestreDTO buscarEnvioTerrestrePorGuia(@RequestParam String numeroGuia) {
		return serviceTerrestre.buscarPorNumeroDeGuia(numeroGuia);
	}
}
