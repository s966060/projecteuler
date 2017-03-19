package org.fde.util;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchUtil {
    public static StopWatch createAndStart() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }
}
