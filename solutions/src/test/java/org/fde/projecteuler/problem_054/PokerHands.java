package org.fde.projecteuler.problem_054;

import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerHands {
    @Test
    public void pokerHands() throws Exception {
        final List<Game> games = new ArrayList<>();

        InputStream pokerStream = ClassUtil.getInputStream(this, "poker.txt");

        new LineReader(pokerStream) {
            @Override
            public void readLine(String line) throws Exception {
                String trimmedLine = line.trim();

                if(!trimmedLine.isEmpty()) {
                    Scanner scanner = new Scanner(trimmedLine);

                    while (scanner.hasNext()) {
                        String cardAsCode = scanner.next();

                        Card card = Card.fromCode(cardAsCode);
                        System.out.println(" ... card = " + card);
                    }

                    System.out.println();
                }
            }
        }.readAll();
    }
}
