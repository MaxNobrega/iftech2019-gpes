package br.ifpb.iftech2019.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Id nao encontrado - "+id);
	}


}
