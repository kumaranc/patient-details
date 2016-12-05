<%-- 
    Document   : index
    Created on : Dec 4, 2016, 3:52:47 PM
    Author     : QmArA
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Details_of_Patients.patients"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <center><h2>Patients</h2></center>
        <a href="/SimpleApp1/NewPatient.jsp"><button style="float: left; background-color: blueviolet; color: white;"> New Patients </button></a>
        <table class = "table table-hover">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Disease</th>
                    <th>Age</th>
                    <th>Blood Group</th>
                </tr>
            </thead>

            <tbody>
                <%  ArrayList<patients> patients = (ArrayList<patients>)request.getAttribute("patients"); 
                for(patients patient:patients){ %>
                    <tr>
                        <td><%= patient.getName() %></td>
                        <td><%= patient.getAddress() %></td>
                        <td><%= patient.getDisease() %></td>
                        <td><%= patient.getAge() %></td>
                        <td><%= patient.getBlood_group() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>       
    </body>
</html>
