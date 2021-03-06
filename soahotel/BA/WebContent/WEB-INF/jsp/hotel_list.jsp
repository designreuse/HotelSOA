<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<body>


	<jsp:include page="menu.jsp" />
	<jsp:include page="hotel_links.jsp" />

	<!-- Page Content -->
	<div class="container">
		<div class="hotelList">
			<c:if test="${not empty hotelList}">
				<ul>
					<c:forEach var="hotel" items="${hotelList}">
						<li><a href="hotel_info?id=${hotel.id}">${hotel.name}</a></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<!-- /.container -->
	<!-- jQuery -->
	<script src="js/jquery.js" ></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js" ></script>
</body>
</html>