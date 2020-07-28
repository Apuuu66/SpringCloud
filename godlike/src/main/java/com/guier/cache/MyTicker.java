package com.guier.cache;

import com.google.common.base.Ticker;

public class MyTicker extends Ticker {
    private long start = Ticker.systemTicker().read();
    private long elapsedNano = 0;

    @Override
    public long read() {
        return start + elapsedNano;
    }

    public void addElapsedTime(long elapsedNano) {
        this.elapsedNano = elapsedNano;
    }
}
