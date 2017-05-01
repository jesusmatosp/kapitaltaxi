<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-key"></i> <spring:message code="kapital.sitramas.main.menu.seguridad" /> <span>> <spring:message code="kapital.sitramas.main.manu.change.password" /> </span>
		</h1>
	</div>
</div>

<c:if test="${not empty msg}">
	<div class="alert alert-block alert-success">
		<a class="close" data-dismiss="alert" href="#">×</a>
		<h4 class="alert-heading"><i class="fa fa-check"></i> Se guardó Correctamente!</h4>
		<p>
			${msg}
		</p>
	</div>
</c:if>
<c:if test="${not empty error}">
	<div class="alert alert-block alert-danger">
		<a class="close" data-dismiss="alert" href="#">×</a>
		<h4 class="alert-heading"><i class="fa fa-check"></i> Error!</h4>
		<p>
			${error}
		</p>
	</div>
</c:if>
<!-- widget grid -->
<section id="widget-grid" class="">
<!-- START ROW -->

	<div class="row">

		<!-- NEW COL START -->
		<article class="col-sm-12 col-md-12 col-lg-12">
			
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget" id="wid-id-1" data-widget-editbutton="false" data-widget-custombutton="false">
				<!-- widget options:
					usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
					
					data-widget-colorbutton="false"	
					data-widget-editbutton="false"
					data-widget-togglebutton="false"
					data-widget-deletebutton="false"
					data-widget-fullscreenbutton="false"
					data-widget-custombutton="false"
					data-widget-collapsed="true" 
					data-widget-sortable="false"
					
				-->
				<header>
					<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
					<h2>Cambiar Password</h2>				
				</header>

				<!-- widget div-->
				<div>
					
					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->
						
					</div>
					<!-- end widget edit box -->
					
					<!-- widget content -->
					<div class="widget-body no-padding">
						
						<form id="checkout-form" action="<%= request.getContextPath() %>/seguridad/update" method="post"  class="smart-form" >
							<header>
								Administre su Cuenta
							</header>
							<fieldset>
									<div class="row">
										<section class="col col-6">
											<label class="label">Ingrese su Password</label>
											<label class="input"> <i class="icon-prepend fa fa-lock"></i>
												<input type="password" name="password_old" id="password_old" placeholder="<spring:message code="kapital.sitramas.seguridad.cuenta.form.password.old" />">
											</label>
										</section>
										<section class="col col-6">
											<label class="label">Ingrese su Nuevo Password</label>
											<label class="input"> <i class="icon-prepend fa fa-lock"></i>
												<input type="password" name="password_new" id="password_new" placeholder="<spring:message code="kapital.sitramas.seguridad.cuenta.form.password.new" />">
											</label>
										</section>
									</div>
	
									<div class="row">
										<section class="col col-6">
											<label class="label">Confirme su Password</label>
											<label class="input"> <i class="icon-prepend fa fa-lock"></i>
												<input type="password" name="password_confirm" id="password_confirm" placeholder="<spring:message code="kapital.sitramas.seguridad.cuenta.form.password.confirm" />">
											</label>
										</section>
									</div>
								</fieldset>
							<footer>
								<button type="submit" class="btn btn-primary"><spring:message code="kapital.sitramas.tools.form.button.save" /></button>
								<button type="button" class="btn btn-default"
									onclick="window.history.back();"><spring:message code="kapital.sitramas.tools.form.button.cancel" /> </button>
							</footer>
						</form>
					</div>
				</div>
			</div>
	</article>
</div>
</section>
<script src="<c:url value="/resources/public/app/app.js" />" ></script>