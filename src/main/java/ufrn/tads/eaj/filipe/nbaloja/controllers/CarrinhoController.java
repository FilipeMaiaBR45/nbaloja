package ufrn.tads.eaj.filipe.nbaloja.controllers;

import ch.qos.logback.core.boolex.EvaluationException;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller

public class CarrinhoController {

    List<Produto> carrinho = new ArrayList<>();

    @RequestMapping(value = "/adicionarcarrinho", method = RequestMethod.GET)
    public void addCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);


        int id = Integer.parseInt(request.getParameter("id"));

        ProdutoDAO pdao = new ProdutoDAO();


        for (Produto p : pdao.listarProdutosPorId(id)) {
            carrinho.add(p);
        }

        for (Produto p : carrinho) {
            response.getWriter().println(p);
        }
        session.setAttribute("carrinho", carrinho);
        RequestDispatcher encaminhar = request.getRequestDispatcher("/cliente");
        encaminhar.forward(request, response);
    }


    @RequestMapping(value = "/vercarrinho", method = RequestMethod.GET)

    public void verCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession s = request.getSession();
        List<Produto> carrinhoSession = (List<Produto>) s.getAttribute("carrinho");

        response.getWriter().println("<body>");
        if (carrinhoSession != null) {
            for (Produto p : carrinhoSession) {
                response.getWriter().println(p.getIdProduto() + " - " + p.getNomeProduto() + "</br>");
            }
        }
        response.getWriter().println("</body>");
        response.getWriter().println("<body>");
        response.getWriter().println("<a href=\"/finalizarcompra\">Finalizar Compra</a>");
        response.getWriter().println("</body>");

    }

    @RequestMapping(value = "/finalizarcompra", method = RequestMethod.GET)
    public void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            response.sendRedirect("/index.html");
        }
    }

}
