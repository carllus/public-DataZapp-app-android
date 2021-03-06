package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;

class CtfeDebugInformationHandler implements DebugInformationHandler {
    @VisibleForTesting
    static final String CTFE_URL_PATH_PREFIX = "/d?";
    @VisibleForTesting
    static final int NUM_EVENTS_PER_SEND = 1;
    private int currentDebugEventNumber;
    private NetworkClient mClient;
    private CtfeHost mCtfeHost;
    private Debug.DebugEvents mDebugEvents;

    @VisibleForTesting
    CtfeDebugInformationHandler(NetworkClient client, CtfeHost host) {
        this.mCtfeHost = host;
        this.mClient = client;
        this.mDebugEvents = new Debug.DebugEvents();
    }

    public CtfeDebugInformationHandler(CtfeHost host) {
        this(new NetworkClientFactory().createNetworkClient(), host);
    }

    public synchronized void receiveEventInfo(Debug.EventInfo event) {
        this.mDebugEvents.event = ArrayUtils.appendToArray(this.mDebugEvents.event, event);
        if (this.mDebugEvents.event.length >= 1 && sendDebugInformationtoCtfe()) {
            this.mDebugEvents.clear();
        }
    }

    private byte[] getDebugEventsAsBytes() throws IOException {
        return MessageNano.toByteArray(this.mDebugEvents);
    }

    private boolean sendDebugInformationtoCtfe() {
        try {
            NetworkClient networkClient = this.mClient;
            CtfeHost ctfeHost = this.mCtfeHost;
            int i = this.currentDebugEventNumber;
            this.currentDebugEventNumber = i + 1;
            networkClient.sendPostRequest(ctfeHost.constructCtfeDebugUrl(i), getDebugEventsAsBytes());
            return true;
        } catch (IOException ex) {
            Log.m542e("CtfeDebugInformationHandler: Error sending information to server that handles debug information: " + ex.getMessage());
            return false;
        }
    }
}
