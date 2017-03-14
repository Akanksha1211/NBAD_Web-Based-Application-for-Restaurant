<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="main.jsp"><span style="float:right;">Main Page</span></a>
</section>

<div id="common">
    
    <div style="padding-left: 250px;">
    <nav id="menu">

        <ul class="parent-menu">

            <li><a href="ordercontroller?param1=1&action=additem">1.&nbsp;READY TO ORDER</a></li>
            <li><a href="ordercontroller?param1=2&action=additem">2.&nbsp;MENU</a></li>
            <li><a href="ordercontroller?param1=3&action=additem">3. &nbsp;WATER</a></li>
            <li><a href="ordercontroller?param1=4&action=additem">4. &nbsp;BREAD</a></li>
            <li><a href="ordercontroller?param1=5&action=additem">5. &nbsp; SILVERWARE</a></li>
            <li><a href="ordercontroller?param1=6&action=additem">6. &nbsp; NAPKINS</a></li>

            <li><a href="#">7. &nbsp; NONALCOHOLIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;</a>

                <ul>

                    <li><a href="#"></a></li>

                    <li><a href="#"></a></li>

                    <li><a href="#"></a></li>
                    
                    <li><a href=""></a></li><li><a href="#"></a></li><li><a href="#"></a></li>
                    <li><a href="#"></a></li><li><a href="#"></a></li><li><a href="#"></a></li>
                    <li><a href="#"></a></li><li><a href="#"></a></li><li><a href="#"></a></li>
                    

                    <li><a href="ordercontroller?param1=7&action=additem">&nbsp;PEPSI</a></li>
                    <li><a href="ordercontroller?param1=8&action=additem">&nbsp;JUICE</a></li>
                    

                </ul></li>

            <li><a href="ordercontroller?param1=9&action=additem">8. &nbsp; ALCOHOLIC </a>

            </li>

            <li><a href="ordercontroller?param1=10&action=additem">9. &nbsp; DESSERTS</a></li>

            <li><a href="ordercontroller?param1=11&action=additem">10. &nbsp; DO NOT DISTURB</a>

            </li>
            
            <li><a href="ordercontroller?param1=12&action=additem">11. &nbsp; MANAGER</a>

            </li>

        </ul>

    </nav>
    </div>
    
    
</div>    
<c:import url="/footer.jsp"/>  

