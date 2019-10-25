package br.com.machadowelton.models;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.machadowelton.models.audit.AuditModel;
import br.com.machadowelton.models.emb.Telefone;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
public class Usuario extends AuditModel {
	
	private static final long serialVersionUID = -4563495439888044903L;

	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private Long id;
	
	@NotNull
	private String nomUsuario;
	
	@Embedded
	private Telefone telefone;
	
	@Temporal(TemporalType.DATE)
	private Date datNascimento;
}
