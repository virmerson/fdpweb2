package br.com.fabricadeprogramador.dao;

public class DAOException extends Exception {

	public DAOException(Throwable e) {
		super(e);
	}

	public DAOException(String msg) {
		super(msg);
	}
	public DAOException(String msg, Throwable e) {
		super(msg, e);
	}
}