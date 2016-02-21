package br.com.fabricadeprogramador.dao;

import java.util.List;

public interface DAO<T> {
	public void salvar(T o);
	public void excluir (T o);
	public T buscarPorId(int id);
	public List<T> buscarTodos ();
	public List<Object[]> buscarTodos2 (); 
}