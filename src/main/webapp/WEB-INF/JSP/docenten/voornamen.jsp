<%--@elvariable id="voornamen" type="be.vdab.servlets.docenten.voornamenservlet"--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<!doctype html>
<html lang="nl">
<head>
    <v:head title="Docenten voornamen"/>
</head>
<body>
    <v:menu/>
    <h1>Docenten voornamen</h1>
    <ul class="zonderbolletjes">
        <c:forEach var="voornaamEnId" items="${voornamen}">
            <c:url value="/docenten/zoeken.htm" var="docentURL">
                <c:param name="id" value="${voornaamEnId.id}"/>
            </c:url>
            <li style="font-size: ${voornaamEnId.voornaam.length() mod 3 + 1}em;">
                <a href="${docentURL}">${voornaamEnId.voornaam}</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>