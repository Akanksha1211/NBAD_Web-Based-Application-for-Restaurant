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
         <h4><font color="green">Add New Table</font></h4>
        <form action="managercontroller" method="post" class="form-inline">
       <input type="hidden" value="addtable" name="action"> 
    <div class="form-group">   
    <label for="exampleInputEmail1">TablNumber:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="TableNumber" name="tablenumber" class="form-control" id="tablenumber" required>
    </div>
    <br>
    <div class="form-group">
    <label for="exampleInputEmail1">Location:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="Location" name="location"  class="form-control" id="location" required></div>
    <br>
    <div class="form-group">
    <label for="exampleInputEmail1">Capacity:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="Capacity" name="capacity" class="form-control" id="capacity" required></div>
    <br><div class="form-group">
    <label for="exampleInputEmail1">TableStatus:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="Status" name="status" class="form-control" id="status" required></div>
    <br><br>
    <button type="submit" class="btn btn-default">Add Table</button><br><br></form>
   
        </form>
<a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>

    </center>
    
        
        
    
    </div>
    
    
    
    
</div>    
<c:import url="/footer.jsp"/>  

