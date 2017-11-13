package br.com.caelum.contas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.ConnectionFactory;

@Controller
public class InfraController {

	@RequestMapping("/tabelas")
	public String criaBanco() throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		PreparedStatement st1 = c.prepareStatement("drop table contas if exists");
		st1.execute();

		PreparedStatement st11 = c.prepareStatement("create table contas (id int identity, descricao varchar(255), valor double, paga boolean, dataPagamento datetime, tipo varchar(20))");
		st11.execute();
		
		PreparedStatement st2 = c.prepareStatement("drop table usuarios if exists");
		st2.execute();

		PreparedStatement st22 = c.prepareStatement("create table usuarios (login VARCHAR(255),senha VARCHAR(255));");
		st22.execute();

		PreparedStatement st3 = c.prepareStatement("insert into usuarios (login, senha) values ('caelum', 'online');");
		st3.execute();
		
		c.close();
		
		return "infra-ok";

	}
}
