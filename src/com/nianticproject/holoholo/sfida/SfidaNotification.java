package com.nianticproject.holoholo.sfida;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;

public class SfidaNotification
{
  public static final String ACTION_NOTIFICATION_DISMISS = "com.nianticproject.holoholo.sfida.dismiss";
  public static final String ACTION_NOTIFICATION_VIBRATE = "com.nianticproject.holoholo.sfida.vibrate";
  public static final int NOTIFICATION_ID = 1;
  private static final String TAG = SfidaNotification.class.getSimpleName();
  private static Notification notification;
  
  private static void addDismissAction(Context paramContext, Notification.Builder paramBuilder)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.nianticproject.holoholo.sfida.dismiss");
    localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 134217728);
    paramBuilder.addAction(paramContext.getResources().getIdentifier("ic_eject_black_48dp", "drawable", paramContext.getPackageName()), "Disconnect", (PendingIntent)localObject);
  }
  
  private static void addVibrateAction(Context paramContext, Notification.Builder paramBuilder)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.nianticproject.holoholo.sfida.vibrate");
    localObject = PendingIntent.getBroadcast(paramContext, 0, (Intent)localObject, 134217728);
    paramBuilder.addAction(paramContext.getResources().getIdentifier("ic_eject_black_48dp", "drawable", paramContext.getPackageName()), "VibrateTest", (PendingIntent)localObject);
  }
  
  public static void dissmiss(Context paramContext)
  {
    if (notification != null) {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(1);
    }
  }
  
  public static Notification getNotification()
  {
    return notification;
  }
  
  public static Notification showSfidaNotification(Context paramContext)
  {
    Log.d(TAG, "showSfidaNotification()");
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    localBuilder.setContentTitle("PokemonGoPlus");
    localBuilder.setContentText("Connecting");
    localBuilder.setTicker("ticker");
    localBuilder.setContentIntent(PendingIntent.getActivity(paramContext, 0, new Intent(), 0));
    localBuilder.setSmallIcon(paramContext.getResources().getIdentifier("ic_eject_black_48dp", "drawable", paramContext.getPackageName()));
    localBuilder.setAutoCancel(false);
    localBuilder.setOngoing(false);
    addDismissAction(paramContext, localBuilder);
    addVibrateAction(paramContext, localBuilder);
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    notification = localBuilder.build();
    paramContext.notify(1, notification);
    return notification;
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.SfidaNotification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */