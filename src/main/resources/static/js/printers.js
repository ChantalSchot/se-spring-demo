const api = "http://localhost:8080/api/printers";


// Requests:

// GET PRINTERLIST
function getPrinterList() {
    console.log("Creating printer list...")

    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        contentType: "application/json",
        success: function (result) {
            showList(result);
        },
        error: function (error) {
            console.log(error);
        }
    });
};

// GET INDIVIDUAL PRINTER
function getPrinter() {
    var id = +$("#printerId").val();
    console.log("Getting printer with id " + id);


    $.ajax({
        url: api + "/" + id,
        type: "get",
        dataType: "json",
        contentType: "application/json",
        success: function (result) {
            showPrinter(result);
            $("#printerId").val("")
        },
        error: function (error) {
            console.log(error);
        }
    });
};

/* ===================== A J A X ===================== */
// POST PRINTER
function postData() {
    var type = $("#type").val();
    var price = $("#price").val();
    console.log("Creating printer of type " + type + " for price " + price);

    var printerObject = {
        type: $("#type").val(),
        price: $("#price").val(),
    }
    console.log("new printerObject = " + printerObject);

    var jsonObject = JSON.stringify(printerObject);
    console.log("new jsonObject = " + jsonObject);

    $.ajax({
        url: api,
        type: "post",
        data: jsonObject,
        contentType: "application/json",
        success: function(newPrinter) {
            console.log("New printer posted: " + newPrinter);
            getPrinterList();
                $("#type").val(""),
                $("#price").val("")
        }
    })


}


// DELETE PRINTER


// PUT PRINTER (edit attributes)




/* ===================== FRONT END OUTPUT ===================== */
function showList(result){
    console.log("Current printers: " + result);
    let list = "";
    $.each(result, function(index, value) {
        list += "Printer id: " + value.id +  "<br>Printer type: " + value.type + "<br> Printer price: $" + value.price + "<br><br>";
    });
    $("#printer-list").html(list);
};

function showPrinter(result){
    console.log("Current printer: " + result);
    let printer = "Printer id: " + result.id +  "<br>Printer type: " + result.type + "<br> Printer price: $" + result.price + "<br><br>";
    $("#printer-list").html(printer);
};



/* ===================== CLICK FUNCTIONS ===================== */

$("#post-printer").click(postData);

$("#get-printers").click(function () {
        console.log($("#printerId").val());
    if ( +$("#printerId").val() === 0) {
        getPrinterList();
    }
    else {
        getPrinter();
    }
});