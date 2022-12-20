<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Sign up</title>
		<link rel="stylesheet" type="text/css" href="css/signup.css" />
	</head>

	<body>
		<div class="bg-container">
			<div class="form-container">
				<h1 class="form-heading">Sign Up</h1>
				<p class="form-text">Please fill in this form to create an
					account</p>
				<form action="create-user" class="form" autocomplete="off">
					<label for="email" class="form-label">Email</label> 
					<input type="email" name="email"
						placeholder="Enter your email id" class="form-input" required/> 
						<br> 
						<label for="password"
						class="form-label">Password</label> 
						<input type="text" name="password"
						placeholder="Enter your password" class="form-input" required /> 
						<br> 
						<label for="confirm-password"
						class="form-label">Confirm Password</label> 
						<input type="text" name="confirm-password"
						placeholder="Re-enter your password" class="form-input"required /> 
						<br> <label for="dob"
						class="form-label" class="form-input">Date Of Birth</label> 
						<input type="date" name="dob"
						class="form-input" /> <br>
						 <label class="form-label" class="form-input"><input type="checkbox"
							checked name="remember-checkbox" required/>Remember Me</label>

					<p class="form-text">
						By creating account you agree to our <a href="" class="form-text">Terms
							and Conditions</a>
					</p>
					<div class="form-btn-container">
						<button type="button" class="form-btn">Cancel</button>
						<button type="submit" class="form-btn">submit</button>
					</div>

				</form>

			</div>



		</div>
	</body>

	</html>