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
			<li><a class="btn btn-default" href="<c:url value="/personal/addpersona.do"  />"><i class="fa fa-pencil-square-o fa-lg"></i> Añadir Persona</a></li>
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
						<form method="POST" id="usuario-form" name="usuario-form" class="smart-form">
							<input type="hidden" value="${persona.id}" id="personaId" name="id" />
							<input type="hidden" value="${persona.usuario.idUsuario}" id="usuarioId" name="usuario.idUsuario" /> 
							<header>
								<h1><spring:message code="kapital.sitramas.seguridad.usuarios.form.subtitulo1" /></h1>
							</header>
							<fieldset>							
								<div class="row">
									<section class="col col-4">
										<label for="dni" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.dni" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-edit"></i>
												<input type="text" onKeyPress="return soloNumeros(event)" maxlength="10" value="${persona.dni}" name="dni" id="dniUser" placeholder="Agregue Documento de Identidad" required />
										</label>	
									</section>
									<section class="col col-8">
										<label for="nombres" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.nombres" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-user"></i>
												<input type="text" value="${persona.nombres}" maxlength="80" name="nombres" id="nombresUser" placeholder="Agregue Nombres Completos" disabled />
										</label>
									</section>
								</div>
							</fieldset>
							<header>
								<h2><spring:message code="kapital.sitramas.seguridad.usuarios.form.subtitulo" /></h2>
							</header>
							<fieldset>
								<div class="row">
									<section class="col col-4">
										<label for="usuario.usuario" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.email" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-envelope-o"></i>
											<input type="email" value="${persona.usuario.usuario}" maxlength="80" name="usuario.usuario" id="usuario" placeholder="Agregue Correo Electrónico" required="" />
										</label>
									</section>
									<section class="col col-4">
										<label for="usuario.strpassword" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.password" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-lock"></i>
											<input type="password" value="${persona.usuario.strpassword}" maxlength="20" name="usuario.strpassword" id="strpassword" placeholder="Agregue Password" required="" data-parsley-equalto="#txtpassword2" >
										</label>
									</section>
									<section class="col col-4">
										<label for="txtpassword2" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.password2"  /> </label>
										<label class="input"> <i class="icon-prepend fa fa-lock"></i>
											<input type="password"  value="${persona.usuario.strpassword}" name="txtpassword2" maxlength="20" id="txtpassword2" placeholder="Confirme su Password" required="" data-parsley-equalto="#strpassword" />
										</label>
									</section>
								</div>	
								<div class="row">
									<section class="col col-4">
											<label for="usuario.estado" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.estado" /> </label> <label class="select"> 
											<select value="${persona.usuario.estado}" name="usuario.estado" id="usuario.estado" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${stateList}" var="option">												
													<option value="${option.value}" <c:out value="${persona.usuario.estado==option.value ? 'selected=selected' : ''}" /> >${option}</option>
												</c:forEach>
										</select> <i></i>
										</label>
									</section>
									<section class="col col-4">
											<label for="usuario.idTipoUsuario" class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.tipoUser" /> </label> <label class="select"> 
											<select value="${persona.usuario.idTipoUsuario}" name="usuario.idTipoUsuario" id="idTipoUsuario" required="">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${tipoUsuario}" var="option">												
													<option value="${option.id}" <c:out value="${persona.usuario.idTipoUsuario==option.id ? 'selected=selected' : ''}" /> >${option.valorParametro}</option>
													
													
												</c:forEach>
										</select> <i></i>
										</label>
									</section>
									<input type="hidden" id="frmClienteId" name="frmClienteId" value="${persona.usuario.idCliente}" />
									<section id="secCliente" class="col col-4" style="display: none;">
											<label class="label"><spring:message code="kapital.sitramas.seguridad.usuarios.form.label.clientes" /> </label> <label class="select"> 
											<select value="${persona.usuario.idCliente}" name="usuario.idCliente" id="forUserIdCliente">
												<option value="">-- Seleccione --</option>
												<c:forEach items="${clientes}" var="cliente">												
													<option value="${cliente.id}" <c:out value="${persona.usuario.idCliente==option.id ? 'selected=selected' : ''}" /> >${cliente.nombreCliente}</option>
												</c:forEach>
										</select> <i></i>
										</label>
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
														<th><input type="checkbox" id="selectAll" /></th>
														<th>Roles</th>
														<th>Descripción</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${roles}" var="roles" >
														<tr>
															<td>
																<input type="checkbox" class="chkval" name="selectedItems" value="${roles.id}" <c:out value="${roles.activa==true ? 'checked=checked' : ''}" /> />
																		
															</td>
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
						<footer>
							<button id="btnGuardarUsuario" type="button" class="btn btn-primary"><spring:message code="kapital.sitramas.tools.form.button.save" /></button>
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
