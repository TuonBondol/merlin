package com.novoda.merlin.service;

import android.content.Context;

import com.novoda.merlin.MerlinsBeard;
import com.novoda.merlin.NetworkStatus;

class CurrentNetworkStatusFetcher {

    private final HostPinger hostPinger;

    public CurrentNetworkStatusFetcher(HostPinger hostPinger) {
        this.hostPinger = hostPinger;
    }

    public void get(Context context) {
        if (MerlinsBeard.from(context).isConnected()) {
            hostPinger.ping();
        } else {
            hostPinger.noNetworkToPing();
        }
    }

    public NetworkStatus getWithoutPing(Context context) {
        if (MerlinsBeard.from(context).isConnected()) {
            return NetworkStatus.newAvailableInstance();
        } else {
            return NetworkStatus.newUnavailableInstance();
        }
    }

}
