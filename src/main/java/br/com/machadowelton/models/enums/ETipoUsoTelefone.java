package br.com.machadowelton.models.enums;

public enum ETipoUsoTelefone {
	
	PESSOAL("PESSOAL"),COMERCIAL("COMERCIAL"), TRABALHO("TRABALHO");
	
	private final String  value;
	
	private ETipoUsoTelefone(String tpoUsoTelefone) {
		this.value = tpoUsoTelefone;
	}
	
	public String toStrig() {
		return this.value;
	}
	
}
