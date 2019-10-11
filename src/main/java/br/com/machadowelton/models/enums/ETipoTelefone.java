package br.com.machadowelton.models.enums;

public enum ETipoTelefone {
	
	CELULAR("CELULAR"), FIXO("FIXO");
	
	private final String value;
	
	private ETipoTelefone(String tpoTelefone) {
		this.value = tpoTelefone;
	}
	
	public String toString() {
		return this.value;
	}
	
}
