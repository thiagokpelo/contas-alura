package br.com.caelum.contas.controller;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContaController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formulario() {
        return "formulario";
    }

    @RequestMapping(value = "/adicionarConta", method = RequestMethod.POST)
    public String adicionar(Conta conta) {

        System.out.println("A conta adicionada é: " + conta.getDescricao());

        ContaDAO dao = new ContaDAO();
        dao.adiciona(conta);

        return "conta-adicionada";
    }

    @RequestMapping(value = "/listarContas", method = RequestMethod.GET)
    public ModelAndView listar() {

        ContaDAO dao = new ContaDAO();
        List<Conta> contas = dao.lista();

        System.out.println("Lista de Contas: " + contas);

        ModelAndView mv = new ModelAndView("conta/lista");
        mv.addObject("contas", contas);

        return mv;
    }

    @RequestMapping(value = "/removerConta", method = RequestMethod.GET)
    public String remover(Conta conta) {
        ContaDAO dao = new ContaDAO();
        dao.remove(conta);

        return "redirect:listarContas";
    }

    @RequestMapping(value = "/mostrarConta", method = RequestMethod.GET)
    public String mostrar(Long id, Model model) {
        ContaDAO dao = new ContaDAO();
        model.addAttribute("conta", dao.buscaPorId(id));

        return "conta/mostra";
    }

    @RequestMapping(value = "/alterarConta", method = RequestMethod.POST)
    public String alterar(Conta conta) {
        ContaDAO dao = new ContaDAO();
        dao.altera(conta);

        return "redirect:listarContas";
    }

}
