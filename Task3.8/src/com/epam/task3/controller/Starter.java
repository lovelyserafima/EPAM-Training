package com.epam.task3.controller;

//import statements
import com.epam.task3.entity.Train;
import com.epam.task3.logic.TunnelManager;
import org.apache.log4j.Logger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Starter {
    //logging information
    private static final Logger LOGGER = Logger.getLogger(Starter.class);
    private static final int DEFAULT_NUMBER_OF_TRAINS = 10;
    private static final int SLEEP_IN_SECONDS = 1;
    private static final int RAND_FOR_ID_TRAIN = 1000;

    public static void main(String[] args) {
        TunnelManager tunnelManager = TunnelManager.getInstance();
        Random random = new Random();
        try {
            for (int i = 0; i < DEFAULT_NUMBER_OF_TRAINS; i++) {
                TimeUnit.SECONDS.sleep(SLEEP_IN_SECONDS);
                Train train = new Train(tunnelManager, random.nextBoolean(), random.nextInt(RAND_FOR_ID_TRAIN));
                LOGGER.info(train + " arrived");
                train.start();
            }
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }
}

