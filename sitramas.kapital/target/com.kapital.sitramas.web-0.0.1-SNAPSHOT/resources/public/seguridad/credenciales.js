/**
 *
 * Kapital Taxi : Sitramas
 * Powered by SmartAdmin
 * @author Jesús Matos (c) 2017
 * 
 */
// DO NOT REMOVE : GLOBAL FUNCTIONS!

		$(window).load(function() {
		    $(".bg_load").fadeOut("slow");
		    $(".wrapper").fadeOut("slow");
		});

	$(document).ready(function() {
		
		pageSetUp();
		var errorClass = 'invalid';
		var errorElement = 'em';
		var $registerForm = $("#checkout-form").validate({
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
				password_old : {
					required : true,
					minlength : 3,
					maxlength : 20
				},
				password_new : {
					required : true,
					minlength : 3,
					maxlength : 20
				},
				password_confirm : {
					required : true,
					minlength : 3,
					maxlength : 20,
					equalTo : '#password_new'
				}
			},

			// Messages for form validation
			messages : {
				password_old : {
					required : 'Por favor Ingrese su Contraseña'
				},
				password_confirm : {
					required : 'Por favor Ingrese su Nueva Contraseña',
					equalTo : 'Ingrese la misma contraseña que la anterior'
				}
			},

			// Do not change code below
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});
		$("#checkout-form").load(function() {
		    $(".bg_load").fadeOut("slow");
		    $(".wrapper").fadeOut("slow");
		});
		
	});