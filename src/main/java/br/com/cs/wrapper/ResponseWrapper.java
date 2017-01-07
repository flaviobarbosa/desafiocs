package br.com.cs.wrapper;

public class ResponseWrapper {

	private String mensagem;
	
	public ResponseWrapper(String message) {
		this.mensagem = message;
	}

	public String getMessage() {
		return mensagem;
	}

	public void setMessage(String message) {
		this.mensagem = message;
	}
}

