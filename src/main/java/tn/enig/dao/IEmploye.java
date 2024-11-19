package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enig.model.Employe;

@Repository
public interface IEmploye extends JpaRepository<Employe, Integer> {
	@Query("select e from Employe e where e.dep.id =:id")
	public List<Employe> getEmployeByDepId(@Param("id") Integer id);
	
	@Query("select e from Employe e where e.p.id =:id")
	public List<Employe> getEmployesByProjId(@Param("id") Integer id);
	
	
	
	

}
