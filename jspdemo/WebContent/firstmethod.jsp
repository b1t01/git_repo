<html>
<body>

<h1>Hello to lower case with a method</h1>

<%!
  String makeItLower(String s){
	return s.toLowerCase();
}
%>

Lower case:

<%= makeItLower("HELLO WORLD")  %>

</body>
</html>