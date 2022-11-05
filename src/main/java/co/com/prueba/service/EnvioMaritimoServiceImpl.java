package co.com.prueba.service;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.prueba.common.EnvioMaritimoDTO;
import co.com.prueba.mapper.EnvioMaritimoMapper;
import co.com.prueba.model.Cliente;
import co.com.prueba.model.EnvioMaritimo;
import co.com.prueba.repo.IClienteRepo;
import co.com.prueba.repo.IEnvioMaritimoRepo;

@Service
public class EnvioMaritimoServiceImpl implements IEnvioMaritimoService{

	@Autowired
	private IEnvioMaritimoRepo repoMaritimo;
	@Autowired
	private IClienteRepo repoCliente;
	private EnvioMaritimoMapper mapperMaritimo;
	private EnvioMaritimo entidad;
	
	
	@Override
	public EnvioMaritimoDTO registrarEnvio(EnvioMaritimoDTO dto) {
		Optional<Cliente> cliente = repoCliente.findById(dto.getIdClienteMaritimo());
		EnvioMaritimoDTO nuevoDTO = new EnvioMaritimoDTO();
		try {
			entidad = mapperMaritimo.convertirAEntidad(dto, cliente.get());
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
		
		EnvioMaritimo nuevo = repoMaritimo.save(entidad);
		
		if(nuevo != null) {
			nuevoDTO = mapperMaritimo.convertirADTO(nuevo);
		}
		
		return nuevoDTO;
	}

	@Override
	public EnvioMaritimoDTO buscarPorNumeroDeGuia(String numeroGuia) {
		EnvioMaritimo consulta = repoMaritimo.buscarEnvioPorGuia(numeroGuia);
		EnvioMaritimoDTO dto = new EnvioMaritimoDTO();
		
		if(consulta != null) {
			dto = mapperMaritimo.convertirADTO(consulta);
		}
		return dto;
	}

}
