<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-upload"></i>  Programación de Servicios
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-7">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-primary"
				href="<c:url value="/seguridad/roles"  />"><i
					class="fa fa-arrow-left"></i> Volver</a></li>
		</ul>
	</div>
</div>
<!-- widget grid -->
<section id="widget-grid" class="">
<!-- START ROW -->
	<div class="row">
		<!-- NEW COL START -->
		<article class="col-sm-12 col-md-12 col-lg-12">
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget" id="wid-id-1" data-widget-editbutton="false" data-widget-custombutton="false">
				<header>
					<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
					<h2>Programación de Servicios</h2>				
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
						<form action="<%= request.getContextPath() %>/servicios/upload" method="POST" id="programacion-form" name="programacion-form" enctype="multipart/form-data" class="smart-form"> 
							<header>
								Cargar Programación
							</header>
							<fieldset>
								<div class="row">
									<section class="col col-4">
											<label class="label">Fecha de Programación: </label>
											<div class="input-group">
												<input type="text" class="form-control datepicker" data-dateformat="dd/mm/yy" data-mask="99/99/9999" data-mask-placeholder= "-" value="${persona.strfechaNacimiento}" name="strfechaNacimiento" id="strfechaNacimiento">
														<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
									</section>
									<section class="col col-4">
										<label class="label">Archivo Carga:</label>
										<div class="input input-file">
											<span class="button"><input type="file" id="file"
												name="file"
												onchange="this.parentNode.nextSibling.value = this.value">Browse</span><input
												type="text" placeholder="Archivo de Programacion" readonly="">
										</div>
									</section>
								</div>
							</fieldset>
							<footer>
								<button id="btnGuardarProg" type="button" class="btn btn-primary"><spring:message code="kapital.sitramas.tools.form.button.save" /></button>
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