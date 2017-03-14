<%-- 
    Document   : footer
    Created on : Jun 2, 2016, 8:18:03 PM
    Author     : aavha
--%>


        
<section id="foot">
    <c:out value="&copy; A Resturant Website"></out>
<c:out value="${cookie1.value}"/>
<b><%=request.getServerName() %></b>:
<b><%=request.getServerPort() %></b>
<c:out value="${cookie.port.getValue()}"/>
</section>
</body>
</html> 