window.onload = function () {
	$("#search_id").on("click", search);
}

function search(){
	var searchText = $("#search_text").val().trim();
	window.location.href="about.html?searchText="+encodeURI(searchText)	;
}