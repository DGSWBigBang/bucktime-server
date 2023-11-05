String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, ''); 
};

jQuery.fn.serializeObject = function() {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                jQuery.each(arr, function() {
                    obj[this.name] = this.value;
                });
            }//if ( arr ) {
        }
    } catch (e) {
        console.error(e.message);
    } finally {
    }
 
    return obj;
};


jQuery.fn.checkRequired = function() {
	const elem = $(this[0]);
    let valid;
    
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "INPUT") {
        	const type = $(elem).attr("type").toUpperCase() || "TEXT";
        	
        	if (type == "TEXT") {
				valid = elem.val().trim().length > 0;
			} else if (type == "RADIO") {
				valid = $("[name='" + elem.attr("name") + "']").is(":checked").length > 0;
			}
        } else if (this[0].tagName && this[0].tagName.toUpperCase() == "TEXTAREA") {
			valid = this[0].value.trim().length > 0;
        } 
    } catch (e) {
		console.error(e.message);
    } finally {
		console.log("valid", valid);		
    }
};
