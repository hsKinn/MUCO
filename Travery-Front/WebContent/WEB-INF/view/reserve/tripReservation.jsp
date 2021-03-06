<!-- 유병훈 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		$("#reserveSubminBtn").click(function(){

			 var departure = $("#departure").val();
			 departure = $.trim(departure);
	         if (departure == "") {
	            alert("출발지를 입력하세요!");
	            $("#departure").focus();
	            return;
	         }
	         
	         var departureDate = $("#departureDate").val();
	         departureDate = $.trim(departureDate);
	         if (departureDate == "") {
	            alert("출발일을 입력하세요!");
	            $("#departureDate").focus();
	            return;
	         }
	         
	         var destinationDate = $("#destinationDate").val();
	         destinationDate = $.trim(destinationDate);
	         if (destinationDate == "") {
	            alert("도착일를 입력하세요!");
	            $("#destinationDate").focus();
	            return;
	         }
	         
	         var checkIn = $("#checkIn").val();
	         checkIn = $.trim(checkIn);
	         if (checkIn == "") {
	            alert("체크인날짜를 입력하세요!");
	            $("#checkIn").focus();
	            return;
	         }
	         
	         var checkOut = $("#checkOut").val();
	         checkOut = $.trim(checkOut);
	         if (checkOut == "") {
	            alert("체크아웃날짜를 입력하세요!");
	            $("#checkOut").focus();
	            return;
	         }
	         
	         var rentDate = $("#rentDate").val();
	         rentDate = $.trim(rentDate);
	         if (rentDate == "") {
	            alert("대여날짜를 입력하세요!");
	            $("#rentDate").focus();
	            return;
	         }
	         
	         var returnDate = $("#returnDate").val();
	         returnDate = $.trim(returnDate);
	         if (returnDate == "") {
	            alert("반납날짜를 입력하세요!");
	            $("#returnDate").focus();
	            return;
	         } 
			
			if (confirm("위 정보로 예약하시겠습니까?")) {
				var form = $("#reservationForm");
				form.attr("method", "post");
				form.attr("action", "/doTripReservation");
				form.submit();
				alert("예약되었습니다.");
				return;
			}
		});
	});
</script>


<section class="bg-primary">
	<div class="container" >
		<!-- Trip Reservation -->
		<!-- 제목 -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">TRIP RESERVATION</h2>
			<hr class="primary">
			<p>For easy trip reservation.</p>
		</div>
		
		<!-- 내용 -->
		<div id="tripReservationWrapper" style=" width:90%; margin:auto;">
			<form id="reservationForm">


				<!-- 출발,여행지 입력 -->
				<div class="form-group">

					<label for="departure">Departure: <input type="text"
						class="form-control" id="departure" name="departure" />
					</label> <img src="/resource/img/reserve/arrow.png" style="height: 20px;" />
					<label for="destination">Place: <select class="form-control"
						id="destination" name="destination" style="width: 200px;">
							<c:forEach items="${loginUserPackList }" var="myDestinationPack">
							<option value="${myDestinationPack.packId }">${myDestinationPack.packTitle }</option>
							</c:forEach>
					</select>
					</label>

				</div>

				<hr>

				<!-- 교통 입력 -->
				<div class="form-group">

					<label for="traffic">Traffic: <input type="text"
						disabled="disabled" value="AirPlane" class="form-control" id="traffic" name="traffic" />
					</label> <label for="grade">Grade: <select class="form-control"
						id="traGrade" name="traGrade" style="width: 200px;">
							<option >Economy</option>
							<option >Business</option>
					</select>
					</label> <label for="departureDate">Departure day: <input type="date"
						class="form-control" id="departureDate" name="departureDate" />
					</label> <label for="destinationDate">Return date: <input type="date"
						class="form-control" id="destinationDate" name="destinationDate" />
					</label> <label for="traPerson">Person: <input type="number"
						class="form-control" id="traPerson" name="traPerson" value="1" />
					</label>

				</div>

				<hr>

				<!-- 숙소 입력 -->
				<div class="form-group">

					<label for="accommodations">Lodgment: <select
						class="form-control" id="accommodations" name="accommodations" style="width: 200px;">
							<option>Hotel</option>
							<option>Hostel</option>
							<option>Guest House</option>
					</select>
					</label> <label for="accGrade">Grade: <select class="form-control"
						id="accGrade" name="accGrade" style="width: 200px;">
							<option>Single</option>
							<option>Double</option>
							<option>Triple</option>
							<option>Quad</option>
							<option>Both</option>
							<option>Man Only</option>
							<option>Women Only</option>
					</select>
					</label> <label for="checkIn">Check In: <input type="date"
						class="form-control" id="checkIn" name="checkIn" />
					</label> <label for="checkOut">Check Out: <input type="date"
						class="form-control" id="checkOut" name="checkOut" />
					</label> <label for="accPerson">Person: <input type="number"
						class="form-control" id="accPerson" name="accPerson" value="1" />
					</label>

				</div>

				<hr>

				<!-- 렌트 입력 -->
				<div class="form-group">

					<label for="rentCar">Rent: <select class="form-control"
						id="rentCar" name="rentCar"style="width: 200px;">
							<option>Large</option>
							<option>Middle</option>
							<option>Small</option>
							<option>Compact</option>
							<option>Suv</option>
					</select>
					</label> <label for="rentDate">Rent Date: <input type="date"
						class="form-control" id="rentDate" name="rentDate" />
					</label> <label for="returnDate">Return Date: <input type="date"
						class="form-control" id="returnDate" name="returnDate" />
					</label> <label for="rentPerson">Person: <input type="number"
						class="form-control" id="rentPerson" name="rentPerson" value="1" />
					</label>

				</div>

				<hr>

				<!-- 제출 -->
				<div id="reserveSubmit">
					<button type="submit" class="btn btn-default" id="reserveSubminBtn"
						name="reserveSubminBtn">Submit</button>
				</div>

			</form>

		</div>

	</div>
</section>
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>