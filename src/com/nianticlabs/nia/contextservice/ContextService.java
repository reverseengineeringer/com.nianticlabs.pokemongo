package com.nianticlabs.nia.contextservice;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public abstract class ContextService
{
  private static final Handler handler = new Handler(handlerThread.getLooper());
  private static final HandlerThread handlerThread = new HandlerThread("ContextService");
  private static final Handler mainHandler = new Handler(Looper.getMainLooper());
  protected final long NULL_POINTER = 0L;
  protected final Object callbackLock = new Object();
  protected final Context context;
  protected long nativeClassPointer;
  private Runnable runOnPause = new Runnable()
  {
    public void run()
    {
      onPause();
    }
  };
  private Runnable runOnResume = new Runnable()
  {
    public void run()
    {
      onResume();
    }
  };
  private Runnable runOnStart = new Runnable()
  {
    public void run()
    {
      onStart();
    }
  };
  private Runnable runOnStop = new Runnable()
  {
    public void run()
    {
      onStop();
    }
  };
  
  static
  {
    handlerThread.start();
  }
  
  public ContextService(Context paramContext, long paramLong)
  {
    context = paramContext;
    nativeClassPointer = paramLong;
  }
  
  public static void assertOnServiceThread()
  {
    if (!onServiceThread()) {
      throw new RuntimeException("Must be on the service thread");
    }
  }
  
  public static Handler getServiceHandler()
  {
    return handler;
  }
  
  public static Looper getServiceLooper()
  {
    return handlerThread.getLooper();
  }
  
  private void invokeOnPause()
  {
    runOnServiceHandler(runOnPause);
  }
  
  private void invokeOnResume()
  {
    runOnServiceHandler(runOnResume);
  }
  
  private void invokeOnStart()
  {
    runOnServiceHandler(runOnStart);
  }
  
  private void invokeOnStop()
  {
    runOnServiceHandler(runOnStop);
  }
  
  public static boolean onServiceThread()
  {
    return Looper.myLooper() == handlerThread.getLooper();
  }
  
  public static boolean onUiThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static void runOnServiceHandler(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    mainHandler.post(paramRunnable);
  }
  
  public static native void setActivityProviderClass(String paramString);
  
  public Context getContext()
  {
    return context;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public final void resetNativeClassPointer()
  {
    synchronized (callbackLock)
    {
      nativeClassPointer = 0L;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.contextservice.ContextService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */