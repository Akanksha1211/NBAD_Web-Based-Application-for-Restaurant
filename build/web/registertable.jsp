<%-- 
    Document   : manager
    Created on : Jun 2, 2016, 11:14:39 PM
    Author     : aavha
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>
</section>

<div id="common">
    <div>
    <h2>Manager Page</h2>

    <center>
         <h4><font color="green">Register Table</font></h4> 
    <form name="registertableform" action="managercontroller" method="get" class="form-inline" id="registertableform">
   <c:if test="${msg1 != null}">
       <h5> <p><c:out value="${msg1}"></c:out></p></h5>
    </c:if>
    <input type="hidden" name="action" value="managerregistertable" />
    <select id="settocookie" name="settocookie" class="form-control"> 
           <c:forEach var="at" items="${tablelist}">
               <option value="${at.getTNumber()}">${at.getTNumber()}</option>
       </c:forEach>
    </select>
    <button type="submit" name="Register Table" class="btn btn-default">Register Table</button>
</form>
        <a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>

    </center>
    
        
        
    
    </div>
    
    
    
    
</div>    
<c:import url="/footer.jsp"/>  

