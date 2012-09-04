<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- 	pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--     <link rel="stylesheet" href="http://yuilibrary.com/combo/css?main-min.css"> -->

<title>Insert title here</title>
</head>
<body class="yui3-skin-sam">

	<script src="http://yui.yahooapis.com/3.6.0/build/yui/yui-min.js"
		type="text/javascript"></script> 

	<div id="hotels"></div>

	<script type="text/javascript">
	//alert("testing")
    </script>
	<script type="text/javascript">
	YUI()
		.use(
			"datatable",
			"datasource-get",
			"datasource-jsonschema",
			"datatable-datasource",
			function(Y) {
			    var json = ${json};			    {
			    var table = new Y.DataTable(
				    {
					columns : [ "Name", "CostRate",
						"ReviewRate" ],
					data : json.ResultSet.Result,
					// Optionally configure your table with a caption
					caption : "My first DataTable!",
					// and/or a summary (table attribute)
					summary : "Example DataTable showing basic instantiation configuration"
				    });
			    table.render("#example");
			});
    </script>
</body>
</html>