package com.ex.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Bear;
import com.ex.beans.Cave;

public interface DAO {

  void setSessionFactory(SessionFactory sessionFactory);

  List<Bear> getBears();

  List<Cave> getCaves();

  void makeBear(Bear bear);

}