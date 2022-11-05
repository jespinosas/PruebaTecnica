package co.com.prueba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.prueba.model.EnvioMaritimo;

public interface IEnvioMaritimoRepo extends JpaRepository<EnvioMaritimo, Integer>{

	@Query("SELECT envio FROM EnvioMaritimo envio WHERE envio.NumeroGuia = :guia")
	public EnvioMaritimo buscarEnvioPorGuia(@Param("guia") String numeroGuia);
}
