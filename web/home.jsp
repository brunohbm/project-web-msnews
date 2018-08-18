<%@page import="java.util.ArrayList"%>
<%@page import="br.com.bruno.banco.NoticiaController" %>
<%@page import="br.com.bruno.modelos.Noticia" %>
<%@page import="br.com.bruno.banco.AssuntoController" %>
<%@page import="br.com.bruno.modelos.Assunto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    NoticiaController nc = new NoticiaController();
    ArrayList<Noticia> noticias = nc.getNoticias(true);
%>

<%@include file="nav.jsp" %>    

  <div class="container-fluid">
     <div class="row m-0">
       <div class="col">
         <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators fixed-bottom m-2">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active mr-3"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1" class="mr-3"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2" class="mr-3"></li>
  </ol>
    <div class="carousel-inner">
        <%  
            int ctr = noticias.size() % 4;
            ctr = (noticias.size() - ctr) / 4;
            int indiceControl = 0;
            for (int rows = 0; rows < ctr; rows++) {
        %>
      <div class="carousel-item <%if (rows == 0) {%> active <%}%>">          
          <div class="row m-0">
              <%for (int cards = 0; cards < 4; cards++) { %>
              <div class="col-sm-12 col-md-6 col-lg-3 my-4">
                  <a href="ServletNoticiaQuery?id=<%=noticias.get(cards + indiceControl).getId()%>" style="text-decoration: none">
                      <div class="card shadow" >                      
                      <img class="card-img-top" style="height: 179.84px;" src=<%=noticias.get(cards + indiceControl).getImagem()%> alt="Sem Imagem">                      
                           <div class="card-body text-dark" style="height: 325px;">
                          <h5 class="card-title text-center"><%=noticias.get(cards + indiceControl).getLegenda()%></h5>
                          <p class="card-text text-justify">
                              <%=noticias.get(cards + indiceControl).getResumo()%>                              
                          </p>
                      </div>
                      <div class="card-footer text-muted">
                          <span class="float-left"><%=noticias.get(cards + indiceControl).getAssunto().getNome()%></span> 
                          <span class="float-right"><%=noticias.get(cards + indiceControl).getData()%></span>
                      </div>
                  </div>
                  </a>
              </div>  
              <%
                }
                indiceControl += 4;
              %>
          </div>  
      </div>
        <%}%>
    </div>
  </div>
  </div>    

<%@include file="footer.jsp"%>    