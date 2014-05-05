<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	<h1 align="center">News</h1>
	<#list blogList as blog>
		<p>
		  <a href=${rc.getContextPath()}/blog/${blog.blog_id}>${blog.title}</a>
		</p>	
	</#list>
</@layout.defaultLayout>
