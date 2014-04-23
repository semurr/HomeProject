<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>

	<#if error??>
	<p><font color="red">${error}</font></p>
	</#if>	

	<form role="form" action="/HomeProject/account/create" method="post">
	  <div class="form-group">
	    <label for="EmailAddress">Email address</label>
	    <input type="email" name="email" class="form-control" id="emailAddress" placeholder="Enter email">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
	  </div>  
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</@layout.defaultLayout>