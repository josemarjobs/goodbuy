<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Lista de Produtos</h2>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Comprar</th>
			<th>Imagem</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="produto" items="${produtoList }">
			<tr>
				<td>${produto.nome }</td>
				<td>${produto.descricao }</td>
				<td>${produto.preco }</td>
				<td>
				<form action="<c:url value="/carrinho" />" method="POST"><input
					type="hidden" name="item.produto.id" value="${produto.id }" /> <input
					type="text" class="qtde" value="1" name="item.quantidade" />
				<button type="submit">Comprar</button>
				</form>
				</td>
				<td><img src="<c:url value="/produtos/${produto.id}/imagem"/>"
					width="70" height="70" /></td>
				<c:if test="${usuarioWeb.logado }">
					<td><a href="<c:url value="/produtos/${produto.id }" />">Editar</a></td>
					<td>
					<form action="<c:url value="/produtos/${produto.id }" />"
						method="POST">
					<button class="link" name="_method" value="DELETE">Remover</button>
					</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
