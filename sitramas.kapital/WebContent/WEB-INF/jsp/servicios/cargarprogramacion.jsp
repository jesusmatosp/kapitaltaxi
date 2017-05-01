<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- widget grid -->
<section id="widget-grid" class="">
<!-- START ROW -->

<c:if test="${not empty error}">
	<div class="alert alert-block alert-danger">
		<a class="close" data-dismiss="alert" href="#">×</a>
		<h4 class="alert-heading"><i class="fa fa-check"></i> Error!</h4>
		<p>
			${error}
		</p>
	</div>
</c:if>
	<div class="row">
		<article class="col-sm-12">
			<div class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Menú</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">
						<c:if test="${programacion.flgBorrador == true}">
							<li><a href="#" data-toggle="modal" data-target="#uploadPrograModal"><i
								class="fa fa-upload"></i> Carga Masiva</a></li>
						</c:if>
						<li><a href="#" class="monitorKT" data-toggle="modal" data-target="#monitoreoCargaModal"><i
								class="fa fa-tachometer"></i> Monitorear Carga</a></li>
						<c:if test="${programacion.flgBorrador == true}">
							<li><a href="javascript:void(0);"> <i
									class="fa fa-calendar"></i> Incluir Programacion</a></li>
							<li><a href="javascript:void(0);" id="btnEnviarProgramacion"> <i
									class="fa fa-send"></i> Enviar Programacion</a></li>
						</c:if>	
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<div class="input-group">
												<input type="text" class="form-control datepicker" data-dateformat="dd/mm/yy" data-mask="99/99/9999" data-mask-placeholder= "-" value="${persona.strfechaNacimiento}" name="strfechaNacimiento" id="strfechaNacimiento">
														<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
							</div>
						</div>
						<button class="btn btn-primary" type="submit">Buscar</button>
					</form>
				</div>
			</div>
		</article>
	</div>
	<!-- col -->
	<div class="row">
		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
			<h1 class="page-title txt-color-blueDark">
				<!-- PAGE HEADER -->
				<i class="fa-fw fa fa-calendar"></i>  Detalle de Programación
			</h1>
		</div>
		<div class="col-xs-12 col-sm-5 col-md-5 col-lg-7">
			<ul id="sparks" class="">
				<li class="sparks-info"><a class="btn btn-primary"
					href="javascript:history.back();"><i
						class="fa fa-arrow-left"></i> Volver</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<article class="col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget" id="wid-id-1" data-widget-editbutton="false" data-widget-custombutton="false" data-widget-icon="fa-edit"
													data-widget-colorbutton="false"	data-widget-fullscreenbutton="false" data-widget-deletebutton="false">
				<header>
					<h2>Programación de Servicios</h2>				
				</header>
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding" >
						<form method="POST" id="upload-form01" name="upload-form01" class="smart-form">
							<fieldset>
								<div class="row">
									<section class="col col-3">
										<label class="label">Fecha de Programación: </label>
										<label class="input"><input type="text" value="${programacion.strFechaProgramacion}" disabled /></label>
									</section>
									<section class="col col-3">
										<label class="label">Cliente: </label>
										<label class="input"><input type="text"  value="${programacion.strCliente}"  disabled /></label>
									</section>
									<section class="col col-3">
										<label class="label">Versión: </label>
										<label class="input"><input type="text" value="${programacion.version}" disabled /></label>
									</section>
									<section class="col col-3">
										<label class="label">Estado: </label>
										<label class="input"><input value="${programacion.strEstadoProgramacion}" type="text" disabled /></label>
									</section>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</article>
	</div>
	<div class="row" >
		<!-- row -->
		<!-- NEW WIDGET START -->
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-editbutton="false" data-widget-colorbutton="false"
								data-widget-icon="fa-edit" data-widget-colorbutton="false"	
								data-widget-fullscreenbutton="false" data-widget-deletebutton="false">
				<header>
					<h2><spring:message code="kapital.sitramas.seguridad.usuarios.form.subtitulo1" /></h2>
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
					
					<form method="POST" id="list-pasajeros-form" name="list-pasajeros-form">
						<table id="dt_basic"
								   class="table table-striped table-bordered table-hover has-tickbox"
								   width="100%">
								<thead>
									<tr>
										<th><input type="checkbox" id="selectAll" /></th>
										<th style="width: 40px;"><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.nro" /></th>
										<th style="width: 80px;">DNI</th>
										<th style="width: 200px;">Apellidos y Nombres</th>
										<th style="width: 80px;">Campaña</th>
										<th style="width: 80px;">Departamento</th>
										<th style="width: 230px;">Dirección</th>
										<th style="width: 80px;">Distrito</th>
										<th style="width: 80px;">Hra. Prog</th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.acc" /> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pasajeros}" var="pasajeros" varStatus="status" >
										<tr>
											<td><input type="checkbox" class="chkval" name="selectedItems" value="${pasajeros.id}" /></td>
											<td><c:out value="${status.index + 1}" /> </td>
											<td><c:out value="${pasajeros.dni}" /> </td>
											<td><c:out value="${pasajeros.nombres}" /> </td>
											<td><c:out value="${pasajeros.campania}" /> </td>
											<td><c:out value="${pasajeros.departamento}" /> </td>
											<td><c:out value="${pasajeros.direccion}" /> </td>
											<td><c:out value="${pasajeros.distrito}" /> </td>
											<td><c:out value="${pasajeros.horaProgramada}" /> </td>
											<td>
												<a href="${pageContext.request.contextPath}/servicios/detalleProgramacion/${pasajeros.id}"
												   class='btn btn-xs btn-default'> <i class='fa fa-search'></i></a>
												<c:if test="${programacion.flgBorrador == true}">
													<a href="#" name="${pasajeros.id}"
												   		class='btn btn-xs btn-default deleteCarga'> <i class='fa fa-trash-o'></i></a>
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>   
							</table>
						</form>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>
