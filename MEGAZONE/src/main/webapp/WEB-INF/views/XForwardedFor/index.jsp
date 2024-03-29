<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<%@ include file="/WEB-INF/views/XForwardedFor/include/common/head.jsp" %>
	
	<body class="sb-nav-fixed">
	
		<%@ include file="/WEB-INF/views/XForwardedFor/include/common/sb-topnav.jsp" %>

		<div id="layoutSidenav">
		
			<%@ include file="/WEB-INF/views/XForwardedFor/include/common/layoutSidenav_nav.jsp" %>
			
			<div id="layoutSidenav_content">
				
				<%@ include file="/WEB-INF/views/XForwardedFor/index/main.jsp" %>
				
				<%@ include file="/WEB-INF/views/XForwardedFor/include/common/footer.jsp" %>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/XForwardedFor/include/common/script.jsp" %>
	</body>
</html>
