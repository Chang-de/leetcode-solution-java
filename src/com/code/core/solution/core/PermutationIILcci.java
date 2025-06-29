package com.code.core.solution.core;

import com.code.core.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationIILcci implements Solution<String[], String> {
    @Override
    public String[] solve(String S) {
        char[] list = S.toCharArray();
        List<String> ans  = new LinkedList<>();
        dfs(list, 0, ans);
        return ans.toArray(new String[0]);
    }

    public void dfs(char[] list, int currentIndex, List<String> ans) {
        if(currentIndex == list.length) {
            ans.add(new String(list));
        }
        HashSet<Character> hasSearched  = new HashSet<>();
        for(int i = currentIndex; i < list.length; i++) {
            if(hasSearched.contains(list[i])) {
                continue;
            }
            swap(list, currentIndex, i);
            dfs(list, currentIndex + 1, ans);
            swap(list, currentIndex, i);
            hasSearched.add(list[i]);
        }
    }

public void swap(char[] list, int i, int j) {
    char tmp = list[i];
    list[i] = list[j];
    list[j] = tmp;
}

    @Override
    public String input() {
        return "";
    }
}
