$(function () {
	
	/*$('#dt_det_programacion').DataTable( {
        "scrollX": true
    } );*/
	
	$('#').click(function(){
		
	});
	
	$('#btnEnviarProgramacion').click(function(e){
		$.SmartMessageBox({
			title : "Mensaje de Confirmación!",
			content : "¿Está Seguro que desea Enviar La Programación? Ya no podrá realizar mas modificaciones sobre esta Programación.",
			buttons : '[No][Si]'
		}, function(ButtonPressed) {
			if (ButtonPressed === "Si") {
				
			}
			if (ButtonPressed === "No") {
				
			}	
		});
		e.preventDefault();
	});
	
	$('#btnGuardarProg').click(function(e) {
		$.SmartMessageBox({
			title : "Mensaje de Confirmación!",
			content : "¿Está Seguro que desea guardar los Cambios los realizados?",
			buttons : '[No][Si]'
		}, function(ButtonPressed) {
			if (ButtonPressed === "Si") {
				$('#upload-programacion-form').submit();
			}
			if (ButtonPressed === "No") {
				
			}	
		});
		e.preventDefault();
		
	});
	
	$('#frm01btnGuardar').click(function(e){
		$.SmartMessageBox({
			title : "Mensaje de Confirmación!",
			content : "¿Está Seguro que desea guardar los Cambios los realizados?",
			buttons : '[No][Si]'
		}, function(ButtonPressed) {
			if (ButtonPressed === "Si") {
				$('#programacion-form').parsley().destroy();
				$('#programacion-form').parsley();
				if ($('#programacion-form').parsley().validate()) {
					$.ajax({
						url: url('servicios/saveProgramacion'),
			            type: 'POST',
			            async: true,
			            data: $("#programacion-form").serialize(),
			            success: function (response) {
			                if (response.success) {
			                	//notify(response.message, "info");
			                	notifyBox("Datos de la Programacion", e, "success");
		                        setTimeout(function () {
		                            location.reload();
		                        }, 2500);
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
	
});