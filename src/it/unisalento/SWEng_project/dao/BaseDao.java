package it.unisalento.SWEng_project.dao;

import java.util.List;

public interface BaseDao<T> {//questa è l'interfaccia di BaseDaoImpl (applicazione del Pattern Bridge)

	public abstract int set(T entity);

	//clazz serve per capire di che oggetto stiamo parlando
	public abstract T get(int id, Class clazz);

	public abstract List<T> getAll(Class clazz);

}