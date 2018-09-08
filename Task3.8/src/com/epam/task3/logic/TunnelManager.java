package com.epam.task3.logic;

import com.epam.task3.entity.Train;
import com.epam.task3.entity.Tunnel;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class TunnelManager {
    //fields
    private Tunnel firstTunnel;
    private Tunnel secondTunnel;
    private Semaphore firstTunnelSemaphore;
    private Semaphore secondTunnelSemaphore;

    //constant values
    private static final int POOL_SIZE = 3;
    private static final String FIRST_TUNNEL_NAME = "FIRST";
    private static final String SECOND_TUNNEL_NAME = "SECOND";

    //work with multi-threads
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static TunnelManager instance;
    private static ReentrantLock lock = new ReentrantLock();

    //private constructor because of pattern singleton
    private TunnelManager() {
        firstTunnel = new Tunnel(FIRST_TUNNEL_NAME);
        secondTunnel = new Tunnel(SECOND_TUNNEL_NAME);

        firstTunnelSemaphore = new Semaphore(POOL_SIZE, true);
        secondTunnelSemaphore = new Semaphore(POOL_SIZE, true);
    }

    public static TunnelManager getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new TunnelManager();
                    instanceCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public Tunnel enterInTunnel(Train train) {
        while (true) {
            if ((firstTunnel.getCurrentDirection() == null)
                    || (train.getDirection() == firstTunnel.getCurrentDirection().get())) {
                if (firstTunnelSemaphore.tryAcquire()) {
                    startMovingTrainInTunnel(firstTunnel, train);
                    return firstTunnel;
                }
            } else if ((secondTunnel.getCurrentDirection() == null)
                    || (train.getDirection() == secondTunnel.getCurrentDirection().get())) {
                if (secondTunnelSemaphore.tryAcquire()) {
                    startMovingTrainInTunnel(secondTunnel, train);
                    return secondTunnel;
                }
            }
        }
    }

    public void leaveTunnel(Tunnel tunnel) {
        if (tunnel.getName().equals(firstTunnel.getName())) {
            firstTunnel.popTrain();
            if (firstTunnel.getTrains().isEmpty()) {
                firstTunnel.setCurrentDirection(null);
            }
            firstTunnelSemaphore.release();
        } else {
            secondTunnel.popTrain();
            if (secondTunnel.getTrains().isEmpty()) {
                secondTunnel.setCurrentDirection(null);
            }
            secondTunnelSemaphore.release();
        }
    }

    private void startMovingTrainInTunnel(Tunnel tunnel, Train train) {
        if (tunnel.getTrains().isEmpty()) {
            tunnel.setCurrentDirection(new AtomicBoolean(train.getDirection()));
        }
        tunnel.pushTrain(train);
    }
}
