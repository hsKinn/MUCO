<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Movie/resource/js/jquery-1.12.1.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		$("#addNewActor").click( function() {
			
			//invalidation check
			
/* 			if ( $("#actorName").val() == "") {
				alert("plase write actor name");
				return;
			} */
			var form = $("#addNewActorForm");
			//	jQueryObject.attr("attributeName" , "AttributeCost");
			// attr = attribute
			form.attr("method", "POST");
			form.attr("action", "/Movie/addNewActorAction");
			form.submit();
		});
	});

</script>
</head>
<body>

	<form id="addNewActorForm">
		${ ErrorMessage }
		<input type="text" id="actorName" name="actorName" />
		<input type="button" id="addNewActor" value="submit" />
		
	</form>
</body>
</html>