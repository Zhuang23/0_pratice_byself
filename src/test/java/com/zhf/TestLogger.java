package com.zhf;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

public class TestLogger {
    @Test
    public void TestLogger(){
        Logger logger = LoggerFactory.getLogger(TestLogger.class);

        logger.trace("---------trace---------------");
        logger.debug("---------debug---------------");
        logger.info("---------info---------------");
        logger.warn("---------warn---------------");
        logger.error("---------error---------------");
    }
}
