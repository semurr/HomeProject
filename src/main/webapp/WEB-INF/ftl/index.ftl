<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	<h1 align="center">Blogs:</h1>
	<#list blogList as blog>
	<p>${blog.title}</p>
	</#list>
</@layout.defaultLayout>
