package br.com.machadowelton.models.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NegocioException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -84988110022943674L;

	public NegocioException() {}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
	public NegocioException(Throwable thr) {
		super(thr);
	}
	
	public NegocioException(String msg, Throwable thr) {
		super(msg, thr);
	}
	
}
