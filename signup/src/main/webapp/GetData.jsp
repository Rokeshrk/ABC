<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('data.png') no-repeat;  
            /*  background-color: #fff;    */
            background-size: cover;
            background-position: fixed;
            background-attachment: fixed;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        center{
            margin-top: -13%;
        }
        h3{
            margin-top: -4%;
        }
        
        .form {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
            padding: 70px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            background-color: #ffffff;
        }
        
        .form img {
            height: auto;
            width: 100px;
            border-radius: 50%;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
        }
        
        .inputBox input {
            width: 180px;
            font-size: 18px;
            font-weight: bold;
            background-color: #2980b9;
            border: none;
            padding: 10px;
            color: #ffffff;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        .inputBox input:hover {
            background-color: #3498db;
        }
        
        .inputBox input:active {
            background-color: #1f618d;
        }
    </style>
</head>
<body>
 <center>
        <img src="logo.png" alt="logo">
        <h1>Dr.NGP INSTITUTE OF TECHNOLOGY</h1>
        <h3>(An Autonomous Institution)</h3>
        <h2>Department of INFORMATION TECHNOLOGY</h2>
    <div class="form">
        <div class="inputBox">
            <input type="submit" value="Staffs"  onclick="location.href='indexstaff.jsp'">
        </div>
        <div class="inputBox">
            <input type="submit" value="Students"  onclick='location.href = "index.jsp"'>
        </div>

    </div>
</center>


</body>


</html>