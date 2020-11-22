package com.github.beastyboo.guns.domain.entity;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by Torbie on 22.11.2020.
 */
public class Cooldown {

    private final UUID uuid;
    private final double timeInSeconds;
    private final long start;

    private final DecimalFormat df = new DecimalFormat("#.#");

    public Cooldown(UUID uuid, double timeInSeconds) {
        this.uuid = uuid;
        this.timeInSeconds = timeInSeconds;
        start = System.currentTimeMillis();
    }

    public double getTimeLeftInSeconds() {
        long now = System.currentTimeMillis();
        double offset = (now - start) / 1000;
        return Double.parseDouble(df.format((offset - timeInSeconds)));
    }

    public UUID getUuid() {
        return uuid;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public long getStart() {
        return start;
    }
}
