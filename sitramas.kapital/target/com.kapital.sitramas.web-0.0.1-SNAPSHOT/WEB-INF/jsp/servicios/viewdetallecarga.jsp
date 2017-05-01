<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- col -->
<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-5">
		<h1 class="page-title txt-color-blueDark">
			<!-- PAGE HEADER --> 
			<i class="fa-fw fa fa-male"></i> Detalle de Programación del Pasajero </span>
		</h1>
	</div>
	<div class="col-xs-12 col-sm-5 col-md-5 col-lg-7">
		<ul id="sparks" class="">
			<li class="sparks-info"><a class="btn btn-primary"
				href="javascript:history.back();" ><i
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
					<h2>Detalle de la Programación </h2>				
				</header>
				<!-- widget div-->
				<div>
					<!-- widget content -->
					<div class="widget-body no-padding">
						<form method="POST" id="persona-form" name="pasajero-form" class="smart-form">
							<input type="hidden" value="${pasajero.id}" id="frmPersonaId" name="id" />
							<header>
								<h1>Datos del Pasajero</h1>
							</header>
							<fieldset>
								<div class="row">
									<section class="col col-3">
										<label for="dni" class="label">DNI </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.dni}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Nombres y Apellidos </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.nombres}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Dirección </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.direccion}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Referencia </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.referencia}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-3">
										<label for="dni" class="label">Distrito: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.distrito}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Cobertura: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.cobertura}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Departamento: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.departamento}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Campaña </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.campania}" /> </label>
									</section>
								</div>
								<div class="row">
									<section class="col col-3">
										<label for="dni" class="label">Responsable: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.responsable}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Entrada/Salida: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.codEntradaSalida}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Hora Programada: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.horaProgramada}" /> </label>
									</section>
									<section class="col col-3">
										<label for="nombres" class="label">Sede: </label>
										<label style="font-weight: bold;" ><c:out value="${pasajero.sede}" /> </label>
									</section>
								</div>
							</fieldset>
						
					</form>
					</div>
				</div>
				
				<div id="map"></div>
				<script>
					function initMap(){
						var uluru = {lat: -25.363, lng: 131.044};
						var map = new google.maps.Map(document.getElementById("map"), {
							zoom: 4,
					        center: uluru
						});
						var marker = new google.maps.Marker({
					          position: uluru,
					          map: map
					    });
					}
				</script>
			</div>
		</article>
	</div>
</section>
