package br.com.bruno.servlets;

import br.com.bruno.modelos.Assunto;
import br.com.bruno.modelos.Noticia;
import java.io.IOException;
import br.com.bruno.banco.NoticiaController;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "ServletSaveNoticia", urlPatterns = {"/ServletSaveNoticia"})
public class ServletSaveNoticia extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Noticia noticia = new Noticia();
        noticia.setLegenda(request.getParameter("legenda"));
        noticia.setResumo(request.getParameter("resumo"));
        noticia.setDescricao(request.getParameter("descricao"));
        noticia.setImagem(request.getParameter("imagem"));
        Assunto a = new Assunto();
        a.setId(Integer.parseInt(request.getParameter("assunto")));
        noticia.setAssunto(a);
        
        NoticiaController nc = new NoticiaController();
        if (nc.saveNoticia(noticia)) {
            response.sendRedirect("index.jsp?mensagem=Salvo");
        } else {        
            response.sendRedirect("index.jsp?mensagem=Erro");                                
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
