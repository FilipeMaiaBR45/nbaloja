package ufrn.tads.eaj.filipe.nbaloja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ufrn.tads.eaj.filipe.nbaloja.DAO.ProdutoDAO;
import ufrn.tads.eaj.filipe.nbaloja.model.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller


public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public void formCadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.getWriter().println("<body>");
        response.getWriter().println("<form method=\"post\" action=\"/cadastrar\">");
        response.getWriter().println("Nome do produto: <input type=\"text\" name=\"nomeproduto\"> <br />");
        response.getWriter().println("time/jogador: <input type=\"text\" name=\"timejogador\"><br />\n" +
                "preço: <input type=\"number\" name=\"preco\" step=\"0.01\"><br />\n" +
                "tamanho: <input type=\"text\" name=\"tamanho\"> <br/>\n" +
                "indicado para: <input type=\"text\" name=\"indicadopara\"> <br/>\n" +
                "<button type=\"submit\">Cadastrar</button>");
        response.getWriter().println("</fomr>");
        response.getWriter().println("</body>");

    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     String nomeProduto = request.getParameter("nomeproduto");
     String timeJogador = request.getParameter("timejogador");
     float preco = Float.parseFloat(request.getParameter("preco")) ;
     String tamanho = request.getParameter("tamanho");
     String indicadoPara = request.getParameter("indicadopara");

        Produto p = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();

        p.setNomeProduto(nomeProduto);
        p.setTimeJogador(timeJogador);
        p.setPreco(preco);
        p.setTamanho(tamanho);
        p.setIndicadoPara(indicadoPara);

        pdao.cadastrarProduto(p);

        response.sendRedirect("/admin");





    }





}
