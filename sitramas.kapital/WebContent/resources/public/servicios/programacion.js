$(function () {
	
	
	$('.monitorKT, #btnRefreshMonitor').click(function(){
		// Setea Campos:
		var header = '<thead><tr>';
		header +="<th>N°</th>";
		header +="<th>Fecha Carga</th>";
		header +="<th>Fecha Proceso</th>";
		header +="<th>Nombre Archivo</th>";
		header +="<th>Estado Carga</th>";
		header +="<th>Usuario Carga</th>";
		header +="</tr></thead>";
		
		$("#dt_carga").html('');
		$.ajax({
			url: url('servicios/monitorCarga'),
			type: 'POST',
			async: true,
			data: {idProgramacion:$("#idProgramacion").val()},
			success: function(response){
				if(response.success){
					var template = header + "<tbody>";
					num = 1;
					$.each(response.data, function(it, val){
						template += "<tr><td>"+num+"</td>";
						template += "<td>"+val.fechaCarga+"</td>";
						template += "<td>"+val.fechaProceso+"</td>";
						template += "<td>"+val.nombreArchivo+"</td>"
						template += "<td><strong>"+val.estadoCarga+"</strong></td>";
						template += "<td>"+val.usuarioCarga+"</td></tr>";
						num++;
					});
					template +="</tbody>";
					$("#dt_carga").html($(template));
				}else{
					alert("Nada :(");
				}
			}
		});
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