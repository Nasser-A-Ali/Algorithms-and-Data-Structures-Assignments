package com.keyin.binarysearchtree.repository;

import com.keyin.binarysearchtree.model.TreeRecord;
import org.springframework.data.repository.CrudRepository;

public interface TreeRepository extends CrudRepository<TreeRecord, Long> {
}