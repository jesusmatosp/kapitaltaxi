<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es_ES" >
	<head>
		<title> <spring:message code="kapital.sitramas.titulo" /> </title>
		<meta name="description" content="">
		<meta name="author" content="">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/bootstrap.min.css" />">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/font-awesome.min.css" />">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-production-plugins.min.css" />" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-production.min.css" />" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-skins.min.css" />" >

		<!-- Messenger Notification -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/hubspot/css/messenger-theme-flat.css" />" >
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/hubspot/css/messenger.css" />" >

		<!-- PARSLEY -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/parsleyjs/parsley.css" />" >

		<!-- SmartAdmin RTL Support  -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/smartadmin-rtl.min.css" />" >
		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.  -->
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/your_style.css" />">

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="<c:url value="/resources/img/favicon/favicon.png" />" type="image/x-icon">
		<link rel="icon" href="<c:url value="/resources/img/favicon/favicon.png" />" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="<c:url value="/resources/img/splash/sptouch-icon-iphone.png" />" >
		<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/img/splash/touch-icon-ipad.png" />">
		<link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/img/splash/touch-icon-iphone-retina.png" />">
		<link rel="apple-touch-icon" sizes="152x152" href="<c:url value="/resources/img/splash/touch-icon-ipad-retina.png" />">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/ipad-landscape.png" />" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/ipad-portrait.png" />" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="<c:url value="/resources/img/splash/iphone.png" />" media="screen and (max-device-width: 320px)">

		<style>
	  		.datepicker{z-index:1151 !important;}
	  		#map{
	  			height: 400px;
	  			width: 100%;
	  		}
		</style>

	</head>

	<!--

	TABLE OF CONTENTS.
	
	Use search to find needed section.
	
	===================================================================
	
	|  01. #CSS Links                |  all CSS links and file paths  |
	|  02. #FAVICONS                 |  Favicon links and file paths  |
	|  03. #GOOGLE FONT              |  Google font link              |
	|  04. #APP SCREEN / ICONS       |  app icons, screen backdrops   |
	|  05. #BODY                     |  body tag                      |
	|  06. #HEADER                   |  header tag                    |
	|  07. #PROJECTS                 |  project lists                 |
	|  08. #TOGGLE LAYOUT BUTTONS    |  layout buttons and actions    |
	|  09. #MOBILE                   |  mobile view dropdown          |
	|  10. #SEARCH                   |  search field                  |
	|  11. #NAVIGATION               |  left panel & navigation       |
	|  12. #MAIN PANEL               |  main panel                    |
	|  13. #MAIN CONTENT             |  content holder                |
	|  14. #PAGE FOOTER              |  page footer                   |
	|  15. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  16. #PLUGINS                  |  all scripts and plugins       |
	
	===================================================================
	
	-->
	
	<!-- #BODY -->
	<!-- Possible Classes

		* 'smart-style-{SKIN#}'
		* 'smart-rtl'         - Switch theme mode to RTL
		* 'menu-on-top'       - Switch to top navigation (no DOM change required)
		* 'no-menu'			  - Hides the menu completely
		* 'hidden-menu'       - Hides the main menu but still accessable by hovering over left edge
		* 'fixed-header'      - Fixes the header
		* 'fixed-navigation'  - Fixes the main menu
		* 'fixed-ribbon'      - Fixes breadcrumb
		* 'fixed-page-footer' - Fixes footer
		* 'container'         - boxed layout mode (non-responsive: will not work with fixed-navigation & fixed-ribbon)
	-->
	<body class="desktop-detected pace-done fixed-header">

		<!-- #HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="<c:url value="/resources/img/Logotipo-kapital-taxi.png" />" alt="KapitalTaxi"> </span>
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
					 Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
				<span id="activity" class="activity-dropdown"> <i class="fa fa-user"></i> <b class="badge"> 21 </b> </span>

				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">

					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					<div class="btn-group btn-group-justified" data-toggle="buttons">
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/mail.html">
							Msgs (14) </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/notifications.html">
							notify (3) </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/tasks.html">
							Tasks (4) </label>
					</div>

					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">

						<div class="alert alert-transparent">
							<h4>Click a button to show messages here</h4>
							This blank page message helps protect your privacy, or you can show the first message here automatically.
						</div>

						<i class="fa fa-lock fa-4x fa-border"></i>

					</div>
					<!-- end notification content -->

					<!-- footer: refresh area -->
					<span> Last updated on: 12/12/2013 9:43AM
						<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..." class="btn btn-xs btn-default pull-right">
							<i class="fa fa-refresh"></i>
						</button> </span>
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>

			<!-- #PROJECTS: projects dropdown -->
			<div class="project-context hidden-xs">

				<span class="label"><spring:message code="kapital.sitramas.main.header.menu.servicios" />  </span>
				<span class="project-selector dropdown-toggle" data-toggle="dropdown"><spring:message code="kapital.sitramas.main.header.submenu.servicios" /> <i class="fa fa-angle-down"></i></span>

				<!-- Suggestion: populate this list with fetch and push technique -->
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);">Online e-merchant management system - attaching integration with the iOS</a>
					</li>
					<li>
						<a href="javascript:void(0);">Notes on pipeline upgradee</a>
					</li>
					<li>
						<a href="javascript:void(0);">Assesment Report for merchant account</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="javascript:void(0);"><i class="fa fa-power-off"></i> Clear</a>
					</li>
				</ul>
				<!-- end dropdown-menu-->

			</div>
			<!-- end projects dropdown -->
			
			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">
				
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end collapse menu -->
				
				<!-- #MOBILE -->
				<!-- Top menu profile link : this shows only when top menu is active -->
				<ul id="mobile-profile-img" class="header-dropdown-list hidden-xs padding-5">
					<li class="">
						<a href="#" class="dropdown-toggle no-margin userdropdown" data-toggle="dropdown"> 
							<img src="<c:url value="/resources/img/avatars/sunny.png" />" alt="John Doe" class="online" />  
						</a>
						<ul class="dropdown-menu pull-right">
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0"><i class="fa fa-cog"></i> Setting</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#ajax/profile.html" class="padding-10 padding-top-0 padding-bottom-0"> <i class="fa fa-user"></i> <u>P</u>rofile</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="toggleShortcut"><i class="fa fa-arrow-down"></i> <u>S</u>hortcut</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="launchFullscreen"><i class="fa fa-arrows-alt"></i> Full <u>S</u>creen</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="login.html" class="padding-10 padding-top-5 padding-bottom-5" data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i> <strong><u>L</u>ogout</strong></a>
							</li>
						</ul>
					</li>
				</ul>
				
				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
						<span> <a href="<c:url value="/logout" />" title="Sign Out" data-action="userLogout" data-logout-msg="You can improve your security further after logging out by closing this opened browser"><i class="fa fa-sign-out"></i></a> </span> 
				</div>
				<!-- end logout button -->

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->
				
				<!-- #SEARCH -->
				<!-- input: search field -->
				<form action="#ajax/search.html" class="header-search pull-right">
					<input id="search-fld" type="text" name="param" placeholder="Find reports and more">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
					<a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a>
				</form>
				<!-- end input: search field -->

				<!-- fullscreen button -->
				<div id="fullscreen" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0);" data-action="launchFullscreen" title="Full Screen"><i class="fa fa-arrows-alt"></i></a> </span>
				</div>
				<!-- end fullscreen button -->

				<!-- multiple lang dropdown : find all flags in the flags page -->
				<ul class="header-dropdown-list hidden-xs">
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-us" alt="United States"> <span> US</span> <i class="fa fa-angle-down"></i> </a>
						<ul class="dropdown-menu pull-right">
							<li class="active">
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-us" alt="United States"> English (US)</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-fr" alt="France"> Français</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-es" alt="Spanish"> Español</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-de" alt="German"> Deutsch</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-jp" alt="Japan"> 日本語</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-cn" alt="China"> 中文</a>
							</li>	
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-it" alt="Italy"> Italiano</a>
							</li>	
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-pt" alt="Portugal"> Portugal</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-ru" alt="Russia"> Русский язык</a>
							</li>
							<li>
								<a href="javascript:void(0);"><img src="<c:url value="/resources/img/blank.gif" />" class="flag flag-kr" alt="Korea"> 한국어</a>
							</li>						
							
						</ul>
					</li>
				</ul>
				<!-- end multiple lang -->

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->
		<aside id="left-panel">

			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as is --> 
					
					<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
						<img src="<c:url value="/resources/img/avatars/sunny.png" />" alt="me" class="online" /> 
						<span> ${sessionScope.sUser} </span>
						<i class="fa fa-angle-down"></i>
					</a> 
					
				</span>
			</div>
			<!-- end user info -->

			<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
			<nav>
				<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

				<ul>
					<li class="active">
						<a href="<%= request.getContextPath() %>/index" title="blank_"><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.home" /></span></a>
					</li>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVISOR', 'ROLE_PROGRAMADOR', 'ROLE_COORDINADOR_CLIENTE')">
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-inbox"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.servicios" /> </span></a>
						<ul>
							<li><a href="<c:url value="/servicios/programacion.do"  />" > Cargar Programación </a></li>
							<li><a href="#" > Historial Servicios </a></li>
							<li><a href="#" > Bandeja de Servicios </a></li>
						</ul>
					</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVISOR', 'ROLE_PROGRAMADOR')">
					<li>
						<a href="widgets.html"><i class="fa fa-lg fa-fw fa-cab"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.unidades" /></span></a>
					</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVISOR', 'ROLE_PROGRAMADOR')">
					<li>
						<a href="widgets.html"><i class="fa fa-lg fa-fw fa-group"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.conductores" /></span></a>
					</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVISOR', 'ROLE_PROGRAMADOR')">
					<li>
						<a href="widgets.html"><i class="fa fa-lg fa-fw fa-code-fork"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.zonificacion" /></span></a>
					</li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVISOR', 'ROLE_PROGRAMADOR')">
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-male"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.personal" /></span></a>
						<ul>
							<li><a href="<c:url value="/personal/personas.do"  />" ><spring:message code="kapital.sitramas.main.manu.personal.personal" /> </a></li>
						</ul>
					</li>
					</sec:authorize>
					
					<li>
						<a href="#"><i class="fa fa-lg fa-fw fa-lock"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.seguridad" /></span></a>
						<ul>
							<li><a href="<c:url value="/seguridad/cuenta.do"  />" ><spring:message code="kapital.sitramas.main.manu.change.password" /> </a></li>
							<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERVISOR', 'ROLE_PROGRAMADOR')">
							<li><a href="<c:url value="/seguridad/privilegios.do"  />"><spring:message code="kapital.sitramas.main.menu.privilegios" /> </a></li>
							<li><a href="<c:url value="/seguridad/roles.do" />"><spring:message code="kapital.sitramas.main.menu.roles" /> </a></li>
							<li><a href="<c:url value="/seguridad/usuarios.do" />"><spring:message code="kapital.sitramas.main.menu.users" /> </a></li>
							</sec:authorize>
						</ul>
					</li>
					<li>
						<a href="widgets.html"><i class="fa fa-lg fa-fw fa-cog"></i> <span class="menu-item-parent"><spring:message code="kapital.sitramas.main.menu.configuracion" /></span></a>
					</li>
				</ul>
			</nav>

			<span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->
		
		<!-- #MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">
				<span class="ribbon-button-alignment"> <span id="refresh"
					class="btn btn-ribbon" data-action="resetWidgets"
					data-title="refresh" rel="tooltip" data-placement="bottom"
					data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings."
					data-html="true"> <i class="fa fa-refresh"></i>
				</span>
				</span>
				<!-- breadcrumb -->
				<tiles:insertAttribute name="breadcrumb" />
				<!-- end breadcrumb -->

				<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right" style="margin-right:25px">
					<a href="#" id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa fa-grid"></i> Change Grid</a>
					<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa fa-plus"></i> Add</span>
					<button id="search" class="btn btn-ribbon" data-title="search"><i class="fa fa-search"></i> <span class="hidden-mobile">Search</span></button>
				</span> -->

			</div>
			<!-- END RIBBON -->

			<!-- #MAIN CONTENT -->
			<div id="content">
				<tiles:insertAttribute name="body" />
			</div>	
			<!-- end row -->
			<div class="bg_load"></div>
			<div class="wrapper">
			    <div class="inner">
			        <span>L</span>
			        <span>o</span>
			        <span>a</span>
			        <span>d</span>
			        <span>i</span>
			        <span>n</span>
			        <span>g</span>
			    </div>
			</div>
			<!-- END #MAIN CONTENT -->

		</div>
		<!-- END #MAIN PANEL -->

		<!-- #PAGE FOOTER -->
		<div class="page-footer">
			<div class="row">
				<div class="col-xs-12 col-sm-6">
					<span class="txt-color-white"><spring:message code="kapital.sitramas.label.footer" /><span class="hidden-xs"> <spring:message code="kapital.sitramas.label.footer.details" /> </span> <spring:message code="kapital.sitramas.label.footer.copyrigth" /> </span>
				</div>
			</div>
			<!-- end row -->
		</div>
		<!-- END FOOTER -->

		<!-- #SHORTCUT AREA : With large tiles (activated via clicking user name tag)
			 Note: These tiles are completely responsive, you can add as many as you like -->
		<div id="shortcut">
			<ul>
				<li>
					<a href="profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span><spring:message code="kapital.sitramas.main.menu.myprofile" /> </span> </span> </a>
				</li>
				<li>
					<a href="index.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
				</li>
			</ul>
		</div>
		<!-- END SHORTCUT AREA -->
		<!--================================================== -->
		<!-- ui-dialog -->
		<div id="dialog_add_privilegios" title="Dialog Simple Title">
			<p>
				<i class='fa fa-question-circle fa-2x'></i>  ¿Está Seguro que desea Guardar los Cambios?
			</p>
		</div>
		<div id="dialog_add_roles" title="Dialog Simple Title">
			<p>
				<i class='fa fa-question-circle fa-2x'></i>  ¿Está Seguro que desea Guardar los Cambios?
			</p>
		</div>
		<div id="dialog_delete_privilegios" title="Dialog Simple Title">
			<p>
				<i class='fa fa-question-circle fa-2x'></i>  ¿Está Seguro que desea Eliminar el Registro?
			</p>
		</div>
		<div id="validation_delete_privilegios" title="Dialog Simple Title">
			<p>
				<i class='fa fa-warning fa-2x'></i>  Debe Seleccionar al menos un Registro
			</p>
		</div>
		<div id="dialog_del_roles" title="Dialog Simple Title">
			<p>
				<i class='fa fa-question-circle fa-2x'></i>  ¿Está Seguro que desea Eliminar el Rol Seleccionado?
			</p>
		</div>
		<%@include file="includes.html" %>
		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>-->


		<!-- #PLUGINS -->
		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.1.1.min.js"><\/script>');
			}
		</script>

		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="<c:url value="/resources/js/app.config.js" />"></script>

		<!-- BOOTSTRAP JS -->
		<script src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>

		<!--[if IE 8]>
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="<c:url value="/resources/js/app.js" />"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="<c:url value="/resources/js/notification/SmartNotification.min.js" />" ></script>

		<!-- JARVIS WIDGETS -->
		<script src="<c:url value="/resources/js/smartwidgets/jarvis.widget.min.js" />"></script>

		<!-- EASY PIE CHARTS -->
		<script src="<c:url value="/resources/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js" />" ></script>

		<!-- SPARKLINES -->
		<script src="<c:url value="/resources/js/plugin/sparkline/jquery.sparkline.min.js" />" ></script>

		<!-- JQUERY VALIDATE -->
		<script src="<c:url value="/resources/js/plugin/jquery-validate/jquery.validate.min.js" />" ></script>

		<!-- JQUERY MASKED INPUT -->
		<script src="<c:url value="/resources/js/plugin/masked-input/jquery.maskedinput.min.js" />" ></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script src="<c:url value="/resources/js/plugin/select2/select2.min.js" />" ></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="<c:url value="/resources/js/plugin/bootstrap-slider/bootstrap-slider.min.js" />" ></script>

		<!-- browser msie issue fix -->
		<script src="<c:url value="/resources/js/plugin/msie-fix/jquery.mb.browser.min.js" />" ></script>

		<!-- FastClick: For mobile devices -->
		<script src="<c:url value="/resources/js/plugin/fastclick/fastclick.min.js" />" ></script>

		<!--[if IE 8]>
		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- Messenger -->
		<script src="<c:url value="/resources/hubspot/js/messenger.min.js" />" ></script>
		<!-- PARSLEY -->
		<script src="<c:url value="/resources/parsleyjs/parsley.min.js" />" ></script>
		<script src="<c:url value="/resources/i18n/es.js" />" ></script>
		<!-- MAIN APP JS FILE -->
		<script src="<c:url value="/resources/js/app.min.js" />" ></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="<c:url value="/resources/js/speech/voicecommand.min.js" />" ></script>

		<!-- SmartChat UI : plugin -->
		<script src="<c:url value="/resources/js/smart-chat-ui/smart.chat.ui.min.js" />" ></script>
		<script src="<c:url value="/resources/js/smart-chat-ui/smart.chat.manager.min.js" />" ></script>

		<!-- Modulo de Seguridad - Administrar Cuenta -->
		<script src="<c:url value="/resources/public/seguridad/credenciales.js" />" ></script>
		
		<!-- Plugins DataTables -->
		<!-- PAGE RELATED PLUGIN(S) -->
		<script src="<c:url value="/resources/js/plugin/datatables/jquery.dataTables.min.js" />"></script>
		<script src="<c:url value="/resources/js/plugin/datatables/dataTables.colVis.min.js" />" ></script>
		<script src="<c:url value="/resources/js/plugin/datatables/dataTables.tableTools.min.js" />" ></script>
		<script src="<c:url value="/resources/js/plugin/datatables/dataTables.bootstrap.min.js" />" ></script>
		<script src="<c:url value="/resources/js/plugin/datatable-responsive/datatables.responsive.min.js" />" ></script>
		<script>var ctx = "${pageContext.request.contextPath}"</script>
		<!-- Modulo de Seguridad - Administrar Cuenta -->
		<script src="<c:url value="/resources/public/seguridad/privilegios.js" />" ></script>
		<script src="<c:url value="/resources/public/seguridad/roles.js" />" ></script>
		<script src="<c:url value="/resources/public/seguridad/usuarios.js" />" ></script>
		<script src="<c:url value="/resources/public/personal/personas.js" />" ></script>
		<script src="<c:url value="/resources/public/servicios/programacion.js" />" ></script>
		
		<!-- CUSTOM NOTIFICATION -->
		<script src="<c:url value="/resources/js/notification/SmartNotification.min.js" />"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				
				var idprivilegio = null;
				$('a.cancel[name]').click(function() {
						idprivilegio = $(this).attr('name');
						$('#dialog_delete_privilegios').dialog('open');
						return false;
				
				});
				$('#dialog_delete_privilegios').dialog({
					autoOpen : false,
					width : 600,
					resizable : false,
					modal : true,
					title : "Mensaje de Confirmación",
					buttons : [{
						html : "<i class='fa fa-trash-o'></i>&nbsp; Eliminar",
						"class" : "btn btn-danger",
						click : function() {	
    						console.log(idprivilegio);
    						window.location.href = "<%=request.getContextPath()%>/seguridad/privilegios/delete/"+idprivilegio;
    						$(this).dialog("close");
						}
					}, {
						html : "<i class='fa fa-times'></i>&nbsp; Cancelar",
						"class" : "btn btn-default",
						click : function() {
							$(this).dialog("close");
						}
					}]
				});	
			});
			
			
		</script>
		
		<script async defer
		    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBxuMB_Z8fF5yzOU2jmbfWaQkNHeAylAk&callback=initMap">
	    </script>
		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
	
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
		
		</script>
		<script  th:inline="javascript" >
		    /*<![CDATA[*/
		    var contextPath = /*[[@{/}]]*/ '/sitramas/';
		    /*]]>*/
		    function url(relative) {
		        return contextPath + relative;
		    }
		</script>
	</body>

</html>