<!-- Dialog - Monitoreo de Carga -->
<div class="modal fade" id="monitoreoCargaModal" tabindex="-1" role="dialog" aria-labelledby="monitoreoCargaModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="monitoreoCargaModalLabel"><i
								class="fa fa-tachometer"></i> Monitoreo de Carga Masiva</h4>
			</div>
			<div class="modal-body">
				<form id="" action="#" name="monitoreo-carga-form" method="post" >
					<table id="dt_carga"
								   class="table table-striped table-bordered table-hover has-tickbox"
								   width="100%">
						<thead>
							<tr>
								<th>N°</th>
								<th>Fecha Carga</th>
								<th>Fecha Procesamiento</th>
								<th>Estado de Procesamiento</th>
							</tr>
						</thead>
					</table>
					<div class="modal-footer">
						<button id="btnRefreshMonitor" type="button" class="btn btn-primary" >
							<i class="fa fa-refresh"></i> Actualizar</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Cerrar</button>
					</div>
				</form>
		</div>
		<!-- /.modal-content -->
	</div>
	</div>
</div>

<!-- Dialog - Programación de Servicios -->
<div class="modal fade" id="uploadPrograModal" tabindex="-1" role="dialog" aria-labelledby="uploadProgModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="uploadProgModalLabel"><i
								class="fa fa-upload"></i> Carga Masiva de Programación</h4>
			</div>
			<div class="modal-body">
				<form id="upload-programacion-form" action="${pageContext.request.contextPath}/servicios/upload" name="upload-programacion-form" method="post" enctype="multipart/form-data" >
				<input type="hidden" value="${programacion.idProgramacion}" name="idProgramacion" id="idProgramacion" />
				<input type="hidden" value="${programacion.strFechaProgramacion}" name="strFechaProgramacion" /> 
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<div class="alert alert-info alert-block">
								<h4 class="alert-heading">Información: </h4>
								A continuación debe adjuntar su archivo de carga, <b>recuerde que la información debe encontrarse 
								correctamente ingresada</b>, el formato permitido es CSV (.csv).
							</div>
							<label>Archivo: </label>
							<div class="form-control">
								<input type="file" id="file" name="file" required>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button id="btnGuardarProg" type="button" class="btn btn-primary"><i class="fa fa-save" ></i> Guardar
				</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">
					Cancelar</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

