<#include "header.ftl">

<b>Welcome to FP Webapp</b><br><br>


<form method="POST" action="supportergui?action=queryProject">
	<fieldset id="queryProject">
	<h2> Search project with following project status</h2>
	<legend>Required Information</legend>


	<label class="container">OPEN PROJECTS
	  <input type="checkbox" name ="pStatus" value="OPEN">
	  <span class="checkmark"></span>
	</label>

	
	<label class="container" > SUCCESSFUL PPROJECTS
	  <input type="checkbox"name ="pStatus" value="SUCCESSFUL">
	  <span class="checkmark"></span>
	</label>
	<label class="container">FAILED PROJECTS
	  <input type="checkbox" name ="pStatus"  value="FAILED">
	  <span class="checkmark"></span>
	</label>
	
		</fieldset>
<button type="submit"  id="selectPPage" name="selectPPage" value="submit">Submit!</button>

</form>
<#include "footer.ftl">