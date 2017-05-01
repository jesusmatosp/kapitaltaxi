<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-male"></i> Lista de Usuarios Registrados </span>
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
		<ul id="sparks" class="">
				<li class="sparks-info"><a class="btn btn-default" href="<c:url value="/seguridad/usuarios/addusuario.do"  />">
									<i class="fa fa-file-o"></i> Nuevo</a></li>
			
				<li class="sparks-info"><a class="btn btn-default" href="#" id="btnDelUsers" name="btnDelUsers">
								<i class="fa fa-thumbs-down"></i>
										Inactivar</a></li>
			
				<li class="sparks-info"><button type="button" name="btnDelUsers" id="btnDelUsers" class="btn btn-default"><i class="fa fa-file-excel-o"></i>
					Exportar</button></li>	
		</ul>
	</div>
</div>
<!-- widget grid -->
<section id="widget-grid" class="well">

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
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.usuario" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.nombres" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.estado" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.tipoUsuario" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.usucrea" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.usuarios.table.col.feccrea" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.acc" /> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${usuarios}" var="usuario" varStatus="status" >
										<tr>
											<td><input type="checkbox" class="chkval" name="selectedItems" value="${usuario.idUsuario}" /></td>
											<td><c:out value="${status.index + 1}" /> </td>
											<td><c:out value="${usuario.usuario}" /> </td>
											<td><c:out value="${usuario.nombresPersona}" /> </td>
											<td><c:out value="${usuario.strEstado}" /> </td>
											<td><c:out value="${usuario.strtipoUsuario}" /> </td>
											<td><c:out value="${usuario.usuarioCreacion}" /> </td>
											<td><c:out value="${usuario.strfechaCreacion}" /> </td>
											
											<td class="val" data-val="${usuario.idUsuario}">
												<div>
													<a href="<%= request.getContextPath() %>/seguridad/usuarios/updateusuario/<c:url value="${usuario.idUsuario}" />"
														class='btn btn-xs btn-default'
														data-original-title='Edit Row'> <i class='fa fa-pencil'></i></a>
													<a href="<%= request.getContextPath() %>/seguridad/usuarios/usuario/<c:url value="${usuario.idUsuario}" />" id="view_usuario" name="${usuario.idUsuario}"
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
				
		