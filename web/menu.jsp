<%-- 
    Document   : menu
    Created on : 25 oct. 2019, 02:09:39
    Author     : ayoub
--%>

<%@page import="java.util.Calendar" %>

<header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <span class="mdl-layout-title">Employee Management System</span>
        
        <div class="mdl-layout-spacer"></div>
        
        <nav class="mdl-navigation mdl-layout--large-screen-only">
            <form action="http://localhost:8080/GestionEmployeeDepartment" method="GET">
                Welcome ${login}
                <button type="submit" class="mdl-button mdl-js-button mdl-button--mini-fab mdl-button--fab mdl-button--primary"><i class="material-icons">
                                                            account_circle
                                                        </i></button>
            </form>
        </nav>
    </div>
</header>