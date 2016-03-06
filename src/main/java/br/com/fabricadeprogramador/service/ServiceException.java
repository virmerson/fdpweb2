package br.com.fabricadeprogramador.service;

public class ServiceException extends Exception {

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e);
	}

}
