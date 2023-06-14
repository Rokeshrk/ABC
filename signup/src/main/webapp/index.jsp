<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student List</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    h1 {
      text-align: center;
    }

    #searchContainer {
      text-align: center;
      margin-bottom: 20px;
    }

    #searchTerm {
      padding: 8px;
      width: 300px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 16px;
    }

    #searchResults {
      margin: 0 auto;
      max-width: 600px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #f2f2f2;
    }
  </style>
  
</head>
<body>
	<form action="indexstudent" method="post" id="form">
	</form>
</body>
<script type="text/javascript">

function formAutoSubmit () {

var frm = document.getElementById("form");

frm.submit();

}

window.onload = formAutoSubmit;

</script>
</html>
