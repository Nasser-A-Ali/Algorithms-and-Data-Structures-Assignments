package com.keyin.binarysearchtree.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.binarysearchtree.model.BinarySearchTree;
import com.keyin.binarysearchtree.model.TreeRecord;
import com.keyin.binarysearchtree.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTService {
    private final TreeRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public BSTService(TreeRepository repository) {
        this.repository = repository;
    }

    /* Creates a binary search tree with the list of numbers, optionally balances it,
     * adds it to the database and returns the data as JSON */
    public String processNumbers(List<Integer> numbers, boolean balance) throws JsonProcessingException {
        BinarySearchTree tree = new BinarySearchTree();
        numbers.forEach(tree::insert);
        if (balance) tree.balance();

        String treeJson = objectMapper.writeValueAsString(tree.root);
        repository.save(new TreeRecord(numbers.toString(), treeJson));
        return treeJson;
    }

    public List<TreeRecord> getAllTrees() {
        return (List<TreeRecord>) repository.findAll();
    }
}