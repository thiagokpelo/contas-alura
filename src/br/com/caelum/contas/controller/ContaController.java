package br.com.caelum.contas.controller;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ContaController {

    private ContaDAO dao;

    @Autowired
    public ContaController(ContaDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formulario() {
        return "formulario";
    }

    @RequestMapping(value = "/adicionarConta", method = RequestMethod.POST)
    public String adicionar(@Valid Conta conta, BindingResult result) {

        if (result.hasErrors()) {
            return "formulario";
        }

        dao.adiciona(conta);

        return "conta-adicionada";
    }

    @RequestMapping(value = "/listarContas", method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Conta> contas = dao.lista();

        System.out.println("Lista de Contas: " + contas);

        ModelAndView mv = new ModelAndView("conta/lista");
        mv.addObject("contas", contas);

        return mv;
    }

    @RequestMapping(value = "/removerConta", method = RequestMethod.GET)
    public String remover(Conta conta) {
        dao.remove(conta);

        return "redirect:listarContas";
    }

    @RequestMapping(value = "/mostrarConta", method = RequestMethod.GET)
    public String mostrar(Long id, Model model) {
        model.addAttribute("conta", dao.buscaPorId(id));

        return "conta/mostra";
    }

    @RequestMapping(value = "/alterarConta", method = RequestMethod.POST)
    public String alterar(Conta conta) {
        dao.altera(conta);

        return "redirect:listarContas";
    }

    @RequestMapping(value = "/pagarConta", method = RequestMethod.POST)
    public void paga(Long id, HttpServletResponse response) {
        dao.paga(id);
        response.setStatus(200);
    }
}
