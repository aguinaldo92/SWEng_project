<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
</s:if>

<s:action name="ListLocations"/>
<s:action name="ManageLocations"/>

<s:div class="container">
	
	<s:div class="account">
			<h2 class="account-in">Dati della residenza</h2>
			
			<s:if test="residence.name == 'Residenza'">
			<s:form name="manageresidence" action="UpdateLocation">
				<s:hidden name="idlocation" value="%{residence.id}"/>
				<s:hidden name="name" value="Residenza"/>
				<s:textfield name="address" value="%{residence.address}" label="Indirizzo" size="80%" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="number" value="%{residence.number}" label="Civico" labelSeparator=" "/>
				<s:textfield name="cap" value="%{residence.cap}" label="CAP" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="city" value="%{residence.city}" label="Città" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="province" value="%{residence.province}" label="Provincia" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="state" value="%{residence.state}" label="Stato" labelSeparator=" " requiredLabel="true"/>
				<s:submit value="Aggiorna residenza" name="submit_name"/>
			</s:form>
			</s:if>
			<s:else>
			<s:form name="manageresidence" action="AddLocation">
				<s:hidden name="name" value="Residenza"/>
				<s:textfield name="address" value="%{residence.address}" label="Indirizzo" size="80%" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="number" value="%{residence.number}" label="Civico" labelSeparator=" "/>
				<s:textfield name="cap" value="%{residence.cap}" label="CAP" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="city" value="%{residence.city}" label="Città" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="province" value="%{residence.province}" label="Provincia" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="state" value="%{residence.state}" label="Stato" labelSeparator=" " requiredLabel="true"/>
				<s:submit value="Aggiorna residenza" name="submit_name"/>
			</s:form>
			</s:else>
			
		</s:div>
		
	<s:iterator value="other_locations">
	
		<s:div class="account">
			<h2 class="account-in"><s:property value="name"/></h2>
			
			<s:form name="otheraddress" action="UpdateLocation">	
				<s:hidden name="idlocation" value="%{id}"/>		
				<s:textfield name="name" label="Nome dell'indirizzo" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="address" label="Indirizzo" size="80%" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="number" label="Civico" labelSeparator=" "/>
				<s:textfield name="cap" label="CAP" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="city" label="Città" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="province" label="Provincia" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="state" label="Stato" value="Italia" labelSeparator=" " requiredLabel="true"/>
				<s:submit value="Aggiorna indirizzo" name="submit_name"/>
			</s:form>
		</s:div>
	
	</s:iterator>
	
	<s:div class="account">
			<h2 class="account-in">Aggiungi un indirizzo di spedizione</h2>
			
			<s:form name="registrationaddress" action="AddLocation">			
				<s:textfield name="name" value="" label="Nome" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="address" value="" label="Indirizzo" size="80%" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="number" value="" label="Civico" labelSeparator=" "/>
				<s:textfield name="cap" value="" label="CAP" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="city" value="" label="Città" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="province" value="" label="Provincia" labelSeparator=" " requiredLabel="true"/>
				<s:textfield name="state" value="Italia" label="Stato" labelSeparator=" " requiredLabel="true"/>
				<s:submit value="Aggiungi indirizzo" name="submit_name"/>
			</s:form>
		</s:div>
</s:div>