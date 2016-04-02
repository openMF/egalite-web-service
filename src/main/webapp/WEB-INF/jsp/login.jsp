<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<LINK href="/resources/css/mfiapp.css" rel="stylesheet" type="text/css">
</head>
<body class="loginBody" onload='document.f.j_username.focus();'>
	<h1 class="loginHeading">BFSI - MFImAx</h1>
	<div class="loginForm">
		<h3 class="formTitle">Sign In</h3>
		<form name='f' action='/j_spring_security_check' method='POST'>
			<table>
				<tr>
					<td class="formLabel">User</td>
					<td><input class="formInput" type='text' name='j_username'
						value=''></td>
				</tr>
				<tr>
					<td class="formLabel">Password</td>
					<td><input class="formInput" type='password' name='j_password' />
						${request.error}</td>
				</tr>
				<tr>
					<td colspan='2' class="buttonRow"><input name="submit"
						class="actionOk" type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>