package com.axiom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.axiom.entity.MobileHandSet;

public interface MobileHandSetRepo extends CrudRepository<MobileHandSet, Long>, QueryByExampleExecutor<MobileHandSet> {

}
