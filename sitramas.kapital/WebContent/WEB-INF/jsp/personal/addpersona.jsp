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
									<section class="col col-4">
										<label for="tipoDocumento" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.tipoDoc" /> </label> <label class="select"> 
										<select value="${persona.tipoDocumento}" name="tipoDocumento" id="tipoDocumento" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${tipoDocumento}" var="option">												
													<option value="${option.id}" <c:out value="${persona.tipoDocumento==option.id ? 'selected=selected' : ''}" /> >${option.valorParametro}</option>
												</c:forEach>
										</select> <i></i>
										</label>
									</section>
									<section class="col col-4">
										<label for="dni" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.dni" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-edit"></i>
											<input type="text" onKeyPress="return soloNumeros(event)" maxlength="10" value="${persona.dni}" name="dni" id="dni" placeholder="Agregue Documento de Identidad" required />
										</label>
									</section>
									<section class="col col-4">
										<label for="nombres" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.nombres" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-user"></i>
												<input type="text" value="${persona.nombres}" maxlength="80" name="nombres" id="nombres" placeholder="Agregue Nombres Completos" required />
										</label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
										<label for="apellidoPaterno" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.paterno" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-user"></i>
												<input type="text" value="${persona.apellidoPaterno}" maxlength="80" name="apellidoPaterno" id="apellidoPaterno" placeholder="Agregue Apellido Paterno" required />
										</label>
									</section>
									<section class="col col-4">
										<label for="apellidoMaterno" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.materno" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-user"></i>
										<input type="text" value="${persona.apellidoMaterno}" name="apellidoMaterno" maxlength="80" id="apellidoMaterno" placeholder="Agregue Apellido Materno" required />
										</label>
									</section>
									<section class="col col-4">
										<label for="sexo" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.sexo" /> </label> <label class="select"> 
										<select name="sexo" id="sexo" value="${persona.sexo}" required="" >
												<option value="">-- Seleccione --</option>
												<c:forEach items="${sexoList}" var="sexo">												
													<option value="${sexo.value}" <c:out value="${persona.sexo==sexo.value ? 'selected=selected' : ''}" /> >${sexo}</option>
												</c:forEach>
										</select> <i></i>
									</label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
										<label for="estadoCivil" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.estadoCivil" /> </label> <label class="select"> 
										<select value="${persona.estadoCivil}" name="estadoCivil" id="estadoCivil" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${estadoCivilList}" var="estadocivil">												
													<option value="${estadocivil.value}" <c:out value="${persona.estadoCivil==estadocivil.value ? 'selected=selected' : ''}" /> >${estadocivil}</option>
												</c:forEach>
										</select> <i></i>
									</label>
									</section>
									<section class="col col-4">
										<div class="form-group">
											<label><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.fecnac" /> </label>
											<div class="input-group">
												<input type="text" class="form-control datepicker" data-dateformat="dd/mm/yy" data-mask="99/99/9999" data-mask-placeholder= "-" value="${persona.strfechaNacimiento}" name="strfechaNacimiento" id="strfechaNacimiento">
														<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</section>
									<section class="col col-4">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.celular1" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-phone"></i>
											<input type="text" value="${persona.celular1}" name="celular1" id="celular1" data-mask="(99) 999-999999" placeholder="999-9999999">
										</label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.celular2" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-phone"></i>
											<input type="text" value="${persona.celular2}" name="celular2" id="celular2" data-mask="(99) 999-999999" placeholder="999-9999999">
										</label>
									</section>
									<section class="col col-4">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.fijo" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-phone"></i>
											<input type="text" value="${persona.fijo}" name="fijo" id="fijo" data-mask="(99) 999-9999" placeholder="999-9999999">
										</label>
									</section>
									<section class="col col-4">
										<label for="correoElectronico" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.email" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-envelope-o"></i>
											<input type="email" value="${persona.correoElectronico}" maxlength="80" name="correoElectronico" id="correoElectronico" placeholder="Agregue Correo Electrónico" required="" />
										</label>
									</section>
									
								</div>
								<div class="row">
									<section class="col col-4">
										<input type="hidden" name="strProvincia" id="strProvincia" value="${persona.strProvincia}" >
										<input type="hidden" name="strDistrito" id="" value="strDistrito" value="${persona.strDistrito}" >
										<label for="codDepartamento" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.departamento" /> </label> <label class="select"> 
										<select value="${persona.strDepartamento}" name="codDepartamento" id="codDepartamento" required="">
											<option value="">-- Seleccione --</option>
											<c:forEach items="${departamentos}" var="dept">												
												<option value="${dept.codUbigeo}" <c:out value="${persona.strDepartamento==dept.codUbigeo ? 'selected=selected' : ''}" /> >${dept.departamento}</option>
											</c:forEach>
										</select> <i></i>
									</label>
									</section>
									<section class="col col-4">
										<label for="codProvincia" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.provincia" /> </label> <label class="select"> 
										<select value="${persona.strProvincia}" name="codProvincia" id="codProvincia" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${provincias}" var="prov">												
													<option value="${prov.codUbigeo}" <c:out value="${persona.strProvincia==prov.codUbigeo ? 'selected=selected' : ''}" /> >${prov.provincia}</option>
												</c:forEach>
										</select> <i></i>
									</label>
									</section>
									<section for="codDistrito" class="col col-4">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.distrito" /> </label> <label class="select"> 
										<select value="${persona.strDistrito}" name="codDistrito" id="codDistrito" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${distritos}" var="dist">												
													<option value="${dist.codUbigeo}" <c:out value="${persona.strDistrito==dist.codUbigeo ? 'selected=selected' : ''}" /> >${dist.distrito}</option>
												</c:forEach>
										</select> <i></i>
									</label>
									</section>
								</div>
								<div class="row">
									<section class="col col-8">
										<label for="direccion" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.direccion" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-home"></i>
											<input type="text" value="${persona.direccion}" maxlength="120" name="direccion" id="direccion" placeholder="Agregue Dirección Completa" required />
										</label>
									</section>
									<section class="col col-4">
										<label for="estado" class="label"><spring:message
												code="kapital.sitramas.seguridad.usuarios.form.label.estado" />
										</label> <label class="select"> <select value="${persona.estado}" name="estado" id="frmPerEstado" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${stateList}" var="option">
													<option value="${option.value}"
														<c:out value="${persona.estado==option.value ? 'selected=selected' : ''}" />>${option}</option>
												</c:forEach>
										</select> <i></i>
										</label>
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
