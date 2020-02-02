/*$(document).ready(function() {
    $('#dataTable').DataTable();
});*/


// Define API and load datatable on page refresh
var table;

$(document).ready(function() {
    initDataTable();

    let api = "http://localhost:8080/api/printers";

    getData(api);

    $("#fetchList").click(function() {
        getData(api);
    });

    $("#clearList").click(function() {
        clear();
    });

    $("#dataTable").on( 'click', 'tr', function () {
        console.log("Selected printer: " + table.row(this).data().type + ", id: " + table.row(this).data().id + ", price " + table.row(this).data().price);
    } );
});

// Initialise the datatable
function initDataTable() {

    columns = [
        { "data": "id" },
        { "data": "type" },
        { "data": "price" },
        /*,
        {  "render": function(data, type, row, meta){
            return '<a title="Delete this table" <i class="fa fa-pencil-alt"></i> </a>';
        } },*/
    ];

   table = $('#dataTable').DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    } );
}

function clear(){
    $('#dataTable').DataTable().clear();
    $('#dataTable').DataTable().columns.adjust().draw();
}

function getData(api) {
    $.get(
        {
            url: api,
            dataType: "json",
            success: function (data) {
                if (data) {
                    $('#dataTable').DataTable().clear();
                    $('#dataTable').DataTable().rows.add(data);
                    $('#dataTable').DataTable().columns.adjust().draw();
                }
            }
        }

    );
}


$("#dataTable").on('click', 'tr', function () {
    $("#dataTable").DataTable().row(this).data();
//    alert( 'You clicked on '+ data[0] +'\'s row' );
} );





