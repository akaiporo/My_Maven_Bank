package manager;

import java.util.List;

import javax.ejb.Stateless;

public interface Manager {
	/**
	 * Push l'objet 'o' en base
	 * @param o
	 */
	public void save(Object o);
	/**
	 * Update l'objet 'o' contenant l'id passé
	 * @param o
	 * @param id
	 */
	public void save(Object o, int id);
	/**
	 * 
	 * @param id
	 * @return un objet 'o' contenant l'id passé
	 */
	public Object findById(int id);
	/**
	 * 
	 * @param name
	 * @return une liste d'objets 'o' de nom 'name'. 
	 * Retourne une liste de 1 objet si plusieurs objets ont le même nom
	 */
	public List<Object> findByName(String name);
}
