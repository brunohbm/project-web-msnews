<%@page import="br.com.bruno.banco.NoticiaController"%>
<%@page import="br.com.bruno.banco.UserController"%>
<%@page import="br.com.bruno.modelos.Usuario"%>
<%@page import="br.com.bruno.modelos.Noticia" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    NoticiaController notContr = new NoticiaController();
    UserController userContr = new UserController();
%>

<%@include file="nav.jsp" %>    

<div class="container-fluid">
    <% if(request.getParameter("mensagem") != null) {%>
        <div class="alert alert-info alert-dismissible fade show mt-3 mb-1" role="alert">
            <%out.print(request.getParameter("mensagem"));%>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>            
    <%}%> 
    <div class="row">
        <div class="col-12 p-2">
            <div class="card">
                <div class="card-header">Noticia</div>
                <div class="card-body">
                    <form action="ServletSaveNoticia" method="POST">
                        <div class="row">
                             <div class="col-4">
                                <div class="form-group">                    
                                    <label for="inputLegenda">Legenda</label>
                                    <input type="text" class="form-control" id="inputLegenda" name="legenda" maxlength="40" placeholder="Limite De 40 Caracteres.">                        
                                </div>
                                <div class="form-group">
                                    <label for="inputImagemLink">Imagem Link</label>
                                    <input type="text" class="form-control" id="inputImagemLink" name="imagemLink" maxlength="200" placeholder="Link Da Imagem">
                                </div>
                                <div class="form-group">
                                    <label for="textareaResumo">Resumo</label>
                                    <textarea class="form-control" id="textareaResumo" rows="6" maxlength="266"></textarea>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text" for="selectAssunto">Assunto:</label>
                                        </div>
                                        <select name="assunto" class="custom-select" id="selectAssunto">
                                            <% for (Assunto a : assContr.getAssuntos()){ %>                    
                                                <option value=<%=a.getId()%>> <%=a.getNome()%> </option>                
                                            <% } %>
                                        </select>
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-secondary" type="submit">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-8">
                                <div class="form-group">
                                    <label for="textareaDescricao">Descrição</label>
                                    <textarea class="form-control" id="textareaDescricao" rows="15"></textarea>
                                </div>
                            </div>          
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-6 p-2">
            <div class="card">
                <div class="card-header">Assunto</div>
                <div class="card-body">
                    <form action="ServletSaveAssunto" method="POST">
                        <div class="form-group mt-4">
                            <label for="inputNome">Nome</label>
                            <div class="input-group mb-5">                        
                                <input type="text" class="form-control" name="nome" id="inputName">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" type="submit">Salvar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-6 p-2">
            <div class="card">
                <div class="card-header">Usuário</div>
                <div class="card-body">
                    <form action="UserSaveServlet" method="POST">
                        <div class="form-group">
                            <label for="inputLogin">Login</label>
                            <input type="text" class="form-control" name="login" id="inputLogin">
                            <label for="inputSenha">Senha</label>
                            <div class="input-group mb-3">                        
                                <input type="text" class="form-control" name="senha" id="inputSenha">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" type="submit">Salvar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div> 
    <div class="row">
        <div class="col-12 p-2">
            <div class="card">
                <div class="card-header">Deletar</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-4">
                            <form action="ServletDeletaNoticia" method="POST">
                                <label for="selectDelNoticia">Noticia</label>
                                <div class="input-group">                                    
                                    <select class="custom-select" id="selectDelNoticia" name="noticia">
                                        <% for(Noticia noticia : notContr.getNoticias(false)) {%>                    
                                        <option value=<%=noticia.getId()%>> <%=noticia.getAssunto().getNome()%> - <%=noticia.getLegenda()%></option>                
                                        <% } %> 
                                    </select>
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-danger" type="submit">Deletar</button>
                                    </div>
                                </div>  
                            </form>
                        </div>
                        <div class="col-4">
                            <form action="UserDeleteServlet" method="POST">
                                <label for="selectDelUsuario">Usuário</label>
                                <div class="input-group">
                                    <select class="custom-select" id="selectDelUsuario" name="user">
                                        <% for(Usuario a : userContr.getUsers()){ %>                    
                                        <option value=<%=a.getId()%>> <%=a.getLogin()%> </option>                
                                        <% } %>
                                    </select>
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-danger" type="submit">Deletar</button>
                                    </div>
                                </div>  
                            </form>
                        </div>
                        <div class="col-4">
                            <form action="ServletDelAssunto" method="POST">
                                <label for="selectDelAssunto">Assunto</label>
                                <div class="input-group">
                                    <select class="custom-select" id="selectDelAssunto" name="assunto">
                                        <% for (Assunto a : assContr.getAssuntos()){ %>                    
                                        <option value=<%=a.getId()%>> <%=a.getNome()%> </option>                
                                        <% } %>
                                    </select>
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-danger" type="submit">Deletar</button>
                                    </div>
                                </div>  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
