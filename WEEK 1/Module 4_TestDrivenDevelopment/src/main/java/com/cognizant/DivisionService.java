package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivisionService {

    private static final Logger logger =
            LoggerFactory.getLogger(DivisionService.class);

    public int divide(int a, int b) {

        try {
            int result = a / b;

            logger.info("Result = {}", result);

            return result;

        } catch (Exception e) {

            logger.error("Exception occurred", e);

            return 0;
        }
    }
}