package com.kayak.exercises.two;

public class Counter {

    public void countUp(final int start, final int end) {
        checkPreconditions(start, end);
        countUp0(start, end);
    }

    public void countDown(final int start, final int end) {
        checkPreconditions(start, end);
        countDown0(start, end);
    }

    public void countUpAndDown(final int start, final int end) {
        checkPreconditions(start, end);
        countUpAndDown0(start, end);
    }

    private void checkPreconditions(final int start, final int end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Start and end must be non-negative");
        }
        if (start >= end) {
            throw new IllegalArgumentException("Start must be less than end");
        }
    }

    private void countUp0(final int start, final int end) {
        if (end <= start) {
            System.out.println(start);
        } else {
            countUp0(start, start + (end - start) / 2);
            countUp0(start + (end - start) / 2 + 1, end);
        }
    }

    private void countDown0(final int start, final int end) {
        if (end <= start) {
            System.out.println(end);
        } else {
            countDown0(start + (end - start) / 2 + 1, end);
            countDown0(start, start + (end - start) / 2);
        }
    }

    private void countUpAndDown0(final int start, final int end) {
        countUp0(start, end - 1);
        System.out.println(end);
        countDown0(start, end - 1);
    }

    //private void countUpAndDown2(final int start, final int end) {
    //    if (end == start) {
    //        System.out.println(start);
    //        return;
    //    }
    //    System.out.println(start);
    //    countUpAndDown2(start+1, end);
    //    System.out.println(start);
    //}

    public static void main(final String[] args) {
        // new Counter().countUp(0,5);
        new Counter().countUpAndDown(0, 5);
        // new Counter().countUp(0,1000000000);
        // new Counter().countUpAndDown(0,1000000000);
        // new Counter().countUpAndDown(0,Integer.MAX_VALUE);
        // new Counter().countUpAndDown(10, 15);
        // new Counter().countUpAndDown2(0,1000000000);
    }
}
