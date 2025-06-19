package com.code;

import com.code.core.Solution;
import com.code.core.solution.AsteroidCollision;
import com.code.core.solution.BinaryTreeLevelOrderTraversal;

public class CodeSolutionMain {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal();
        System.out.println(solution.solve(solution.input()));
    }
}
