<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="static/css/login.css">
<body>


<h2>Home Decor</h2>
<c:if test="${not empty error}">
	        <p style="color: red;">${error}</p>
	    </c:if>
<div class="container" id="container">
 <c:if test="${not empty error}">
	        <p style="color: red;">${error}</p>
	    </c:if>
	<div class="form-container sign-up-container">
 <form action="RegisterServlet" method="post">
			<h1>Create Account</h1>
			
			<input type="text" name="firstName" placeholder="FirstName" />
			<input type="text" name="lastName" placeholder="LastName" />
			<input type="text" name="username" placeholder="Username" />
			<input type="text" name = "password" placeholder="Password" />
			<button>Sign Up</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
<form action="LoginServlet" method="post">
			<h1>Sign in</h1>
			
			<input type="text" name="username" placeholder="Username" />
			<input type="password" name="password" placeholder="Password" />
<!-- 			<a href="#">Forgot your password?</a>
 -->			<button>Sign In</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Friend!</h1>
				<p>Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>

<footer>

</footer>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function () {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    console.log("loaded");

    signUpButton.addEventListener('click', () => {
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener('click', () => {
        container.classList.remove("right-panel-active");
    });
});
</script>


</body>
</html>