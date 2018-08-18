<%@page import="br.com.bruno.modelos.Noticia" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!     
    Noticia noticia;
%>

<%
   noticia = (Noticia)request.getAttribute("noticia");
   String[] texto = noticia.getDescricaoFormat();
%>
<%@include file="nav.jsp" %>    
        <div class="container">
            <div class="row justify-content-center mt-5 mb-5">
                <div class="col-sm-12 col-lg-9">
                    <div class="card shadow-lg">
                        <img class="card-img-top" src="<%=noticia.getImagem()%>" alt="<%=noticia.getLegenda()%>">
                        <div class="card-body text-dark p-5">
                            <h2  class="card-title text-center mb-5"><%=noticia.getLegenda()%></h2>
                            <%for (int i = 0; i < texto.length; i++) {%>
                                <p class="card-text text-justify"><%=texto[i]%></p>
                            <%}%>  
                        </div>
                        <div class="card-footer text-muted">
                          <span class="float-left"><%=noticia.getAssunto().getNome()%></span> 
                          <span class="float-right"><%=noticia.getData()%></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@include file="footer.jsp"%>        
    
