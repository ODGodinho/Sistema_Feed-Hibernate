function startLoad(){
	document.querySelector("#loadSpinner").style.display = "table";
}

function endLoad(){
	document.querySelector("#loadSpinner").style.display = "none";
}

window.addEventListener("load", () => {
	endLoad();
})