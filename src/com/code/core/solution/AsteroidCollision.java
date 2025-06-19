package com.code.core.solution;

import com.code.core.Solution;

import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision implements Solution<int[], int[]> {
    @Override
    public int[] solve(int[] asteroids) {
        if(asteroids.length <= 1){
            return asteroids;
        }
        Deque<Integer> ans = new LinkedList<>();
        ans.push(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++){
            tryHit(ans, asteroids[i]);
        }
        int ansSize = ans.size();
        int[] ansArray = new int[ansSize];
        for(int i = ansSize - 1; i >=0; i--) {
            ansArray[i] = ans.poll();
        }
        return ansArray;
    }

    public void tryHit(Deque<Integer> ans, int currentAsteroid) {
        if(ans.isEmpty()){
            ans.push(currentAsteroid);
            return;
        }
        int recentAsteroid = ans.poll();
        if(recentAsteroid * currentAsteroid < 0 && recentAsteroid > 0){
            int hitResult = recentAsteroid + currentAsteroid;
            if(hitResult != 0) {
                hitResult = hitResult * recentAsteroid > 0 ? recentAsteroid : currentAsteroid;
                tryHit(ans, hitResult);
            }
        } else {
            ans.push(recentAsteroid);
            ans.push(currentAsteroid);
        }
    }

    @Override
    public int[] input() {
        return new int[]{10, 2, -5};
    }
}
