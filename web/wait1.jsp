<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>
</section>
<div id="common" style="overflow: auto">
    <h2>Wait Staff Page</h2>
    <div style="padding-left: 250px;">
    
       <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 8px solid">
       
        <th></th>
        <tr>
            <td><c:forEach var="front" items="${tableFront}">
                     <c:set var="isExists" value="0"></c:set>
                    <c:forEach var="userTable" items="${usertableList}"> 
                       
                        <c:choose>
                            <c:when test="${front.getTNumber() eq userTable.getTNumber()}">
                                <c:set var="isExists" value="1"></c:set>
                              <button><a href="#${front.getTNumber()}" style="background-color: green;"> 
                                    <c:out value="${front.getTNumber()}"></c:out> <sup>
                                    <c:out value="${front.getCapacity()}"></sup></c:out> 
                         </a></button>
                                
<div id="${front.getTNumber()}" class="modalDialog">
	
               <div>
		<a href="#close" title="Close" class="close">X</a>
		<h2>Table Number:${front.getTNumber()}</h2>
                <c:forEach var="order" items="${orderList}">
                  
                    <c:if test="${front.getTNumber() eq order.getTNumber()}">
                        <c:forEach var="menu" items="${order.getMenuList()}">
                       <c:if test="${menu.getMenuType() eq 'Non-Alcoholic'}">
                       <a href="usercontroller?action=deleteorder&param1=${order.getOrderId()}">
                        <c:out value="${menu.getMenuItem()}"></c:out> &nbsp;&nbsp;&nbsp;
                        <c:out value="$${menu.getPrice()}"></c:out>
                        
                        </a></c:if>
                       <br>
                        
                        </c:forEach>
                       
                    </c:if>
                </c:forEach> 
                       <c:forEach var="amount" items="${amountList}">
                           <c:if test="${amount.getTNumber() eq front.getTNumber()}">
                               <label>Pay Bill:</label>
                               <c:out value="$${amount.getAmount()}"></c:out>
                           </c:if>
                           
                       </c:forEach>
		
                       
                       </div>
</div>                 
                            
                            
                            
                            
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
                     <button>  <a href="#${middle.getTNumber()}" style="background-color: green;"> 
                                    <c:out value="${middle.getTNumber()}"></c:out> <sup>
                                    <c:out value="${middle.getCapacity()}"></sup></c:out> 
                         </a></button>
                                
<div id="${middle.getTNumber()}" class="modalDialog">
	
               <div>
		<a href="#close" title="Close" class="close">X</a>
		<h2>Table Number:${middle.getTNumber()}</h2>
                <c:forEach var="order" items="${orderList}">
                  
                    <c:if test="${middle.getTNumber() eq order.getTNumber()}">
                        <c:forEach var="menu" items="${order.getMenuList()}">
                       <c:if test="${menu.getMenuType() eq 'Non-Alcoholic'}">
                       <a href="usercontroller?action=deleteorder&param1=${order.getOrderId()}">
                        <c:out value="${menu.getMenuItem()}"></c:out> &nbsp;&nbsp;&nbsp;
                        <c:out value="$${menu.getPrice()}"></c:out>
                        
                        </a></c:if>
                       <br>
                        
                        </c:forEach>
                       
                    </c:if>
                           
                          
                </c:forEach>
                       <c:forEach var="amount" items="${amountList}">
                           <c:if test="${amount.getTNumber() eq middle.getTNumber()}">
                               <label>Pay Bill:</label>
                               <c:out value="$${amount.getAmount()}"></c:out>
                           </c:if>
                           
                       </c:forEach>
		
		</div>
</div>                 
                            
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
                               <button>  <a href="#${end.getTNumber()}" style="background-color: green;"> 
                                    <c:out value="${end.getTNumber()}"></c:out> <sup>
                                    <c:out value="${end.getCapacity()}"></sup></c:out> 
                         </a></button>
                         
        <div id="${end.getTNumber()}" class="modalDialog">
	
               <div>
		<a href="#close" title="Close" class="close">X</a>
		<h2>Table Number:${end.getTNumber()}</h2>
                <c:forEach var="order" items="${orderList}">
                  
                    <c:if test="${end.getTNumber() eq order.getTNumber()}">
                        <c:forEach var="menu" items="${order.getMenuList()}">
                       <c:if test="${menu.getMenuType() eq 'Non-Alcoholic'}">
                       <a href="usercontroller?action=deleteorder&param1=${order.getOrderId()}">
                        <c:out value="${menu.getMenuItem()}"></c:out> &nbsp;&nbsp;&nbsp;
                        <c:out value="$${menu.getPrice()}"></c:out>
                        
                        </a></c:if>
                       <br>
                        
                        </c:forEach>
                       
                       <c:forEach var="amount" items="${amountList}">
                           <c:if test="${amount.getTNumber() eq end.getTNumber()}">
                               <label>Pay Bill:</label>
                               <c:out value="$${amount.getAmount()}"></c:out>
                           </c:if>
                           
                       </c:forEach>
		
                    </c:if>
                           
                          
                </c:forEach>  
                     
                       
		</div>
</div>                 
               
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
    </div>
  </div>    

<c:import url="/footer.jsp"/>  

