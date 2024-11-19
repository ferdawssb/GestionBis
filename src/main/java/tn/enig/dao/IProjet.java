package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enig.model.Employe;
import tn.enig.model.Projet;

@Repository
public interface IProjet extends JpaRepository<Projet, Integer> {
	@Query("select p from Projet p where p.dp.id =:id")
	public  List<Projet> getProjetsByDepId(@Param("id") Integer id);
	
	
	
}
