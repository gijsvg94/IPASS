$(document).ready(initPage());

function initPage() {
    loadStandenmotor();

    $("#searchInput").keyup(function (e) {
        filterStandenmotor(e);
    });

    $("#standenmotorTable").click(changeContent);

    $("#close").click(clearFields);

    $("#add_standenmotor").click(function () {
        document.getElementById("myModal").style.display = "block";
    });
}

function loadStandenmotor() {
    $.get("localhost:8888/standenmotor/standenmotor", function (data) {
        var countryTable = $("#standenmotorTable");
        $.each(data, function (index, object) {
            var String =
                "<tr id='row" +
                index +
                "'>" +
                "<td class='code_row'>" +
                object.punten +
                "</td>" +
                "<td>" +
                object.doelpuntenvoor +
                "</td>" +
                "<td>" +
                object.doelpuntentegen +
                "</td>" +
                "<td>" +
                object.gewonnenwedstrijden +
                "</td>" +
                "<td>" +
                object.verlorenwedstrijden +
                "</td>" +
                "<td>" +
                object.gelijkewedstrijden +
                "</td>" +
                "<td>" +
                object.teamid +
                "</td>" +
                "<td class='delete'>&times;</td>" +
                "</tr>";
            standenmotorTable.append(String);
        });
    });
}