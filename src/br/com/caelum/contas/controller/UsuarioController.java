package br.com.caelum.contas.controller;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String formulario() {
        return "usuario/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String entrar(Usuario usuario, HttpSession session) {
        UsuarioDAO dao = new UsuarioDAO();

        if(dao.existeUsuario(usuario)) {
            session.setAttribute("usuario:logado", usuario);
            return "menu";
        }

        return "redirect:login";
    }
}
