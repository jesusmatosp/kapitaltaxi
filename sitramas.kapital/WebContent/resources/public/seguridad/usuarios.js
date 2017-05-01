$(function () {
	
	var idUsuario = $('#usuarioId').val();
	var idCliente = $('#forUserIdCliente').val();
	if(idUsuario != null){
		if(idUsuario != ""){
			$('#dniUser').prop('disabled', true);
			$('#dniUser').addClass('parsley-success');
			$('#nombresUser').addClass('parsley-success');
			if($('#idTipoUsuario').val() === '1'){
				$('#secCliente').show(); //muestro mediante id
				$('#forUserIdCliente').val($('#frmClienteId').val());
			}
		}
	}
	
	$('#btnGuardarUsuario').click(function(e) {
		$.SmartMessageBox({
			title : "Mensaje de Confirmación!",
			content : "¿Está Seguro que desea guardar los Cambios los realizados?",
			buttons : '[No][Si]'
		}, function(ButtonPressed) {
			if (ButtonPressed === "Si") {
				$('#usuario-form').parsley().destroy();
				$('#usuario-form').parsley();
				if ($('#usuario-form').parsley().validate()) {
					$.ajax({
						url: url('seguridad/saveUsuario'),
			            type: 'POST',
			            async: true,
			            data: $("#usuario-form").serialize(),
			            success: function (response) {
			                if (response.success) {
			                	notifyBox("Datos de la Persona", e, "success");
		                        setTimeout(function () {
		                            location.reload();
		                        }, 4500);
			                } else {
			                	notifyBox("Error General", e, "error");
			                    //notify("Ocurrió un Error en la Aplicación, comuniquese con el Administrador del Sistema", "error");
			                }
			            }
					});
				}
			}
			if (ButtonPressed === "No") {
				
			}	
		});
		e.preventDefault();
		
	});
	$('#btnDelUsers').click(function(e) {
		if ($(".chkval:checked").length > 0) {
			$.SmartMessageBox({
				title : "Inactivación de Usuarios",
				content : "Usted está a punto de Inactivar el o los siguientes usuarios, Por favor Ingrese el motivo de la Inactivación",
				buttons : "[Aceptar]",
				input : "text",
				placeholder : "Ingrese Comentarios"
			}, function(ButtonPress, Value) {
				//alert(ButtonPress + " " + Value);
				$('#comentarios').val(Value);
				$.ajax({
					url: url('seguridad/inactivarUsuarios'),
		            type: 'POST',
		            async: true,
		            data: $("#list-usuarios-form").serialize(),
		            success: function (response) {
		            	if (response.success) {
		                	notifyBox(" Inactivación de Usuario", e, "success");
	                        setTimeout(function () {
	                            location.reload();
	                        }, 4500);
		                } else {
		                	notifyBox("Error General", e, "error");
		                }
		            }
				});
			});
				e.preventDefault();
		}
		else{
			notifyBox("Advertencia: Debe de Seleccionar al menos un usuario para inactivar", e, "warning");
		}
	});
	
	$('#dniUser').blur(function() {
		var dni = $(this).val();
		$.ajax({
			url: url('personal/findPersona'),
            type: 'POST',
            async: true,
            data: {dni:dni},
            success: function (response) {
                if (response.success) {
                	if(response.data.existe === true){
                		$('#nombresUser').val(response.data.nombres);
                		$('#personaId').val(response.data.personaId);
                		$('#nombresUser').removeClass('parsley-error');
                		$('#btnGuardarUsuario').prop('disabled', false);
                		
                		return;
                	}else{
                		$('#btnGuardarUsuario').prop('disabled', true);
                		$('#nombresUser').addClass('parsley-error');
                		
                	}
                } else {
                    notify(response.message, "error");
                }
            }
		});
	});
	
	$('#usuario').blur(function() {
		var usuario = $(this).val();
		$.ajax({
			url: url('seguridad/findUsuario'),
            type: 'POST',
            async: true,
            data: {usuario:usuario},
            success: function (response) {
                if (response.success) {
                	if(response.data.existeUser === true){
                		$('#dialog_user_existe_2').dialog('open');
        				$('#btnGuardarUsuario').prop('disabled', true);
        				$('#usuario').addClass('parsley-error');
                	}else{
        				$('#btnGuardarUsuario').prop('disabled', false);
        				$('#usuario').removeClass('parsley-error');
                	}
                }
            }
		});
	});

	$('#idTipoUsuario').change(function(){
		var codTipoUsuario = $(this).val();
		if(codTipoUsuario == '1'){
			$('#secCliente').show(); //muestro mediante id
		}else{
			$('#secCliente').hide(); //muestro mediante id
		}
	});
	
	$('#sandbox-container input').datepicker({
	    language: "es"
	});
	
	$('#dialog_info').dialog({
		autoOpen : false,
		width : 600,
		resizable : false,
		modal : true,
		title : "Mensaje de Confirmación",
		buttons : [{
			html : "&nbsp; Aceptar",
			"class" : "btn btn-success",
			click : function() {
				$(this).dialog("close");
			}
		}]
	});
	
	$('#dialog_user_existe_2').dialog({
		autoOpen : false,
		width : 600,
		resizable : false,
		modal : true,
		title : "Mensaje de Error",
		buttons : [{
			html : "&nbsp; Aceptar",
			"class" : "btn btn-danger",
			click : function() {
				$(this).dialog("close");
			}
		}]
	});
	
});

	Messenger.options = {
	    extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
	    theme: 'flat',
	}

	function notifyBox(message, e, type){
		
		var titulo = "";
		var contenido = "";
		var bg_color = "";
		var icono = "";
		if(type==='error'){
			titulo = "Mensaje de Advertencia";
			contenido = "Oops! Ocurrió un problema en el Sistema, por favor comuniquese con el Administrador." + message;
			bg_color = "#C46A69";
			icono = "fa fa-warning shake animated";
		}else if(type==='success'){
			titulo = "Mensaje Informativo";
			contenido = "Correcto: " + message;
			bg_color = "#739E73";
			icono = "fa fa-check";
		}else if(type==='warning'){
			titulo = "Mensaje Informativo";
			contenido = message;
			bg_color = "#C79121";
			icono = "fa fa-shield fadeInLeft animated";
		}
		$.bigBox({
			title : titulo,
			content : contenido,
			color : bg_color,
			//timeout: 6000,
			icon : icono,
			number : "1",
			timeout : 6000
		});
		e.preventDefault();
	}
	
	function notify(message, type) {
	    var t = (type == null) ? 'success' : type;

	    setTimeout(function () {
	        Messenger().post({
	            message: message,
	            type: t,
	            hideAfter: 12,
	            showCloseButton: true
	        });
	    }, 900);

	}

	function soloNumeros(e) 
	{ 
		var key = window.Event ? e.which : e.keyCode 
		return ((key >= 48 && key <= 57) || (key==8)) 
	}