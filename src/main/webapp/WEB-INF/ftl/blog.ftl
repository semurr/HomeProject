<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	<h1 align="left">${blog.title}</h1>
	<p style="font-size:12">${blog.author.email}
	  <#if blog.time??>
	    <p style="font-size:8">time = ${blog.time} 	  
	  </#if>
	  <hr/>
	</p>
	<p>${blog.subject} </p>	
</@layout.defaultLayout>