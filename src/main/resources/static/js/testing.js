// alert("Test");

$("h1").click(function(){
  $(this).toggleText("Click me!", "And again!");
});

// $("h1").html("<u>Test title</u>");

$.fn.toggleText = function(t1, t2){
  if (this.text() == t1) this.text(t2);
  else                   this.text(t1);
  return this;
};

function print() {
	let value = $("#fav-animal").val();
	alert(value);
	console.log(value);
}

// $("button").click(function() {
// 	print();
// });

$(".table").click(function() {
    $("#picture").slideToggle();
});

$("#hide-divs").click(function() {
    $("div").toggle(1000);
});

$("#submit-colour").click(function () {
    toggle(
        function() {
            let colour = $("#new-colour").val();
            $(".bluebox").html(colour + " box");
            $(".bluebox").removeClass("bg-primary");
            $(".bluebox").css("background-color",colour);
        },
        function() {
            $(".bluebox").html("blue box");
            $(".bluebox").css({ 'background-color' : '', 'opacity' : '' });
            $(".bluebox").addClass("bg-primary");
        }

    );
});
