package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCanceledListener;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl$LoaderInfo
  implements Loader.OnLoadCompleteListener<Object>, Loader.OnLoadCanceledListener<Object>
{
  final Bundle mArgs;
  LoaderManager.LoaderCallbacks<Object> mCallbacks;
  Object mData;
  boolean mDeliveredData;
  boolean mDestroyed;
  boolean mHaveData;
  final int mId;
  boolean mListenerRegistered;
  Loader<Object> mLoader;
  LoaderInfo mPendingLoader;
  boolean mReportNextStart;
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  
  public LoaderManagerImpl$LoaderInfo(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    mId = paramBundle;
    mArgs = paramLoaderCallbacks;
    LoaderManager.LoaderCallbacks localLoaderCallbacks;
    mCallbacks = localLoaderCallbacks;
  }
  
  void callOnLoadFinished(Loader<Object> paramLoader, Object paramObject)
  {
    String str;
    if (mCallbacks != null)
    {
      str = null;
      if (LoaderManagerImpl.access$000(this$0) != null)
      {
        str = access$000this$0).mFragmentManager.mNoTransactionsBecause;
        access$000this$0).mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
      }
    }
    try
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  onLoadFinished in " + paramLoader + ": " + paramLoader.dataToString(paramObject));
      }
      mCallbacks.onLoadFinished(paramLoader, paramObject);
      if (LoaderManagerImpl.access$000(this$0) != null) {
        access$000this$0).mFragmentManager.mNoTransactionsBecause = str;
      }
      mDeliveredData = true;
      return;
    }
    finally
    {
      if (LoaderManagerImpl.access$000(this$0) != null) {
        access$000this$0).mFragmentManager.mNoTransactionsBecause = str;
      }
    }
  }
  
  void cancel()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Canceling: " + this);
    }
    if ((mStarted) && (mLoader != null) && (mListenerRegistered) && (!mLoader.cancelLoad())) {
      onLoadCanceled(mLoader);
    }
  }
  
  void destroy()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Destroying: " + this);
    }
    mDestroyed = true;
    boolean bool = mDeliveredData;
    mDeliveredData = false;
    String str;
    if ((mCallbacks != null) && (mLoader != null) && (mHaveData) && (bool))
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Reseting: " + this);
      }
      str = null;
      if (LoaderManagerImpl.access$000(this$0) != null)
      {
        str = access$000this$0).mFragmentManager.mNoTransactionsBecause;
        access$000this$0).mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
      }
    }
    try
    {
      mCallbacks.onLoaderReset(mLoader);
      if (LoaderManagerImpl.access$000(this$0) != null) {
        access$000this$0).mFragmentManager.mNoTransactionsBecause = str;
      }
      mCallbacks = null;
      mData = null;
      mHaveData = false;
      if (mLoader != null)
      {
        if (mListenerRegistered)
        {
          mListenerRegistered = false;
          mLoader.unregisterListener(this);
          mLoader.unregisterOnLoadCanceledListener(this);
        }
        mLoader.reset();
      }
      if (mPendingLoader != null) {
        mPendingLoader.destroy();
      }
      return;
    }
    finally
    {
      if (LoaderManagerImpl.access$000(this$0) != null) {
        access$000this$0).mFragmentManager.mNoTransactionsBecause = str;
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(mId);
    paramPrintWriter.print(" mArgs=");
    paramPrintWriter.println(mArgs);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCallbacks=");
    paramPrintWriter.println(mCallbacks);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoader=");
    paramPrintWriter.println(mLoader);
    if (mLoader != null) {
      mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if ((mHaveData) || (mDeliveredData))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHaveData=");
      paramPrintWriter.print(mHaveData);
      paramPrintWriter.print("  mDeliveredData=");
      paramPrintWriter.println(mDeliveredData);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(mData);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mStarted=");
    paramPrintWriter.print(mStarted);
    paramPrintWriter.print(" mReportNextStart=");
    paramPrintWriter.print(mReportNextStart);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(mDestroyed);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetaining=");
    paramPrintWriter.print(mRetaining);
    paramPrintWriter.print(" mRetainingStarted=");
    paramPrintWriter.print(mRetainingStarted);
    paramPrintWriter.print(" mListenerRegistered=");
    paramPrintWriter.println(mListenerRegistered);
    if (mPendingLoader != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(mPendingLoader);
      paramPrintWriter.println(":");
      mPendingLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  void finishRetain()
  {
    if (mRetaining)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Finished Retaining: " + this);
      }
      mRetaining = false;
      if ((mStarted != mRetainingStarted) && (!mStarted)) {
        stop();
      }
    }
    if ((mStarted) && (mHaveData) && (!mReportNextStart)) {
      callOnLoadFinished(mLoader, mData);
    }
  }
  
  public void onLoadCanceled(Loader<Object> paramLoader)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadCanceled: " + this);
    }
    if (mDestroyed) {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
      }
    }
    do
    {
      do
      {
        return;
        if (this$0.mLoaders.get(mId) == this) {
          break;
        }
      } while (!LoaderManagerImpl.DEBUG);
      Log.v("LoaderManager", "  Ignoring load canceled -- not active");
      return;
      paramLoader = mPendingLoader;
    } while (paramLoader == null);
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Switching to pending loader: " + paramLoader);
    }
    mPendingLoader = null;
    this$0.mLoaders.put(mId, null);
    destroy();
    this$0.installLoader(paramLoader);
  }
  
  public void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadComplete: " + this);
    }
    if (mDestroyed) {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
      }
    }
    do
    {
      do
      {
        return;
        if (this$0.mLoaders.get(mId) == this) {
          break;
        }
      } while (!LoaderManagerImpl.DEBUG);
      Log.v("LoaderManager", "  Ignoring load complete -- not active");
      return;
      LoaderInfo localLoaderInfo = mPendingLoader;
      if (localLoaderInfo != null)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo);
        }
        mPendingLoader = null;
        this$0.mLoaders.put(mId, null);
        destroy();
        this$0.installLoader(localLoaderInfo);
        return;
      }
      if ((mData != paramObject) || (!mHaveData))
      {
        mData = paramObject;
        mHaveData = true;
        if (mStarted) {
          callOnLoadFinished(paramLoader, paramObject);
        }
      }
      paramLoader = (LoaderInfo)this$0.mInactiveLoaders.get(mId);
      if ((paramLoader != null) && (paramLoader != this))
      {
        mDeliveredData = false;
        paramLoader.destroy();
        this$0.mInactiveLoaders.remove(mId);
      }
    } while ((LoaderManagerImpl.access$000(this$0) == null) || (this$0.hasRunningLoaders()));
    access$000this$0).mFragmentManager.startPendingDeferredFragments();
  }
  
  void reportStart()
  {
    if ((mStarted) && (mReportNextStart))
    {
      mReportNextStart = false;
      if (mHaveData) {
        callOnLoadFinished(mLoader, mData);
      }
    }
  }
  
  void retain()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Retaining: " + this);
    }
    mRetaining = true;
    mRetainingStarted = mStarted;
    mStarted = false;
    mCallbacks = null;
  }
  
  void start()
  {
    if ((mRetaining) && (mRetainingStarted)) {
      mStarted = true;
    }
    do
    {
      do
      {
        return;
      } while (mStarted);
      mStarted = true;
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Starting: " + this);
      }
      if ((mLoader == null) && (mCallbacks != null)) {
        mLoader = mCallbacks.onCreateLoader(mId, mArgs);
      }
    } while (mLoader == null);
    if ((mLoader.getClass().isMemberClass()) && (!Modifier.isStatic(mLoader.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + mLoader);
    }
    if (!mListenerRegistered)
    {
      mLoader.registerListener(mId, this);
      mLoader.registerOnLoadCanceledListener(this);
      mListenerRegistered = true;
    }
    mLoader.startLoading();
  }
  
  void stop()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Stopping: " + this);
    }
    mStarted = false;
    if ((!mRetaining) && (mLoader != null) && (mListenerRegistered))
    {
      mListenerRegistered = false;
      mLoader.unregisterListener(this);
      mLoader.unregisterOnLoadCanceledListener(this);
      mLoader.stopLoading();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(mId);
    localStringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(mLoader, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */