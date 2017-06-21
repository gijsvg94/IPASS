function addFormulier() {
    $.get("localhost:8888/standenmotor/addFormulier", function (data) {
        var formulierTable = $("#formulierTable");
        $.each(data, function (index, object) {
            var String =
                "<tr id='row" +
                index +
                "'>" +
                "<td class='code_row'>" +
                object.formulierid +
                "</td>" +
                "<td>" +
                object.wedstrijdid +
                "</td>" +
                "<td>" +
                object.opmerkingid +
                "</td>" +
                "<td>" +
                object.teamidthuis +
                "</td>" +
                "<td>" +
                object.teamiduit +
                "</td>" +
                "<td>" +
                object.doelpuntenthuis +
                "</td>" +
                "<td>" +
                object.doelpuntenuit +
                "</td>" +
                "<td class='delete'>&times;</td>" +
                "</tr>";
            formulierTable.append(String);
        });
    });
}
