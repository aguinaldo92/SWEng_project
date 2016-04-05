<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!-- Devo visualizzare i tipi di prodotto iterando l'arraylist #session.prodotti che contiene i prodotti -->

<div class="products">
	<div class="top-products">

		<!-- visualizzo i tipi di prodotto, quando clicco devo aprire una action che mi permette di fare qualcosa con il tipo di prodotto es: apre specifico prodotto -->
		<s:iterator value="#session.typeOfProducts">
			<!-- cambiare action in modo da  aprire uno specifico prodotto per il configuratore -->
			<s:url action="ProductsOfTypeOfProduct.action" var="aTypeOfProds">
				<!-- passo il parametro alla action per visualizzare lo specifico tipo di prodotto -->
				<s:param name="id">
					<s:property value="id" />
				</s:param>
			</s:url>
			<div class="col-md-3 md-col">

				<div class="col-md">
					<s:a href="%{aTypeOfProds}">CIAO
					<s:param name="id">
							<s:property value="id" />
						</s:param>
					</s:a>
					<%-- 					<s:a href="%{aTypeOfProds}"></s:a> --%>
					<s:url action="ImagesOfTypeOfProduct.action" var="aImgsTypeOfProds">
						<s:param name="id">
							<s:property value="id" />
						</s:param>
					</s:url>
					<sj:div href="%{aImgsTypeOfProds}" class="slider" timeout="10000"
						indicator="indicator">
						<img id="indicator" src="images/others/loading.jpg" border="0" />
					</sj:div>

					<div class="top-content">
						<h5>
							<s:a href="%{aTypeOfProds}">
								<s:property value="model" />
							</s:a>
							<div class="white">
								<s:property value="categoryName" />
								<br>
								<s:property value="brand" />
								- <br> Quantità disponibili :
								<s:property value="quantityAvailable" />
								<br> A partire da :
								<p class="dollar">
									<span class="in-dollar">$</span><span><s:property
											value="minPrice" /></span>
								</p>
							</div>
						</h5>
					</div>
				</div>
			</div>
		</s:iterator>

	</div>
	<div class="clearfix"></div>

</div>


