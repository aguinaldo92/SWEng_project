<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<head>
<s:include value="/js/menu_header.html"></s:include>
<%-- <sj:head/> serve al datetimepicker --%>
<sj:head />
</head>

<%-- questa riga serve per far si che quando viene caricata la pagina header.jsp  sia eseguita la Action Categories <s:action name="Categories"  executeResult="true" /> --%>
<s:action name="Categories" executeResult="true" />
<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="header-top-in">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt=" "></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
						<li><s:a action="index">Home</s:a></li>
						<li><s:if test="#session.login != null">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<s:property value="#session.username" /> <b class="caret"></b>
								</a>
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<ul class="dropdown-menu">
										<li><s:a action="profile">Profile</s:a></li>
									</ul>
							</s:if> <s:else>
								<s:a action="loginUser">Login</s:a>
							</s:else></li>
						<ul class="dropdown-menu">
							<li class="nav-header">View</li>
							<li><a href="<s:url namespace="/" action="todo"/>">My
									TODOs</a></li>
							<li class="divider"></li>
							<li class="nav-header">Manage</li>
							<s:url var="newtodourl" namespace="/" action="todo-edit" />
							<li><sj:a id="newTodoLink" href="%{newtodourl}"
									openDialog="todoDialog" openDialogTitle="New TODO ...">New TODO ...</sj:a></li>
						</ul>
						<li><a href="#"> SHOPPING CART</a></li>
						<li><a href="checkout.html">CHECKOUT</a></li>
						<li><div class="cart">
								<a href="#" class="cart-in"> </a> <span> 0</span>
							</div>
							<ul class="sub-icon1 list">
								<h3>Recently added items(2)</h3>
								<div class="shopping_cart">
									<div class="cart_box">
										<div class="message">
											<div class="alert-close"></div>
											<div class="list_img">
												<img src="images/14.jpg" class="img-responsive" alt="">
											</div>
											<div class="list_desc">
												<h4>
													<a href="#">velit esse molestie</a>
												</h4>
												1 x<span class="actual"> $12.00</span>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<div class="cart_box1">
										<div class="message1">
											<div class="alert-close1"></div>
											<div class="list_img">
												<img src="images/15.jpg" class="img-responsive" alt="">
											</div>
											<div class="list_desc">
												<h4>
													<a href="#">velit esse molestie</a>
												</h4>
												1 x<span class="actual"> $12.00</span>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
								<div class="total">
									<div class="total_left">CartSubtotal :</div>
									<div class="total_right">$250.00</div>
									<div class="clearfix"></div>
								</div>
								<div class="login_buttons">
									<div class="check_button">
										<a href="checkout.html">Check out</a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</ul></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="index.html"><i> </i>Desktops</a></li>
					<li><a href="#">Laptops Notebooks</a>
						<ul class="drop">
							<li><a href="products.html">Sony(2)</a></li>
							<li><a href="products.html">Android(4)</a></li>
							<li><a href="products.html">Apple(7)</a></li>
							<li><a href="products.html">Acer(53)</a></li>
							<li><a href="products.html">HP(78)</a></li>
							<li><a href="products.html">Intel(5)</a></li>
						</ul></li>
					<li><s:url action="BestDeals.action" var="aBestDeals" />
					<s:a href="%{aBestDeals}" >Best Deals</s:a>  </li>
					<!-- 						itero sulla lista di categorie e cliccando su una categoria carico nella user session i tipi di prodotti ad essa associati -->
					<s:iterator value="#session.brandsPerCategories"
						status="iteratorStatus">
						<s:url action="TypeOfProductsBy.action" var="aProdByCat">
							<s:param name="categoryName" value="key" />
						</s:url>
						<!-- 					la productsByCategory.action deve caricare i dati nella user session, poi reindirizzare alla tiles da cui leggere i dati -->
						<li><s:a href="%{aProdByCat}">
								<s:property value="key" />
							</s:a>
							<ul class="drop">
								<s:iterator value="value">
									<s:url action="TypeOfProductsBy.action"
										var="aProdByCatAndBrand">
										<s:param name="categoryName" value="key" />
										<s:param name="brand">
											<s:property />
										</s:param>
									</s:url>
									<li><s:a href="%{aProdByCatAndBrand}">
											<s:property />
										</s:a></li>
								</s:iterator>
							</ul></li>
					</s:iterator>

				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div>
		</div>
	</div>
	<div class="header-bottom-in">
		<div class="container">
			<div class="header-bottom-on">
				<p class="wel">
					<a href="#">Welcome visitor you can login or create an account.</a>
				</p>
				<div class="header-can">
					<ul class="social-in">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>
						<li><a href="#"><i class="skype"> </i></a></li>
					</ul>
					<div class="down-top">
						<select class="in-drop">
							<option value="Dollars" class="in-of">Dollars</option>
							<option value="Euro" class="in-of">Euro</option>
							<option value="Yen" class="in-of">Yen</option>
						</select>
					</div>
					<div class="search">
						<form>
							<input type="text" value="Search" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '';}"> <input
								type="submit" value="">
						</form>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>