package co.com.prueba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.prueba.model.EnvioTerrestre;

public interface IEnvioTerrestreRepo extends JpaRepository<EnvioTerrestre, Integer>{

	@Query("SELECT envio FROM EnvioTerrestre envio WHERE envio.NumeroGuia = :guia")
	public EnvioTerrestre buscarEnvioPorGuia(@Param("guia") String numeroGuia);
}
