<h1>This is from JSP Page</h1>
<br/>
<h1>Model View Injected</h1>
<%= request.getAttribute("mykey") %>
<br/>
<h1>Content from request</h1>
<%= request.getAttribute("hello1") %>
<br/>
<h1>Content from session</h1>
<%= session.getAttribute("hello2") %>