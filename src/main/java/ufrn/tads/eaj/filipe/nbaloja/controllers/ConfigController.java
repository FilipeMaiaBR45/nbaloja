package ufrn.tads.eaj.filipe.nbaloja.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/config", method = RequestMethod.GET)
public class ConfigController {

    @GetMapping
    public void createInitialTable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = ConectaBanco.getConnection();
            stmt = connection.prepareStatement("create table produto (id SERIAL PRIMARY KEY, nomeProduto VARCHAR(55), timeJogador VARCHAR(100), preco FLOAT, tamanho varchar(40), indicadoPara varchar(45))");

            stmt.execute();

            stmt = connection.prepareStatement("insert into produto (nomeproduto, timejogador, preco, tamanho, indicadopara) values\n" +
                    "('camisa lebron', 'Lebrom James', '150.0', 'G', 'dia a dia'),\n" +
                    "('camisa harden', 'James Harden', '150.0', 'G', 'dia a dia'),\n" +
                    "('camisa Kawhi ', 'Kawhi Leonard', '150.0', 'G', 'dia a dia'),\n" +
                    "('camisa kyrie ', 'Kyrie Irving', '150.0', 'G', 'dia a dia'),\n" +
                    "('camisa Chris ', 'Chris Paul', '150.0', 'G', 'dia a dia')");

            stmt.execute();


            response.getWriter().println("ok");

            connection.close();


        } catch (SQLException | URISyntaxException ex) {
            response.getWriter().append("nao criou a tabela" + ex);
        }
    }
}
