<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	<h1 align="center">News</h1>
	<#if blogList??>
	<#list blogList as blog>
		<p>
		  <a href=${rc.getContextPath()}/blog/${blog.blog_id}>${blog.title}</a>
		</p>	
	</#list>
	</#if>
</@layout.defaultLayout>
