package io.ethelhub.kr0n0.lazycom;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created by Kr0n0 on 5/3/18.
 */

public class RegistrationService extends IntentService {
    public RegistrationService() {
        super("RegistrationService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Creamos una instancia de la clase InstanceID
        InstanceID myID = InstanceID.getInstance(this);

        // Obtenemos el token de registro en forma de String con getToken
        try {
            String registrationToken = myID.getToken(
                    getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                    null
            );
            Log.d("Registration Token", registrationToken);
            GcmPubSub subscription = GcmPubSub.getInstance(this);
            subscription.subscribe(registrationToken, "/topics/example_1", null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
