package com.DisasterArtist.disaster;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class DisasterApp extends Application {
    public static final String CHANNEL_WEATHER_ID = "WEATHER_NOTIFICATION_CHANNEL";
    public static final String CHANNEL_2_ID = "NOTIFICATION_CHANNEL_2";
    @Override
    public void onCreate() {
        super.onCreate();
        
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel weatherNotification = new NotificationChannel(CHANNEL_WEATHER_ID,
                    "Weather Notification", NotificationManager.IMPORTANCE_LOW);

            weatherNotification.setDescription("Communicates current weather");

            NotificationManager notManager = getSystemService(NotificationManager.class);
            notManager.createNotificationChannel(weatherNotification);

        }
    }
}
