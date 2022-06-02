package com.example.android.colony;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


public class MyFirebaseMessagingService extends FirebaseInstanceIdService {


    String refreshedToken;



    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        // Get updated InstanceID token.
        refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
         sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String Token) {
    }

}
