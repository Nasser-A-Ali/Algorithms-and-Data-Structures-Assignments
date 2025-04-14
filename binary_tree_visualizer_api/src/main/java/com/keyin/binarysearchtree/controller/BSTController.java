package com.keyin.binarysearchtree.controller;

import com.keyin.binarysearchtree.model.TreeRecord;
import com.keyin.binarysearchtree.service.BSTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BSTController {
    private final BSTService bstService;

    public BSTController(BSTService bstService) {
        this.bstService = bstService;
    }

    // Takes the data and processes them in the service layer to create a binary tree
    @PostMapping("/process-numbers")
    public ResponseEntity<String> processNumbers(
            @RequestBody List<Integer> numbers,
            @RequestParam(defaultValue = "false") boolean balance) {
        try {
            return ResponseEntity.ok(bstService.processNumbers(numbers, balance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Returns all previous processed trees
    @GetMapping("/previous-trees")
    public List<TreeRecord> getPreviousTrees() {
        return bstService.getAllTrees();
    }
}