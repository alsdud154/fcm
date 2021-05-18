package kr.co.velnova.fcm.controller;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FcmController {

    @PostMapping("fcm")
    public String fcm() throws FirebaseMessagingException {
        // This registration token comes from the client FCM SDKs.
        String registrationToken = "c8IN4ZC4x6U:APA91bHK3ebbapKSodZnyyJVFSasgrMOOXjYmj7mDj_d7645a6d9geYTL7EQU52AYtMBCFLlua7lh2GTpMgPg2vHw5Jj6BzA_i2zzCF-5Yr4T2KA8pivEPbpjn3r6P-8sBl_Hn1TpHa9";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle("제목")
                        .setBody("내용")
                        .build())
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(registrationToken)
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = FirebaseMessaging.getInstance().send(message);
        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);

        return response;
    }
}
