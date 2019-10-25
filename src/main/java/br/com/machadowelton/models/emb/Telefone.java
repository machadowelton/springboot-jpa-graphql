package br.com.machadowelton.models.emb;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import br.com.machadowelton.models.enums.ETipoTelefone;
import br.com.machadowelton.models.enums.ETipoUsoTelefone;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
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
	
}
