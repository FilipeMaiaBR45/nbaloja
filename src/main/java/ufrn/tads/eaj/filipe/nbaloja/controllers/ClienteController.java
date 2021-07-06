package ufrn.tads.eaj.filipe.nbaloja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.tads.eaj.filipe.nbaloja.DAO.ProdutoDAO;
import ufrn.tads.eaj.filipe.nbaloja.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping
    public void listarItens(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException, ServletException {

        ProdutoDAO pdao = new ProdutoDAO();


        response.getWriter().println("<table>");

        response.getWriter().println("<tr>");
        response.getWriter().println("<th>Nome</th>");
        response.getWriter().println("<th>time/jogador</th>");
        response.getWriter().println("<th>preço</th>");
        response.getWriter().println("<th>tamanho</th>");
        response.getWriter().println("<th>indicado para</th>");
        response.getWriter().println("</tr>");

        int i = 0;

        for (Produto p : pdao.listarProdutos()) {
            response.getWriter().println("<tr>");
            response.getWriter().println("<th>" + p.getNomeProduto() + "</th>");
            response.getWriter().println("<th>" + p.getTimeJogador() + "</th>");
            response.getWriter().println("<th>" + p.getPreco() + " R$</th>");
            response.getWriter().println("<th>" + p.getTamanho() + "</th>");
            response.getWriter().println("<th>" + p.getIndicadoPara() + "</th>");


            response.getWriter().println("<th> <a href=\"adicionarcarrinho?id=" + pdao.listarProdutos().get(i).getIdProduto() + " \" >Adicionar<a/></th>");


            i++;


        }

        response.getWriter().println("</table>");

        response.getWriter().println("<a href=\"/vercarrinho\">Ver Carrinho</a>");


    }
}
