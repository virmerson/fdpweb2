package br.com.fabricadeprogramador.dao;

public class DAOFactory {
	private static UsuarioDAO usuarioDAO;
	private static EstadoDAO estadoDAO;
	public static DAO getDAO(String nomeDao){
		if (nomeDao.equalsIgnoreCase("usuarioDAO")){
			if (usuarioDAO==null){
				usuarioDAO = new UsuarioDAO();
			}
			return usuarioDAO;
		}else if (nomeDao.equalsIgnoreCase("estadoDAO")){
			if (estadoDAO==null){
				estadoDAO = new EstadoDAO();
			}
			return estadoDAO;
		}
		return null;
	}
}
