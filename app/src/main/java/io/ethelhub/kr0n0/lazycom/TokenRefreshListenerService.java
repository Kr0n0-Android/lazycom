package io.ethelhub.kr0n0.lazycom;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Kr0n0 on 5/3/18.
 */

public class TokenRefreshListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Intent i = new Intent(this, RegistrationService.class);
        startService(i);
        super.onTokenRefresh();
    }
}
