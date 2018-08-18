<%@page import="java.util.ArrayList"%>
<%@page import="br.com.bruno.banco.AssuntoController" %>
<%@page import="br.com.bruno.modelos.Assunto" %>
<%@page import="br.com.bruno.modelos.Noticia" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    ArrayList<Noticia> noticias;    
%>
<%
    noticias = (ArrayList<Noticia>) request.getAttribute("noticias");
%>

<%@include file="nav.jsp" %>

      <div class="container-fluid">
          <div class="row m-0">
              <%for (Noticia noticia : noticias) {%>
              
               <div class="col-sm-12 col-md-6 col-lg-3 my-4">
                   <a href="ServletNoticiaQuery?id=<%=noticia.getId()%>" style="text-decoration: none">
                    <div class="card">
                        <img class="card-img"  style="height: 179.84px;" src=<%=noticia.getImagem()%>>
                        <div class="card-body text-dark" style="height: 325px;">
                            <h5 class="card-title"><%=noticia.getLegenda()%></h5>
                            <p class="card-text text-justify"><%=noticia.getResumo()%></p>
                        </div>
                        <div class="card-footer text-muted">
                           <span class="float-left"><%=noticia.getAssunto().getNome()%></span> 
                          <span class="float-right"><%=noticia.getData()%></span>
                        </div>
                    </div>
                   </a>
              </div>
                    
              <%}%>
          </div>
      </div>
    
<%@include file="footer.jsp"%>
