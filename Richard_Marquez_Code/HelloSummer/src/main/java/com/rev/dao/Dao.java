package com.rev.dao;

import com.rev.beans.Bear;
import com.rev.beans.Cave;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Dao {
    List<Bear> getBears();

    List<Cave> getCaves();

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    void makeBear(Bear bear);
}
