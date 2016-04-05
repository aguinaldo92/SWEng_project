<%@ taglib prefix="s" uri="/struts-tags" %>

<s:iterator value="#session.shops" begin="#parameters.idshop" end="#parameters.idshop">

<s:date name="registrationDate" format="dd/MM/yyyy" var="regDate"/>

<div class="single-para">
	<div class="para-grid">
		<div style="text-align: center;font-weight: bold; color: #f95a32;">
		<h1><s:property value="name"/></h1>
		<br>
		Data di registrazione: <s:property value="regDate"/>
		</div>
		<div class="clearfix"></div>
	 </div>
	<div class="container">
	<div class="single">
		<h2 class="account-in">Gestione dello shop</h2>
	<div style="float:left; display:block;">
		<div class="single-bottom">
		<h4>Collocazione su GMaps</h4>
		<s:if test="lat!=90.00000 && lon!=0.00000">
		<iframe width="470" height="310" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?q=<s:property value="lat"/>,<s:property value="lon"/>&mrt=loc&t=m&z=17&hl=it&output=embed"></iframe>
		</s:if>
		<s:else>
		E' stato riscontrato un problema nella collocazione dello <br>shop su Google Maps.
		Controllare l'indirizzo completo inserito <br>se si vuole visualizzare correttamente la mappa.
		</s:else>
		</div>
	</div>
	<div style="float:left; display:block;">
		<div class="account">
			<s:form name="update" action="UpdateShop">
				<s:textfield name="id" hidden="true"/>
				<s:textfield name="name" hidden="true"/>
				<s:textfield name="registrationDate" value="%{#regDate}" hidden="true"/>
				
				<s:textfield name="address" label="Indirizzo (*)" size="60%"/>
				<s:textfield name="cap" label="CAP (*)" />
				<s:textfield name="city" label="Città (*)" />
				<s:textfield name="province" label="Provincia (*)"/>
				<s:textfield name="state" label="Stato (*)"/>
				<s:select name="typology" label="Tipologia di negozio" 
				list="#{NULL:'','Magazzino':'Magazzino','Negozio al dettaglio':'Negozio al dettaglio','Privato':'Privato','Filiale di catena comm.':'Filiale di catena comm.'}" />
				
				<s:submit value="Modifica"/>
			</s:form>	
		</div>
				
	</div>
	</div>
	</div>
	</div>

</s:iterator>