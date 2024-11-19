package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.enig.model.Departement;
import tn.enig.model.Employe;

@Repository
public interface IDepartement extends JpaRepository<Departement, Integer> {

	
}
