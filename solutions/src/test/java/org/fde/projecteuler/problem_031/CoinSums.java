package org.fde.projecteuler.problem_031;

import org.fde.util.ListOfLong;
import org.junit.Test;

import java.util.List;

import static org.fde.projecteuler.problem_031.CoinSumProducer.createCoinSumProducer;
import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class CoinSums {
    @Test
    public void coinSumsForTarget_1_Cent() {
        ListOfLong participants = createListOfLong(1);
        CoinSumProducer producer = createCoinSumProducer(1L, participants);

        List<CoinCombination> result = producer.produce();
        System.out.println("result = " + result);
        assertEquals(1, result.size());
    }

    @Test
    public void coinSumsForTarget_2_Cent() {
        ListOfLong participants = createListOfLong(1, 2);
        CoinSumProducer producer = createCoinSumProducer(2L, participants);

        List<CoinCombination> result = producer.produce();
        System.out.println("result = " + result);
        assertEquals(2, result.size());
    }

    @Test
    public void coinSumsForTarget_5_Cent() {
        ListOfLong participants = createListOfLong(1, 2, 5);
        CoinSumProducer producer = createCoinSumProducer(5L, participants);

        List<CoinCombination> result = producer.produce();
        System.out.println("result = " + result);
        assertEquals(4, result.size());
    }

    @Test
    public void coinSumsForTarget_10_Cent() {
        ListOfLong participants = createListOfLong(1, 2, 5, 10);
        CoinSumProducer producer = createCoinSumProducer(10L, participants);

        List<CoinCombination> result = producer.produce();
        System.out.println("result = " + result);
        assertEquals(11, result.size());
    }

    @Test
    public void coinSumsForTarget_20_Cent() {
        ListOfLong participants = createListOfLong(1, 2, 5, 10, 20);
        CoinSumProducer producer = createCoinSumProducer(20L, participants);

        List<CoinCombination> result = producer.produce();
        assertEquals(41, result.size());
    }

    @Test
    public void coinSumsForTarget_50_Cent() {
        ListOfLong participants = createListOfLong(1, 2, 5, 10, 20, 50);
        CoinSumProducer producer = createCoinSumProducer(50L, participants);

        List<CoinCombination> result = producer.produce();
        assertEquals(451, result.size());
    }

    @Test
    public void coinSumsForTarget_100_Cent() {
        ListOfLong participants = createListOfLong(1, 2, 5, 10, 20, 50, 100);
        CoinSumProducer producer = createCoinSumProducer(100L, participants);

        List<CoinCombination> result = producer.produce();
        assertEquals(4563, result.size());
    }

    @Test
    public void coinSumsForTarget_200_Cent() {
        ListOfLong participants = createListOfLong(1, 2, 5, 10, 20, 50, 100, 200);
        CoinSumProducer producer = createCoinSumProducer(200L, participants);

        List<CoinCombination> result = producer.produce();
        System.out.println("result = " + result);
        assertEquals(73682, result.size());
    }
}
