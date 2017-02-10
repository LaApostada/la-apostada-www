package apostada.repositorios;

import apostada.entidades.Equipo;
import apostada.entidades.Liga;
import apostada.entidades.Partido;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PartidoRepository extends JpaRepository<Partido, Long> {
	
	//Consulta Partidos que se pueden apostar
	@Query("SELECT p FROM Partido p WHERE p.fecha BETWEEN ?1 AND '20201212'")
	List<Partido> findPartidoByAnteriorFecha(Date f);
	
	//Consulta Partidos Finalizados
	@Query("SELECT p FROM Partido p WHERE p.resultado BETWEEN 1 AND 3")
	List<Partido> findByPartidoFinalizado();
	
	//Todos los partidos
	@Query("SELECT p FROM Partido p")
	List<Partido> findPartido();
	
	//Consulta Partidos de un equipo concreto
	@Query("SELECT p FROM Partido p WHERE p.equipoLocal=?1 OR p.equipoVisitante=?1")
	List<Partido> findPartidoByEquipoName(Equipo e);
	
	//Consulta Partidos de una liga concreta
	@Query("SELECT p FROM Partido p WHERE p.equipoLocal.liga=?1")
	List<Partido> findPartidoByLiga(Liga l);
}