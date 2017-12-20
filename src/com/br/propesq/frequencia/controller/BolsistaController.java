package com.br.propesq.frequencia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.propesq.frequencia.dao.BolsistaDao;
import com.br.propesq.frequencia.dao.CampusDao;
import com.br.propesq.frequencia.model.Bolsista;
import com.br.propesq.frequencia.model.Campus;
import com.br.propesq.frequencia.util.PasswordStorage.CannotPerformOperationException;

@Controller
public class BolsistaController {

	@RequestMapping("cadastroBolsista")
	public String cadastroBolsista(Model model) {

		CampusDao dao = new CampusDao();
		List<Campus> listaCampus = dao.listar();
		model.addAttribute("listaCampus", listaCampus);

		return "Bolsista/cadastroBolsista";
	}

	@RequestMapping("cadastroComSucessoBolsista")
	public String cadastroComSucessoBolsista(Bolsista bolsista, Model model) throws CannotPerformOperationException {

		BolsistaDao dao = new BolsistaDao();
		dao.salvar(bolsista);
		model.addAttribute("msg", "Usu�rio Inclu�do com Sucesso!");

		return "forward:listarBolsista";

	}
	
	@RequestMapping("removerBolsista")
    public String removerBolsista(Bolsista bolsista, Model model) {

		BolsistaDao dao = new BolsistaDao();
	dao.remover(bolsista.getId());
	model.addAttribute("mensagem", "Bolsista Removido com Sucesso");

	return "forward:listarBolsista";
    }

	@RequestMapping("/menuBolsista")
	public String menuBolsista() {
		return "Bolsista/menuBolsista";

	}

	@RequestMapping("/loginBolsista")
	public String loginBolsista() {
		return "Bolsista/loginBolsista";

	}

	@RequestMapping("listarBolsista")
	public String listarBolsista(Model model) {

		CampusDao dao = new CampusDao();
		List<Campus> listaCampus = dao.listar();
		model.addAttribute("listaCampus", listaCampus);

		BolsistaDao dao2 = new BolsistaDao();
		List<Bolsista> listaBolsista = dao2.listar();
		model.addAttribute("listaBolsista", listaBolsista);

		return "Bolsista/listaBolsista";
	}

}
