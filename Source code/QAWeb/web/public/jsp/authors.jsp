<%--
    Document   : search
    Created on : Sep 3, 2010, 9:21:15 PM
    Author     : Hoang-PC
--%>
<%@page import="uit.qass.model.Author"%>
<%@page import="uit.qass.dblp.AuthorUtil"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean-el" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="l"%>
<%
List<String> authors    =   AuthorUtil.getListAuthorFromListObj((List<Author>) request.getAttribute("objs"));
request.setAttribute("authors", authors);
%>
<td class="bg4">
    <div>
       
        <!--Show all authors which you search-->
        <div style="text-align: left;background-color: transparent;">
            <span style="color: green"><c:out value="${warning}"/></span>
            <ul>
            <c:forEach var="au" items="${authors}">
                <li style="display: inline-block;width: 200px;">
                    <html:link href="showPubsByAuthor.do?authorName=${au}">
                        <c:out value="${au}"/>
                    </html:link>
                </li>
            </c:forEach>
            </ul>
        </div>
    </div
</td>
