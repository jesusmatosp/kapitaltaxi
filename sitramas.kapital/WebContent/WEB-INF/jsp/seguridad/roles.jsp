<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-lock"></i> <spring:message code="kapital.sitramas.main.menu.seguridad" /> <span>> <spring:message code="kapital.sitramas.main.menu.roles" /> </span>
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-default"
				href="<c:url value="/seguridad/addrol"  />"><i
					class="fa fa-file-o"></i> Nuevo</a></li>
			<li class="sparks-info"><button type="button" name="btnDelRoles" id="btnDelRoles" class="btn btn-danger"><i class="fa fa-trash-o"></i>
					Eliminar</button></li>
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
						<h2><spring:message code="kapital.sitramas.seguridad.roles.table.title" /></h2>
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
						<form name="form-roles-table" action="<%= request.getContextPath() %>/seguridad/roles/delete" 
										  id="form-roles-table" method="post" role="form" >
							<table id="dt_basic"
								   class="table table-striped table-bordered table-hover has-tickbox"
								   width="100%">
								<thead>
									<tr>
										<th><input type="checkbox" id="selectAll" /></th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.nro" /></th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.nombre" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.descr" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.estado" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.usu" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.fec" /> </th>
										<th><spring:message code="kapital.sitramas.seguridad.roles.table.col.acc" /> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lroles}" var="rol" varStatus="status" >
										<tr>
											<td><input type="checkbox" class="chkval" name="selectedItems" value="${rol.id}" /></td>
											<td><c:out value="${status.index + 1}" /> </td>
											<td><c:out value="${rol.nombreRol }" /> </td>
											<td><c:out value="${rol.descripcionRol }" /> </td>
											<td><c:out value="${rol.estadoDescr }" /> </td>
											<td><c:out value="${rol.usuarioCreacion }" /> </td>
											<td><c:out value="${rol.strFechaCreacion }" /> </td>
											<td class="val" data-val="${rol.id}">
												<div>
													<a
														href="<%= request.getContextPath() %>/seguridad/role/update/<c:url value="${rol.id}" />"
														class='btn btn-xs btn-default'
														data-original-title='Edit Row'> <i class='fa fa-pencil'></i></a>
													<a href="#" id="delete_roles" name="${rol.id}"
														class='cancel1 btn btn-xs btn-default'
														data-original-title='Cancel'> <i class='fa fa-trash-o'></i></a>
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