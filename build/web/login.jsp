<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">   
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    <title>MS News</title>
  </head>
  <body class="bg-dark">  
      <div class="container">
          <div class="row justify-content-center">
              <div class="col-md-auto mt-5">
                  <div class="card">                      
                      <div class="card-body">    
                          <div class="text-center m-5">
                              <img class="img-fluid"  src="data:image/png;base64,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">
                          </div>
                          <form class="m-5 text-center" action="ServletLogin" method="POST">
                      <div class="form-group ">
                          <label for="inputLogin">Login</label>
                          <input type="text" name="login" class="form-control m-2" maxlength="15" id="inputLogin">
                      </div>
                      <div class="form-group">
                          <label for="inputSenha">Senha</label>
                          <input type="password" name="senha" class="form-control m-2" maxlength="15" id="inputSenha">
                      </div>                              
                              <button type="submit" class="btn btn-outline-light mt-5">
                                  <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAVhSURBVGhD7Zl9SJVXHMefNTbGWDBoL2zLMcv3UptWNl/y+tJ0edN8S22aaVftikLQihrZrbGsOWi5oDFjBL2NLd21upmpdc1okG0tTv+VGzRG/RHEWbBGb9/ffs89z2KR0oxzn7/8wofzO+f4PB9/4n2812NMZCITCW6mrMHkN5so+60mKtVOM0reaEJKjIeet3TBydRGVIQ04ubbjUTBJMSN30IaKdXS6s30BnJMcwOhbpyf7kZZqJuyg8JKuNhxdZqbJHtCLL2+RNRjKLwB1yJrMTkwdyE0yk2JOgldgdeVi6IiGnCfaTfnWhPjwo0YF31v1tF1WBtTR6SbaBfuRdUhz/JdZgbMWmviaknG1eKAWcevwAWur8S7qF4ncStwm9ljOQRzxqy1JrGGZEKNaiShFoLRLrHDYSRVk0yqVpK51RCMdokdDiOlimTyMiVJqYLgWrvEDoeRXkkyvVJJHJUQjg/1S+xwGNlLSWZVKAmPImupfokdDiO3gmSuJckph2C0S+xwGM4yknlLlMRZBpFXpl9ih8MoKCW5uERJeBQFJfoldjiM4iKSxcVKUlwEwWiX2OEwygtJlhcqSRlLmIBk7Y+IXX0W5R6iSeb8/6S0lJ4tW4yisiKqr1qMKdbymA6tqconWZmvJFX5EFwHJC2n4d04RLRxCMMtZyjRXHtS+PrOqgIik8oC/FFZiNfU+ugOrVmej4vMF1bdw3xn1q2D8G0dJArgx4Otg9jp8dPL5t5ocRViak0+Uc0ifMMsMevlTjSae8sXkeS1QCM8Cnbob2Ss7DgJX/spov/Ca9d3+FFJRM9YX/Yw9U56xeXEPea0Kw/tdU4iHpeZey4nSa4DjfC+4Hr8jXScRObX/bRtvHT0Y6RjgGhU+nFqdx+iLcXDrPwAq1cuxD33QiL3QvRUp9ML5jrPJc8DjfC+YMbfyP4T8O/vI9LNvj7cYVyW5mGac3GwKQd/WtNAmnNJ8nqgkeYcCN4ffyNdvfB39RLpB3e6jj/eyKocHFiVQ9KaBmLOzfVA/T4EM/5Gen3IOH6Mto0bH0Z4pNHoOYZTPt/jv1pm1izAgY8WPNqIOTfXVQ3B2PdiHzwC3+BRokc4gut+3+gvdjPrc/HquiycY/7+OBuzrWVjfSbJdZmqkfWZEIz+RlocuLjBoR6/PPbwPPD4HT4M3/BhIpNzh/HgXDd2/uId+/Hr8dAkvv7nlgyilgzc5fqvDRmINPdaHCT5voFGeE8w+hvZlE5yU7qSbHJAbHYoyaUf4L3kJRJeDAvvk/8getIRttlBxNd/4slEglnz/Vabe2M5tGZLGsnWNCXZkgbBBCQjXsSOdKGc+Cdtzp8UTyK9uGU+bvH1V1rno7d1PtGnaeo/J2M5tKYtheRnqUrSlgLRlvr0ks/5G+frrzK32lJpm7Ws1TFmtieT3J6sJDyK7e/pl9jhMNrnkWxPUhIexZfz9EvscBi7kkh+ZUl2zYVgtEvscBi755DsmK0ku+dAMNoldjiMPYkk9yQoCY+C0S6xw2HsnUVy77tKsncWxL5Z+iV2OIyD8SQPxivJtyxhtEvscBidsSQPxSlJZxxEZ6x+iR0Oo3sGye4ZSuKdiQvMFW8s1euE73+bCRwr8Ci6ZwahEV8Mbviiccisj0ZjrS+GSDd837u+KPV2hX2XGf0HPb2RGGKudUeqo7fjkfTOiShK1MnATHX01heO6N4o3Gf0H731hSG9PwIYCMd5prw/nLKDAd+7YSACvw9EkPSHYaql1xt/OCqYm4Ph/OEpiHADv/ojgnQ8/W/8MfTS0DRknQmjUt2cDUPJ2elI/imRnrN0E5nIRJ4qhvEPC3NDKS6WNVcAAAAASUVORK5CYII=">                               
                              </button>                                                 
                  </form>                         
                      </div>
                       <%
                              if(request.getParameter("erro") != null){                                  
                          %>                          
                              <div class="alert alert-danger m-0 text-center">
                                  Erro ao logar !
                              </div>                          
                          <%}%>
                  </div>
              </div>
          </div>
      </div>
    </body>
  <script src="js/jquery.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</html>
