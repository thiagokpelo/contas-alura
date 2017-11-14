<%--
  Created by IntelliJ IDEA.
  User: thiagocapelo
  Date: 12/11/17
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>

    <script src="resources/js/jquery.js"></script>

    <script>
        function pagaAgora(id) {
            $.post("pagarConta", { id: id }, function() {
                $('#conta_' + id).html("Paga");
            });
        };
    </script>
</head>
<body>
<table style="height: 10px; width: 775px;" border="1">
        <thead>
            <tr>
                <th>Código</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Tipo</th>
                <th>Pago?</th>
                <th>Data de Pagamento</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${contas}" var="conta">
            <tr>
                <td>${conta.id}</td>
                <td>${conta.descricao}</td>
                <td>${conta.valor}</td>
                <td>${conta.tipo}</td>
                <td>
                    <c:if test="${conta.paga eq false}">
                        Não paga
                    </c:if>
                    <c:if test="${conta.paga eq true}">
                        Paga!
                    </c:if>
                </td>
                <td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
                <td id="conta_${conta.id}">
                    <a href="removerConta?id=${conta.id}">Deletar</a> |
                    <a href="mostrarConta?id=${conta.id}">Alterar</a> |
                    
                    <c:if test="${conta.paga eq false}">
                        <a href="#" onclick="pagaAgora(${conta.id})">Pagar</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
