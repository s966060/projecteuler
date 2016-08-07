package org.fde.problem_003;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PrimeBuilderTest {
    @Test
    public void thePrimesUpTo_100() {
        Primes primes = new Primes();
        PrimeBuilder builder = primes.getPrimeBuilder();

        assertEquals(2L, builder.next());
        assertEquals(3L, builder.next());
        assertEquals(5L, builder.next());
        assertEquals(7L, builder.next());
        assertEquals(11L, builder.next());
        assertEquals(13L, builder.next());
        assertEquals(17L, builder.next());
        assertEquals(19L, builder.next());
        assertEquals(23L, builder.next());
        assertEquals(29L, builder.next());
        assertEquals(31L, builder.next());
        assertEquals(37L, builder.next());
        assertEquals(41L, builder.next());
        assertEquals(43L, builder.next());
        assertEquals(47L, builder.next());
        assertEquals(53L, builder.next());
        assertEquals(59L, builder.next());
        assertEquals(61L, builder.next());
        assertEquals(67L, builder.next());
        assertEquals(71L, builder.next());
        assertEquals(73L, builder.next());
        assertEquals(79L, builder.next());
        assertEquals(83L, builder.next());
        assertEquals(89L, builder.next());
        assertEquals(97L, builder.next());
    }

    @Test
    public void theFirst_1000_primes() throws IOException {
        Primes primes = new Primes();
        PrimeBuilder builder = primes.getPrimeBuilder();

        String fileName = "src/test/resources/primes_1000.txt";
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        assertNotNull(is);

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        while ((line = br.readLine()) != null) {
            long prime = Long.valueOf(line);
            System.out.println("prime = " + prime);

            assertEquals(prime, builder.next());
        }

        br.close();
    }
}
