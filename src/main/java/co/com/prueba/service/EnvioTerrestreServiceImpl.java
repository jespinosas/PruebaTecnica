package co.com.prueba.service;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.prueba.common.EnvioTerrestreDTO;
import co.com.prueba.mapper.EnvioTerrestreMapper;
import co.com.prueba.model.Cliente;
import co.com.prueba.model.EnvioTerrestre;
import co.com.prueba.repo.IClienteRepo;
import co.com.prueba.repo.IEnvioTerrestreRepo;

@Service
public class EnvioTerrestreServiceImpl implements IEnvioTerrestreService{

	@Autowired
	private IEnvioTerrestreRepo repoTerrestre;
	@Autowired
	private IClienteRepo repoCliente;
	private EnvioTerrestreMapper mapperTerrestre;
	private EnvioTerrestre entidad;
	
	@Override
	public EnvioTerrestreDTO registrarEnvio(EnvioTerrestreDTO dto) {
		Optional<Cliente> cliente = repoCliente.findById(dto.getIdCliente());
		EnvioTerrestreDTO nuevoDTO = new EnvioTerrestreDTO();
		try {
			entidad = mapperTerrestre.convertirAEntidad(dto, cliente.get());
			entidad.setPrecioTotal(entidad.getPrecioEnvio() * entidad.getCantidadProducto());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(dto.getCantidadProducto() > 10) {
			entidad.setDescuento(entidad.getPrecioTotal() * 0.03);
		}
		else {
			entidad.setDescuento(0);
		}
		entidad.setPrecioDescuento(entidad.getPrecioTotal() - entidad.getDescuento());
		
		EnvioTerrestre nuevo = repoTerrestre.save(entidad);
		
		if(nuevo != null) {
			nuevoDTO = mapperTerrestre.convertirADTO(nuevo);
		}
		
		return nuevoDTO;
	}

	@Override
	public EnvioTerrestreDTO buscarPorNumeroDeGuia(String numeroGuia) {
		EnvioTerrestre consulta = repoTerrestre.buscarEnvioPorGuia(numeroGuia);
		EnvioTerrestreDTO dto = new EnvioTerrestreDTO();
		
		if(consulta != null) {
			dto = mapperTerrestre.convertirADTO(consulta);
		}
		return dto;
	}

}
