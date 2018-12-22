<html>
<head> Confirmation </head>
<%
	//read from data
	String favlang=request.getParameter("favoritelanguage");
	
	//create the cookie
	Cookie cookie=new Cookie("myfavoritelanguage", favlang);
	
	//set the life span of the cookie, (total number of seconds)
	cookie.setMaxAge(60*60*24*365); //<--this is for one year
	
	//send cookie to browser
	response.addCookie(cookie);
%>

<body>
Thanks, we set your favorite language to: ${param.favoritelanguage}
<br/><br/>

<a href="cookies-homepage.jsp"> Return to homepage</a>


</body>

</html>