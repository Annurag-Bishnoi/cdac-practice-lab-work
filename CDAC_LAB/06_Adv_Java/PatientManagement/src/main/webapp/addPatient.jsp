<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: inline-block; width: 100px; font-weight: bold; }
        .form-group input { padding: 5px; width: 250px; }
        button { padding: 6px 15px; margin-left: 100px; cursor: pointer; }
        .result-box { margin-top: 30px; padding: 15px; border: 1px solid #ccc; background-color: #f9f9f9; width: 350px; }
    </style>
</head>
<body>

    <h2>User Registration</h2>
    
    <form action="create" method="POST">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" required>
        </div>
        
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        
        <div class="form-group">
            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required>
        </div>
        
        <div class="form-group">
            <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="Male" style="width: auto;" checked> Male
            <input type="radio" id="female" name="gender" value="Female" style="width: auto;"> Female
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
        </div>
        
        <div class="form-group">
            <label for="phoneNo">Phone No:</label>
            <input type="text" id="phoneNo" name="phoneNo" required>
        </div>
        
        <button type="submit">Submit</button>
    </form>

    <hr>

  

</body>
</html>