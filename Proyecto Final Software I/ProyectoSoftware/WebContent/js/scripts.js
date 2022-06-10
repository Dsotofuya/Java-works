/**
 * 
 */

function validDigitInput(evt) {
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

function unlockBlocksByAddress() {
	var blockSelectorText = document.getElementById('blockSelector').options[document.getElementById('blockSelector').selectedIndex].text;
	var internalIDSelectorText = document.getElementById('internalIDSelector').options[document.getElementById('internalIDSelector').selectedIndex].text;
	var blockSelector = document.getElementById('blockSelector');
	var internalIDSelector = document.getElementById('internalIDSelector');
	if (blockSelectorText != blockSelector.options[0].value) {
		if (blockSelector.disabled == false) {
			document.getElementById("blockSelector")[0].selected = 'selected';
		} else {
			document.getElementById("blockSelector").disabled = false;
		}
	}
	if (internalIDSelectorText != internalIDSelector.options[0].value && internalIDSelector.disabled == false) {
		document.getElementById("internalIDSelector")[0].selected = 'selected';
	}
}

function unlockinternalIDSelectorByBlock() {
	var internalIDSelectorText = document.getElementById('internalIDSelector').options[document.getElementById('internalIDSelector').selectedIndex].text;
	var internalIDSelector = document.getElementById('internalIDSelector');
	if (internalIDSelector.disabled == false) {
		if (internalIDSelectorText != internalIDSelector.options[0].value) {
			document.getElementById("internalIDSelector")[0].selected = 'selected';
		}
	} else {
		document.getElementById("internalIDSelector").disabled = false;
	}
}

function validLettersInput(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	evt = (evt) ? evt : window.event;
	var flag = false;
	if (charCode > 96 && charCode < 123 || evt.keyCode > 64 && evt.keyCode < 91 || evt.keyCode == 8 || evt.keyCode == 9) {
		flag = true;
		}
	return flag;
	}
	
function validNumberInput(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	evt = (evt) ? evt : window.event;
	var flag = false;
	if (charCode > 47 && charCode < 58 || evt.keyCode == 8 || evt.keyCode == 9) {
		flag = true;
		}
	return flag;
	}