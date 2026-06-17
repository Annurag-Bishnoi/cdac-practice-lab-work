<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style>
    *{
        margin:0;
        padding:0;
        box-sizing:border-box;
        font-family: Arial, sans-serif;
    }

    body{
        height:100vh;
        display:flex;
        justify-content:center;
        align-items:center;
        background:white;
    }

    .login-container{
        width:350px;
        background:#fff;
        padding:30px;
        border-radius:15px;
        box-shadow:0 8px 20px rgba(0,0,0,0.2);
    }

    .login-container h2{
        text-align:center;
        margin-bottom:25px;
        color:#333;
    }

    .input-group{
        margin-bottom:15px;
    }

    .input-group label{
        display:block;
        margin-bottom:5px;
        color:#555;
        font-weight:bold;
    }

    .input-group input{
        width:100%;
        padding:10px;
        border:1px solid #ccc;
        border-radius:8px;
        outline:none;
    }

    .input-group input:focus{
        border-color:#4facfe;
    }

    .btn-login{
        width:100%;
        padding:12px;
        border:none;
        background:#4facfe;
        color:white;
        font-size:16px;
        border-radius:8px;
        cursor:pointer;
        transition:0.3s;
    }

    .btn-login:hover{
        background:#2196f3;
    }

    .footer{
        text-align:center;
        margin-top:15px;
    }

    .footer a{
        text-decoration:none;
        color:#4facfe;
    }
</style>

</head>
<body>

<div class="login-container">
    <h2>Login</h2>

    <form action="login" method="post">
			
        <div class="input-group">
            <label>Username</label>
            <input type="text" name="username" placeholder="Enter username" required>
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter password" required>
        </div>

        <button type="submit" class="btn-login">Login</button>

      

    </form>
</div>

</body>
</html>