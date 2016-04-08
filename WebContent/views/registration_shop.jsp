<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="single-para">
	<div class="para-grid">
		<div style="text-align: center;font-weight: bold; color: #f95a32;">
		<h1><s:property value="name"/></h1>
		</div>
		<div class="clearfix"></div>
	 </div>
	<s:div class="container">
	<s:div class="account">
	<h2 class="account-in">Registrazione nuovo shop</h2>
	<s:if test="hasActionErrors()">
	<div style="color:red">
	<s:actionerror />
	</div>
	</s:if>
			<s:form name="update" action="AddShop">
				
				<s:textfield name="name" label="Nome dello shop" requiredLabel="true" labelSeparator=" "/>
				<s:textfield name="address" label="Indirizzo" size="80%" requiredLabel="true" labelSeparator=" "/>
				<s:textfield name="cap" label="CAP" requiredLabel="true" labelSeparator=" "/>
				<s:textfield name="city" label="Città" requiredLabel="true" labelSeparator=" "/>
				<s:textfield name="province" label="Provincia" requiredLabel="true" labelSeparator=" "/>
				<s:textfield name="state" label="Stato" value="Italia" requiredLabel="true" labelSeparator=" "/>
				
				<s:submit value="Aggiungi shop"/>
			</s:form>
		</s:div>
	</s:div>
</div>
