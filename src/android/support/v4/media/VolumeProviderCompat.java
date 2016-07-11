package android.support.v4.media;

import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat
{
  public static final int VOLUME_CONTROL_ABSOLUTE = 2;
  public static final int VOLUME_CONTROL_FIXED = 0;
  public static final int VOLUME_CONTROL_RELATIVE = 1;
  private Callback mCallback;
  private final int mControlType;
  private int mCurrentVolume;
  private final int mMaxVolume;
  private Object mVolumeProviderObj;
  
  public VolumeProviderCompat(int paramInt1, int paramInt2, int paramInt3)
  {
    mControlType = paramInt1;
    mMaxVolume = paramInt2;
    mCurrentVolume = paramInt3;
  }
  
  public final int getCurrentVolume()
  {
    return mCurrentVolume;
  }
  
  public final int getMaxVolume()
  {
    return mMaxVolume;
  }
  
  public final int getVolumeControl()
  {
    return mControlType;
  }
  
  public Object getVolumeProvider()
  {
    if ((mVolumeProviderObj != null) || (Build.VERSION.SDK_INT < 21)) {
      return mVolumeProviderObj;
    }
    mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(mControlType, mMaxVolume, mCurrentVolume, new VolumeProviderCompatApi21.Delegate()
    {
      public void onAdjustVolume(int paramAnonymousInt)
      {
        VolumeProviderCompat.this.onAdjustVolume(paramAnonymousInt);
      }
      
      public void onSetVolumeTo(int paramAnonymousInt)
      {
        VolumeProviderCompat.this.onSetVolumeTo(paramAnonymousInt);
      }
    });
    return mVolumeProviderObj;
  }
  
  public void onAdjustVolume(int paramInt) {}
  
  public void onSetVolumeTo(int paramInt) {}
  
  public void setCallback(Callback paramCallback)
  {
    mCallback = paramCallback;
  }
  
  public final void setCurrentVolume(int paramInt)
  {
    mCurrentVolume = paramInt;
    Object localObject = getVolumeProvider();
    if (localObject != null) {
      VolumeProviderCompatApi21.setCurrentVolume(localObject, paramInt);
    }
    if (mCallback != null) {
      mCallback.onVolumeChanged(this);
    }
  }
  
  public static abstract class Callback
  {
    public abstract void onVolumeChanged(VolumeProviderCompat paramVolumeProviderCompat);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ControlType {}
}

/* Location:
 * Qualified Name:     android.support.v4.media.VolumeProviderCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */