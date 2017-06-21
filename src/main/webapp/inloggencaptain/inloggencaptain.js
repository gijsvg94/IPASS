function getToken() {
			var data = $("#loginform").serialize();
			$.post("/restservices/authentication", data, function(response) {
				window.sessionStorage.setItem("sessionToken", response);
			}).fail(function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
				console.log(errorThrown);
			});
		}

$(document).ready(function () {
    //event handler for submit button
    $("#btnSubmit").click(function () {
        //collect userName and password entered by users
        var userName = $("#username").val();
        var password = $("#password").val();

        //call the authenticate function
        authenticate(userName, password);
    });
});

//authenticate function to make ajax call
function authenticate(userName, password) {
    $.ajax
    ({
        type: "POST",
        //the url where you want to sent the userName and password to
        url: "/AuthenticationResource",
        dataType: 'json',
        async: false,
        //json object to sent to the authentication url
        data: '{"userName": "' + userName + '", "password" : "' + password + '"}',
        success: function () {
            //do any process for successful authentication here
        }
    })
}