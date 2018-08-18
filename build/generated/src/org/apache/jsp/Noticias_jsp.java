package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import br.com.bruno.banco.AssuntoController;
import br.com.bruno.modelos.Assunto;
import br.com.bruno.modelos.Noticia;

public final class Noticias_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    AssuntoController ac = new AssuntoController();
    ArrayList<Assunto> assuntos = new ArrayList<>();
    ArrayList<Noticia> noticias = new ArrayList<>();    

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');

    noticias = (ArrayList<Noticia>) request.getAttribute("noticias");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">   \n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("    <title>MS News - Home</title>\n");
      out.write("  </head>\n");
      out.write("  <body style=\"background-color: #D3D3D3\">  \n");
      out.write("  <nav class=\"navbar navbar-expand-lg navbar-light bg-light justify-content-between\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"#\">MS News</a>\n");
      out.write("    <ul class=\"navbar-nav\">\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("      <button class=\"btn btn-secondary dropdown-toggle\" type=\"button\" id=\"dropdownAssuntoButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("        Categorias\n");
      out.write("      </button>\n");
      out.write("      <div class=\"dropdown-menu\" aria-labelledby=\"dropdownAssuntoButton\">\n");
      out.write("          ");
 for (Assunto ass : assuntos) { 
      out.write("\n");
      out.write("          <a class=\"dropdown-item\" href=\"ServletAssuntoQuery?id=");
      out.print(ass.getId());
      out.write('"');
      out.write('>');
      out.print(ass.getNome());
      out.write("</a>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("      </div>    \n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("  </nav>\n");
      out.write("      \n");
      out.write("      <div class=\"container\">\n");
      out.write("          <div class=\"row\">\n");
      out.write("              ");
for (Noticia noticia : noticias) {
      out.write("\n");
      out.write("              <div class=\"col\">");
noticia.getLegenda();
      out.write("</div>\n");
      out.write("              ");
}
      out.write("\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("    </body>\n");
      out.write("  <script src=\"js/jquery.min.js\"></script>\n");
      out.write("  <script src=\"js/popper.min.js\"></script>\n");
      out.write("  <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
