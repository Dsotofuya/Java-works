/**
 * 
 */

/*window.onload = function() {
	let checkNavigation = performance.getEntriesByType("navigation");
	for (let i = 0; i < checkNavigation.length; i++) {
		if (checkNavigation[i].type === "back_forward") {
			document.getElementById("adviceWrapper").style.display = "none";
			document.getElementById("buttonWrapper").style.display = "block";
		}
	}
}*/

/*window.addEventListener('load', function(){
	if(performance.getEntriesByType("navigation")[0].type === "back_forward"){
		document.getElementById("adviceWrapper").style.display = "none";
		document.getElementById("buttonWrapper").style.display = "block";
	}
})*/

function validDigitInput(evt, componentName, value, maxValue) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	evt = (evt) ? evt : window.event;
	var flag = false;
	if (charCode > 47 && charCode < 58 || evt.keyCode == 8 || evt.keyCode == 9) {
		flag = true;
	}
	return flag;
}

function doAlert(checkboxElem, elementName) {
	var element = document.getElementById(elementName + "amount");
	if (checkboxElem.checked) {
		if (element.value < 2) {
			element.value = "1";
			document.getElementById("secret").classList.add("hidden");
		}
	} else {
		document.getElementById(elementName + "amount").value = "";
	}
}

/*let option = document.createElement("option");
	option.text = blockOptions[i].value;
	blockSelector.add(option); 
	blockOptions[i].innerHTML = "Water";
	*/

function unlockBlocksByAddress() {
	document.getElementById("blockSelector").disabled = false;
}

function unlockinternalIDSelectorByBlock() {
 	document.getElementById("internalIDSelector").disabled = false;
}