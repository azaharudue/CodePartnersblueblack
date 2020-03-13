<#include "header.ftl">

<b>Welcome to our Small Web App Funding Project</b><br><br>
<div class ="">
<form method="POST" action="projectstartergui?action=requestMakeProject">
	<fieldset id="requestMakeProject">
	
		<legend>Required Informations to create a funding request </legend>
		
		
				<div>
					<label>Email</label>
					<input type="text" name="emailPS" id="emailPS">
			    </div>
				  		 </br>
				<div>
						<label>Name</label>
						<input type="text" name="name" id="name">
				 </div>
				    	 </br>
				   <div>
						<label>  IBAN   </label>
						<input type="text" name="iban" id="iban">
				    </div>   <br>
		   			 <div>
						<label>Project Name</label>
					<input type="text" name="pName" id="pName">
		   			 </div>
		   			 		</br>
					<div> 							
					<label > Project Description</label> </br>						
					<textarea type="text" name="pDescription" rows="10" cols="20" id="pDescription"></textarea>				
					
					</div> 
					 </br>
					<div>
						<label>Funding Limit</label>
						<input type="text" name="fundingLimit" id="fundingLimit">
				    </div>
				     </br>
					<div>	
						<label>End Date</label>
						<input type="text" name="endDate" id="datepicker1">
				    </div>
	
		  		  
		    
				<div>
					<label  align="left">Name of Rewards [Please Use this format : NameOfReward1:Amount1;NameOfReward2:Amount2] </label></br>
					<input type="text" name="nameOfRewardPerAmount"rows="10" cols="20" id="nameOfRewardPerAmount">
			   </div>
				
			
		    
	</fieldset>
	
	<button type="submit" name="requestMakeProject" id="submit">Submit</button>
</form>
</div>
<#include "footer.ftl"> 