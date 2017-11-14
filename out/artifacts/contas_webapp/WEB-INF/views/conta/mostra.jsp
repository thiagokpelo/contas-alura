<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: thiagocapelo
  Date: 12/11/17
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Contas</title>
</head>
<body>
<h1>Editar Conta</h1>

<form action="alterarConta" method="post">

    <label for="descricao">Descrição:</label>
    <textarea name="descricao" id="descricao" cols="30" rows="10">
        ${conta.descricao}
    </textarea>
    <br>

    <label for="valor">Valor:</label>
    <input id="valor" name="valor" type="text" value="${conta.valor}">
    <br>

    <label for="tipo">Tipo</label>
    <select name="tipo" id="tipo">
        <option value="ENTRADA" ${conta.tipo == 'ENTRADA' ? 'selected' : ''}>Entrada</option>
        <option value="SAIDA" ${conta.tipo == 'SAIDA' ? 'selected' : ''}>Saída</option>
    </select>
    <br>

    <label for="paga">Pago?</label>
    <input id="paga" name="paga" type="checkbox" ${conta.paga ? 'checked' : ''}>
    <br>

    <label for="dataPagamento">Data de Pagamento:</label>
    <input id="dataPagamento" name="dataPagamento" type="text" value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/>" />

    <input name="id" type="hidden" value="${conta.id}">
    <br>
    <br>

    <button type="submit">Alterar</button>
</form>
</body>
</html>
