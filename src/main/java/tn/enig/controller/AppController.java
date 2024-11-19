package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.*;

import tn.enig.model.*;

@Controller
public class AppController {
	@Autowired
	IEmploye emp;
	@Autowired
	IProjet pro;
	@Autowired
	IDepartement dep;

	@GetMapping("/home")
	public String f1(Model m) {
		List<Departement> ldep = dep.findAll();
		m.addAttribute("ldep", ldep);

		return "Figure1";
	}

	@GetMapping("/employes/dept/{id}")
	public String f2(Model m, @PathVariable Integer id) {
		List<Employe> lemp = emp.getEmployeByDepId(id);
		Departement d = dep.findById(id).orElse(null);
		m.addAttribute("d", d);
		m.addAttribute("lemp", lemp);
		return "Figure2";
	}

	@GetMapping("/projets/{id}")
	public String f3(Model m, @PathVariable Integer id) {
		List<Projet> lpro = pro.getProjetsByDepId(id);
		Departement d = dep.findById(id).orElse(null);
		m.addAttribute("d", d);
		m.addAttribute("lpro", lpro);
		return "Figure3";
	}

	@GetMapping("/employes/proj/{id}")
	public String f4(Model m, @PathVariable Integer id) {
		List<Employe> lemp = emp.getEmployesByProjId(id);
		Projet p = pro.findById(id).orElse(null);
		m.addAttribute("p", p);
		m.addAttribute("lemp", lemp);
		return "Figure4";
	}

	@GetMapping("/ajoutProjet")
	public String f5(Model m) {
		Projet p = new Projet();
		List<Departement> ldep = dep.findAll();
		m.addAttribute("p", p);
		m.addAttribute("ldep", ldep);
		return "Figure5";
	}

	@PostMapping("/saveProjet")
	public String f6(Model m, @ModelAttribute Projet p) {
		pro.save(p);

		return "redirect:/home";
	}

	@GetMapping("/ajoutEmploye")
	public String f7(Model m) {
		Employe e = new Employe();
		List<Departement> ldep = dep.findAll();
		List<Projet> lp = pro.findAll();
		m.addAttribute("e", e);
		m.addAttribute("ldep", ldep);
		m.addAttribute("lp", lp);
		return "Figure6";
	}

	@PostMapping("/saveEmploye")
	public String f8(Model m, @ModelAttribute Employe e) {
		emp.save(e);

		return "redirect:/home";
	}

}
