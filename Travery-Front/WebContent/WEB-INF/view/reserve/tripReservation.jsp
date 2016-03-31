<!-- 유병훈 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {

	});
</script>


<section class="bg-primary" id="one">
	<div class="container">
		<!-- Trip Reservation -->
		<div class="col-lg-8 col-lg-offset-2 text-center">
			<h2 class="margin-top-0 wow fadeIn">TRIP RESERVATION</h2>
			<hr class="primary">
			<p>손 쉽게 여행 예약을 할 수 있는 기능</p>
		</div>
		
		<div id="tripReservationWrapper">
			<form id="reservationForm">


				<!-- 출발,여행지 입력 -->
				<div class="form-group">

					<label for="departure">출발지: <input type="text"
						class="form-control" id="departure" />
					</label> <img src="/resource/img/reserve/arrow.png" style="height: 20px;" />
					<label for="destination">여행지: <select class="form-control"
						id="destination" style="width: 200px;">
							<option>my list</option>
							<option>my list</option>
							<option>my list</option>
							<option>my list</option>
					</select>
					</label>

				</div>

				<hr>

				<!-- 교통 입력 -->
				<div class="form-group">

					<label for="traffic">교통: <input type="text"
						disabled="disabled" value="비행기" class="form-control" id="traffic" />
					</label> <label for="grade">등급: <select class="form-control"
						id="grade" style="width: 200px;">
							<option>이코노미</option>
							<option>비지니스</option>
					</select>
					</label> <label for="departureDate">출국일: <input type="date"
						class="form-control" id="departureDate" />
					</label> <label for="destinationDate">귀국일: <input type="date"
						class="form-control" id="destinationDate" />
					</label> <label for="traPerson">인원: <input type="number"
						class="form-control" id="traPerson" value="1" />
					</label>

				</div>

				<hr>

				<!-- 숙소 입력 -->
				<div class="form-group">

					<label for="accommodations">숙소: <select
						class="form-control" id="accommodations" style="width: 200px;">
							<option>호텔</option>
							<option>호스텔</option>
							<option>게스트하우스</option>
					</select>
					</label> <label for="accGrade">등급: <select class="form-control"
						id="accGrade" style="width: 200px;">
							<option>1인실</option>
							<option>2인실</option>
							<option>3인실</option>
							<option>4인실</option>
							<option>남녀혼용</option>
							<option>남자전용</option>
							<option>여자전용</option>
					</select>
					</label> <label for="checkIn">체크인: <input type="date"
						class="form-control" id="checkIn" />
					</label> <label for="checkOut">체크아웃: <input type="date"
						class="form-control" id="checkOut" />
					</label> <label for="accPerson">인원: <input type="number"
						class="form-control" id="accPerson" value="1" />
					</label>

				</div>

				<hr>

				<!-- 렌트 입력 -->
				<div class="form-group">

					<label for="rentCar">렌트카: <select class="form-control"
						id="rentCar" style="width: 200px;">
							<option>대형</option>
							<option>중형</option>
							<option>소형</option>
							<option>경차</option>
							<option>suv</option>
					</select>
					</label> <label for="rentDate">대여일: <input type="date"
						class="form-control" id="rentDate" />
					</label> <label for="returnDate">반납일: <input type="date"
						class="form-control" id="returnDate" />
					</label> <label for="rentPerson">인원: <input type="number"
						class="form-control" id="rentPerson" value="1" />
					</label>

				</div>

				<hr>

				<!-- 제출 -->
				<div id="reserveSubmit">
					<button type="submit" class="btn btn-default" id="subminBtn"
						name="subminBtn">제출</button>
				</div>

			</form>

		</div>

	</div>
</section>
<!-- Footer -->
<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>