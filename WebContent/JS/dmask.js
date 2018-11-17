$(".telefonemask").mask("(00) 0000-0000");
$(".numbermask").mask("#0000000000");
$(".cep").mask("00000-000")
$(".cep").keyup(() =>{
	if($(".cep").val().length >= 9){
		var ceppss = $(".cep").val();
		$.ajax({
		  url: "https://viacep.com.br/ws/"+ceppss+"/json/",
		}).done(function(ret) {
		  $(".ruacep").val(ret.logradouro);
		  $(".numerocep").val("");
		  $(".bairrocep").val(ret.bairro);
		  $(".cidadecep").html("Cidade de " + ret.localidade);
		});
	}
});