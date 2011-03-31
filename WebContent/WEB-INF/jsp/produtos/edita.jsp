<form id="produtosForm" action="<c:url value="/produtos/${produto.id }" />" method="POST">
	<fieldset>
		<legend>Editar Produto</legend>
		<input type="hidden" name="produto.id" value="${produto.id }" />
		<label for="nome">Nome:</label> 
		<input id="nome" name="produto.nome" type="text" value="${produto.nome }" 
		class="required" minlength="3"/>
		<label for="descricao">Descrição:</label> 
		<textarea id="descricao" name="produto.descricao" 
		class="required" maxlength="40">${produto.descricao }</textarea>
		<label for="preco">Preço:</label> 
		<input id="preco" name="produto.preco" type="text" value="${produto.preco }"
		class="required" min="0"/>
		
		<button type="submit" name="_method" value="PUT">Enviar</button>
	</fieldset>
</form>
<script type="text/javascript">
	$('#produtosForm').validate();
</script>

<form action="<c:url value="/produtos/${produto.id }/imagem"/>" 
method="POST" enctype="multipart/form-data">
	<fieldset>
		<legend>Upload de Imagem</legend>
		<input type="file" name="imagem" id="imagem" />
		<button type="submit">Enviar</button>
	</fieldset>
</form>
<p><img src="<c:url value="/produtos/${produto.id}/imagem"/>"
					width="70" height="70" /></p>