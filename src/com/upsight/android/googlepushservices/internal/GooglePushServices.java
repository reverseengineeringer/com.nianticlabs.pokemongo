package com.upsight.android.googlepushservices.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.event.comm.UpsightCommRegisterEvent;
import com.upsight.android.analytics.event.comm.UpsightCommRegisterEvent.Builder;
import com.upsight.android.analytics.event.comm.UpsightCommUnregisterEvent;
import com.upsight.android.analytics.event.comm.UpsightCommUnregisterEvent.Builder;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnRegisterListener;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnUnregisterListener;
import com.upsight.android.googlepushservices.UpsightGooglePushServicesApi;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.marketing.UpsightBillboard;
import com.upsight.android.marketing.UpsightBillboard.Handler;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.HandlerScheduler;

@Singleton
public class GooglePushServices
  implements UpsightGooglePushServicesApi
{
  private static final String KEY_GCM = "com.upsight.gcm";
  private static final String LOG_TAG = GooglePushServices.class.getName();
  private static final String PREFERENCES_NAME = "com.upsight.android.googleadvertisingid.internal.registration";
  private static final String PROPERTY_APP_VERSION = "gcmApplicationVersion";
  private static final String PROPERTY_REG_ID = "gcmRegistrationId";
  static final String PUSH_SCOPE = "com_upsight_push_scope";
  private final Scheduler mComputationScheduler;
  private UpsightLogger mLogger;
  private final Set<UpsightGooglePushServices.OnRegisterListener> mPendingRegisterListeners;
  private final Set<UpsightGooglePushServices.OnUnregisterListener> mPendingUnregisterListeners;
  private SharedPreferences mPrefs;
  private UpsightBillboard mPushBillboard;
  private boolean mRegistrationIsInProgress;
  private final Handler mUiThreadHandler;
  private boolean mUnregistrationIsInProgress;
  private UpsightContext mUpsight;
  
  @Inject
  GooglePushServices(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
    mLogger = paramUpsightContext.getLogger();
    if (Looper.myLooper() != null) {}
    for (mUiThreadHandler = new Handler(Looper.myLooper());; mUiThreadHandler = new Handler(Looper.getMainLooper()))
    {
      mComputationScheduler = paramUpsightContext.getCoreComponent().subscribeOnScheduler();
      mRegistrationIsInProgress = false;
      mUnregistrationIsInProgress = false;
      mPendingRegisterListeners = new HashSet();
      mPendingUnregisterListeners = new HashSet();
      mPrefs = mUpsight.getSharedPreferences("com.upsight.android.googleadvertisingid.internal.registration", 0);
      return;
    }
  }
  
  private int getAppVersion()
  {
    try
    {
      int i = mUpsight.getPackageManager().getPackageInfo(mUpsight.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Could not get package name: " + localNameNotFoundException);
    }
  }
  
  private String getRegistrationId()
  {
    String str = mPrefs.getString("gcmRegistrationId", null);
    if (TextUtils.isEmpty(str)) {
      str = null;
    }
    while (mPrefs.getInt("gcmApplicationVersion", Integer.MIN_VALUE) == getAppVersion()) {
      return str;
    }
    return null;
  }
  
  private boolean hasPlayServices()
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mUpsight);
    if (i != 0)
    {
      mLogger.e(LOG_TAG, "Google play service is not available: ", new Object[] { GooglePlayServicesUtil.getErrorString(i) });
      return false;
    }
    return true;
  }
  
  private boolean isRegistered()
  {
    return getRegistrationId() != null;
  }
  
  private void registerInBackground(final String paramString)
  {
    mRegistrationIsInProgress = true;
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super String> paramAnonymousSubscriber)
      {
        try
        {
          paramAnonymousSubscriber.onNext(GoogleCloudMessaging.getInstance(mUpsight).register(new String[] { paramString }));
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (IOException localIOException)
        {
          paramAnonymousSubscriber.onError(localIOException);
        }
      }
    }).subscribeOn(mComputationScheduler).observeOn(HandlerScheduler.from(mUiThreadHandler)).subscribe(new Observer()
    {
      public void onCompleted() {}
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        synchronized (GooglePushServices.this)
        {
          HashSet localHashSet = new HashSet(mPendingRegisterListeners);
          mPendingRegisterListeners.clear();
          GooglePushServices.access$202(GooglePushServices.this, false);
          ??? = localHashSet.iterator();
          if (((Iterator)???).hasNext()) {
            ((UpsightGooglePushServices.OnRegisterListener)((Iterator)???).next()).onFailure(new UpsightException(paramAnonymousThrowable));
          }
        }
      }
      
      public void onNext(String paramAnonymousString)
      {
        synchronized (GooglePushServices.this)
        {
          GooglePushServices.this.storeRegistrationId(paramAnonymousString);
          UpsightCommRegisterEvent.createBuilder().setToken(paramAnonymousString).record(mUpsight);
          HashSet localHashSet = new HashSet(mPendingRegisterListeners);
          mPendingRegisterListeners.clear();
          GooglePushServices.access$202(GooglePushServices.this, false);
          ??? = localHashSet.iterator();
          if (((Iterator)???).hasNext()) {
            ((UpsightGooglePushServices.OnRegisterListener)((Iterator)???).next()).onSuccess(paramAnonymousString);
          }
        }
      }
    });
  }
  
  private void storeRegistrationId(String paramString)
  {
    int i = getAppVersion();
    SharedPreferences.Editor localEditor = mPrefs.edit();
    localEditor.putString("gcmRegistrationId", paramString);
    localEditor.putInt("gcmApplicationVersion", i);
    localEditor.apply();
  }
  
  private void unregisterInBackground()
  {
    mUnregistrationIsInProgress = true;
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super String> paramAnonymousSubscriber)
      {
        try
        {
          GoogleCloudMessaging.getInstance(mUpsight).unregister();
          paramAnonymousSubscriber.onCompleted();
          return;
        }
        catch (IOException localIOException)
        {
          paramAnonymousSubscriber.onError(localIOException);
        }
      }
    }).subscribeOn(mComputationScheduler).observeOn(HandlerScheduler.from(mUiThreadHandler)).subscribe(new Observer()
    {
      public void onCompleted()
      {
        synchronized (GooglePushServices.this)
        {
          UpsightCommUnregisterEvent.createBuilder().record(mUpsight);
          HashSet localHashSet = new HashSet(mPendingUnregisterListeners);
          mPendingUnregisterListeners.clear();
          GooglePushServices.access$502(GooglePushServices.this, false);
          ??? = localHashSet.iterator();
          if (((Iterator)???).hasNext()) {
            ((UpsightGooglePushServices.OnUnregisterListener)((Iterator)???).next()).onSuccess();
          }
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        synchronized (GooglePushServices.this)
        {
          HashSet localHashSet = new HashSet(mPendingUnregisterListeners);
          mPendingUnregisterListeners.clear();
          GooglePushServices.access$502(GooglePushServices.this, false);
          ??? = localHashSet.iterator();
          if (((Iterator)???).hasNext()) {
            ((UpsightGooglePushServices.OnUnregisterListener)((Iterator)???).next()).onFailure(new UpsightException(paramAnonymousThrowable));
          }
        }
      }
      
      public void onNext(String paramAnonymousString) {}
    });
  }
  
  public UpsightBillboard createPushBillboard(UpsightContext paramUpsightContext, UpsightBillboard.Handler paramHandler)
    throws IllegalArgumentException, IllegalStateException
  {
    try
    {
      if (mPushBillboard != null)
      {
        mPushBillboard.destroy();
        mPushBillboard = null;
      }
      mPushBillboard = UpsightBillboard.create(paramUpsightContext, "com_upsight_push_scope", paramHandler);
      paramUpsightContext = mPushBillboard;
      return paramUpsightContext;
    }
    finally {}
  }
  
  public void register(UpsightGooglePushServices.OnRegisterListener paramOnRegisterListener)
  {
    if (paramOnRegisterListener == null) {
      try
      {
        throw new IllegalArgumentException("Listener could not be null");
      }
      finally {}
    }
    if (!hasPlayServices()) {
      paramOnRegisterListener.onFailure(new UpsightException("Google Play Services are not available", new Object[0]));
    }
    for (;;)
    {
      return;
      if (mUnregistrationIsInProgress)
      {
        paramOnRegisterListener.onFailure(new UpsightException("Unregistration is in progress, try later", new Object[0]));
      }
      else
      {
        Object localObject7 = null;
        Object localObject6 = null;
        Object localObject5 = null;
        Object localObject1 = localObject7;
        Object localObject4;
        try
        {
          Object localObject8 = mUpsight.getPackageManager().getApplicationInfo(mUpsight.getPackageName(), 128).metaData;
          localObject2 = localObject6;
          localObject4 = localObject5;
          if (localObject8 != null)
          {
            localObject1 = localObject7;
            localObject8 = ((Bundle)localObject8).getString("com.upsight.gcm");
            localObject2 = localObject6;
            localObject4 = localObject5;
            localObject1 = localObject7;
            if (!TextUtils.isEmpty((CharSequence)localObject8))
            {
              localObject1 = localObject7;
              localObject2 = ((String)localObject8).substring(0, ((String)localObject8).lastIndexOf('.'));
              localObject1 = localObject2;
              localObject4 = ((String)localObject8).substring(((String)localObject8).lastIndexOf('.') + 1);
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Object localObject2;
            mLogger.e("Upsight", "Unexpected error: Package name missing!?", new Object[] { localNameNotFoundException });
            Object localObject3 = localObject1;
            localObject4 = localObject5;
          }
          mPendingRegisterListeners.add(paramOnRegisterListener);
        }
        if ((!mUpsight.getPackageName().equals(localObject2)) || (TextUtils.isEmpty((CharSequence)localObject4)))
        {
          mLogger.e(LOG_TAG, "Registration aborted, wrong or no value for com.upsight.gcm was defined", new Object[0]);
          if (!mUpsight.getPackageName().equals(localObject2)) {
            mLogger.e(LOG_TAG, "Check that the package name of your application is specified correctly", new Object[0]);
          }
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            mLogger.e(LOG_TAG, "Check that your GCM sender id is specified correctly", new Object[0]);
          }
          paramOnRegisterListener.onFailure(new UpsightException("GCM properties must be set in the Android Manifest with <meta-data android:name=\"com.upsight.gcm\" android:value=\"" + mUpsight.getPackageName() + ".GCM_SENDER_ID\" />", new Object[0]));
        }
        else if (!mRegistrationIsInProgress)
        {
          registerInBackground((String)localObject4);
        }
      }
    }
  }
  
  public void unregister(UpsightGooglePushServices.OnUnregisterListener paramOnUnregisterListener)
  {
    if (paramOnUnregisterListener == null) {
      try
      {
        throw new IllegalArgumentException("Listener could not be null");
      }
      finally {}
    }
    if (!isRegistered()) {
      paramOnUnregisterListener.onFailure(new UpsightException("Application is not registered to pushes yet", new Object[0]));
    }
    for (;;)
    {
      return;
      if (mRegistrationIsInProgress)
      {
        paramOnUnregisterListener.onFailure(new UpsightException("Registration is in progress, try later", new Object[0]));
      }
      else
      {
        mPendingUnregisterListeners.add(paramOnUnregisterListener);
        if (!mUnregistrationIsInProgress) {
          unregisterInBackground();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GooglePushServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */