<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-lock"></i> <spring:message code="kapital.sitramas.main.menu.seguridad" /> <span>> <spring:message code="kapital.sitramas.main.menu.privilegios" /> > ${title} </span>
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-7">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-primary"
				href="<c:url value="/seguridad/privilegios"  />"><i
					class="fa fa-arrow-left"></i> Volver</a></li>
		</ul>
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
					<h2>Administración de Privilegios</h2>				
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
						
						<form id="privilegios-form" action="<%= request.getContextPath() %>/seguridad/privilegios/save"  method="post" class="smart-form" >
							<header>
								Agregar Privilegio
							</header>
							<input type="hidden" name="id" id="hdIdPrivilegio" value="${privilegio.id}" />
							<fieldset>
									<div class="row">
										<section class="col col-4">
											<label class="label">Nombre Privilegio:</label>
											<label class="input"> <i class="icon-prepend fa fa-lock"></i>
												<input type="text" value="${privilegio.nombrePrivilegio}" name="nombrePrivilegio" id="nombrePrivilegio" placeholder="Agregar Nombre" required />
											</label>
											
										</section>
										<section class="col col-8">
											<label class="label">Descripción</label>
											<label class="input"> <i class="icon-prepend fa fa-lock"></i>
												<input type="text" value="${privilegio.descripcionPrivilegio}" name="descripcionPrivilegio" id="descripcionPrivilegio" placeholder="Agregar Descripción" required />
											</label>
										</section>
									</div>
	
									<div class="row">
										<section class="col col-4">
											<label class="label">Estado</label> <label class="select"> 
											<select value="${privilegio.estado}" name="estado" id="estado" required>
												<option value=""> -- Seleccione -- </option>
												<c:forEach items="${stateList}" var="option">												
													<option value="${option.value}" <c:out value="${privilegio.estado==option.value ? 'selected=selected' : ''}" /> >${option}</option>
												</c:forEach>
										</select> <i></i>
										</label>
									</section>
									</div>
								</fieldset>
							<footer>
								<button id="btnGuardar" type="button" class="btn btn-primary"><spring:message code="kapital.sitramas.tools.form.button.save" /></button>
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
<!-- Modulo de Seguridad - Administrar Cuenta -->
<script src="<c:url value="/resources/public/seguridad/privilegios.js" />" ></script>
