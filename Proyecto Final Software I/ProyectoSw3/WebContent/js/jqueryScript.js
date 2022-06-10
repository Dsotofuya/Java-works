/**
 * 
 */
$(document).ready(function() {
	$('#addressSelector').change(function() {
		var addressText = document.getElementById('addressSelector').options[document.getElementById('addressSelector').selectedIndex].text;
		var blockSelector = document.getElementById('blockSelector');
		for (i = 1; i < blockSelector.options.length; i++) {
			if (addressText == blockSelector.options[i].getAttribute("name")) {
				$("#blockSelector option[name='" + blockSelector.options[i].getAttribute("name") + "']").show();
			} else {
				$("#blockSelector option[name='" + blockSelector.options[i].getAttribute("name") + "']").hide();
			}
		}
	})
	$('#blockSelector').change(function() {
		var addressText = document.getElementById('addressSelector').options[document.getElementById('addressSelector').selectedIndex].text;
		var blockText = document.getElementById('blockSelector').options[document.getElementById('blockSelector').selectedIndex].text;
		var numberSelector = document.getElementById('internalIDSelector');
		var compositedName = addressText + "+" + blockText;
		for (i = 1; i < numberSelector.options.length; i++) {
			if (compositedName == numberSelector.options[i].getAttribute("name")) {
				$("#internalIDSelector option[name='" + numberSelector.options[i].getAttribute("name") + "']").show();
			} else {
				$("#internalIDSelector option[name='" + numberSelector.options[i].getAttribute("name") + "']").hide();
			}
		}
	})
});