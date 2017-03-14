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

<div id="common" center>
    <div>
    <h2>Manager Page</h2>
    <center>
        <h4><font color="green">Add User Table</font></h4>
    <form action="managercontroller" method="post" class="form-inline">
       <input type="hidden" value="addusertable" name="action"> 
      <div class="form-group">  
    <label for="exampleInputEmail1">TablNumber:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="TableNumber" name="tablenumber" id="tablenumber" class="form-control" required></div>
    <br>
     <div class="form-group">
    <label for="exampleInputEmail1">UserName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="UserName" name="username" id="username" class="form-control" required></div>
    <br><br>
    <button type="submit" value="Add User Table" class="btn btn-default">Add User Table</button><br><br></form>
   
        </form>
<a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>

    </center>
    
        
        
    
    </div>
    
    
    
    
</div>    
<c:import url="/footer.jsp"/>  

