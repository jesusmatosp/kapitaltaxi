<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER -->
			<i class="fa-fw fa fa-lock"></i> <spring:message code="kapital.sitramas.main.menu.seguridad" /> <span>> <spring:message code="kapital.sitramas.main.menu.roles" /> > ${title} </span>
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
					<h2>Administración de Roles</h2>				
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
						<form action="<%= request.getContextPath() %>/seguridad/roles/save" method="POST" id="roles-form" name="roles-form" class="smart-form">
							<input type="hidden" id="hdRoleId" name="hdRoleId" value="${oRole.id}" > 
							<header>
								<c:out value="${title}" /> Rol
							</header>
							<fieldset>
								<div class="row">
									<section class="col col-4">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.roles.form.label.nombre" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-lock"></i>
											<input type="text" value="${oRole.nombreRol}" name="txtnamerol" id="txtnamerol" placeholder='<spring:message code="kapital.sitramas.seguridad.roles.form.placeholder.nombre" />' >
										</label>
									</section>
									<section class="col col-8">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.roles.form.label.descr" /> </label>
										<label class="input"> <i class="icon-prepend fa fa-lock"></i>
												<input type="text" value="${oRole.descripcionRol}" name="txtdescrol" id="txtdescrol" placeholder="Agregar Descripción">
										</label>
									</section>
								</div>
								<div class="row">
									<section class="col col-4">
										<label class="label"><spring:message code="kapital.sitramas.seguridad.roles.form.label.estado" /> </label> <label class="select"> 
										<select name="stateLst" id="stateLst">
											<c:forEach items="${stateList}" var="option">												
												<option value="${option.value}" <c:out value="${oRole.estado==option.value ? 'selected=selected' : ''}" /> >${option}</option>
											</c:forEach>
										</select> <i></i>
									</label>
									</section>
								</div>
							</fieldset>
							<header>
								Privilegios
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
														<th>Privilegio</th>
														<th>Descripción</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${lprivilegios}" var="privilegios" >
														<tr>
															<td>
																<input type="checkbox" class="chkval" name="selectedItems" value="${privilegios.id}" <c:out value="${privilegios.activa==true ? 'checked=checked' : ''}" /> />		
															</td>
															<td><c:out value="${privilegios.nombrePrivilegio}" /></td>
															<td><c:out value="${privilegios.descripcionPrivilegio}" /></td>
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
								<button id="btnGuardarRol" type="button" class="btn btn-primary"><spring:message code="kapital.sitramas.tools.form.button.save" /></button>
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