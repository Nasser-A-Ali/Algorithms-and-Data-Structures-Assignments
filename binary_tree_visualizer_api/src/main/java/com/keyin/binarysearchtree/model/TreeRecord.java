package com.keyin.binarysearchtree.model;

import jakarta.persistence.*;

@Entity
public class TreeRecord {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inputNumbers;
    @Column(columnDefinition = "TEXT")
    private String treeStructure;

    // Parameterized Constructor
    public TreeRecord(String inputNumbers, String treeStructure) {
        this.inputNumbers = inputNumbers;
        this.treeStructure = treeStructure;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInputNumbers() { return inputNumbers; }
    public void setInputNumbers(String inputNumbers) { this.inputNumbers = inputNumbers; }
    public String getTreeStructure() { return treeStructure; }
    public void setTreeStructure(String treeStructure) { this.treeStructure = treeStructure; }
}