package com.ex.dao;

import java.util.List;

import com.ex.beans.Bear;
import com.ex.beans.Cave;

public interface Dao {

	List<Bear> getBears();

	List<Cave> getCaves();

	void makeBear(Bear b);

}