<#import "layout/defaultLayout.ftl" as layout>
<@layout.defaultLayout>
	<h1 align="center">News</h1>
	<#if blogButton?? == true>
	  <p align="center">
	    <a href=${rc.getContextPath()}/blog/create class="btn btn-primary" role="button">Add new Blog/News</a>
	  </p>  	  	
	<hr/>
	</#if>
	
	<#if blogList??>
	<#list blogList as blog>
		<p>
		  <a href=${rc.getContextPath()}/blog/${blog.blog_id}>${blog.title}</a>		  
		  <#if blog.subject?length gte 40>
		    <p>${blog.subject?substring(0, 40)}. . .</p>
		  <#else>
		    <p>${blog.subject}</p>
		  </#if>		  
		</p>	
	</#list>
	</#if>
	<#include "common/pagination.ftl" />
</@layout.defaultLayout>
