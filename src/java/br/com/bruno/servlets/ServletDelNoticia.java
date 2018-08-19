package br.com.bruno.servlets;

import br.com.bruno.banco.NoticiaController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDelNoticia extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {          
        NoticiaController noticiaCtr = new NoticiaController();
        String id = request.getParameter("noticia");
        if (id == null) {        
            response.sendRedirect("index.jsp?mensagem=Erro ao deletar!!");                
        } else {        
            noticiaCtr.delNoticia(id);
            response.sendRedirect("index.jsp?mensagem=Deletado com sucesso");
        }
    }  
    
}
