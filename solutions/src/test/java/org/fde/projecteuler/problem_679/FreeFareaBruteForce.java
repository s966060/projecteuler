package org.fde.projecteuler.problem_679;

public class FreeFareaBruteForce {
    private final int wordLenght;
    private int count;

    FreeFareaBruteForce(int wordLength) {
        this.count = 0;
        this.wordLenght = wordLength;
    }

    public int go() {
        StringBuilder word = new StringBuilder();
        go(word, this.wordLenght);
        return this.count;
    }

    private void go(StringBuilder word, int wordLength) {
        if (wordLength <= 0) {
            boolean isTargetFound = FreeFarea.findTarget(word);

            if (isTargetFound) {
                ++count;
            }
        }
        else {
            for (char a : FreeFarea.ALPHABET) {
                word.append(a);
                go(word, wordLength - 1);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}
