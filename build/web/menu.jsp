<%-- 
    Document   : menu
    Created on : 25 oct. 2019, 02:09:39
    Author     : ayoub
--%>

<%@page import="java.util.Calendar" %>

<header class="mdl-layout__header">
    <div class="mdl-layout__header-row">
        <!-- Title -->
        <form action="EmpDepServlet?action=ListeDepartement" method="POST">
                <button type="submit" class="mdl-button mdl-js-button mdl-button--mini-fab mdl-button--fab mdl-button--primary"><i class="material-icons">
                                                            arrow_back
                                                        </i></button>
            </form>
        <span class="mdl-layout-title"> Employee Management System</span>
        
        <div class="mdl-layout-spacer"></div>
        
        <nav class="mdl-navigation mdl-layout--large-screen-only">
            <form action="EmpDepServlet?action=Logout" method="POST">
                Welcome ${login}
                <button type="submit" class="mdl-button mdl-js-button mdl-button--mini-fab mdl-button--fab mdl-button--primary"><i class="material-icons">
                                                            exit_to_app
                                                        </i></button>
            </form>
        </nav>
    </div>
</header>