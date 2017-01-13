package org.fde.projecteuler.problem_054;

import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.fail;

public class PokerHands {
    @Test
    public void pokerHands() throws Exception {
        final List<Game> games = readGames();

        for(Game game : games) {
            game.evaluate();
        }

        fail();
    }

    private List<Game> readGames() throws Exception {
        final List<Game> games = new ArrayList<>();

        InputStream pokerStream = ClassUtil.getInputStream(this, "poker.txt");

        new LineReader(pokerStream) {
            @Override
            public void readLine(String line) throws Exception {
                String trimmedLine = line.trim();

                if (!trimmedLine.isEmpty()) {
                    Game game = readOneGame(trimmedLine);
                    games.add(game);
                }
            }

            private Game readOneGame(String line) {
                Scanner scanner = new Scanner(line);

                Hand one = new Hand();
                Hand two = new Hand();

                for (int counter = 0; scanner.hasNext(); ++counter) {
                    String cardAsCode = scanner.next();

                    Card card = Card.fromCode(cardAsCode);

                    if (counter < 5) {
                        one.add(card);
                    } else {
                        two.add(card);
                    }
                }

                Game game = Game.createGame(one, two);
                return game;
            }
        }.readAll();

        return games;
    }
}
