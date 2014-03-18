<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	
	<h1>Login</h1>
	</br>

	<form role="form" action="/HomeProject/account/login" method="post">
	  <div class="form-group">
	    <label for="EmailAddress">Email address</label>
	    <input type="email" name="email" class="form-control" id="emailAddress" placeholder="Enter email">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
	  </div>  
	  <button type="submit" class="btn btn-default">Log In</button>
	</form>
</@layout.defaultLayout>