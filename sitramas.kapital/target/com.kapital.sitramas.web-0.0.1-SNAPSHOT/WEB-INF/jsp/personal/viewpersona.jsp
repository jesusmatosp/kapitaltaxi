<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-male"></i> Registro de Información Personal </span>
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-7">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-primary"
				href="<c:url value="/personal/personas.do"  />"><i
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
				<header>
					<span class="widget-icon"> <i class="fa fa-edit"></i> </span>
					<h2><spring:message code="kapital.sitramas.main.menu.users" /> </h2>				
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
						<form method="POST" id="persona-form" name="usuario-form" class="smart-form">
							<input type="hidden" value="${persona.id}" id="frmPersonaId" name="id" />
							<header>
								<h1><spring:message code="kapital.sitramas.seguridad.usuarios.form.subtitulo1" /></h1>
							</header>
							<fieldset>
								<div class="row">
									<section class="col col-2">
										<label for="tipoDocumento" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.tipoDoc" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.strTipoDocumento}" /> </label>
									</section>
									<section class="col col-2">
										<label for="dni" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.dni" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.dni}" /> </label>
									</section>
									<section class="col col-2">
										<label for="nombres" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.nombres" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.nombres}" /> </label>
									</section>
									<section class="col col-2">
										<label for="apellidoPaterno" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.paterno" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.apellidoPaterno}" /> </label>
									</section>
									<section class="col col-2">
										<label for="apellidoPaterno" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.paterno" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.apellidoPaterno}" /> </label>
									</section>
									<section class="col col-2">
										<label for="apellidoMaterno" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.materno" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.apellidoMaterno}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-2">
										<label for="sexo" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.sexo" /> </label> 
										<label style="font-weight: bold;" ><c:out value="${persona.strSexo}" /> </label>
									</section>
									<section class="col col-2">
										<label for="estadoCivil" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.estadoCivil" /> </label> 
										<label style="font-weight: bold;" ><c:out value="${persona.strEstadoCivil}" /> </label>
									</section>
									<section class="col col-2">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.fecnac" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.strfechaNacimiento}" /> </label>	
									</section>
									<section class="col col-2">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.celular1" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.celular1}" /> </label>
									</section>
									<section class="col col-2">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.celular2" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.celular2}" /> </label>
									</section>
									<section class="col col-2">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.fijo" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.fijo}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-2">
										<label for="correoElectronico" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.email" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.correoElectronico}" /> </label>
									</section>
									<section class="col col-2">
										<input type="hidden" name="strProvincia" id="strProvincia" value="${persona.strProvincia}" >
										<input type="hidden" name="strDistrito" id="" value="strDistrito" value="${persona.strDistrito}" >
										<label for="codDepartamento" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.departamento" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.strDepartamento}" /> </label> 
										
									</section>
									<section class="col col-2">
										<label for="codProvincia" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.provincia" /> </label> 
										<label style="font-weight: bold;" ><c:out value="${persona.strProvincia}" /> </label>
									</section>
									<section class="col col-2">
										<label for="codDistrito" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.distrito" /> </label> 
										<label style="font-weight: bold;" ><c:out value="${persona.strDistrito}" /> </label>
									</section>
									<section class="col col-4">
										<label for="direccion" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.direccion" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.direccion}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-2">
										<label for="estado" class="label"><spring:message
												code="kapital.sitramas.seguridad.usuarios.form.label.estado" />
										</label> 
										<label style="font-weight: bold;" ><c:out value="${persona.strEstado}" /> </label>
									</section>
								</div>
							</fieldset>
						<footer>
							<button id="btnGuardarUser" type="button" class="btn btn-primary"><spring:message code="kapital.sitramas.tools.form.button.save" /></button>
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
