<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-lock"></i> Registro de Usuarios
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-7">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-primary"
				href="<c:url value="/seguridad/usuarios"  />"><i
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
						<form method="POST" id="view-usuario-form" name="usuario-form" class="smart-form">
							<header>
								<h1><spring:message code="kapital.sitramas.seguridad.usuarios.form.subtitulo" /></h1>
							</header>
							<fieldset>							
								<div class="row">
									<section class="col col-4">
										<label for="dni" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.dni" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.dni}" /> </label>
									</section>
									<section class="col col-4">
										<label for="nombres" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.nombres" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.strNombresCompletos}" /> </label>
									</section>
									<section class="col col-4">
										<label for="usuario.usuario" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.email" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.usuario.usuario}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
											<label for="usuario.estado" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.estado" /> </label> 	
											<label style="font-weight: bold;" ><c:out value="${persona.usuario.strEstado}" /> </label>
									</section>
									<section class="col col-4">
										<label for="usuario.idTipoUsuario" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.tipoUser" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.usuario.strtipoUsuario}" /> </label>
									</section>
									<section class="col col-4">
										<label for="usuario.idTipoUsuario" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.clientes" /> </label>
										<label style="font-weight: bold;" ><c:out value="${persona.usuario.strNombreCliente}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
											<label for="usuario.estado" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.usucrea" /> </label> 	
											<label style="font-weight: bold;" ><c:out value="${persona.usuario.usuarioCreacion}" /> </label>
									</section>
									<section class="col col-4">
											<label for="usuario.estado" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.feccrea" /> </label> 	
											<label style="font-weight: bold;" ><c:out value="${persona.usuario.strfechaCreacion}" /> </label>
									</section>
									<section class="col col-4">
											<label for="usuario.estado" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.usumod" /> </label> 	
											<label style="font-weight: bold;" ><c:out value="${persona.usuario.usuariosModificacion}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
											<label for="usuario.estado" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.usumod" /> </label> 	
											<label style="font-weight: bold;" ><c:out value="${persona.usuario.strfechaModifica}" /> </label>
									</section>
								</div>
							</fieldset>
							<header>
								<h2>Asignación de Roles</h2>
							</header>
							<fieldset>
							<!-- NEW WIDGET START -->
							<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<!-- widget div-->
								<div>
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->

									</div>
									<!-- end widget edit box -->

									<!-- widget content -->
									<div class="widget-body">
										<div class="table-responsive">
										
											<table class="table table-bordered table-striped table-condensed table-hover smart-form has-tickbox">
												<thead>
													<tr>
														<th>Roles</th>
														<th>Descripción</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${persona.usuario.roles}" var="roles" >
														<tr>
															<td><c:out value="${roles.nombreRol}" /></td>
															<td><c:out value="${roles.descripcionRol}" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											
										</div>
									</div>
									<!-- end widget content -->

								</div>
								<!-- end widget div -->
						</article>
						</fieldset>	
					</form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
