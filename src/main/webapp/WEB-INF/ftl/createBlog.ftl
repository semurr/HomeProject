<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>

	<#if error??>
	<p><font color="red">${error}</font></p>
	</#if>
	<#if success??>
	<p><font color="green">${success}</font></p>
	</#if>		

	<form role="form" action=${rc.getContextPath()}/blog/create method="post">
	  <div class="form-group">
	    <label for="title">Blog Title</label>
	    <input type="text" name="title" class="form-control" id="title" placeholder="Enter blog title">
	  </div>
	  <div class="form-group">
	    <label for="Content">Content</label>
	   <textarea class="form-control" name="subject" rows="20" id="subject" placeholder="Blog content"></textarea>
	  </div>  
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</@layout.defaultLayout>