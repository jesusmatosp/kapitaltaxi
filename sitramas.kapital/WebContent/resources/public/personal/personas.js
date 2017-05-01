$(function () {
	
	$('#btnGuardarUser').click(function(e) {
		//alert("prueba");
		//$('#dialog_add_users').dialog('open');
		//return false;
		$.SmartMessageBox({
			title : "Mensaje de Confirmación!",
			content : "¿Está Seguro que desea guardar los Cambios los realizados?",
			buttons : '[No][Si]'
		}, function(ButtonPressed) {
			if (ButtonPressed === "Si") {
				$('#persona-form').parsley().destroy();
				$('#persona-form').parsley();
				if ($('#persona-form').parsley().validate()) {
					$.ajax({
						url: url('personal/savePersona'),
			            type: 'POST',
			            async: true,
			            data: $("#persona-form").serialize(),
			            success: function (response) {
			                if (response.success) {
			                	//notify(response.message, "info");
			                	notifyBox("Datos de la Persona", e, "success");
		                        setTimeout(function () {
		                            location.reload();
		                        }, 4500);
		                        //$('#dialog_info').dialog('open');
		                		//return false;
			                } else {
			                	notifyBox("Error General", e, "error");
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
	
	$('#codDepartamento').change(function () {
		Persona.changeDepartamento();
	});
	
	$('#codProvincia').change(function () {
		Persona.changeProvincia();
	});
	
	Persona = {
			changeDepartamento: function(){
				var codDepartamento = $('#codDepartamento').val();
				if (codDepartamento != '') {
					$.ajax({
						url: url('personal/listProvincia'),
		                type: 'POST',
		                data: {id: codDepartamento},
		                success: function (response) {
		                    if (response.success) {
		                        var template = '<option>-- Seleccione --</option>';
		                        $('#codDistrito').html($(template));
		                        $.each(response.data, function (it, val) {
		                            template += '<option value="' + val.id + '" >' + val.nombre + '</option>';
		                        });
		                        $('#codProvincia').html($(template));
		                    } else {
		                        humane.log(response.message, {addnCls: 'humane-original-error'});
		                    }
		                }
						
					});
				}
			},
			changeProvincia: function (){
				var codProvincia = $('#codProvincia').val();
				if (codProvincia != '') {
					$.ajax({
						url: url('personal/listDistrito'),
		                type: 'POST',
		                data: {id: codProvincia},
		                success: function (response) {
		                    if (response.success) {
		                        var template = '<option>-- Seleccione --</option>';
		                        $.each(response.data, function (it, val) {
		                            template += '<option value="' + val.id + '" >' + val.nombre + '</option>';
		                        });
		                        $('#codDistrito').html($(template));
		                    } else {
		                        humane.log(response.message, {addnCls: 'humane-original-error'});
		                    }
		                }
						
					});
				}
			}
		};
	
	$('#dni').blur(function() {
		var dni = $(this).val();
		$.ajax({
			url: url('personal/findPersona'),
            type: 'POST',
            async: true,
            data: {dni:dni},
            success: function (response) {
                if (response.success) {
                	if(response.data.existe === true){
                		$('#btnGuardarUser').prop('disabled', true);
                		$('#diagol_registro_existe').dialog('open');
                		$('#dni').addClass('parsley-error');
                		return;
                	}else{
                		$('#dni').removeClass('parsley-error');
                		$('#btnGuardarUser').prop('disabled', false);
                	}
                } else {
                    humane.log(response.message, {addnCls: 'humane-original-error'});
                    notify(response.message, "error");
                }
            }
		});
	});
	
	$('#diagol_registro_existe').dialog({
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
	
	$('#dialog_add_users').dialog({
		autoOpen : false,
		width : 600,
		resizable : false,
		modal : true,
		title : "Mensaje de Confirmación",
		buttons : [{
			html : "<i class='fa fa-save'></i>&nbsp; Guardar",
			"class" : "btn btn-success",
			click : function(e) {
				
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
	
	$('#btnDelPersonas').click(function(e) {
		if ($(".chkval:checked").length > 0) {
			$.SmartMessageBox({
				title : "Inactivación de Personas",
				content : "Usted está a punto de Inactivar el o las siguientes Personas, Por favor Ingrese el motivo de la Inactivación",
				buttons : "[Aceptar]",
				input : "text",
				placeholder : "Ingrese Comentarios"
			}, function(ButtonPress, Value) {
				//alert(ButtonPress + " " + Value);
				$('#comentarios').val(Value);
				$.ajax({
					url: url('personal/inactivarPersonas'),
		            type: 'POST',
		            async: true,
		            data: $("#list-personas-form").serialize(),
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
	
});