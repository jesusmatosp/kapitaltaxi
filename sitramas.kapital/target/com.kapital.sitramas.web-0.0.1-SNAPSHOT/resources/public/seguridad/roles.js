$(function () {
	
	//alert("Llamdo desde el script de Roles ");
	var errorClass = 'invalid';
	var errorElement = 'em';
	var $registerForm = $("#roles-form").validate({
		errorClass		: errorClass,
		errorElement	: errorElement,
		highlight: function(element) {
	        $(element).parent().removeClass('state-success').addClass("state-error");
	        $(element).removeClass('valid');
	    },
	    unhighlight: function(element) {
	        $(element).parent().removeClass("state-error").addClass('state-success');
	        $(element).addClass('valid');
	    },

		// Rules for form validation
		rules : {
			txtnamerol : {
				required : true,
				minlength : 3,
				maxlength : 80
			},
			txtdescrol : {
				required : true,
				minlength : 8,
				maxlength : 120
			}
		},

		// Messages for form validation
		messages : {
				txtnameprivilegio : {
				required : 'Por favor Ingrese un Nombre del Rol '
			},
				txtdescrprivilegio : {
				required : 'Por favor Ingrese una descripción del Rol ',
			}
		},

		// Do not change code below
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		}
	});
	
	/** Ventana de Confirmación */
	$('#btnGuardarRol').click(function() {
		//alert("prueba");
		$('#dialog_add_roles').dialog('open');
		return false;
	});
	$('#dialog_add_roles').dialog({
		autoOpen : false,
		width : 600,
		resizable : false,
		modal : true,
		title : "Mensaje de Confirmación",
		buttons : [{
			html : "<i class='fa fa-save'></i>&nbsp; Guardar",
			"class" : "btn btn-success",
			click : function() {
				$("#roles-form").submit();
				console.log("envia formulario");
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
	var idroles = null;
	$('a.cancel1[name]').click(function() {
		idroles = $(this).attr('name');
		$('#dialog_del_roles').dialog('open');
		return false;
	});
	$('#dialog_del_roles').dialog({
		autoOpen : false,
		width : 600,
		resizable : false,
		modal : true,
		title : "Mensaje de Confirmación",
		buttons : [{
			html : "<i class='fa fa-trash-o'></i>&nbsp; Eliminar",
			"class" : "btn btn-danger",
			click : function() {	
				console.log(idroles);
				window.location.href = ctx+"/seguridad/roles/delete/"+idroles;
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
	
	$("#btnDelRoles").click(function (){
		if ($(".chkval:checked").length > 0) {
		    //perform submit
			$("#form-roles-table").submit();
		}
		else{
		    $('#validation_delete_privilegios').dialog('open');
			return false;    
		}
	});
	
	
	
	
	
});