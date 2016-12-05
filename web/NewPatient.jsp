<%-- 
    Document   : NewPatient
    Created on : Dec 4, 2016, 5:31:23 PM
    Author     : QmArA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .center_div{
                margin: 0 auto;
                margin-top: 5%;
            }
        </style>
    </head>
    <body>
        <a href="/SimpleApp1/patients"><button style="float: right; background-color: blueviolet; color: white;"> Main Menu </button></a>
        <center><h2> New Patient </h2></center>
        <div class="container center_div">
            <form  method="POST" action="/SimpleApp1/patients">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter Name">
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" name="address" placeholder="Enter Address">
                </div>
                <div class="form-group">
                    <label for="disease">Disease:</label>
                    <input type="text" class="form-control" name="disease" placeholder="Enter Disease">
                </div>
                <div class="form-group">
                    <label for="Age">Age</label>
                    <input type="text" class="form-control" name="age" placeholder="Enter Age">
                </div>
                <div class="form-group">
                    <label for="bloodgroup">Blood Group</label>
                    <input type="text" class="form-control" name="bloodgroup" placeholder="Enter Blood Group">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </body>
</html>
