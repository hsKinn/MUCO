<!-- test -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<!-- Log out -->
<jsp:include page="/WEB-INF/view/member/logout.jsp"></jsp:include>

<!-- Left Menu -->
<jsp:include page="/WEB-INF/view/common/leftMenu.jsp"></jsp:include>

<script type="text/javascript">
	function readURL(input) {

		document.getElementById("imgFile").required;
		document.getElementById("imgFile").accept = "img/*";
		var x = document.getElementById("imgFile");
		var txt = "";
		if ('files' in x) {
			if (x.files.length == 0) {
				txt = "Select one or more files.";
			} else {
				for (var i = 0; i < x.files.length; i++) {
					txt += "<br><strong>" + (i + 1) + ". file</strong><br>";
					var file = x.files[i];
					if ('name' in file) {
						txt += "name: " + file.name + "<br>";
					}
					if ('size' in file) {
						txt += "size: " + file.size + " bytes <br>";
					}
				}
			}
		} else {
			if (x.value == "") {
				txt += "Select one or more files.";
			} else {
				txt += "The files property is not supported by your browser!";
				txt += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead. 
			}
			document.getElementById("demo").innerHTML = txt;
		}

		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#imagePreview").show();
				$('#uploadImg').attr("src", e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>











<div onload="readURL(this)">
	<input type="file" name="imgFile" id="imgFile" style="display: none;"
		multiple size="50" accept="image/*" onchange="readURL(this);" required>
	<button type="button" class="btn btn-default btn-sm"
		onclick="document.all.imgFile.click();">
		<img src="<c:url value="/resource/img/place/btn-image.png" />" />
	</button>
	<p id="demo"></p>
	<table>
		<tr>
			<td align="center" id='imagePreview'>미리보기</td>
			<td align="center" id='uploadImg'></td>

		</tr>
	</table>
</div>












<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>