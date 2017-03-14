<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="logout.jsp"><span style="float:right;">Logout</span></a>
</section>

<div id="common">
    <h2 float="left;"><font color="green">Busyboy Login Page</font></h2><br><br>
    <div style="padding-left: 250px;">
    
        <form name="login" method="post" action="usercontroller" class="form-inline">
        <input type="hidden" value="buslogin" name="action"/>
         <div class="form-group">
         <label>Password:</label>
        <input type="password" name="password" required>
         </div>
        <button type="submit" class="btn btn-default" value="Submit"/>Submit<br>
    </form>
    
    
    </div>
    
</div>    
<c:import url="/footer.jsp"/>  

