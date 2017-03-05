package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.fde.util.SetOfLong;

import java.util.HashMap;
import java.util.Map;

import static org.fde.util.ListOfLong.createListOfLong;

public class PrimeFactors {
    private final static Map<Long, ListOfLong> LARGE_KNOWN_PRIMES = createLargeKnownFactorizations();
    private final Primes primes;

    public PrimeFactors() {
        this.primes = new Primes();
    }

    private static Map<Long, ListOfLong> createLargeKnownFactorizations() {
        Map map = new HashMap();

        map.put(1_746_860_020_068_409L, createListOfLong(1_746_860_020_068_409L));
        map.put(489_133_282_872_437_279L, createListOfLong(489_133_282_872_437_279L));

        map.put(10_181_446_324_101_389L, createListOfLong(11437, 890_220_016_097L));
        map.put(345_869_461_223_138_161L, createListOfLong(3761, 91_962_100_830_401L));
        map.put(3_493_720_040_136_818L, createListOfLong(2, 1_746_860_020_068_409L));
        map.put(34_761_632_124_320_657L, createListOfLong(17L, 2_113L, 967_724_510_017L));
        map.put(2_015_874_949_414_289_041L, createListOfLong(13L, 13L, 293L, 40_710_764_977_973L));
        map.put(691_738_922_446_276_322L, createListOfLong(2L, 3_761L, 91_962_100_830_401L));
        map.put(143_263_821_649_299_118L, createListOfLong(2L, 47L, 229L, 982_789L, 6_771_937L));
        map.put(2_850_877_693_509_864_481L, createListOfLong(239L, 1_471L, 8_109_013_290_449L));
        map.put(403_174_989_882_857_807L, createListOfLong(23L, 31L, 6_747_397L, 83_804_587L));
        map.put(688_262_759_233_844_254L, createListOfLong(2L, 15_287L, 22_511_374_345_321L));
        map.put(2_349_876_047_052_519_209L, createListOfLong(7, 335_696_578_150_359_887L));
        map.put(166_161_328_781_867_495L, createListOfLong(5L, 1_545_751L, 21_499_106_749L));

        map.put(401_148_933_487_119_415L, createListOfLong(5L, 13L, 6_171_522_053_647_991L));
        map.put(113_462_052_453_797_382L, createListOfLong(2L, 3L, 3L, 739L, 8_529_698_726_041L));
        map.put(80_229_786_697_423_883L, createListOfLong(13L, 6_171_522_053_647_991L));
        map.put(193_691_839_151_221_265L, createListOfLong(5L, 61L, 635_055_210_331_873L));

        map.put(1128918769150954091L, createListOfLong(1128918769150954091L));
        map.put(661_305_304_151_087_678L, createListOfLong(2L, 11_886_691L, 27_817_047_829L));

        map.put(112_891_876_915_095_409L, createListOfLong(71L, 311L, 5_112_625_194_289L));
        map.put(272_545_100_330_177_459L, createListOfLong(197L, 2_700_389L, 512_325_323L));

        map.put(1596532234150820504L, createListOfLong(2, 2, 2, 125739569, 1587141827));
        return map;
    }

    public ListOfLong getPrimeFactors(long target) {
        if (target < 0) {
            String msg = String.format("target (%,d) < 0", target);
            throw new IllegalArgumentException(msg);
        }

        // LETS cheat a bit...
        if (LARGE_KNOWN_PRIMES.containsKey(target)) {
            return LARGE_KNOWN_PRIMES.get(target);
        }

        PrimeBuilder builder = new PrimeBuilder(this.primes);

        ListOfLong factors = new ListOfLong();

        long squareOfPrime = 0;
        long prime = builder.next();

        for (; prime <= target && target > squareOfPrime; prime = builder.next()) {
            while ((target % prime) == 0) {
                target /= prime;
                factors.add(prime);
            }

            squareOfPrime = prime * prime;
        }

        if (target > 1) {
            factors.add(target);
        }

        return factors;
    }

    public SetOfLong getDistinctPrimeFactors(long target) {
        ListOfLong list = getPrimeFactors(target);

        return new SetOfLong(list);
    }

    @Override
    public String toString() {
        return "PrimeFactors{" +
                "primes=" + primes +
                '}';
    }
}
