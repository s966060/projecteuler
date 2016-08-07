package org.fde.problem_004;

public class Palindrome {
    private final int firstFactor;
    private final int secondFactor;
    private final int palindrome;

    public Palindrome(int firstFactor, int secondFactor) {
        this.firstFactor = firstFactor;
        this.secondFactor = secondFactor;
        this.palindrome = firstFactor * secondFactor;
    }

    public int getFirstFactor() {
        return firstFactor;
    }

    public int getSecondFactor() {
        return secondFactor;
    }

    public int getPalindrome() {
        return palindrome;
    }

    @Override
    public String toString() {
        return "Palindrome{" +
                "firstFactor=" + firstFactor +
                ", secondFactor=" + secondFactor +
                ", palindrome=" + palindrome +
                '}';
    }
}
