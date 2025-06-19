package com.code.core;

public interface Solution <R, T> {
    R solve(T args);
    T input();
}
