package com.keyin.binarysearchtree.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.binarysearchtree.model.BinaryNode;
import com.keyin.binarysearchtree.model.BinarySearchTree;
import com.keyin.binarysearchtree.model.TreeRecord;
import com.keyin.binarysearchtree.repository.TreeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BSTServiceTest {

    @Mock
    private TreeRepository repository;

    @InjectMocks
    private BSTService bstService;

    private String toJson(BinaryNode root) throws Exception {
        return new ObjectMapper().writeValueAsString(root);
    }

    @Test
    void testProcessNumbersBalancedTree() throws Exception {
        List<Integer> numbers = Arrays.asList(5, 3, 7, 2, 4, 6, 8);
        BinarySearchTree expectedTree = new BinarySearchTree();
        numbers.forEach(expectedTree::insert);
        expectedTree.balance();
        String expectedJson = toJson(expectedTree.root);

        when(repository.save(any(TreeRecord.class))).thenReturn(null);

        String actualJson = bstService.processNumbers(numbers, true);

        assertEquals(expectedJson, actualJson);
        verify(repository, times(1)).save(any(TreeRecord.class));
    }

    @Test
    void testProcessNumbersUnbalancedTree() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        BinarySearchTree expectedTree = new BinarySearchTree();
        numbers.forEach(expectedTree::insert);
        String expectedJson = toJson(expectedTree.root);

        when(repository.save(any(TreeRecord.class))).thenReturn(null);

        String actualJson = bstService.processNumbers(numbers, false);

        assertEquals(expectedJson, actualJson);
        verify(repository, times(1)).save(any(TreeRecord.class));
    }

    @Test
    void testProcessNumbersEmptyList() throws Exception {
        List<Integer> numbers = Collections.emptyList();
        String expectedJson = toJson(null); // Empty list results in a null root

        when(repository.save(any(TreeRecord.class))).thenReturn(null);

        String actualJson = bstService.processNumbers(numbers, false);

        assertEquals(expectedJson, actualJson);
        verify(repository, times(1)).save(any(TreeRecord.class));
    }

    @Test
    void testGetAllTrees() {
        List<TreeRecord> expectedTrees = Arrays.asList(
                new TreeRecord("[1, 2, 3]", "{\"value\":1,\"left\":{\"value\":2,\"left\":{\"value\":3,\"left\":null,\"right\":null},\"right\":null},\"right\":null}"),
                new TreeRecord("[5, 3, 7]", "{\"value\":5,\"left\":{\"value\":3,\"left\":null,\"right\":null},\"right\":{\"value\":7,\"left\":null,\"right\":null}}")
        );
        when(repository.findAll()).thenReturn(expectedTrees);

        List<TreeRecord> actualTrees = bstService.getAllTrees();

        assertEquals(expectedTrees.size(), actualTrees.size());
        // Need to compare content
        for (int i = 0; i < expectedTrees.size(); i++) {
            assertEquals(expectedTrees.get(i).getInputNumbers(), actualTrees.get(i).getInputNumbers());
            assertEquals(expectedTrees.get(i).getTreeStructure(), actualTrees.get(i).getTreeStructure()); // Corrected getter
        }
        verify(repository, times(1)).findAll();
    }
}