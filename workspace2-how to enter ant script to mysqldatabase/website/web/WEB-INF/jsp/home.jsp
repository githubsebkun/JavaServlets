<%@ page import="de.nava.informa.core.ChannelIF" %> 
<%@ page import="de.nava.informa.core.ItemIF" %> 
<%@ page import="java.util.Iterator" %> 
<jsp:useBean id="channel" scope="request" type="ChannelIF" />
<html>
   <head>
      <title>website</title>
   </head>
   <body>
      <h1>Home</h1>
      <h2><%=channel.getTitle()%></h2>
      <ul>

         <% 
           Iterator it = channel.getItems().iterator();
           while (it.hasNext())
           {
              ItemIF item = (ItemIF) it.next();
         %>
            <li>
               <a href="<%=item.getLink()%>"><%=item.getTitle()%></a>
               <br />
               <%=item.getDescription()%>

            </li>
         <% } %>
      </ul>
   </body>
</html>