<%-- 
    Document   : header
    Created on : Jun 2, 2016, 7:57:33 PM
    Author     : aavha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>
    <head>
        
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
          <link rel="stylesheet" href="styles/bootstrap.min.css">
          <script src="js/jquery.min.js"></script>
          <script src="js/bootstrap.min.js"></script>
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous"> 
          <link rel="stylesheet" href="styles/main.css">
        <style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    margin: auto;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

@keyframes animatetop {
    from {top:-300px; opacity:0}
    to {top:0; opacity:1}
}

/* The Close Button */
.close {
    color: white;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}
</style>

        
        <script>      
      //Call to Order page
      
      
      //Function handling different user roles
            function login(){
                var username=document.getElementById("username").value;
                var password=document.getElementById("password").value;
                
                 
                if(username == "wait" && password==1234){
                     window.location = "wait.jsp";
                  }
               else if(username == "barattend" && password=="1234"){
                   window.location = "barattend.jsp";
                 }
               else if(username == "host" && password=="1234"){
                   window.location = "host.jsp"; 
               }  
               else if(username == "manager" && password=="1234"){
                   window.location = "manager.jsp";
                 }      
             else{
                 window.location = "error.jsp";
             }    
                
            }
            
            //Function to change color of the button 
            function changecolor(a){
                 var color = document.getElementById(a);
                  color.style.border="solid black 1px";
                  color.style.font="black";
}

                function changecolor1(a){
                    var color1 = document.getElementById(a);
                    color1.style.border="solid black 1px";
                    color1.style.backgroundColor="white";
                    color1.style.borderColor="white";
           
}


            </script>
            
    </head>
    <body>
        <section id="head">
            <span class="head1">
                <c:out value=" A Restaurant Website"></c:out>
            </span>
