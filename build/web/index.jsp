<%-- 
    Document   : index
    Created on : 10 nov. 2019, 01:10:27
    Author     : ayoub
--%>

<%@page import="Entity.Dept"%>
<%@page import="java.util.List"%>
<%@page import="Dao.EmpDao"%>
<%@page import="Entity.Emp"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    if(session.getAttribute("isLogged")== null){
        response.sendRedirect("login.jsp");
    }else{
 %>
 
 <% 
    EmpDao empDao=new EmpDao();
    List<Emp> empL;
    
    Dept dept = new Dept();
    dept.setDeptno("10");
    
    empL = empDao.findAllByDept(dept);
 %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <%
                for(Emp emp : empL){%>
                    <tr>
                        <td> <%=emp.getEmpno() %> </td>
                        <td> <%=emp.getEname() %> </td>  
                    </tr>
            <%}%>
      </table>
    </body>
</html>

<% } %>
