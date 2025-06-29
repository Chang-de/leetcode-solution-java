package com.code.core.solution.core;

import com.code.core.Solution;

import java.util.*;

public class Combination implements Solution<List<List<Integer>>, Combination.Input> {

    public List<List<Integer>> ans;

    @Override
    public List<List<Integer>> solve(Input input) {
        int n = input.n;
        int k = input.k;
        ans = new LinkedList<>();
        LinkedList<Integer> currentList = new LinkedList<>();
        dfs(currentList, k, 1, n);
        return ans;
    }

    public void dfs(LinkedList<Integer> currentList, int k, int currentNumber, int n) {
        int currentLength = currentList.size();
        if(currentLength == k) {
            ans.add(new ArrayList<>(currentList));
            return;
        }
        if (currentLength + n - currentLength + 1 < k) {
            return;
        }
        if (currentNumber > n) {
            return;
        }
        currentList.add(currentNumber);
        dfs(currentList, k, currentNumber + 1, n);
        currentList.removeLast();
        dfs(currentList, k, currentNumber + 1, n);
    }

    public void swap(Integer[] nums, int i, int j) {
        Integer tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Override
    public Input input() {
        Input input = new Input();
        input.n = 4;
        input.k = 2;
        return input;
    }

    public final class Input {
        int n;
        int k;
    }
}
