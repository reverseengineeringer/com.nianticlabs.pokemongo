package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat
  extends ContextCompat
{
  private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback paramSharedElementCallback)
  {
    SharedElementCallback21Impl localSharedElementCallback21Impl = null;
    if (paramSharedElementCallback != null) {
      localSharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback);
    }
    return localSharedElementCallback21Impl;
  }
  
  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompatJB.finishAffinity(paramActivity);
      return;
    }
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ActivityCompat21.finishAfterTransition(paramActivity);
      return;
    }
    paramActivity.finish();
  }
  
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      ActivityCompatHoneycomb.invalidateOptionsMenu(paramActivity);
      return true;
    }
    return false;
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.postponeEnterTransition(paramActivity);
    }
  }
  
  public static void requestPermissions(@NonNull final Activity paramActivity, @NonNull String[] paramArrayOfString, final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.requestPermissions(paramActivity, paramArrayOfString, paramInt);
    }
    while (!(paramActivity instanceof OnRequestPermissionsResultCallback)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        int[] arrayOfInt = new int[val$permissions.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int j = val$permissions.length;
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = localPackageManager.checkPermission(val$permissions[i], str);
          i += 1;
        }
        ((ActivityCompat.OnRequestPermissionsResultCallback)paramActivity).onRequestPermissionsResult(paramInt, val$permissions, arrayOfInt);
      }
    });
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.setEnterSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
    }
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.setExitSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
    }
  }
  
  public static boolean shouldShowRequestPermissionRationale(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return ActivityCompatApi23.shouldShowRequestPermissionRationale(paramActivity, paramString);
    }
    return false;
  }
  
  public static void startActivity(Activity paramActivity, Intent paramIntent, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompatJB.startActivity(paramActivity, paramIntent, paramBundle);
      return;
    }
    paramActivity.startActivity(paramIntent);
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityCompatJB.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompat21.startPostponedEnterTransition(paramActivity);
    }
  }
  
  public Uri getReferrer(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      paramActivity = ActivityCompat22.getReferrer(paramActivity);
    }
    Intent localIntent;
    Uri localUri;
    do
    {
      return paramActivity;
      localIntent = paramActivity.getIntent();
      localUri = (Uri)localIntent.getParcelableExtra("android.intent.extra.REFERRER");
      paramActivity = localUri;
    } while (localUri != null);
    paramActivity = localIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (paramActivity != null) {
      return Uri.parse(paramActivity);
    }
    return null;
  }
  
  public static abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt);
  }
  
  private static class SharedElementCallback21Impl
    extends ActivityCompat21.SharedElementCallback21
  {
    private SharedElementCallback mCallback;
    
    public SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
    {
      mCallback = paramSharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      mCallback.onMapSharedElements(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List<View> paramList)
    {
      mCallback.onRejectSharedElements(paramList);
    }
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */