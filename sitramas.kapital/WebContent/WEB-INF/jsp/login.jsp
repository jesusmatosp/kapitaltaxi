<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es_ES" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title><spring:message code="kapital.sitramas.titulo" /></title>
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/font-awesome.min.css" />" >

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-production.min.css" />" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-skins.min.css" />" >

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-rtl.min.css" />" > 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="<c:url value="/resources/img/favicon/favicon.png" />" type="image/x-icon">
		<link rel="icon" href="<c:url value="/resources/img/favicon/favicon.png" />" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="<c:url value="/resources/img/splash/sptouch-icon-iphone.png" />" >
		<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/img/splash/touch-icon-ipad.png" />" >
		<link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />" >
		<link rel="apple-touch-icon" sizes="152x152" href="<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />" >
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/ipad-landscape.png" />" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/ipad-portrait.png" />" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/iphone.png" />" media="screen and (max-device-width: 320px)">

	</head>
	
	<body class="animated fadeInDown">

		<header id="header">

			<div id="logo-group">
				<span id="logo"> <img src="<c:url value="/resources/img/Logotipo-kapital-taxi.png" />" alt="SmartAdmin"> </span>
			</div>

			<span id="extr-page-header-space"> <span class="hidden-mobile hidden-xs"><spring:message code="kapital.sitramas.login.subtitulo.cuenta" /></span> <a href="register.html" class="btn btn-danger"><spring:message code="kapital.sitramas.login.button.afiliacion" /></a> </span>

		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
						<h1 class="txt-color-red login-header-big"><spring:message code="kapital.sitramas.login.titulo" /></h1>
						<div class="hero">

							<div class="pull-left login-desc-box-l">
								<h4 class="paragraph-header"><spring:message code="kapital.sitramas.login.descripcion.sitramas" /> </h4>
								<div class="login-app-icons">
									<a href="http://www.kapitaltaxi.com" class="btn btn-danger btn-sm"><spring:message code="kapital.sitramas.login.button.visitenos" /></a>
									<a href="javascript:void(0);" class="btn btn-danger btn-sm"><spring:message code="kapital.sitramas.login.button.about" /></a>
								</div>
							</div>
							<img src="<c:url value="/resources/img/demo/iphoneview.png" />" class="pull-right display-image" alt="" style="width:210px">
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
						<div class="well no-padding">
							<form action="<c:url value='j_spring_security_check' />" id="login-form" class="smart-form client-form" method="post" >
								<header>
									<spring:message code="kapital.sitramas.login.titulo.iniciar.sesion" />
								</header>

								<fieldset>
									
									<section>
										<label class="label"><spring:message code="kapital.sitramas.login.label.user" /> </label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="email" name="username" >
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> <spring:message code="kapital.sitramas.login.tooltip.user" /> </b></label>
									</section>

									<section>
										<label class="label"><spring:message code="kapital.sitramas.login.label.password" /></label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="password">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> <spring:message code="kapital.sitramas.login.tooltip.password" /></b> </label>
										<div class="note">
											<a href="forgotpassword.html"><spring:message code="kapital.sitramas.login.label.forget" /> </a>
										</div>
									</section>
									
									<c:if test="${not empty error}">
										<section>
											<div class="alert alert-danger fade in">
												<button class="close" data-dismiss="alert">
													×
												</button>
												<i class="fa-fw fa fa-times"></i>
												<strong><spring:message code="kapital.sitramas.utilities.label.error" />!</strong> ${error}
											</div>
										</section>			
									</c:if>
									<c:if test="${not empty msg}">
										<section>
											<div class="alert alert-info fade in">
												<button class="close" data-dismiss="alert">×</button>
												<i class="fa-fw fa fa-info"></i> <strong><spring:message code="kapital.sitramas.utilities.label.info" /> !</strong> ${msg}
											</div>
										</section>
									</c:if>
								
									<section>
										<label class="checkbox">
											<input type="checkbox" name="remember" checked="">
											<i></i><spring:message code="kapital.sitramas.login.label.staysign" /> </label>
									</section>
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">
										<spring:message code="kapital.sitramas.login.titulo.iniciar.sesion" />
									</button>
								</footer>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
							</form>

						</div>
						
						<h5 class="text-center"><spring:message code="kapital.sitramas.login.label.other.sign" /> </h5>
															
							<ul class="list-inline text-center">
								<li>
									<a href="javascript:void(0);" class="btn btn-primary btn-circle"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="javascript:void(0);" class="btn btn-info btn-circle"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="javascript:void(0);" class="btn btn-warning btn-circle"><i class="fa fa-linkedin"></i></a>
								</li>
							</ul>
						
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	    <script src="<c:url value="/resources/jquery/jquery.min.js" />"></script>
		<script> if (!window.jQuery) { document.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');} </script>

	    <!--<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script> if (!window.jQuery.ui) { document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>-->

		<!-- IMPORTANT: APP CONFIG -->
		<script src="<c:url value="/resources/js/app.config.seed.js" />"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>
		
		<!--[if IE 8]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="<c:url value="/resources/js/app.seed.js" />"></script>

	</body>
</html>