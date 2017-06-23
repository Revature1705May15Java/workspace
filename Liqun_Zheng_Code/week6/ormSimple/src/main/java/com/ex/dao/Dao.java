package com.ex.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ex.beans.Bear;
import com.ex.beans.Cave;

public interface Dao {

	List<Bear> getBears();

	List<Cave> getCaves();

	void makeBear(Bear bear);

}