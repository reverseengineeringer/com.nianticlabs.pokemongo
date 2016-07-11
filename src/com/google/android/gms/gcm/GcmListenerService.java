package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.util.concurrent.Executor;

public abstract class GcmListenerService
  extends Service
{
  private int zzaCe;
  private int zzaCf = 0;
  private final Object zzpd = new Object();
  
  /* Error */
  private final void zzk(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 33
    //   2: aload_1
    //   3: invokevirtual 39	android/content/Intent:getAction	()Ljava/lang/String;
    //   6: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne +9 -> 20
    //   14: aload_1
    //   15: invokestatic 51	com/google/android/gms/gcm/GcmReceiver:completeWakefulIntent	(Landroid/content/Intent;)Z
    //   18: pop
    //   19: return
    //   20: aload_1
    //   21: ldc 53
    //   23: invokevirtual 57	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 4
    //   28: aload 4
    //   30: ifnonnull +256 -> 286
    //   33: ldc 59
    //   35: astore 4
    //   37: iconst_m1
    //   38: istore_2
    //   39: aload 4
    //   41: invokevirtual 63	java/lang/String:hashCode	()I
    //   44: lookupswitch	default:+245->289, -2062414158:+129->173, 102161:+114->158, 814694033:+159->203, 814800675:+144->188
    //   88: ldc 65
    //   90: new 67	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   97: ldc 70
    //   99: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 4
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 83	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: aload_0
    //   115: getfield 22	com/google/android/gms/gcm/GcmListenerService:zzpd	Ljava/lang/Object;
    //   118: astore 4
    //   120: aload 4
    //   122: monitorenter
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 24	com/google/android/gms/gcm/GcmListenerService:zzaCf	I
    //   128: iconst_1
    //   129: isub
    //   130: putfield 24	com/google/android/gms/gcm/GcmListenerService:zzaCf	I
    //   133: aload_0
    //   134: getfield 24	com/google/android/gms/gcm/GcmListenerService:zzaCf	I
    //   137: ifne +12 -> 149
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 85	com/google/android/gms/gcm/GcmListenerService:zzaCe	I
    //   145: invokevirtual 89	com/google/android/gms/gcm/GcmListenerService:zzgA	(I)Z
    //   148: pop
    //   149: aload 4
    //   151: monitorexit
    //   152: aload_1
    //   153: invokestatic 51	com/google/android/gms/gcm/GcmReceiver:completeWakefulIntent	(Landroid/content/Intent;)Z
    //   156: pop
    //   157: return
    //   158: aload 4
    //   160: ldc 59
    //   162: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +124 -> 289
    //   168: iconst_0
    //   169: istore_2
    //   170: goto +119 -> 289
    //   173: aload 4
    //   175: ldc 91
    //   177: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq +109 -> 289
    //   183: iconst_1
    //   184: istore_2
    //   185: goto +104 -> 289
    //   188: aload 4
    //   190: ldc 93
    //   192: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq +94 -> 289
    //   198: iconst_2
    //   199: istore_2
    //   200: goto +89 -> 289
    //   203: aload 4
    //   205: ldc 95
    //   207: invokevirtual 45	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +79 -> 289
    //   213: iconst_3
    //   214: istore_2
    //   215: goto +74 -> 289
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 99	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   223: invokespecial 103	com/google/android/gms/gcm/GcmListenerService:zzt	(Landroid/os/Bundle;)V
    //   226: goto -112 -> 114
    //   229: astore 4
    //   231: aload_1
    //   232: invokestatic 51	com/google/android/gms/gcm/GcmReceiver:completeWakefulIntent	(Landroid/content/Intent;)Z
    //   235: pop
    //   236: aload 4
    //   238: athrow
    //   239: aload_0
    //   240: invokevirtual 106	com/google/android/gms/gcm/GcmListenerService:onDeletedMessages	()V
    //   243: goto -129 -> 114
    //   246: aload_0
    //   247: aload_1
    //   248: ldc 108
    //   250: invokevirtual 57	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokevirtual 112	com/google/android/gms/gcm/GcmListenerService:onMessageSent	(Ljava/lang/String;)V
    //   256: goto -142 -> 114
    //   259: aload_0
    //   260: aload_1
    //   261: ldc 108
    //   263: invokevirtual 57	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   266: aload_1
    //   267: ldc 114
    //   269: invokevirtual 57	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   272: invokevirtual 118	com/google/android/gms/gcm/GcmListenerService:onSendError	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: goto -161 -> 114
    //   278: astore 5
    //   280: aload 4
    //   282: monitorexit
    //   283: aload 5
    //   285: athrow
    //   286: goto -249 -> 37
    //   289: iload_2
    //   290: tableswitch	default:+30->320, 0:+-72->218, 1:+-51->239, 2:+-44->246, 3:+-31->259
    //   320: goto -232 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	GcmListenerService
    //   0	323	1	paramIntent	Intent
    //   38	252	2	i	int
    //   9	2	3	bool	boolean
    //   229	52	4	localObject2	Object
    //   278	6	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	229	finally
    //   20	28	229	finally
    //   39	88	229	finally
    //   88	114	229	finally
    //   114	123	229	finally
    //   158	168	229	finally
    //   173	183	229	finally
    //   188	198	229	finally
    //   203	213	229	finally
    //   218	226	229	finally
    //   239	243	229	finally
    //   246	256	229	finally
    //   259	275	229	finally
    //   283	286	229	finally
    //   123	149	278	finally
    //   149	152	278	finally
    //   280	283	278	finally
  }
  
  private void zzt(Bundle paramBundle)
  {
    paramBundle.remove("message_type");
    paramBundle.remove("android.support.content.wakelockid");
    if (zza.zzu(paramBundle))
    {
      zza.zzaz(this).zzv(paramBundle);
      return;
    }
    String str = paramBundle.getString("from");
    paramBundle.remove("from");
    onMessageReceived(str, paramBundle);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(String paramString, Bundle paramBundle) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onSendError(String paramString1, String paramString2) {}
  
  public final int onStartCommand(final Intent paramIntent, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        zzaCe = paramInt2;
        zzaCf += 1;
        if (Build.VERSION.SDK_INT >= 11)
        {
          AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable()
          {
            public void run()
            {
              GcmListenerService.zza(GcmListenerService.this, paramIntent);
            }
          });
          return 3;
        }
      }
      new AsyncTask()
      {
        protected Void zzb(Void... paramAnonymousVarArgs)
        {
          GcmListenerService.zza(GcmListenerService.this, paramIntent);
          return null;
        }
      }.execute(new Void[0]);
    }
  }
  
  boolean zzgA(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.GcmListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */