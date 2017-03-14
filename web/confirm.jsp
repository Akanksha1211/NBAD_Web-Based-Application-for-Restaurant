<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="main.jsp"><span style="float:right;">Main Page</span></a>
</section>

<div id="common" style="overflow-x: auto;">
<center>
    <h1><font color="green">Your cart</font></h1><br><br>

<table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 2px solid; width:80%" >
  <tr>
      <td><b>Quantity</b></td>
      <td><b>Description</b></td>
      <td><b>Price</b></td>
      <td><b>Amount</b></td>
    
  </tr>
  
  <c:forEach var="order" items="${order}">
  <tr>
      <c:forEach var="menu" items="${order.menuList}">
        
        
          <td><c:out value="${order.getQuantity()}"></c:out></td>
          <td><c:out value="${menu.getMenuItem()}"></c:out></td>
    <td><c:out value="${menu.getPrice()}"></c:out></td>
    <td><c:out value="${order.getQuantity()*menu.getPrice()}"></c:out></td>
   </c:forEach>
  </tr>
  </c:forEach>
</table><br>
<label for="exampleInputEmail1">Total:</label>
<span>$&nbsp;<c:out value="${total}"></c:out></span>

<br></center>
<div style="padding-left: 90px;">    

 <form method="post" action="ordercontroller?action=checkout" class="form-inline">
   
  <a href="ordercontroller?action=confirm">Confirm</button>
 </form>
</div>
</div>
    
<c:import url="/footer.jsp"/>  

