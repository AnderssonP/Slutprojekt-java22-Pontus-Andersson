
<%if(request.getParameter("allow") == null && request.getParameter("denied")== null){
	%>

<form action ="AcceptCookies" class="cookie-container">

	<p>
	We use cookies, please accept that we do!
	</p>
	
	Allow Cookies<input type="checkbox"  name="allow">
	Don´t allow<input type ="checkbox" name="denied">
	<input type="submit" value="submit" class="cookie-btn"/>
		
</form>
<% }else{
}%>