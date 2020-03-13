<#include "header.ftl">

<b>Welcome to our Webapp for the Project Funding  </b>

<table id="project">
	<tr>
		<th>ID</th>
		<th>Project Name</th>
		<th>Email of Project Starter</th>
		<th>Project Description</th>
		<th>Project Status</th>
		<th>Funding Limit</th>
		<th>Dead line</th>		
		
		
	</tr>
	
	<#list project as p>
	<tr>
		<td><a href="supportergui?action=selectToDonate&amp;pid=${p.id}" title="Donate For This Project">${p.id}</a></td>
	
		
		<td>${p.pName}</td>
		<td>${p.emailPS}</td>	
		<td>${p.pDescription}</td>
		<td>${p.pStatus}</td>
		<td>${p.fundingLimit}</td>
		<td>${p.endDate}</td>
				
				
		<div class="Donatelink">
		
		<p><a  href="supportergui?action=selectToDonate&amp;pid=${p.id}" > Donate For this project! </a></p>
		
		</div
		
	</tr>
	</#list>
	
</table>
<#include "footer.ftl">