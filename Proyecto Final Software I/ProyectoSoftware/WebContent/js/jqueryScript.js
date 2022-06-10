/**
 * 
 */
$(document).ready(function() {

	var addressSelector = document.getElementById('addressSelector');
	var currentValue = addressSelector.options[1].value;
	var index = 0;
	for (i = 0; i < addressSelector.options.length; i++) {
		if (currentValue == addressSelector.options[i].value) {
			$("#addressSelector option[name='" + addressSelector.options[i].getAttribute("name") + "']").eq(index).hide();
			index++;
		} else {
			currentValue = addressSelector.options[i].value;
			index = 0;
		}
	}

	$('#addressSelector').change(function() {
		var addressText = document.getElementById('addressSelector').options[document.getElementById('addressSelector').selectedIndex].text;
		var blockSelector = document.getElementById('blockSelector');
		var currentValue = blockSelector.options[0].value;
		for (i = 0; i < blockSelector.options.length; i++) {
			var niko = blockSelector.options[i];
			if (addressText == blockSelector.options[i].getAttribute("name")) {
				if (currentValue != blockSelector.options[i].value) {
					$(niko).show();
					currentValue = blockSelector.options[i].value;
				} else {
					$(niko).hide();
				}
			} else {
				$(niko).hide();
			}
		}
	})

	$('#blockSelector').change(function() {
		var addressText = document.getElementById('addressSelector').options[document.getElementById('addressSelector').selectedIndex].text;
		var blockText = document.getElementById('blockSelector').options[document.getElementById('blockSelector').selectedIndex].text;
		var internalIDSelector = document.getElementById('internalIDSelector');
		var compositedName = addressText + "+" + blockText;
		for (i = 0; i < internalIDSelector.options.length; i++) {
			var niko = internalIDSelector.options[i];
			if (compositedName == internalIDSelector.options[i].getAttribute("name")) {
				if (currentValue != internalIDSelector.options[i].value) {
					$(niko).show();
					currentValue = internalIDSelector.options[i].value;
				} else {
					$(niko).hide();
				}
			} else {
				$(niko).hide();
			}
		}
	})
});