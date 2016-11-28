package org.fde.projecteuler.problem_051;

import org.fde.util.Digits;
import org.fde.util.primes.Primes;

public interface Replace {
    ReplaceFamily getFamily(Primes primes, Digits canonicalSuspectAsDigits);
}
