package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  private static final ComponentName zzRw;
  private static final ComponentName zzRx;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      KEY_CALLER_UID = "callerUid";
      if (Build.VERSION.SDK_INT < 14) {
        break label58;
      }
    }
    label58:
    for (;;)
    {
      KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
      zzRw = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      zzRx = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      return;
      break;
    }
  }
  
  /* Error */
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc 84
    //   7: invokestatic 90	com/google/android/gms/common/internal/zzx:zzcj	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 94	com/google/android/gms/auth/GoogleAuthUtil:zzaa	(Landroid/content/Context;)V
    //   14: new 96	android/os/Bundle
    //   17: dup
    //   18: invokespecial 97	android/os/Bundle:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 101	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 106	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   29: astore_0
    //   30: aload_3
    //   31: ldc 108
    //   33: aload_0
    //   34: invokevirtual 111	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_3
    //   38: getstatic 45	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   41: invokevirtual 115	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   44: ifne +11 -> 55
    //   47: aload_3
    //   48: getstatic 45	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   51: aload_0
    //   52: invokevirtual 111	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: new 117	com/google/android/gms/common/zza
    //   58: dup
    //   59: invokespecial 118	com/google/android/gms/common/zza:<init>	()V
    //   62: astore_0
    //   63: aload_2
    //   64: invokestatic 124	com/google/android/gms/common/internal/zzl:zzal	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   67: astore_2
    //   68: aload_2
    //   69: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   72: aload_0
    //   73: ldc 126
    //   75: invokevirtual 130	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   78: ifeq +98 -> 176
    //   81: aload_0
    //   82: invokevirtual 134	com/google/android/gms/common/zza:zzno	()Landroid/os/IBinder;
    //   85: invokestatic 139	com/google/android/gms/internal/zzau$zza:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzau;
    //   88: aload_1
    //   89: aload_3
    //   90: invokeinterface 144 3 0
    //   95: astore_1
    //   96: aload_1
    //   97: ldc -110
    //   99: invokevirtual 150	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_3
    //   103: aload_1
    //   104: ldc -104
    //   106: invokevirtual 155	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   109: ifne +45 -> 154
    //   112: new 70	com/google/android/gms/auth/GoogleAuthException
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 157	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_1
    //   122: ldc 126
    //   124: ldc -97
    //   126: aload_1
    //   127: invokestatic 165	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: new 72	java/io/IOException
    //   134: dup
    //   135: ldc -89
    //   137: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: astore_1
    //   142: aload_2
    //   143: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   146: aload_0
    //   147: ldc 126
    //   149: invokevirtual 172	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   152: aload_1
    //   153: athrow
    //   154: aload_2
    //   155: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   158: aload_0
    //   159: ldc 126
    //   161: invokevirtual 172	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   164: return
    //   165: astore_1
    //   166: new 70	com/google/android/gms/auth/GoogleAuthException
    //   169: dup
    //   170: ldc -82
    //   172: invokespecial 157	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   175: athrow
    //   176: new 72	java/io/IOException
    //   179: dup
    //   180: ldc -80
    //   182: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramContext	Context
    //   0	186	1	paramString	String
    //   4	151	2	localObject1	Object
    //   21	96	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   81	121	121	android/os/RemoteException
    //   81	121	141	finally
    //   122	141	141	finally
    //   166	176	141	finally
    //   81	121	165	java/lang/InterruptedException
  }
  
  /* Error */
  public static java.util.List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc -75
    //   3: invokestatic 185	com/google/android/gms/common/internal/zzx:zzh	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   6: pop
    //   7: ldc 84
    //   9: invokestatic 90	com/google/android/gms/common/internal/zzx:zzcj	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 82	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   16: astore_3
    //   17: aload_3
    //   18: invokestatic 94	com/google/android/gms/auth/GoogleAuthUtil:zzaa	(Landroid/content/Context;)V
    //   21: new 117	com/google/android/gms/common/zza
    //   24: dup
    //   25: invokespecial 118	com/google/android/gms/common/zza:<init>	()V
    //   28: astore_0
    //   29: aload_3
    //   30: invokestatic 124	com/google/android/gms/common/internal/zzl:zzal	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   33: astore_3
    //   34: aload_3
    //   35: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   38: aload_0
    //   39: ldc 126
    //   41: invokevirtual 130	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   44: ifeq +90 -> 134
    //   47: aload_0
    //   48: invokevirtual 134	com/google/android/gms/common/zza:zzno	()Landroid/os/IBinder;
    //   51: invokestatic 139	com/google/android/gms/internal/zzau$zza:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzau;
    //   54: new 187	com/google/android/gms/auth/AccountChangeEventsRequest
    //   57: dup
    //   58: invokespecial 188	com/google/android/gms/auth/AccountChangeEventsRequest:<init>	()V
    //   61: aload_2
    //   62: invokevirtual 192	com/google/android/gms/auth/AccountChangeEventsRequest:setAccountName	(Ljava/lang/String;)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   65: iload_1
    //   66: invokevirtual 196	com/google/android/gms/auth/AccountChangeEventsRequest:setEventIndex	(I)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   69: invokeinterface 199 2 0
    //   74: invokevirtual 205	com/google/android/gms/auth/AccountChangeEventsResponse:getEvents	()Ljava/util/List;
    //   77: astore_2
    //   78: aload_3
    //   79: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   82: aload_0
    //   83: ldc 126
    //   85: invokevirtual 172	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   88: aload_2
    //   89: areturn
    //   90: astore_2
    //   91: ldc 126
    //   93: ldc -97
    //   95: aload_2
    //   96: invokestatic 165	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   99: pop
    //   100: new 72	java/io/IOException
    //   103: dup
    //   104: ldc -89
    //   106: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   109: athrow
    //   110: astore_2
    //   111: aload_3
    //   112: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   115: aload_0
    //   116: ldc 126
    //   118: invokevirtual 172	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   121: aload_2
    //   122: athrow
    //   123: astore_2
    //   124: new 70	com/google/android/gms/auth/GoogleAuthException
    //   127: dup
    //   128: ldc -82
    //   130: invokespecial 157	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   133: athrow
    //   134: new 72	java/io/IOException
    //   137: dup
    //   138: ldc -80
    //   140: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramInt	int
    //   0	144	2	paramString	String
    //   16	96	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	78	90	android/os/RemoteException
    //   47	78	110	finally
    //   91	110	110	finally
    //   124	134	110	finally
    //   47	78	123	java/lang/InterruptedException
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    zzx.zzh(paramString, "accountName must be provided");
    zzx.zzcj("Calling this from your main thread can lead to deadlock");
    zzaa(paramContext.getApplicationContext());
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramAccount, paramString, new Bundle());
  }
  
  public static String getToken(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return zza(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2);
  }
  
  @Deprecated
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return zzb(paramContext, paramAccount, paramString, paramBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    zzi(paramIntent);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("callback_intent", paramIntent);
    localBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString, localBundle).getToken();
  }
  
  public static String getTokenWithNotification(Context paramContext, Account paramAccount, String paramString1, Bundle paramBundle1, String paramString2, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("Authority cannot be empty or null.");
    }
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle1);
    localBundle.putString("authority", paramString2);
    localBundle.putBundle("sync_extras", paramBundle1);
    localBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString1, localBundle).getToken();
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle, paramIntent);
  }
  
  @Deprecated
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    return getTokenWithNotification(paramContext, new Account(paramString1, "com.google"), paramString2, paramBundle1, paramString3, paramBundle2);
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  /* Error */
  public static TokenData zza(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 4
    //   6: ldc 84
    //   8: invokestatic 90	com/google/android/gms/common/internal/zzx:zzcj	(Ljava/lang/String;)V
    //   11: aload 4
    //   13: invokestatic 94	com/google/android/gms/auth/GoogleAuthUtil:zzaa	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +160 -> 177
    //   20: new 96	android/os/Bundle
    //   23: dup
    //   24: invokespecial 97	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 101	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 106	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc 108
    //   39: aload_0
    //   40: invokevirtual 111	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 45	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   47: invokevirtual 150	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +11 -> 64
    //   56: aload_3
    //   57: getstatic 45	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   60: aload_0
    //   61: invokevirtual 111	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_3
    //   65: ldc_w 307
    //   68: invokestatic 313	android/os/SystemClock:elapsedRealtime	()J
    //   71: invokevirtual 317	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   74: new 117	com/google/android/gms/common/zza
    //   77: dup
    //   78: invokespecial 118	com/google/android/gms/common/zza:<init>	()V
    //   81: astore_0
    //   82: aload 4
    //   84: invokestatic 124	com/google/android/gms/common/internal/zzl:zzal	(Landroid/content/Context;)Lcom/google/android/gms/common/internal/zzl;
    //   87: astore 4
    //   89: aload 4
    //   91: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   94: aload_0
    //   95: ldc 126
    //   97: invokevirtual 130	com/google/android/gms/common/internal/zzl:zza	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   100: ifeq +190 -> 290
    //   103: aload_0
    //   104: invokevirtual 134	com/google/android/gms/common/zza:zzno	()Landroid/os/IBinder;
    //   107: invokestatic 139	com/google/android/gms/internal/zzau$zza:zza	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzau;
    //   110: aload_1
    //   111: aload_2
    //   112: aload_3
    //   113: invokeinterface 320 4 0
    //   118: astore_2
    //   119: aload_2
    //   120: ifnonnull +69 -> 189
    //   123: ldc 126
    //   125: ldc_w 322
    //   128: invokestatic 326	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: new 70	com/google/android/gms/auth/GoogleAuthException
    //   135: dup
    //   136: ldc_w 328
    //   139: invokespecial 157	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   142: athrow
    //   143: astore_1
    //   144: ldc 126
    //   146: ldc -97
    //   148: aload_1
    //   149: invokestatic 165	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   152: pop
    //   153: new 72	java/io/IOException
    //   156: dup
    //   157: ldc -89
    //   159: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   162: athrow
    //   163: astore_1
    //   164: aload 4
    //   166: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   169: aload_0
    //   170: ldc 126
    //   172: invokevirtual 172	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   175: aload_1
    //   176: athrow
    //   177: new 96	android/os/Bundle
    //   180: dup
    //   181: aload_3
    //   182: invokespecial 330	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   185: astore_3
    //   186: goto -158 -> 28
    //   189: aload_2
    //   190: ldc_w 332
    //   193: invokestatic 335	com/google/android/gms/auth/TokenData:zza	(Landroid/os/Bundle;Ljava/lang/String;)Lcom/google/android/gms/auth/TokenData;
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +16 -> 214
    //   201: aload 4
    //   203: getstatic 57	com/google/android/gms/auth/GoogleAuthUtil:zzRw	Landroid/content/ComponentName;
    //   206: aload_0
    //   207: ldc 126
    //   209: invokevirtual 172	com/google/android/gms/common/internal/zzl:zzb	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   212: aload_1
    //   213: areturn
    //   214: aload_2
    //   215: ldc -110
    //   217: invokevirtual 150	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   220: astore_1
    //   221: aload_2
    //   222: ldc_w 337
    //   225: invokevirtual 341	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   228: checkcast 343	android/content/Intent
    //   231: astore_2
    //   232: aload_1
    //   233: invokestatic 349	com/google/android/gms/auth/firstparty/shared/zzd:zzbE	(Ljava/lang/String;)Lcom/google/android/gms/auth/firstparty/shared/zzd;
    //   236: astore_3
    //   237: aload_3
    //   238: invokestatic 352	com/google/android/gms/auth/firstparty/shared/zzd:zza	(Lcom/google/android/gms/auth/firstparty/shared/zzd;)Z
    //   241: ifeq +24 -> 265
    //   244: new 218	com/google/android/gms/auth/UserRecoverableAuthException
    //   247: dup
    //   248: aload_1
    //   249: aload_2
    //   250: invokespecial 355	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   253: athrow
    //   254: astore_1
    //   255: new 70	com/google/android/gms/auth/GoogleAuthException
    //   258: dup
    //   259: ldc -82
    //   261: invokespecial 157	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   264: athrow
    //   265: aload_3
    //   266: invokestatic 357	com/google/android/gms/auth/firstparty/shared/zzd:zzc	(Lcom/google/android/gms/auth/firstparty/shared/zzd;)Z
    //   269: ifeq +12 -> 281
    //   272: new 72	java/io/IOException
    //   275: dup
    //   276: aload_1
    //   277: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   280: athrow
    //   281: new 70	com/google/android/gms/auth/GoogleAuthException
    //   284: dup
    //   285: aload_1
    //   286: invokespecial 157	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   289: athrow
    //   290: new 72	java/io/IOException
    //   293: dup
    //   294: ldc -80
    //   296: invokespecial 168	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   299: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramContext	Context
    //   0	300	1	paramAccount	Account
    //   0	300	2	paramString	String
    //   0	300	3	paramBundle	Bundle
    //   4	198	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   103	119	143	android/os/RemoteException
    //   123	143	143	android/os/RemoteException
    //   189	197	143	android/os/RemoteException
    //   214	254	143	android/os/RemoteException
    //   265	281	143	android/os/RemoteException
    //   281	290	143	android/os/RemoteException
    //   103	119	163	finally
    //   123	143	163	finally
    //   144	163	163	finally
    //   189	197	163	finally
    //   214	254	163	finally
    //   255	265	163	finally
    //   265	281	163	finally
    //   281	290	163	finally
    //   103	119	254	java/lang/InterruptedException
    //   123	143	254	java/lang/InterruptedException
    //   189	197	254	java/lang/InterruptedException
    //   214	254	254	java/lang/InterruptedException
    //   265	281	254	java/lang/InterruptedException
    //   281	290	254	java/lang/InterruptedException
  }
  
  private static void zzaa(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.zzaa(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException paramContext)
    {
      throw new GooglePlayServicesAvailabilityException(paramContext.getConnectionStatusCode(), paramContext.getMessage(), paramContext.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException paramContext)
    {
      throw new GoogleAuthException(paramContext.getMessage());
    }
  }
  
  public static TokenData zzb(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("handle_notification", true);
    return zzc(paramContext, paramAccount, paramString, localBundle);
  }
  
  private static TokenData zzc(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
    throws IOException, GoogleAuthException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    try
    {
      paramAccount = zza(paramContext, paramAccount, paramString, localBundle);
      GooglePlayServicesUtil.zzac(paramContext);
      return paramAccount;
    }
    catch (GooglePlayServicesAvailabilityException paramAccount)
    {
      GooglePlayServicesUtil.showErrorNotification(paramAccount.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException paramAccount)
    {
      GooglePlayServicesUtil.zzac(paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static void zzi(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    paramIntent = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(paramIntent, 1);
      return;
    }
    catch (URISyntaxException paramIntent)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */