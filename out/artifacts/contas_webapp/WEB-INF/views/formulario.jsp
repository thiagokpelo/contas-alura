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
    <h1>Adicionar Contas</h1>

    <form action="adicionarConta" method="post">

        <label for="descricao">Descrição:</label>
        <textarea name="descricao" id="descricao" cols="30" rows="10"></textarea>
        <br>

        <label for="valor">Valor:</label>
        <input id="valor" name="valor" type="text">
        <br>

        <label for="tipo">Tipo</label>
        <select name="tipo" id="tipo">
            <option value="ENTRADA">Entrada</option>
            <option value="SAIDA">Saída</option>
        </select>

        <br>
        <br>

        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
