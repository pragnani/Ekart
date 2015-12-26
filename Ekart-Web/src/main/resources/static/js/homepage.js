$(function() {

	$('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	$("#register-form").validate(
			{
				rules : {
					username : {
						required : true,
						minlength : 4,
						remote : {
							url : "/register/available",
							type : "get",
							data : {
								username : function() {
									return $("#register-form")
											.find("#username").val();
								}
							}
						}
					},
					name : {
						required : true,
						minlength : 5
					},
					email : {
						required : true,
						email : true
					},
					password : {
						required : true,
						minlength : 5
					},
					password_again : {
						required : true,
						minlength : 5,
						equalTo : "#password"
					}
				},
				highlight : function(element) {
					$(element).closest('.form-group')
							.removeClass('has-success').addClass('has-error');
				},
				unhighlight : function(element) {
					$(element).closest('.form-group').removeClass('has-error')
							.addClass('has-success');
				},
				messages : {
					username : {
						remote : "Username already exists!"
					}
				}
			});
	$("#register-submit").on("click", function(e) {

		var $form = $('#register-form');
		if ($form.valid()) {
			$form.find('#confirm-password').attr('disabled', 'disabled');

			$.ajax({
				type : "POST",
				cache : false,
				url : $form.attr('action'),
				data : $form.serializeArray(),
				success : function(data) {
					alert(data);
				}
			});

		}

	});

});
