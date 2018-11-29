$(document).ready(function () {
    console.log("ready!");
    init();
});

function init() {
    // var data = callMe();
    // console.log("data init: ", data);
    // $('#h2Ajax').append(data);
}

function buildPathParams(params) {
    return "requestMsg=" + params;
}

function callAllPatient() {
    var url = "http://localhost:8091/allPatient";
    callMe(url, function (output) {
        // $('#h2Ajax').html(output[0].age);
        // $('#h2Ajax').append(output[0].age);
        $('#patientTable').DataTable({
            data: output,
            columns: [
                {data: "firstName"},
                {data: "lastName"},
                {data: "age"}
            ]
        });
    });
}

function callAllPatientCri() {
    var url = "http://localhost:8091/patientCri" + "?";
    var obj = JSON.stringify({firstName: "a", lastName: "aa", age: 22});
    var dataParam = buildPathParams(obj);
    url += dataParam;
    callMe(encodeURI(url), function (output) {
        $('#patientTable').DataTable({
            data: output,
            columns: [
                {data: "firstName"},
                {data: "lastName"},
                {data: "age"}
            ]
        });
    });
}

function callMe(url, handleData) {
    var dataMain = "";
    console.log("Hi Javascript");
    $.ajax({
        method: "GET",
        url: url,
    }).done(function(data, textStatus, jqXHR) {
        if (jqXHR.status === 200) {
            handleData(data);
        } else if (jqXHR.status === 204) {
            alert(textStatus)
        }
    }).fail(function(jqXHR, textStatus) {
        console.log(jqXHR, "<>", textStatus);
    });
}