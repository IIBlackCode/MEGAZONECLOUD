<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="/WEB-INF/views/include/common/head.jsp" %>

<body class="bg-theme bg-theme1">

<!-- Start wrapper-->
<div id="wrapper">
 
<%@ include file="/WEB-INF/views/include/common/sidebar.jsp" %>
<%@ include file="/WEB-INF/views/include/common/header.jsp" %>
	
<div class="content-wrapper">
<div class="container-fluid">

<!--Start Dashboard Content-->
<%@ include file="/WEB-INF/views/Dashboard/Count.jsp" %>
<%@ include file="/WEB-INF/views/Dashboard/Graph.jsp" %>
<%@ include file="/WEB-INF/views/Dashboard/Table.jsp" %> 
<!--End Dashboard Content-->

<!--start overlay-->
<div class="overlay toggle-menu"></div>
<!--end overlay-->

</div><!-- End container-fluid-->
<%@ include file="/WEB-INF/views/include/common/footer.jsp" %>

</div><!--End content-wrapper-->
</div><!--End wrapper-->

<%@ include file="/WEB-INF/views/include/common/commonJS.jsp" %>

</body>
</html>
