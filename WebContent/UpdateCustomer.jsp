<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UpdateCustomerController" method="post">

	<h2>UPDATE CUSTOMER DETAILS</h2>
	
	Select:<select name="searchCriteria">
	<option value="None">None</option>
		<option value="CI_Customer_ID">Customer ID</option>
		<option value="CI_Cus_SSN_ID">Customer SSN ID</option>
	</select><br/>
	Value:<input type="number" name="searchValue"><br/>
	
	<input type="submit" name="Search" value="Search"><br/>
	
	
	<%
	
		if(session.getAttribute("searchCustomerStatus")!=null)
		{
	
	%>
	
	
	
	
	Customer SSN ID:<input type="number" name="Customer_SSN_ID" value="<%=session.getAttribute("customer_ssn_id") %>" disabled><br/>
	Customer ID:<input type="number" name="Customer_ID" value="<%=session.getAttribute("customer_id") %>" disabled><br/>
	Old Customer Name:<input type="text" name="Old_Customer_Name" value="<%=session.getAttribute("customer_name") %>" disabled><br/>
	New Customer Name:<input type="text" name="New_Customer_Name" placeholder="Enter the new name"><br/>
	Old Address:<input type="text" name="Old_Address" value="<%=session.getAttribute("customer_address") %>" disabled><br/>
	New Address:<input type="text" name="New_Address" placeholder="Enter the new address"><br/>
	Old Age:<input type="number" name="Old_Age" value="<%=session.getAttribute("customer_age") %>" disabled><br/>
	New Age:<input type="number" name="New_Age" placeholder="Enter the new age"><br/>
	
	<font color="red">(<superscript>*</superscript>)Fields are compulsory</font><br/>
	
	<input type="submit" name="Update" value="Update">
	
	<%
	
		}
	
	%>
	
</form>

</body>
</html>