<%-- 
    Document   : login
    Created on : Jun 2, 2016, 8:45:11 PM
    Author     : aavha
--%>
<%-- 
    Document   : main
    Created on : Jun 2, 2016, 8:22:00 PM
    Author     : aavha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="main.jsp"><span style="float:right;">Main Page</span></a>
</section>

<center>
<div  id="common">
    
    <form name="login" action="usercontroller" method="post" class="form-inline">
        <input type="hidden" value="login" name="action" />
        
    <h1User Login Form </h1> 
    <p><i><c:out value="${message}"></c:out></i></p>
    <h6>Please enter your Username and Password to continue</h6>
    <div class="form-group">
    <label for="exampleInputName2">Username:</label>
    <input type="text" placeholder="Username" name="username" id="username" class="form-control" required>
    <img src="images/image4_2.jpg" alt="Keyboard"></div>
    <br><br>
    <div class="form-group">
    <label for="exampleInputName2">Password:</label>
    <input type="password" placeholder="Password" name="password" id="password" class="form-control" required>
    <img src="images/image4_2.jpg" alt="Keyboard"></div>
    <br>
    <br>
    <button type="submit" value="Login" onclick="login()" class="btn btn-default">Login</button><br><br>
        
        </form>
    
   
    &copy;<c:out value=" Copyright 2016 Fadi Mohsen"></c:out>
</div>
</center>

        
        
      
        
<c:import url="/footer.jsp"/>             
        