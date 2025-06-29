package com.code;

import com.code.core.Solution;
import com.code.core.solution.core.Permutation;

public class CoreSolutionMain {
    public static void main(String[] args) {
        Solution solution = new Permutation();
        System.out.println(solution.solve(solution.input()));
    }
}
