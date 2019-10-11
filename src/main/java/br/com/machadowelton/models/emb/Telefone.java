package br.com.machadowelton.models.emb;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.machadowelton.models.enums.ETipoTelefone;
import br.com.machadowelton.models.enums.ETipoUsoTelefone;

@Embeddable
public class Telefone {
	
	@NotNull
	private Integer numDDI;
	
	@NotNull
	private Integer numDDD;	
	
	@NotNull
	private Long numTelefone;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ETipoTelefone tpoTelefone;
 
	@Enumerated(EnumType.STRING)
	private ETipoUsoTelefone tpoUsoTelefone;

	public Integer getNumDDI() {
		return numDDI;
	}

	public void setNumDDI(Integer numDDI) {
		this.numDDI = numDDI;
	}

	public Integer getNumDDD() {
		return numDDD;
	}

	public void setNumDDD(Integer numDDD) {
		this.numDDD = numDDD;
	}

	public Long getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(Long numTelefone) {
		this.numTelefone = numTelefone;
	}

	public ETipoTelefone getTpoTelefone() {
		return tpoTelefone;
	}

	public void setTpoTelefone(ETipoTelefone tpoTelefone) {
		this.tpoTelefone = tpoTelefone;
	}

	public ETipoUsoTelefone getTpoUsoTelefone() {
		return tpoUsoTelefone;
	}

	public void setTpoUsoTelefone(ETipoUsoTelefone tpoUsoTelefone) {
		this.tpoUsoTelefone = tpoUsoTelefone;
	}
	
	public String toString() {
		return "["
				+ "numDDI="  + this.numDDI
				+ ", numDDD=" + this.numDDD
				+ ", numTelefone=" + this.numTelefone
				+ ", tpoTelefone=" + this.tpoTelefone
				+ ", tpoUsoTelefone=" + this.tpoUsoTelefone
				+ "]";
	}
	
}
