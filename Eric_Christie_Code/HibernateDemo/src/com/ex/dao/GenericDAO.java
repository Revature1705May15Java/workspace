package com.ex.dao;

import java.util.Collection;

public interface GenericDAO<E> {

  void create(E e);
  E getById(int id);
  Collection<E> getAll();
  void update(E e);
  void delete(E e);
  void deleteById(int id);
}
