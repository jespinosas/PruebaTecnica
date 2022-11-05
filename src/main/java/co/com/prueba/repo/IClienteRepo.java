package co.com.prueba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.com.prueba.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{

	@Query("SELECT cliente FROM Cliente cliente WHERE cliente.usuario = :usuario AND cliente.contraseña = :contraseña")
	public Cliente buscarPorUsuarioYContraseña(@Param("usuario")String usuario, @Param("contraseña")String contraseña);
}
