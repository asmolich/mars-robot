package com.kayak.exercises.two;

/**
 * Class has methods to count in sequential order without using any iterative programming loops,
 * i.e. while, for, do, for-each, etc
 *
 * @author asmolich
 */
public class Counter {

    /**
     * Prints out numbers in sequential order from start to end inclusive. Each number on new line.
     *
     * @param start. start must be > 0
     * @param end. end must be > 0 and > start
     */
    public static void countUp(final int start, final int end) {
        checkPreconditions(start, end);
        countUp0(start, end);
    }

    /**
     * Prints out numbers in sequential order from end to start inclusive. Each number on new line.
     *
     * @param start. start must be > 0
     * @param end. end must be > 0 and > start
     */
    public static void countDown(final int start, final int end) {
        checkPreconditions(start, end);
        countDown0(start, end);
    }

    /**
     * Prints out numbers in sequential order from start to end (only once), but then also counts down to the start

     * @param start. start must be > 0
     * @param end. end must be > 0 and > start
     */
    public static void countUpAndDown(final int start, final int end) {
        checkPreconditions(start, end);
        countUpAndDown0(start, end);
    }

    private static void checkPreconditions(final int start, final int end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Start and end must be non-negative");
        }
        if (start >= end) {
            throw new IllegalArgumentException("Start must be less than end");
        }
    }

    private static void countUp0(final int start, final int end) {
        if (end <= start) {
            System.out.println(start);
        } else {
            countUp0(start, start + (end - start) / 2);
            countUp0(start + (end - start) / 2 + 1, end);
        }
    }

    private static void countDown0(final int start, final int end) {
        if (end <= start) {
            System.out.println(end);
        } else {
            countDown0(start + (end - start) / 2 + 1, end);
            countDown0(start, start + (end - start) / 2);
        }
    }

    private static void countUpAndDown0(final int start, final int end) {
        countUp0(start, end - 1);
        System.out.println(end);
        countDown0(start, end - 1);
    }

    //private static void countUpAndDown2(final int start, final int end) {
    //    if (end == start) {
    //        System.out.println(start);
    //        return;
    //    }
    //    System.out.println(start);
    //    countUpAndDown2(start+1, end);
    //    System.out.println(start);
    //}

    public static void main(final String[] args) {
        // Counter.countUp(0,5);
        Counter.countUpAndDown(0, 5);
        // Counter.countUp(0,1000000000);
        // Counter.countUpAndDown(0,1000000000);
        // Counter.countUpAndDown(0,Integer.MAX_VALUE);
        // Counter.countUpAndDown(10, 15);
        // Counter.countUpAndDown2(0,1000000000);
    }
}
