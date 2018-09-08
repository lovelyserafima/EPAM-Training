package com.epam.task3.entity;

import com.epam.task3.logic.TunnelManager;
import org.apache.log4j.Logger;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Train extends Thread {
    //fields
    private int number;
    private boolean direction;
    private TunnelManager tunnelManager;

    //constant values
    private static final int TIME_IN_TUNNEL_IN_SECONDS = 3;
    private static final Logger LOGGER = Logger.getLogger(Train.class);

    public Train(){}

    public Train(TunnelManager systemOfTunnel, boolean direction, int number){
        this.tunnelManager = systemOfTunnel;
        this.direction = direction;
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public TunnelManager getTunnelManager() {
        return tunnelManager;
    }

    public void setTunnelManager(TunnelManager tunnelManager) {
        this.tunnelManager = tunnelManager;
    }

    @Override
    public void run(){
        Tunnel tunnel = new Tunnel();
        try {
            tunnel = tunnelManager.enterInTunnel(this);
            LOGGER.info(toString() + " entered in " + tunnel);
            TimeUnit.SECONDS.sleep(TIME_IN_TUNNEL_IN_SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        } finally{
            tunnelManager.leaveTunnel(tunnel);
            LOGGER.info(toString() + " left " + tunnel);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return getNumber() == train.getNumber() &&
                getDirection() == train.getDirection() &&
                Objects.equals(getTunnelManager(), train.getTunnelManager());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getDirection(), getTunnelManager());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " №" + number
                + ", " + direction + " direction";
    }
}

