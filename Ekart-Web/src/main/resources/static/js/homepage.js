$(function() {

	// var token = $("meta[name='_csrf']").attr("content");
	// var header = $("meta[name='_csrf_header']").attr("content");
	// $(document).ajaxSend(function(e, xhr, options) {
	// xhr.setRequestHeader(header, token);
	// });

	var loginFun = function(e) {
		$("#login-form").delay(100).fadeIn(100);
		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	};

	var registerFun = function(e) {
		$("#register-form").delay(100).fadeIn(100);
		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	};

	$('#myModal').on('hidden.bs.modal', function(e) {
		$('#btnSignin').removeClass('active');
		$('#btnRegister').removeClass('active');
	});

	$('#login-form-link').click(loginFun);
	$('#register-form-link').click(registerFun);
	$('#btnSignin').click(loginFun);
	$('#btnRegister').click(registerFun);

	$("#login-form").validate(
			{
				rules : {
					username : {
						required : true,
						minlength : 4,
					},
					password : {
						required : true,
						minlength : 5
					},
					highlight : function(element) {
						$(element).closest('.form-group').removeClass(
								'has-success').addClass('has-error');
					},
					unhighlight : function(element) {
						$(element).closest('.form-group').removeClass(
								'has-error').addClass('has-success');
					}
				}
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
					if (data.success) {
						$form.find(".alert-danger").css('display', 'none');
						$form.find(".alert-success").css('display', 'block');
					} else {
						$form.find(".alert-success").css('display', 'none');
						$form.find(".alert-danger").css('display', 'block');
					}
				}
			});

		}

	});
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
	$("#login-submit").on("click", function(e) {

		var $form = $('#login-form');
		if ($form.valid()) {

			$.ajax({
				type : "POST",
				cache : false,
				url : $form.attr('action'),
				data : $form.serializeArray(),
				success : function(data) {
					if (data.success) {
						window.location="/";
						window.location.reload();
					}
					else{
						$form.find(".alert-danger").css('display', 'block');
					}
				}
			});

		}

	});

});
