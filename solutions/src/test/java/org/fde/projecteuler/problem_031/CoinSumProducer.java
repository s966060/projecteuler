package org.fde.projecteuler.problem_031;

import org.fde.util.ListOfLong;

import java.util.ArrayList;
import java.util.List;

class CoinSumProducer {
    private final Long target;
    private final ListOfLong coins;
    private final List<Participant> allParticipants;
    private final List<CoinCombination> combinations;

    private CoinSumProducer(Long target, ListOfLong coins) {
        this.target = target;
        this.coins = coins;

        this.allParticipants = produceParticipants();
        this.combinations = new ArrayList<>();
    }

    List<CoinCombination> produce() {
        nextCombination(new CoinCombination(), this.allParticipants);
        return this.combinations;
    }

    private void nextCombination(
            final CoinCombination combination,
            final List<Participant> participants) {

        List<Participant> newParticipants = new ArrayList<>(participants);

        while (newParticipants.size() > 0) {
            Participant p = newParticipants.get(0);
            newParticipants.remove(0);

            if (!combination.hasCoin(p)) {
                CoinCombination newCombination = new CoinCombination(combination);
                newCombination.add(p);

                if (newCombination.sum() < target) {
                    nextCombination(newCombination, newParticipants);
                } else if (newCombination.sum() == target) {
                    combinations.add(newCombination);
                }
            }
        }
    }

    private List<Participant> produceParticipants() {
        List<Participant> participants = new ArrayList<>();

        for (long coin : this.coins) {
            for (long count = 1; (count * coin) <= target; ++count) {
                participants.add(new Participant(coin, count));
            }
        }

        return participants;
    }

    static CoinSumProducer createCoinSumProducer(final Long target, ListOfLong coins) {
        coins.forEach(coin -> {
            if (coin > target) {
                String msg = String.format("coin %s > target %s", coin, target);
                throw new IllegalArgumentException(msg);
            }
        });

        coins.forEach(number -> {
            if (number <= 0) {
                String msg = String.format("number %s <= 0", number);
                throw new IllegalArgumentException(msg);
            }
        });

        ListOfLong sortedCoins = new ListOfLong(coins);
        sortedCoins.sort();

        return new CoinSumProducer(target, sortedCoins);
    }
}
