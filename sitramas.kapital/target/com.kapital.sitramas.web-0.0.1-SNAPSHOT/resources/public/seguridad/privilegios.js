/**
 * 
 */
$(document).ready(function() {
			
			pageSetUp();
			
			/* // DOM Position key index //
		
			l - Length changing (dropdown)
			f - Filtering input (search)
			t - The Table! (datatable)
			i - Information (records)
			p - Pagination (paging)
			r - pRocessing 
			< and > - div elements
			<"#id" and > - div with an id
			<"class" and > - div with a class
			<"#id.class" and > - div with an id and class
			
			Also see: http://legacy.datatables.net/usage/features
			*/	
	
			/* BASIC ;*/
				var responsiveHelper_dt_basic = undefined;
				var responsiveHelper_datatable_fixed_column = undefined;
				var responsiveHelper_datatable_col_reorder = undefined;
				var responsiveHelper_datatable_tabletools = undefined;
				
				var breakpointDefinition = {
					tablet : 1024,
					phone : 480
				};
	
				$('#dt_basic').dataTable({
					"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-12 hidden-xs'l>r>"+
						"t"+
						"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
					"autoWidth" : true,
			        "oLanguage": {
					    "sSearch": '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>'
					},
					"preDrawCallback" : function() {
						// Initialize the responsive datatables helper once.
						if (!responsiveHelper_dt_basic) {
							responsiveHelper_dt_basic = new ResponsiveDatatablesHelper($('#dt_basic'), breakpointDefinition);
						}
					},
					"rowCallback" : function(nRow) {
						responsiveHelper_dt_basic.createExpandIcon(nRow);
					},
					"drawCallback" : function(oSettings) {
						responsiveHelper_dt_basic.respond();
					}
				});
	
			/* END BASIC */
			
			/* COLUMN FILTER  */
		    var otable = $('#datatable_fixed_column').DataTable({
		    	//"bFilter": false,
		    	//"bInfo": false,
		    	//"bLengthChange": false
		    	//"bAutoWidth": false,
		    	//"bPaginate": false,
		    	//"bStateSave": true // saves sort state using localStorage
				"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6 hidden-xs'f><'col-sm-6 col-xs-12 hidden-xs'<'toolbar'>>r>"+
						"t"+
						"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
				"autoWidth" : true,
				"oLanguage": {
					"sSearch": '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>'
				},
				"preDrawCallback" : function() {
					// Initialize the responsive datatables helper once.
					if (!responsiveHelper_datatable_fixed_column) {
						responsiveHelper_datatable_fixed_column = new ResponsiveDatatablesHelper($('#datatable_fixed_column'), breakpointDefinition);
					}
				},
				"rowCallback" : function(nRow) {
					responsiveHelper_datatable_fixed_column.createExpandIcon(nRow);
				},
				"drawCallback" : function(oSettings) {
					responsiveHelper_datatable_fixed_column.respond();
				}		
			
		    });
		    
		    // custom toolbar
		    $("div.toolbar").html('<div class="text-right"><img src="img/logo.png" alt="SmartAdmin" style="width: 111px; margin-top: 3px; margin-right: 10px;"></div>');
		    	   
		    // Apply the filter
		    $("#datatable_fixed_column thead th input[type=text]").on( 'keyup change', function () {
		    	
		        otable
		            .column( $(this).parent().index()+':visible' )
		            .search( this.value )
		            .draw();
		            
		    } );
		    /* END COLUMN FILTER */   
	    
			/* COLUMN SHOW - HIDE */
			$('#datatable_col_reorder').dataTable({
				"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'C>r>"+
						"t"+
						"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
				"autoWidth" : true,
				"oLanguage": {
					"sSearch": '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>'
				},
				"preDrawCallback" : function() {
					// Initialize the responsive datatables helper once.
					if (!responsiveHelper_datatable_col_reorder) {
						responsiveHelper_datatable_col_reorder = new ResponsiveDatatablesHelper($('#datatable_col_reorder'), breakpointDefinition);
					}
				},
				"rowCallback" : function(nRow) {
					responsiveHelper_datatable_col_reorder.createExpandIcon(nRow);
				},
				"drawCallback" : function(oSettings) {
					responsiveHelper_datatable_col_reorder.respond();
				}			
			});
			
			/* END COLUMN SHOW - HIDE */
	
			/* TABLETOOLS */
			$('#datatable_tabletools').dataTable({
				
				// Tabletools options: 
				//   https://datatables.net/extensions/tabletools/button_options
				"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'T>r>"+
						"t"+
						"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
				"oLanguage": {
					"sSearch": '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>'
				},		
		        "oTableTools": {
		        	 "aButtons": [
		             "copy",
		             "csv",
		             "xls",
		                {
		                    "sExtends": "pdf",
		                    "sTitle": "SmartAdmin_PDF",
		                    "sPdfMessage": "SmartAdmin PDF Export",
		                    "sPdfSize": "letter"
		                },
		             	{
	                    	"sExtends": "print",
	                    	"sMessage": "Generated by SmartAdmin <i>(press Esc to close)</i>"
	                	}
		             ],
		            "sSwfPath": "js/plugin/datatables/swf/copy_csv_xls_pdf.swf"
		        },
				"autoWidth" : true,
				"preDrawCallback" : function() {
					// Initialize the responsive datatables helper once.
					if (!responsiveHelper_datatable_tabletools) {
						responsiveHelper_datatable_tabletools = new ResponsiveDatatablesHelper($('#datatable_tabletools'), breakpointDefinition);
					}
				},
				"rowCallback" : function(nRow) {
					responsiveHelper_datatable_tabletools.createExpandIcon(nRow);
				},
				"drawCallback" : function(oSettings) {
					responsiveHelper_datatable_tabletools.respond();
				}
			});
			
			/* END TABLETOOLS */
		
			var errorClass = 'invalid';
			var errorElement = 'em';
			var $registerForm = $("#privilegios-form").validate({
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
					txtnameprivilegio : {
						required : true,
						minlength : 3,
						maxlength : 80
					},
					txtdescrprivilegio : {
						required : true,
						minlength : 8,
						maxlength : 120
					}
				},

				// Messages for form validation
				messages : {
						txtnameprivilegio : {
						required : 'Por favor Ingrese un Nombre de Privilegio'
					},
						txtdescrprivilegio : {
						required : 'Por favor Ingrese una descripción del Privilegio',
					}
				},

				// Do not change code below
				errorPlacement : function(error, element) {
					error.insertAfter(element.parent());
				}
			});
			
			/** Ventana de Confirmación */
			$('#btnGuardar').click(function(e) {
				$.SmartMessageBox({
					title : "Mensaje de Confirmación!",
					content : "¿Está Seguro que desea guardar los Cambios los realizados?",
					buttons : '[No][Si]'
				}, function(ButtonPressed) {
					if (ButtonPressed === "Si") {
						$('#privilegios-form').parsley().destroy();
						$('#privilegios-form').parsley();
						if ($('#privilegios-form').parsley().validate()) {
							$.ajax({
								url: url('seguridad/privilegios/save'),
					            type: 'POST',
					            async: true,
					            data: $("#privilegios-form").serialize(),
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
				//alert("prueba");
				//$('#dialog_add_privilegios').dialog('open');
				//return false;
			});
			
			$('#dialog_add_privilegios').dialog({
				autoOpen : false,
				width : 600,
				resizable : false,
				modal : true,
				title : "Mensaje de Confirmación",
				buttons : [{
					html : "<i class='fa fa-save'></i>&nbsp; Guardar",
					"class" : "btn btn-success",
					click : function() {
						$("#privilegios-form").submit();
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
			
			$('#selectAll').click(function(e){
			    var table= $(e.target).closest('table');
			    $('td input:checkbox',table).prop('checked',this.checked);
			});
			
			$("#btnDelPrivilegios").click(function (e){
				if ($(".chkval:checked").length > 0) {
				    //perform submit
					$("#form-priv-table").submit();
				}
				else{
					notifyBox("Advertencia: Debe de Seleccionar al menos un privilegio para eliminar", e, "warning");
				}
			});
			
			$('#validation_delete_privilegios').dialog({
				autoOpen : false,
				width : 600,
				resizable : false,
				modal : true,
				title : "Mensaje de Advertencia",
				buttons : [{
					html : "&nbsp; Aceptar",
					"class" : "btn btn-default",
					click : function() {
						$(this).dialog("close");
					}
				}]
			});	
		});