package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E>
  extends FragmentContainer
{
  private final Activity mActivity;
  private SimpleArrayMap<String, LoaderManager> mAllLoaderManagers;
  private boolean mCheckedForLoaderManager;
  final Context mContext;
  final FragmentManagerImpl mFragmentManager = new FragmentManagerImpl();
  private final Handler mHandler;
  private LoaderManagerImpl mLoaderManager;
  private boolean mLoadersStarted;
  final int mWindowAnimations;
  
  FragmentHostCallback(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    mActivity = paramActivity;
    mContext = paramContext;
    mHandler = paramHandler;
    mWindowAnimations = paramInt;
  }
  
  public FragmentHostCallback(Context paramContext, Handler paramHandler, int paramInt)
  {
    this(null, paramContext, paramHandler, paramInt);
  }
  
  FragmentHostCallback(FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity, paramFragmentActivity, mHandler, 0);
  }
  
  void doLoaderDestroy()
  {
    if (mLoaderManager == null) {
      return;
    }
    mLoaderManager.doDestroy();
  }
  
  void doLoaderRetain()
  {
    if (mLoaderManager == null) {
      return;
    }
    mLoaderManager.doRetain();
  }
  
  void doLoaderStart()
  {
    if (mLoadersStarted) {
      return;
    }
    mLoadersStarted = true;
    if (mLoaderManager != null) {
      mLoaderManager.doStart();
    }
    for (;;)
    {
      mCheckedForLoaderManager = true;
      return;
      if (!mCheckedForLoaderManager)
      {
        mLoaderManager = getLoaderManager("(root)", mLoadersStarted, false);
        if ((mLoaderManager != null) && (!mLoaderManager.mStarted)) {
          mLoaderManager.doStart();
        }
      }
    }
  }
  
  void doLoaderStop(boolean paramBoolean)
  {
    if (mLoaderManager == null) {}
    while (!mLoadersStarted) {
      return;
    }
    mLoadersStarted = false;
    if (paramBoolean)
    {
      mLoaderManager.doRetain();
      return;
    }
    mLoaderManager.doStop();
  }
  
  void dumpLoaders(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(mLoadersStarted);
    if (mLoaderManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
      paramPrintWriter.println(":");
      mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  Activity getActivity()
  {
    return mActivity;
  }
  
  Context getContext()
  {
    return mContext;
  }
  
  FragmentManagerImpl getFragmentManagerImpl()
  {
    return mFragmentManager;
  }
  
  Handler getHandler()
  {
    return mHandler;
  }
  
  LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mAllLoaderManagers == null) {
      mAllLoaderManagers = new SimpleArrayMap();
    }
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(paramString);
    if (localLoaderManagerImpl == null)
    {
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
        mAllLoaderManagers.put(paramString, localLoaderManagerImpl);
      }
      return localLoaderManagerImpl;
    }
    localLoaderManagerImpl.updateHostController(this);
    return localLoaderManagerImpl;
  }
  
  LoaderManagerImpl getLoaderManagerImpl()
  {
    if (mLoaderManager != null) {
      return mLoaderManager;
    }
    mCheckedForLoaderManager = true;
    mLoaderManager = getLoaderManager("(root)", mLoadersStarted, true);
    return mLoaderManager;
  }
  
  void inactivateFragment(String paramString)
  {
    if (mAllLoaderManagers != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)mAllLoaderManagers.get(paramString);
      if ((localLoaderManagerImpl != null) && (!mRetaining))
      {
        localLoaderManagerImpl.doDestroy();
        mAllLoaderManagers.remove(paramString);
      }
    }
  }
  
  void onAttachFragment(Fragment paramFragment) {}
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  @Nullable
  public View onFindViewById(int paramInt)
  {
    return null;
  }
  
  @Nullable
  public abstract E onGetHost();
  
  public LayoutInflater onGetLayoutInflater()
  {
    return (LayoutInflater)mContext.getSystemService("layout_inflater");
  }
  
  public int onGetWindowAnimations()
  {
    return mWindowAnimations;
  }
  
  public boolean onHasView()
  {
    return true;
  }
  
  public boolean onHasWindowAnimations()
  {
    return true;
  }
  
  public void onRequestPermissionsFromFragment(@NonNull Fragment paramFragment, @NonNull String[] paramArrayOfString, int paramInt) {}
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment)
  {
    return true;
  }
  
  public boolean onShouldShowRequestPermissionRationale(@NonNull String paramString)
  {
    return false;
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt != -1) {
      throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    mContext.startActivity(paramIntent);
  }
  
  public void onSupportInvalidateOptionsMenu() {}
  
  void reportLoaderStart()
  {
    if (mAllLoaderManagers != null)
    {
      int j = mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[j];
      int i = j - 1;
      while (i >= 0)
      {
        arrayOfLoaderManagerImpl[i] = ((LoaderManagerImpl)mAllLoaderManagers.valueAt(i));
        i -= 1;
      }
      i = 0;
      while (i < j)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[i];
        localLoaderManagerImpl.finishRetain();
        localLoaderManagerImpl.doReportStart();
        i += 1;
      }
    }
  }
  
  void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> paramSimpleArrayMap)
  {
    mAllLoaderManagers = paramSimpleArrayMap;
  }
  
  SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig()
  {
    int k = 0;
    int j = 0;
    if (mAllLoaderManagers != null)
    {
      int m = mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[m];
      int i = m - 1;
      while (i >= 0)
      {
        arrayOfLoaderManagerImpl[i] = ((LoaderManagerImpl)mAllLoaderManagers.valueAt(i));
        i -= 1;
      }
      k = 0;
      i = j;
      j = k;
      k = i;
      if (j < m)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[j];
        if (mRetaining) {
          i = 1;
        }
        for (;;)
        {
          j += 1;
          break;
          localLoaderManagerImpl.doDestroy();
          mAllLoaderManagers.remove(mWho);
        }
      }
    }
    if (k != 0) {
      return mAllLoaderManagers;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentHostCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */