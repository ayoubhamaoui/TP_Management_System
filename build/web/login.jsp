<%-- 
    Document   : login
    Created on : 10 nov. 2019, 01:23:46
    Author     : ayoub
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <%@include file="./head.jsp" %>
    <body>
        <%
            
            if(session.getAttribute("isLogged") != null){
                    response.sendRedirect("index.jsp");
            }else{
        %>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <main class="mdl-layout__content">
                <div class="page-content">
                    <div class="mdl-grid center-items">
                        <div class="mdl-layout-spacer"></div>
                        <div class="mdl-cell mdl-cell--4-col">
                            <div class="mdl-card mdl-shadow--6dp">
                                <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                                    <h2 class="mdl-card__title-text">
                                        Login
                                    </h2>
                                </div>
                                <div class="mdl-card__supporting-text">
                                    <form name="myForm" action="LoginServlet" method="GET" >
                                        
                                        <div class="mdl-textfield mdl-js-textfield">
                                            <input type="text" class="mdl-textfield__input" id="login" placeholder="Login" name="login" >
                                            <label class="mdl-textfield__label" for="login">Login</label>
                                        </div>
                                            
                                        <div class="mdl-textfield mdl-js-textfield">
                                            <input type="password" class="mdl-textfield__input" id="password" placeholder="Password" name="password">
                                            <label class="mdl-textfield__label" for="password">Password</label>
                                        </div>
                                            
                                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" type="submit">
                                            Login
                                        </button> 
                                        
                                    </form>    
                                </div> 
                            </div>
                        </div>
                        <div class="mdl-layout-spacer"></div>
                    </div>
                </div>
            </main>
        </div>
        <% } %>
    </body>
</html>
