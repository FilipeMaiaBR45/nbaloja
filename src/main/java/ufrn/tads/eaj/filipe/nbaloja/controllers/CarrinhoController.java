package ufrn.tads.eaj.filipe.nbaloja.controllers;

import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/adicionarcarrinho")
public class CarrinhoController {

    @GetMapping
    public void verCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException {
      //int id =  Integer.parseInt(request.getParameter("id"));

      response.getWriter().println("oi");
    }
}
