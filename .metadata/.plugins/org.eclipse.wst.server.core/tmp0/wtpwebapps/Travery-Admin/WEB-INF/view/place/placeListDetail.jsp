<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Place Detail</title>
</head>
<body>

<div id="detailWrapper">
	<table id="detailTable">
		<tr>
			<th>여행지ID</th>
			<th>여행지명</th>
			<th>주소</th>
			<th>조회수</th>
			<th>추천수</th>
			<th>최조등록자 이름</th>
			<th>도시ID</th>
		</tr>

		<tr>
			<td>${placeDetail.placeId}</td>
			<td>${placeDetail.placeName}</td>
			<td>${placeDetail.address}</td>
			<td>${placeDetail.viewCount}</td>
			<td>${placeDetail.likeCount}</td>
			<td>${placeDetail.email}최조등록자 이름</td>
			<td>${placeDetail.email}도시ID</td>
		</tr>

		<tr>
			<th colspan="7">여행지 설명</th>
		</tr>

		<tr>
			<td id="articleDescript" colspan="7">${placeDetail.description}</td>
		</tr>

		<tr>
			<th colspan="7">여행지 이미지</th>
		</tr>

		<tr>
			<td colspan="6">
				여행지 이미지 넣기! here! 
			</td>
		</tr>
	</table>

	
</div>	


</body>
</html>