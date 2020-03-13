<!DOCTYPE HTML>
<html lang='de' dir='ltr'>
<head>
	<meta charset="utf-8" />
	<title>Funding Project - ${pagetitle}</title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	<script>
  		$(function() {
    		$( "#datepicker2" ).datepicker(
    		{
    			minDate:'today',
    			
    		});
 
  			$("#datepicker1").datepicker({
  				minDate:'today',
    			onSelect: function (dateValue, inst) {
        			$("#datepicker2").datepicker("option", "minDate", dateValue)
    			}
			});
		});
  	</script>
</head>
<body>
<div id="wrapper">
	<div id="logo"> Funding Project<br>Software Engineering Lab Assingnment</div>
    <ul id="navigation">
    	<li><a href="index" title="Index">View Homepage</a></li>
	<#if navtype == "supporter">
    	<li><a href="supportergui?page=defaultwebpageS" title="Search Projects">Search Projects</a></li>	
	<#elseif navtype == "projectstarter">
		<li><a href="projectstartergui?page=defaultWebpagePS" title="Insert Project">Insert Project</a></li>
	<#else>
    	<li><a href="projectstartergui" title="Project Starter">Project Starter</a></li>
		<li><a href="supportergui" title="supporter">Supporter</a></li>
	</#if>
    </ul>
	<div id="content">
    </ul>
	<div id="content">
	
	</body>