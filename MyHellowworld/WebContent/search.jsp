<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    <%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC, Inc. Human Resources Portal- Employee Search </title>
</head>
<body>
<font size="+1">
Abc, Inc HUman Resources Portal=Employee Search</font><br>
<hr width="100%" noshade="true">
<html:errors/>
<html:form action="/search">
<table>
<tr>
<td align="right"><bean:message key="label.search.name"/>:<td>
<td><html:text property="name"></html:text></td>
</tr>
<tr>
<td></td>
<td>-- or --</td>
</tr>
<tr>
<td align="right"><bean:message key="label.search.ssNum"/>:<td>
<td><html:text property="ssNum"></html:text></td>
</tr>
<td></td>
<html:submit></html:submit>
</table>
</html:form>
<logic:present name="searchForm" property="results">
<hr width="100% size="1" noshade="true">
<bean:size id="size" name="searchForm" property="results"/>
<logic:equal name="size" value="0">
<font color="red"><cTypeface:Bold>No employee found</cTypeface:Bold></font>
</logic:equal>
<logic:greaterThan name="size" value="0">
<table border="1">
<tr>
<th>Name</th>
<th>Social Security Number</th>
</tr>
<logic:iterate id="result" name="searchForm" property="results">
<tr>
<td><bean:write name="result" property="name"/></td>
<td><bean:write name="result" property="ssNum"/></td>
</tr>
</logic:iterate>
</table>
</logic:greaterThan>
</logic:present>
</body>
</html>