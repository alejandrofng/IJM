function validate(file, callBack)
{
	var fileReader = new FileReader();
	var header = "";
	var result;

	fileReader.onloadend = function(e) {
	  var arr = (new Uint8Array(e.target.result)).subarray(0, 4);
	  
	  for(var i = 0; i < arr.length; i++) {
		 header += arr[i].toString(16);
	  }
	  switch (header) {
		case "89504e47":
			type = "image/png";
			result = true;
			break;
		case "47494638":
			type = "image/gif";
			result = true;
			break;
		case "ffd8ffe0": 
		case "ffd8ffe1":
		case "ffd8ffe2":
			type = "image/jpeg";
			result = true;
			break;
		default:
			type = "unknown"; // Or you can use the blob.type as fallback
			result = false;
			break;
	}
	  // Check the file signature against known types
	callBack(result);
	};
	fileReader.readAsArrayBuffer(file);

}