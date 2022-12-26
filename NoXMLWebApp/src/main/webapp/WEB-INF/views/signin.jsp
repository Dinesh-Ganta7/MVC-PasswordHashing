<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Star-Sign in</title>
<link rel="stylesheet" type="text/css" href="css/signup.css">
</head>
<body>

	<div>
		<div class="bg-container">
			<div class="form-container">
				<h1 class="form-heading">Sign In</h1>
				<p class="form-text">Enter your login credentials</p>
				<form action="validate-login" class="form" autocomplete="off">
					<label for="email" class="form-label">Email</label> <input
						type="email" name="email" placeholder="Enter your email id"
						class="form-input" required /> <br> <label for="password"
						class="form-label">Password</label> <input type="text"
						name="password" placeholder="Enter your password"
						class="form-input" required />
					<p>${passwordErr}</p>

					<div class="form-btn-container">

						<button type="submit" class="form-btn">submit</button>
					</div>

				</form>

			</div>



		</div>


	</div>


	<div></div>

</body>
</html>