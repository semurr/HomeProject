<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	<h1 align="center"> title = ${blog.title}</h1>
	<p>subject = ${blog.subject} </p>	
	<p>author = ${blog.author} </p>
	<#if blog.time??>
	  <p>time = ${blog.time} </p>
	</#if>
</@layout.defaultLayout>