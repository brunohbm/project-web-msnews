<%@page import="java.util.ArrayList"%>
<%@page import="br.com.bruno.banco.AssuntoController" %>
<%@page import="br.com.bruno.modelos.Assunto" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    AssuntoController assContr = new AssuntoController();
    ArrayList<Assunto> assuntos = assContr.getAssuntos();   
%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">   
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">

    <title>MS News</title>
  </head>
  <body style="background-color: #E8E8E8">  
      <nav class="navbar navbar-expand-lg navbar-light shadow-sm justify-content-between" style="background-color: white">
    <a class="navbar-brand ml-3" href="home.jsp">MS News</a>
    <ul class="navbar-nav">
      <li class="nav-item dropdown dropleft mr-3">
          <button style="background-color: transparent" class="btn" type="button" id="dropdownAssuntoButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <img src="img/list.png">
          </button>
      <div class="dropdown-menu text-center" aria-labelledby="dropdownAssuntoButton">   
          <h6 class="dropdown-header">Assuntos</h6>          
          <% for (Assunto ass : assuntos) {%>                    
          <a class="dropdown-item" href="ServletAssuntoQuery?id=<%=ass.getId()%>"><%=ass.getNome()%></a>          
        <%}%>
          <a class="dropdown-item" href="ServletAssuntoQuery?id=0">Todos</a>  
      </div>    
      </li>
    </ul>
  </nav>
     
