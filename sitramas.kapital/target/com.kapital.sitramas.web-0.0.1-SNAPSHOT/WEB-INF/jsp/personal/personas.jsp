<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-male"></i> Lista de Personas Registradas </span>
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-default"
				href="<c:url value="/personal/addpersona.do"  />"><i
					class="fa fa-file-o"></i> Nuevo</a></li>
			<li class="sparks-info"><a class="btn btn-default" href="#" id="btnDelPersonas" name="btnDelUsers">
								<i class="fa fa-thumbs-down"></i>
										Inactivar</a></li>
			<li class="sparks-info"><button type="button" name="btnDelUsers" id="btnDelUsers" class="btn btn-default"><i class="fa fa-file-excel-o"></i>
					Exportar</button></li>		
					
		</ul>
	</div>
</div>
<!-- widget grid -->
<section id="widget-grid" class="well">
	<!-- row -->
	<div class="row">
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
					<form method="POST" id="list-personas-form" name="list-personas-form">
						<input type="hidden" id="comentarios" name="comentarios" />
						<table id="dt_basic"
								   class="table table-striped table-bordered table-hover has-tickbox"
								   width="100%">
								<thead>
									<tr>
										<th><input type="checkbox" id="selectAll" /></th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.nro" /></th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.dni" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.nombres" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.sexo" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.estadociv" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.direccion" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.estado" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.usucrea" /> </th>
										<th><spring:message code="kapital.sitramas.personal.personas.table.col.feccrea" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.acc" /> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${personas}" var="persona" varStatus="status" >
										<tr>
											<td><input type="checkbox" class="chkval" name="selectedItems" value="${persona.id}" /></td>
											<td><c:out value="${status.index + 1}" /> </td>
											<td><c:out value="${persona.dni}" /> </td>
											<td><c:out value="${persona.strNombresCompletos}" /> </td>
											<td><c:out value="${persona.strSexo}" /> </td>
											<td><c:out value="${persona.strEstadoCivil}" /> </td>
											<td><c:out value="${persona.direccion}" /> </td>
											<td><c:out value="${persona.strEstado}" /> </td>
											<td><c:out value="${persona.usuarioCreacion}" /> </td>
											<td><c:out value="${persona.strFechaCreacion}" /> </td>
											<td class="val" data-val="${persona.id}">
												<div>
													<a
														href="<%= request.getContextPath() %>/personal/updatepersona/<c:url value="${persona.id}" />"
														class='btn btn-xs btn-default'
														data-original-title='Edit Row'> <i class='fa fa-pencil'></i></a>
													<a href="<%= request.getContextPath() %>/personal/persona/<c:url value="${persona.id}" />" id="view_usuario" name="${persona.id}"
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