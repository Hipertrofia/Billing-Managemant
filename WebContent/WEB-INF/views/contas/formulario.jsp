<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri-"http://springframework.org/tag/form" prefix="form" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Conta</title>
</head>
<body>
	<h3>Adicionar contas</h3>
	<form actio="adcionaConta" method="post">
		Descrição:</br>
		<textarea name="descrição" rows ="5" cols="100"></textarea>
		<form:errors path="conta.descricao"/>
		</br>
		Valor: </br>
		<input type="text" name="valor" /></br>
		Tipo:</br>
		<select name="tupo">
			<option value="ENTRADA">ENTRADA</option>
			<option value="SAIDA">SAIDA</option>
		</select>
		</br></br>
		<input type="submit" value="adicionar"/>
	</form>
</body>
</html>