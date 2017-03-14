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

<div id="common"><center>
    <div>
    <h2>Manager Page</h2>

    <div style="float:left">
        <a href="managercontroller?action=getrole">Add User</a><br>
        <a href ="addrole.jsp">Add Role</a><br>
    <a href="managercontroller?action=adduserrole">Add User/Role</a><br>
    <a href="addtable.jsp">Add Table</a><br>
    <a href="addusertable.jsp">Add User/Table</a><br>
    <a href="managercontroller?action=register">Register Table</a><br>
    <a href="managercontroller?action=deleteorders">Delete All orders</a><br>
    
    </div> 
     <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 8px solid">
       
        <th></th>
        <tr>
            <td><c:forEach var="front" items="${tableFront}">
                     <c:set var="isExists" value="0"></c:set>
                    <c:forEach var="userTable" items="${usertableList}"> 
                       
                        <c:choose>
                            <c:when test="${front.getTNumber() eq userTable.getTNumber()}">
                                <c:set var="isExists" value="1"></c:set>
             <button id="${front.getTNumber()}" class="color_green" onclick="changecolor('${front.getTNumber()}')">
                 <c:out value="${front.getTNumber()}"></c:out>
                  <sup><c:out value="${front.getCapacity()}"></c:out>
                  </sup></button>
                                         
                            </c:when>
                            <c:otherwise>
                              
                            </c:otherwise>
                        </c:choose>
                       
                    </c:forEach>
                     <c:if test="${isExists==0}">
                    <button >
                                    <c:out value="${front.getTNumber()}"></c:out> <sup>
                                    <c:out value="${front.getCapacity()}"></sup></c:out> 
                               </button>
                     </c:if>
                </c:forEach>
            </td>
        </tr>
        
        <tr>
            <td><c:forEach var="middle" items="${tableMiddle}">
                     <c:set var="isExistsM" value="0"></c:set>
                    <c:forEach var="userTable" items="${usertableList}"> 
                       
                        <c:choose>
                            <c:when test="${middle.getTNumber() eq userTable.getTNumber()}">
                                <c:set var="isExistsM" value="1"></c:set>
                     <button id="${middle.getTNumber()}" class="color_green" onclick="changecolor('${middle.getTNumber()}')">
                         <c:out value="${middle.getTNumber()}"></c:out> <sup>
                             <c:out value="${middle.getCapacity()}"></c:out> 
                             </sup></button>
                        
                            
                            </c:when>   
                            <c:otherwise>
                              
                            </c:otherwise>
                        </c:choose>
                       
                    </c:forEach>
                     <c:if test="${isExistsM==0}">
                    <button >
                                    <c:out value="${middle.getTNumber()}"></c:out> <sup>
                                    <c:out value="${middle.getCapacity()}"></sup></c:out> 
                               </button>
                     </c:if>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td><c:forEach var="end" items="${tableEnd}">
                     <c:set var="isExistsE" value="0"></c:set>
                    <c:forEach var="userTable" items="${usertableList}"> 
                       
                        <c:choose>
                            <c:when test="${end.getTNumber() eq userTable.getTNumber()}">
                                <c:set var="isExistsE" value="1"></c:set>
                                 <button id="${end.getTNumber()}" class="color_green" onclick="changecolor('${end.getTNumber()}')">
                                     <c:out value="${end.getTNumber()}"></c:out><sup><c:out value="${end.getCapacity()}"></c:out></sup></button>
           
                         
                            </c:when>
                            <c:otherwise>
                              
                            </c:otherwise>
                        </c:choose>
                       
                    </c:forEach>
                     <c:if test="${isExistsE==0}">
                    <button >
                                    <c:out value="${end.getTNumber()}"></c:out> <sup>
                                    <c:out value="${end.getCapacity()}"></sup></c:out> 
                               </button>
                     </c:if>
                </c:forEach>
            </td>
        </tr>
    
       </table>
    
           </div></center>
    
    
    
    
</div>    
<c:import url="/footer.jsp"/>  

