package br.com.bruno.servlets;

import br.com.bruno.banco.AssuntoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDelAssunto extends HttpServlet {

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            AssuntoController assuntoCtr = new AssuntoController();
            String id = request.getParameter("assunto");
            if (id != null && assuntoCtr.delAssunto(id)){        
                response.sendRedirect("index.jsp?mensagem=Deletado com sucesso");
            } else {        
                response.sendRedirect("index.jsp?mensagem=Erro ao deletar !!");                  
            }
    }   
}
