<div class="navbar navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/HomeProject">Workspace</a>
        </div>
        <div class="collapse navbar-collapse">          
          <ul class="nav navbar-nav navbar-right">        
        	<li class="dropdown">
        		<#if Session.sessionData??>
        			<#if Session.sessionData.validated>
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Logged In <b class="caret"></b></a>
        			<#else>
        				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Account<b class="caret"></b></a>
        			</#if>
        		<#else>
        			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Account<b class="caret"></b></a>
        		</#if>        		
        		<ul class="dropdown-menu">
        			<li><a href="#"></a></li>
        			<li><a href=${rc.getContextPath()}/account/create>Create Account</a></li>
        			<li><a href="${rc.getContextPath()}/account/login">Login</a></li>
        			<li class="divider"></li>
        			<li><a href="#">Separated link</a></li>
        		</ul>
        	</li>
          </ul>		
        </div><!--/.nav-collapse -->
      </div>
</div>