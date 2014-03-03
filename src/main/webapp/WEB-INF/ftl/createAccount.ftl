<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>

	<form role="form" method="post">
	  <div class="form-group">
	    <label for="EmailAddress">Email address</label>
	    <input type="email" class="form-control" id="emailAddress" placeholder="Enter email">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" id="password" placeholder="Password">
	  </div>  
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</@layout.defaultLayout>