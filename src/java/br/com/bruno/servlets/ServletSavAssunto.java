package br.com.bruno.servlets;

import br.com.bruno.banco.AssuntoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletSavAssunto", urlPatterns = {"/ServletSavAssunto"})
public class ServletSavAssunto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            AssuntoController assuntoCtr = new AssuntoController();
            String nome = request.getParameter("nome");
            if ("".equals(nome)) {        
                response.sendRedirect("index.jsp?mensagem=Erro ao salvar !!");                
            } else {        
                assuntoCtr.saveAssunto(nome);
                response.sendRedirect("index.jsp?mensagem=Salvo com sucesso");
            }
    }
        
}
