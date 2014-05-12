<#-- if current page not page 1 add a prev button -->
<#-- always have the max limit page button -->
<#-- set the current page to active -->


<div align=left>
<#if pagination??>
  <ul class="pagination">	
	<#if pagination.currentPageNumber != 1>
		<li><a href=?page=${pagination.currentPageNumber - 1}>&laquo;</a></li>
	</#if>  
    <li><a href=?page=1>1</a></li>
    <li><a href=?page=2>2</a></li>    
    <#if pagination.currentPageNumber lt pagination.maxPageNumber>
		<li><a href=?page=${pagination.currentPageNumber + 1}>&raquo;</a></li>
	</#if>      
  </ul>
<#else>
  <ul class="pagination">
  	<li><a href=?page=1>First</a></li>
  </ul>
</#if>
</div>