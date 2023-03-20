<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

<head>
<title>Thêm tài khoản</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: black;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>

	<form:form action="add-admin" method="POST" modelAttribute="admin">
		<div class="container">
			<h1>Thêm tài khoản</h1>
			<hr>
			
			<label for="name"><b>Tên của bạn</b></label>
				<form:input path="display_name" type="text" placeholder="Tên của bạn" name="name" id="name" />

			<label for="email"><b>Tên tài khoản</b></label>
				<form:input path="username" type="text" placeholder="Tên tài khoản" name="email" id="email" />

			<label for="psw"><b>Mật khẩu</b></label>
				<form:input path="password" type="password" placeholder="Mật khẩu" name="psw" id="psw" />
			<hr>

			<button type="submit" class="registerbtn">Thêm tài khoản</button>
		</div>
	</form:form>

</body>
