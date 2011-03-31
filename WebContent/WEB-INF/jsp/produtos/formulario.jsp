<form id="produtosForm" action="<c:url value="/produtos" />" method="POST">
	<fieldset>
		<legend>Adicionar Produto</legend> 
			<label for="nome">Nome:</label> 
			<input id="nome" name="produto.nome" type="text" value="${produto.nome }" 
			class="required" minlength="3"/>
			<label for="descricao">Descrição:</label> 
			<textarea id="descricao" name="produto.descricao" 
			class="required" maxlength="40">${produto.descricao }</textarea>
			<label for="preco">Preço:</label> 
			<input id="preco" name="produto.preco" type="text" value="${produto.preco }"
			class="required" min="0"/>
			<button type="submit">Enviar</button>
	</fieldset>
</form>
<script type="text/javascript">
	$('#produtosForm').validate();
</script>