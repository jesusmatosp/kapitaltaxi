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
						<li><a href="#" data-toggle="modal" data-target="#myModal"><i
								class="fa fa-file"></i> Nuevo</a></li>
						<li><a href="javascript:void(0);"> <i
								class="fa fa-calendar"></i> Hoy</a></li>
						<li><a href="javascript:void(0);"> <i
								class="fa fa-file-excel-o"></i> Exportar</a></li>
								
								
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
				<i class="fa-fw fa fa-calendar"></i>  Bandeja de Programación
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
	
	<div class="row" >
		<!-- row -->
		<!-- NEW WIDGET START -->
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-editbutton="false" data-widget-colorbutton="false">
				<header>
					<span class="widget-icon"> <i class="fa fa-table"></i></span>
						<h2><spring:message code="kapital.sitramas.seguridad.usuarios.form.subtitulo1" /></h2>
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
					
					<form method="POST" id="list-usuarios-form" name="list-usuarios-form">
						<input type="hidden" id="comentarios" name="comentarios" />
						<table id="dt_basic"
								   class="table table-striped table-bordered table-hover has-tickbox"
								   width="100%">
								<thead>
									<tr>
										<th><input type="checkbox" id="selectAll" /></th>
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.nro" /></th>
										<th style="width: 323px;">Cliente</th>
										<th style="width: 157px;">Fec. Programación</th>
										<th style="width: 80px;">Versión</th>
										<th style="width: 157px;" >Estado</th>
										<th style="width: 157px;" >Archivo</th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.acc" /> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${programaciones}" var="programacion" varStatus="status" >
										<tr>
											<td><input type="checkbox" class="chkval" name="selectedItems" value="${programacion.idProgramacion}" /></td>
											<td><c:out value="${status.index + 1}" /> </td>
											<td><c:out value="${programacion.strCliente}" /> </td>
											<td><c:out value="${programacion.strFechaProgramacion}" /> </td>
											<td><c:out value="${programacion.version}" /> </td>
											<td><c:out value="${programacion.strEstadoProgramacion}" /> </td>
											<td><a href="<c:url  value='/servicios/download/${programacion.idProgramacion}' />"><c:out value="${programacion.rutaArchivo}" /> </a></td>
											<td class="val" data-val="${programacion.idProgramacion}">
												<div>
													<a href="<%= request.getContextPath() %>/servicios/addprogramacion/<c:url value="${programacion.idProgramacion}" />"
														class='btn btn-xs btn-default'
														data-original-title='Edit Row'> <i class='fa fa-upload'></i></a>
													<a href="<%= request.getContextPath() %>/seguridad/usuarios/usuario/<c:url value="${programacion.idProgramacion}" />" id="view_usuario" name="${programacion.idProgramacion}"
														class='btn btn-xs btn-default'
														data-original-title='Cancel'> <i class='fa fa-send'></i></a>
													<a href="<%= request.getContextPath() %>/seguridad/usuarios/usuario/<c:url value="${programacion.idProgramacion}" />" id="view_usuario" name="${programacion.idProgramacion}"
														class='btn btn-xs btn-default'
														data-original-title='Cancel'> <i class='fa fa-search'></i></a>
												</div>
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