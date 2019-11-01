package org.fde.projecteuler.problem_679;

public class FreeFareaBruteForce {
    private final int wordLenght;
    private int count;

    FreeFareaBruteForce(int wordLength) {
        this.count = 0;
        this.wordLenght = wordLength;
    }

    public int go() {
        Word word = new Word(this.wordLenght);
        go(word, this.wordLenght);
        return this.count;
    }

    private void go(Word word, int wordLength) {
        if (wordLength <= 0) {
            boolean isTargetFound = word.findTarget();

            if (isTargetFound) {
                ++count;
            }
        }
        else {
            for (char a : FreeFarea.ALPHABET) {
                word.add(a);
                go(word, wordLength - 1);
                word.remove();
            }
        }
    }
}
