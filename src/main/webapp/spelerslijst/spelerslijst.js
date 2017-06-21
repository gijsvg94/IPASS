$(document).ready(initPage());

function initPage() {
    loadSpelerlijst();

    $("#searchInput").keyup(function (e) {
        filterSpelers(e);
    });

    $("#spelerTable").click(changeContent);

    $("#close").click(clearFields);

    $("#add_Speler").click(function () {
        document.getElementById("myModal").style.display = "block";
    });

    $("#cancel").click(clearFields);

    $("#save").click(saveFields);
}

function loadSpelerlijst() {
    $.get("localhost:8888/spelerslijst/Spelerlijst", function (data) {
        var countryTable = $("#spelerlijstTable");
        $.each(data, function (index, object) {
            var String =
                "<tr id='row" +
                index +
                "'>" +
                "<td class='code_row'>" +
                object.spelerid +
                "</td>" +
                "<td>" +
                object.naam +
                "</td>" +
                "<td>" +
                object.status +
                "</td>" +
                "<td>" +
                object.teamid +
                "</td>" +
                "<td class='delete'>&times;</td>" +
                "</tr>";
            countryTable.append(String);
        });
    });
}


function deleteSpeler(e) {
	$.ajax({
		url: "localhost:8888/spelerlijsts/deleteSpeler/" + nummer,
		method: "delete",
		success: function(response) {
	   		console.log("succes");
	   		loadVoorraad();
	   		},
	   		error: function(response) {
	   		console.log("failure");
	   		}
	   		});
}



function showContent(e) {
    var row = e.target.parentNode;
    var countryCode = row.firstChild.innerText;
    var country = getCountry(countryCode);
    document.getElementById("myModal").style.display = "block";
}

function getSpeler(code) {
    $.get("localhost:8888/spelerslijst/getspeler/" + code, function (data) {
        var inputs = $("#inputContainer input");

        $.each(inputs, function (index, input) {
            input.value = data[input.id];
        });

        document.getElementById("spelerid").disabled = true;
    });
}

function changeContent(e) {
    if (e.target.nodeName === "TH") sortCountries(e);
    else if (e.target.classList.contains("delete")) deleteSpeler(e);
    else showContent(e);
}

function addSpeler(e) {
    var object = {};

    var inputs = $("#inputContainer input");

    $.each(inputs, function (index, input) {
        object["" + input.id + ""] = input.value;
    });

    var spelerTable = $("#spelerTable");

    $.ajax({
        url: "/restservices/spelerlijst/",
        type: "POST",
        contentType: "application/json",
        beforeSend: function (xhr) {
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader("Authorization", "Bearer " + token);
        },
        data: JSON.stringify(object),
        success: function (result) {
            var String =
                "<tr id='row" +
                object.code +
                "'>" +
                "<td class='code_row'>" +
                object.spelerid +
                "</td>" +
                "<td>" +
                object.naam +
                "</td>" +
                "<td>" +
                object.status +
                "</td>" +
                "<td>" +
                object.teamid +
                "</td>" +
                "<td class='delete'>&times;</td>" +
                "</tr>";
            spelerTable.append(String);
            clearFields();
            document.getElementById("myModal").style.display = "none";
        }
    });
}

function clearFields() {
    var inputs = $("#inputContainer input");

    $.each(inputs, function (index, input) {
        input.value = "";
    });

    document.getElementById("spelerid").disabled = false;
    document.getElementById("myModal").style.display = "none";
}

function saveFields(e) {
    document.getElementById("spelerid").disabled ? updateSpeler() : addSpeler();
}

function updateSpeler() {
    var object = {};

    var inputs = $("#inputContainer input");

    $.each(inputs, function (index, input) {
        object["" + input.id + ""] = input.value;
    });

    var spelerTable = $("#spelerTable");

    $.ajax({
        url: "localhost:8888/spelerslijst/spelerlijst/",
        type: "PUT",
        contentType: "application/json",
        beforeSend: function (xhr) {
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader("Authorization", "Bearer " + token);
        },
        data: JSON.stringify(object),
        success: function (result) {
            var code_rows = document.getElementsByClassName("code_row");
            var searchText = object.code;
            var found;

            for (var i = 0; i < code_rows.length; i++) {
                if (code_rows[i].textContent === searchText) {
                    found = code_rows[i];
                    break;
                }
            }

            found.parentNode.innerHTML =
                "<td class='code_row'>" +
                object.spelerid +
                "</td>" +
                "<td>" +
                object.naam +
                "</td>" +
                "<td>" +
                object.status +
                "</td>" +
                "<td>" +
                object.teamid +
                "</td>" +
                "<td class='delete'>&times;</td>";

            clearFields();
            document.getElementById("myModal").style.display = "none";
        }
    });
}