<#include "header.ftl">

<b>Welcome to our Webapp for the Project Funding  </b>
<p> Click on ID to see details of any project</p>

<table id="projects">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Status</th>
		
		
	</tr>
	
	<#list projects as p> 
	
	 <tr>
		<td><a href="supportergui?action=selectPPage&amp;id=${p.id}" title="Search Project Details">${p.id}</a></td>
		<td> ${p.pName}</td>
		<td> ${p.pStatus}</td>
	</tr>
	</#list>
</table>
<#include "footer.ftl">