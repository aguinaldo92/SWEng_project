<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<s:if test="hasActionErrors()">
	<div style="color: red">
		<s:actionerror />
	</div>
</s:if>

<script>
	function showDiv(selectBox,idNewValue) {
		if(selectBox.options[selectBox.selectedIndex].value === "-1") {
			$('#'+idNewValue.id).show();
		} else {
			$('#'+idNewValue.id).hide();
			idNewValue.value = "";
		}
	};
	
</script>

<s:div class="container">
	<s:div class="product">
		<h2 class="product-in">Inserisci nuova Caratteristica</h2>
		
		<s:form name="addCharacteristic" id="idAddCharacteristic" action="AddCharactristic" >
		
		<s:url action="Characteristics" var="aCharacteristics" />
		
			<sj:select name="characteristicName" id="idCharacteristicName"
					href="%{aCharacteristics}" list="categoryNames" label="Characteristic*"
					headerKey="-1" headerValue="Aggiungi Caratteristica"
					listKey="characteristicNames"
					onChange="showDiv(this,idNewCategory)"
					onChangeTopics="reloadBrand,reloadModel" 
					value="-1"        />
		
		
		
		</s:form>
	</s:div>
</s:div>