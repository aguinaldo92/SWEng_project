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
<script>
function alertCiao(){
	alert("ciao");
}
</script>
<s:div class="container">
	<s:div class="product">
		<h2 class="product-in">Inserisci nuovo prodotto</h2>

		<s:form name="addProduct" id="idAddProduct" action="AddProduct" >

			<s:url action="Categories" var="aCategories" />
<%-- 			<s:div cssClass="col-md-1">  funziona --%>
				<sj:select name="categoryName" id="idCategoryName"
					href="%{aCategories}" list="categoryNames" label="Category*"
					headerKey="-1" headerValue="Aggiungi Categoria"
					listKey="categoryNames"
					onChange="showDiv(this,idNewCategory)"
					onChangeTopics="reloadBrand,reloadModel" 
					value="-1"        />
<%-- 			</s:div> --%>
<%-- 			<s:div cssClass="col-md-2"> --%>
				<s:textfield name="newCategory" id="idNewCategory" />
<%-- 			</s:div> --%>
			<s:url id="idaBrand" var="aBrand" action="Brands">
				<s:param name="categoryName" value="" />
			</s:url>

			<sj:select name="brandName" id="idBrandName" formIds="idAddProduct"
				href="%{aBrand}" list="brandNames" label="Brand*" headerKey="-1"
				headerValue="Aggiungi Brand" onChange="showDiv(this,idNewBrand)"
				onChangeTopics="reloadModel" reloadTopics="reloadBrand" 
				value="-1"/>

			<s:textfield name="newBrand" id="idNewBrand" />
<%-- il value="" serve per evitare che jquery aggiunga la virgola iniziale quando struts passa i parametri --%>
			<s:url id="idaModel" var="aModel" action="Models">
				<s:param name="categoryName" value="" />
				<s:param name="brandName" value="" />
			</s:url>

			<sj:select name="modelName" id="idModelName" formIds="idAddProduct"
				href="%{aModel}" list="modelNames" label="Model*" headerKey="-1"
				headerValue="Aggiungi Model" onChange="showDiv(this,idNewModel)"
				reloadTopics="reloadModel" 
				value="-1"  />

			<s:textfield name="newModel" id="idNewModel" />

			<s:textfield name="barcode" label="Bar code" />
			<s:textfield name="title" label="Title*" />
			<s:textfield name="description" label="Description" />
			<s:textfield name="sizes" label="Size" />
			<s:textfield name="weight" label="Weight" />
			<s:textfield name="sellingPrice" label="SellingPrice*" />
			<s:textfield name="sellingDiscount" label="SellingDiscount" />
			<s:submit value="Invia" />
		</s:form>

	</s:div>
</s:div>