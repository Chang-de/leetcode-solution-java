package com.code.core.solution;

import com.code.core.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation implements Solution<List<List<Integer>>, int[]> {

    List<List<Integer>> ans;

    @Override
    public List<List<Integer>> solve(int[] nums) {
        ans = new LinkedList<>();
        dfs(nums, 0, nums.length);
        return ans;
    }

    public void dfs(int[] nums, int currentIndex, int n) {
        if(n == currentIndex) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = currentIndex; i < n; i++) {
            swap(nums, currentIndex, i);
            dfs(nums, currentIndex + 1, n);
            swap(nums, currentIndex, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Override
    public int[] input() {
        return new int[]{1,2,3};
    }
}
