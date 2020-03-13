<#include "header.ftl">

<b>Welcome to our little demonstration on the FP Webapp</b><br>
</br>

<form method="POST" action="supportergui?action=requestAddDonation">
	<fieldset id="requestAddDonation">
		<legend>Required Information</legend>
		<div>
			<label>Supporter Email</label>
			<input type="text" name="email" id ="email">
	    </div>
	    <div>
			<label>Supporter IBAN</label>
			<input type="text" name="iban" id ="iban">
	    </div>
	    <div>
			<label>Supporter Name</label>
			<input type="text" name="name" id="name">
	    </div>
	    <div>
	    	<label>Amount To Donate</label>
	    	<input type="text" name="amountToDonate" id ="amountToDOnate">
	    </div>
	 	</fieldset>
	<input type="hidden" value="${pid}" name="pid">
	<button type="submit"  name= "requestAddDonation" id="requestAddDonation">Submit</button>
	
</form>
<#include "footer.ftl">