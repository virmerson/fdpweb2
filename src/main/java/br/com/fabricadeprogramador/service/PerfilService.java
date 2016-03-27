package br.com.fabricadeprogramador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.dao.DAO;
import br.com.fabricadeprogramador.dao.DAOException;
import br.com.fabricadeprogramador.entidade.Perfil;

@Service
public class PerfilService {

	@Autowired
	@Qualifier("perfilDAO")
	private DAO<Perfil> perfilDAO;
	
	public Perfil salvar(Perfil perfil) throws ServiceException{
		
		
		try {
			return perfilDAO.salvar(perfil);
		} catch (DAOException e) {
			
			throw new ServiceException(e);
		} catch (Exception e){
			throw new ServiceException(e);
		}
		
	}

	public List<Perfil> buscarTodos() {
		return perfilDAO.buscarTodos();
	}

	public void excluir(Perfil perfil) {
		
		perfilDAO.excluir(perfil);
	}

	public Perfil buscarPorId(int id) {
		
		return perfilDAO.buscarPorId(id);
	}
	
}