<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<body>


	<jsp:include page="menu.jsp" />
	<jsp:include page="hotel_links.jsp" />

	<!-- Page Content -->
	<div class="container">
		<div class="section">
			<div class="button editButton">
				<a href="hotel_edit?id=${hotel.id}"> <span
					class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				</a>
			</div>

			<%-- <form:form id="removeForm" action="hotelRemove?id=${hotel.id}" method="POST">--%>
			<div class="button removeButton">
				<!-- <input id="submit" type="image" class="glyphicon glyphicon-remove" alt=" "/> -->
				<a href="hotelRemove?id=${hotel.id}"><span id="removeButton"
					class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>

			</div>
			<%-- 	</form:form>
 --%>

			<div class="sectionLabel">
				<spring:message code="label.basic_information" />
			</div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.hotel_name" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.name}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.hotel_desc" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.desc}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.hotel_avg_rate" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.averageRate}" />
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="section">
			<div class="sectionLabel">
				<spring:message code="label.address" />
			</div>

			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.street" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.street}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.house_number" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.houseNumber}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.postal_code" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.postalCode}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.city" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.city}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.state" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.state}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.country" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.country}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.longitude" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.longitude}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.latitude" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.address.latitude}" />
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="section">
			<div class="sectionLabel">
				<spring:message code="label.contact" />
			</div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.phone_number" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.contact.phone}" />
				</div>
			</div>
			<div class="clear"></div>
			<div class="output">
				<div class="tableLeft">
					<spring:message code="label.mail" />
				</div>
				<div class="tableRight">
					<c:out value="${hotel.contact.mail}" />
				</div>
			</div>
			<div class="clear"></div>
		</div>

		<div class="section" id="reservations">
			<div class="sectionLabel">
				<spring:message code="label.reservations" />
			</div>
			<c:forEach var="reservation" items="${reservations}">
				<div class="output">
					<div class="tableLeft">
						<a href="reservationInfo?id=${reservation.id}">
							<c:out value="${reservation.room.number}" />
							<c:out value="${reservation.account.firstName}" />
							<c:out value="${reservation.account.lastName}" />
						</a>
					</div>
					<div class="tableRight">
						<a href="remove_reservation?id=${reservation.id}">
							<span id="removeButton" class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</a>
					</div>
					<div class="clear"></div>
				</div>
			</c:forEach>
		</div>

		<div class="section">
			<div class="sectionLabel">
				<spring:message code="label.rooms" />
			</div>
			<c:forEach var="room" items="${rooms}">
				<div class="output">
					<div class="tableRight">
						<c:out value="${room.roomType.name}" />
						<c:out value=" ${room.size}" />
						<c:out value=" ${room.roomType.price}" />
					</div>
					<div class="clear"></div>
				</div>
			</c:forEach>
			<div class="tableRight">
				<a href="add_room?id=${hotel.id}">
					<span id="addButton" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					<spring:message code="label.add_room" />
				</a>
			</div>
		</div>
	</div>

	<!-- /.container -->
	<!-- jQuery -->
	<script src="js/jquery.js" ></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js" ></script>
</body>
</html>