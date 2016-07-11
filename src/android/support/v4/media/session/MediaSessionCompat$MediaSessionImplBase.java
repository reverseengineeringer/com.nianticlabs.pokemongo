package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat.Callback;
import android.view.KeyEvent;
import java.util.List;

class MediaSessionCompat$MediaSessionImplBase
  implements MediaSessionCompat.MediaSessionImpl
{
  private final AudioManager mAudioManager;
  private MediaSessionCompat.Callback mCallback;
  private final ComponentName mComponentName;
  private final Context mContext;
  private final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList();
  private boolean mDestroyed = false;
  private Bundle mExtras;
  private int mFlags;
  private final MessageHandler mHandler;
  private boolean mIsActive = false;
  private boolean mIsMbrRegistered = false;
  private boolean mIsRccRegistered = false;
  private int mLocalStream;
  private final Object mLock = new Object();
  private final PendingIntent mMediaButtonEventReceiver;
  private MediaMetadataCompat mMetadata;
  private final String mPackageName;
  private List<MediaSessionCompat.QueueItem> mQueue;
  private CharSequence mQueueTitle;
  private int mRatingType;
  private final Object mRccObj;
  private PendingIntent mSessionActivity;
  private PlaybackStateCompat mState;
  private final MediaSessionStub mStub;
  private final String mTag;
  private final MediaSessionCompat.Token mToken;
  private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback()
  {
    public void onVolumeChanged(VolumeProviderCompat paramAnonymousVolumeProviderCompat)
    {
      if (mVolumeProvider != paramAnonymousVolumeProviderCompat) {
        return;
      }
      paramAnonymousVolumeProviderCompat = new ParcelableVolumeInfo(mVolumeType, mLocalStream, paramAnonymousVolumeProviderCompat.getVolumeControl(), paramAnonymousVolumeProviderCompat.getMaxVolume(), paramAnonymousVolumeProviderCompat.getCurrentVolume());
      MediaSessionCompat.MediaSessionImplBase.this.sendVolumeInfoChanged(paramAnonymousVolumeProviderCompat);
    }
  };
  private VolumeProviderCompat mVolumeProvider;
  private int mVolumeType;
  
  public MediaSessionCompat$MediaSessionImplBase(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
  {
    if (paramComponentName == null) {
      throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
    }
    mContext = paramContext;
    mPackageName = paramContext.getPackageName();
    mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    mTag = paramString;
    mComponentName = paramComponentName;
    mMediaButtonEventReceiver = paramPendingIntent;
    mStub = new MediaSessionStub();
    mToken = new MediaSessionCompat.Token(mStub);
    mHandler = new MessageHandler(Looper.myLooper());
    mRatingType = 0;
    mVolumeType = 1;
    mLocalStream = 3;
    if (Build.VERSION.SDK_INT >= 14)
    {
      mRccObj = MediaSessionCompatApi14.createRemoteControlClient(paramPendingIntent);
      return;
    }
    mRccObj = null;
  }
  
  private void adjustVolume(int paramInt1, int paramInt2)
  {
    if (mVolumeType == 2)
    {
      if (mVolumeProvider != null) {
        mVolumeProvider.onAdjustVolume(paramInt1);
      }
      return;
    }
    mAudioManager.adjustStreamVolume(paramInt1, mLocalStream, paramInt2);
  }
  
  private PlaybackStateCompat getStateWithUpdatedPosition()
  {
    long l2 = -1L;
    for (;;)
    {
      synchronized (mLock)
      {
        PlaybackStateCompat localPlaybackStateCompat = mState;
        l1 = l2;
        if (mMetadata != null)
        {
          l1 = l2;
          if (mMetadata.containsKey("android.media.metadata.DURATION")) {
            l1 = mMetadata.getLong("android.media.metadata.DURATION");
          }
        }
        Object localObject2 = null;
        ??? = localObject2;
        if (localPlaybackStateCompat != null) {
          if ((localPlaybackStateCompat.getState() != 3) && (localPlaybackStateCompat.getState() != 4))
          {
            ??? = localObject2;
            if (localPlaybackStateCompat.getState() != 5) {}
          }
          else
          {
            l2 = localPlaybackStateCompat.getLastPositionUpdateTime();
            long l3 = SystemClock.elapsedRealtime();
            ??? = localObject2;
            if (l2 > 0L)
            {
              l2 = (localPlaybackStateCompat.getPlaybackSpeed() * (float)(l3 - l2)) + localPlaybackStateCompat.getPosition();
              if ((l1 < 0L) || (l2 <= l1)) {
                break label205;
              }
              ??? = new PlaybackStateCompat.Builder(localPlaybackStateCompat);
              ((PlaybackStateCompat.Builder)???).setState(localPlaybackStateCompat.getState(), l1, localPlaybackStateCompat.getPlaybackSpeed(), l3);
              ??? = ((PlaybackStateCompat.Builder)???).build();
            }
          }
        }
        if (??? != null) {
          break;
        }
        return localPlaybackStateCompat;
      }
      label205:
      long l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
    }
    return (PlaybackStateCompat)???;
  }
  
  private void sendEvent(String paramString, Bundle paramBundle)
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onEvent(paramString, paramBundle);
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void sendMetadata(MediaMetadataCompat paramMediaMetadataCompat)
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onMetadataChanged(paramMediaMetadataCompat);
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void sendQueue(List<MediaSessionCompat.QueueItem> paramList)
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onQueueChanged(paramList);
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void sendQueueTitle(CharSequence paramCharSequence)
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onQueueTitleChanged(paramCharSequence);
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void sendSessionDestroyed()
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onSessionDestroyed();
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        mControllerCallbacks.kill();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void sendState(PlaybackStateCompat paramPlaybackStateCompat)
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onPlaybackStateChanged(paramPlaybackStateCompat);
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void sendVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
  {
    int i = mControllerCallbacks.beginBroadcast() - 1;
    for (;;)
    {
      IMediaControllerCallback localIMediaControllerCallback;
      if (i >= 0) {
        localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
      }
      try
      {
        localIMediaControllerCallback.onVolumeInfoChanged(paramParcelableVolumeInfo);
        i -= 1;
        continue;
        mControllerCallbacks.finishBroadcast();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
  }
  
  private void setVolumeTo(int paramInt1, int paramInt2)
  {
    if (mVolumeType == 2)
    {
      if (mVolumeProvider != null) {
        mVolumeProvider.onSetVolumeTo(paramInt1);
      }
      return;
    }
    mAudioManager.setStreamVolume(mLocalStream, paramInt1, paramInt2);
  }
  
  private boolean update()
  {
    boolean bool2 = false;
    label57:
    boolean bool1;
    if (mIsActive)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        if ((mIsMbrRegistered) || ((mFlags & 0x1) == 0)) {
          break label117;
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          MediaSessionCompatApi18.registerMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver);
          mIsMbrRegistered = true;
        }
      }
      else
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 14)
        {
          if ((mIsRccRegistered) || ((mFlags & 0x2) == 0)) {
            break label174;
          }
          MediaSessionCompatApi14.registerRemoteControlClient(mContext, mRccObj);
          mIsRccRegistered = true;
          bool1 = true;
        }
      }
      label117:
      label174:
      do
      {
        do
        {
          return bool1;
          MediaSessionCompatApi8.registerMediaButtonEventReceiver(mContext, mComponentName);
          break;
          if ((!mIsMbrRegistered) || ((mFlags & 0x1) != 0)) {
            break label57;
          }
          if (Build.VERSION.SDK_INT >= 18) {
            MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver);
          }
          for (;;)
          {
            mIsMbrRegistered = false;
            break;
            MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(mContext, mComponentName);
          }
          bool1 = bool2;
        } while (!mIsRccRegistered);
        bool1 = bool2;
      } while ((mFlags & 0x2) != 0);
      MediaSessionCompatApi14.setState(mRccObj, 0);
      MediaSessionCompatApi14.unregisterRemoteControlClient(mContext, mRccObj);
      mIsRccRegistered = false;
      return false;
    }
    if (mIsMbrRegistered)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label286;
      }
      MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver);
    }
    for (;;)
    {
      mIsMbrRegistered = false;
      bool1 = bool2;
      if (!mIsRccRegistered) {
        break;
      }
      MediaSessionCompatApi14.setState(mRccObj, 0);
      MediaSessionCompatApi14.unregisterRemoteControlClient(mContext, mRccObj);
      mIsRccRegistered = false;
      return false;
      label286:
      MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(mContext, mComponentName);
    }
  }
  
  public Object getMediaSession()
  {
    return null;
  }
  
  public Object getRemoteControlClient()
  {
    return mRccObj;
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return mToken;
  }
  
  public boolean isActive()
  {
    return mIsActive;
  }
  
  public void release()
  {
    mIsActive = false;
    mDestroyed = true;
    update();
    sendSessionDestroyed();
  }
  
  public void sendSessionEvent(String paramString, Bundle paramBundle)
  {
    sendEvent(paramString, paramBundle);
  }
  
  public void setActive(boolean paramBoolean)
  {
    if (paramBoolean == mIsActive) {}
    do
    {
      return;
      mIsActive = paramBoolean;
    } while (!update());
    setMetadata(mMetadata);
    setPlaybackState(mState);
  }
  
  public void setCallback(final MediaSessionCompat.Callback paramCallback, Handler paramHandler)
  {
    if (paramCallback == mCallback) {
      return;
    }
    if ((paramCallback == null) || (Build.VERSION.SDK_INT < 18))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(mRccObj, null);
      }
      if (Build.VERSION.SDK_INT >= 19) {
        MediaSessionCompatApi19.setOnMetadataUpdateListener(mRccObj, null);
      }
    }
    for (;;)
    {
      mCallback = paramCallback;
      return;
      if (paramHandler == null) {
        new Handler();
      }
      paramHandler = new MediaSessionCompatApi14.Callback()
      {
        public void onCommand(String paramAnonymousString, Bundle paramAnonymousBundle, ResultReceiver paramAnonymousResultReceiver)
        {
          paramCallback.onCommand(paramAnonymousString, paramAnonymousBundle, paramAnonymousResultReceiver);
        }
        
        public void onFastForward()
        {
          paramCallback.onFastForward();
        }
        
        public boolean onMediaButtonEvent(Intent paramAnonymousIntent)
        {
          return paramCallback.onMediaButtonEvent(paramAnonymousIntent);
        }
        
        public void onPause()
        {
          paramCallback.onPause();
        }
        
        public void onPlay()
        {
          paramCallback.onPlay();
        }
        
        public void onRewind()
        {
          paramCallback.onRewind();
        }
        
        public void onSeekTo(long paramAnonymousLong)
        {
          paramCallback.onSeekTo(paramAnonymousLong);
        }
        
        public void onSetRating(Object paramAnonymousObject)
        {
          paramCallback.onSetRating(RatingCompat.fromRating(paramAnonymousObject));
        }
        
        public void onSkipToNext()
        {
          paramCallback.onSkipToNext();
        }
        
        public void onSkipToPrevious()
        {
          paramCallback.onSkipToPrevious();
        }
        
        public void onStop()
        {
          paramCallback.onStop();
        }
      };
      if (Build.VERSION.SDK_INT >= 18)
      {
        Object localObject = MediaSessionCompatApi18.createPlaybackPositionUpdateListener(paramHandler);
        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(mRccObj, localObject);
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        paramHandler = MediaSessionCompatApi19.createMetadataUpdateListener(paramHandler);
        MediaSessionCompatApi19.setOnMetadataUpdateListener(mRccObj, paramHandler);
      }
    }
  }
  
  public void setExtras(Bundle paramBundle)
  {
    mExtras = paramBundle;
  }
  
  public void setFlags(int paramInt)
  {
    synchronized (mLock)
    {
      mFlags = paramInt;
      update();
      return;
    }
  }
  
  public void setMediaButtonReceiver(PendingIntent paramPendingIntent) {}
  
  public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    label88:
    do
    {
      synchronized (mLock)
      {
        mMetadata = paramMediaMetadataCompat;
        sendMetadata(paramMediaMetadataCompat);
        if (!mIsActive) {
          return;
        }
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        localObject2 = mRccObj;
        if (paramMediaMetadataCompat == null)
        {
          paramMediaMetadataCompat = (MediaMetadataCompat)localObject1;
          if (mState != null) {
            break label88;
          }
        }
        for (long l = 0L;; l = mState.getActions())
        {
          MediaSessionCompatApi19.setMetadata(localObject2, paramMediaMetadataCompat, l);
          return;
          paramMediaMetadataCompat = paramMediaMetadataCompat.getBundle();
          break;
        }
      }
    } while (Build.VERSION.SDK_INT < 14);
    localObject1 = mRccObj;
    if (paramMediaMetadataCompat == null) {}
    for (paramMediaMetadataCompat = (MediaMetadataCompat)localObject2;; paramMediaMetadataCompat = paramMediaMetadataCompat.getBundle())
    {
      MediaSessionCompatApi14.setMetadata(localObject1, paramMediaMetadataCompat);
      return;
    }
  }
  
  public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
  {
    do
    {
      do
      {
        synchronized (mLock)
        {
          mState = paramPlaybackStateCompat;
          sendState(paramPlaybackStateCompat);
          if (!mIsActive) {
            return;
          }
        }
        if (paramPlaybackStateCompat != null) {
          break;
        }
      } while (Build.VERSION.SDK_INT < 14);
      MediaSessionCompatApi14.setState(mRccObj, 0);
      MediaSessionCompatApi14.setTransportControlFlags(mRccObj, 0L);
      return;
      if (Build.VERSION.SDK_INT >= 18) {
        MediaSessionCompatApi18.setState(mRccObj, paramPlaybackStateCompat.getState(), paramPlaybackStateCompat.getPosition(), paramPlaybackStateCompat.getPlaybackSpeed(), paramPlaybackStateCompat.getLastPositionUpdateTime());
      }
      while (Build.VERSION.SDK_INT >= 19)
      {
        MediaSessionCompatApi19.setTransportControlFlags(mRccObj, paramPlaybackStateCompat.getActions());
        return;
        if (Build.VERSION.SDK_INT >= 14) {
          MediaSessionCompatApi14.setState(mRccObj, paramPlaybackStateCompat.getState());
        }
      }
      if (Build.VERSION.SDK_INT >= 18)
      {
        MediaSessionCompatApi18.setTransportControlFlags(mRccObj, paramPlaybackStateCompat.getActions());
        return;
      }
    } while (Build.VERSION.SDK_INT < 14);
    MediaSessionCompatApi14.setTransportControlFlags(mRccObj, paramPlaybackStateCompat.getActions());
  }
  
  public void setPlaybackToLocal(int paramInt)
  {
    if (mVolumeProvider != null) {
      mVolumeProvider.setCallback(null);
    }
    mVolumeType = 1;
    sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, 2, mAudioManager.getStreamMaxVolume(mLocalStream), mAudioManager.getStreamVolume(mLocalStream)));
  }
  
  public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat)
  {
    if (paramVolumeProviderCompat == null) {
      throw new IllegalArgumentException("volumeProvider may not be null");
    }
    if (mVolumeProvider != null) {
      mVolumeProvider.setCallback(null);
    }
    mVolumeType = 2;
    mVolumeProvider = paramVolumeProviderCompat;
    sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, mVolumeProvider.getVolumeControl(), mVolumeProvider.getMaxVolume(), mVolumeProvider.getCurrentVolume()));
    paramVolumeProviderCompat.setCallback(mVolumeCallback);
  }
  
  public void setQueue(List<MediaSessionCompat.QueueItem> paramList)
  {
    mQueue = paramList;
    sendQueue(paramList);
  }
  
  public void setQueueTitle(CharSequence paramCharSequence)
  {
    mQueueTitle = paramCharSequence;
    sendQueueTitle(paramCharSequence);
  }
  
  public void setRatingType(int paramInt)
  {
    mRatingType = paramInt;
  }
  
  public void setSessionActivity(PendingIntent paramPendingIntent)
  {
    synchronized (mLock)
    {
      mSessionActivity = paramPendingIntent;
      return;
    }
  }
  
  private static final class Command
  {
    public final String command;
    public final Bundle extras;
    public final ResultReceiver stub;
    
    public Command(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      command = paramString;
      extras = paramBundle;
      stub = paramResultReceiver;
    }
  }
  
  class MediaSessionStub
    extends IMediaSession.Stub
  {
    MediaSessionStub() {}
    
    public void adjustVolume(int paramInt1, int paramInt2, String paramString)
    {
      MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(paramInt1, paramInt2);
    }
    
    public void fastForward()
      throws RemoteException
    {
      mHandler.post(9);
    }
    
    public Bundle getExtras()
    {
      synchronized (mLock)
      {
        Bundle localBundle = mExtras;
        return localBundle;
      }
    }
    
    public long getFlags()
    {
      synchronized (mLock)
      {
        long l = mFlags;
        return l;
      }
    }
    
    public PendingIntent getLaunchPendingIntent()
    {
      synchronized (mLock)
      {
        PendingIntent localPendingIntent = mSessionActivity;
        return localPendingIntent;
      }
    }
    
    public MediaMetadataCompat getMetadata()
    {
      return mMetadata;
    }
    
    public String getPackageName()
    {
      return mPackageName;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      return MediaSessionCompat.MediaSessionImplBase.this.getStateWithUpdatedPosition();
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue()
    {
      synchronized (mLock)
      {
        List localList = mQueue;
        return localList;
      }
    }
    
    public CharSequence getQueueTitle()
    {
      return mQueueTitle;
    }
    
    public int getRatingType()
    {
      return mRatingType;
    }
    
    public String getTag()
    {
      return mTag;
    }
    
    public ParcelableVolumeInfo getVolumeAttributes()
    {
      synchronized (mLock)
      {
        int m = mVolumeType;
        int n = mLocalStream;
        VolumeProviderCompat localVolumeProviderCompat = mVolumeProvider;
        if (m == 2)
        {
          i = localVolumeProviderCompat.getVolumeControl();
          j = localVolumeProviderCompat.getMaxVolume();
          k = localVolumeProviderCompat.getCurrentVolume();
          return new ParcelableVolumeInfo(m, n, i, j, k);
        }
        int i = 2;
        int j = mAudioManager.getStreamMaxVolume(n);
        int k = mAudioManager.getStreamVolume(n);
      }
    }
    
    public boolean isTransportControlEnabled()
    {
      return (mFlags & 0x2) != 0;
    }
    
    public void next()
      throws RemoteException
    {
      mHandler.post(7);
    }
    
    public void pause()
      throws RemoteException
    {
      mHandler.post(5);
    }
    
    public void play()
      throws RemoteException
    {
      mHandler.post(1);
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
      throws RemoteException
    {
      mHandler.post(2, paramString, paramBundle);
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
      throws RemoteException
    {
      mHandler.post(3, paramString, paramBundle);
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
      throws RemoteException
    {
      mHandler.post(18, paramUri, paramBundle);
    }
    
    public void previous()
      throws RemoteException
    {
      mHandler.post(8);
    }
    
    public void rate(RatingCompat paramRatingCompat)
      throws RemoteException
    {
      mHandler.post(12, paramRatingCompat);
    }
    
    public void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
    {
      if (mDestroyed) {}
      try
      {
        paramIMediaControllerCallback.onSessionDestroyed();
        return;
      }
      catch (Exception paramIMediaControllerCallback) {}
      mControllerCallbacks.register(paramIMediaControllerCallback);
      return;
    }
    
    public void rewind()
      throws RemoteException
    {
      mHandler.post(10);
    }
    
    public void seekTo(long paramLong)
      throws RemoteException
    {
      mHandler.post(11, Long.valueOf(paramLong));
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper)
    {
      mHandler.post(15, new MediaSessionCompat.MediaSessionImplBase.Command(paramString, paramBundle, MediaSessionCompat.ResultReceiverWrapper.access$700(paramResultReceiverWrapper)));
    }
    
    public void sendCustomAction(String paramString, Bundle paramBundle)
      throws RemoteException
    {
      mHandler.post(13, paramString, paramBundle);
    }
    
    public boolean sendMediaButton(KeyEvent paramKeyEvent)
    {
      if ((mFlags & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          mHandler.post(14, paramKeyEvent);
        }
        return bool;
      }
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2, String paramString)
    {
      MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(paramInt1, paramInt2);
    }
    
    public void skipToQueueItem(long paramLong)
    {
      mHandler.post(4, Long.valueOf(paramLong));
    }
    
    public void stop()
      throws RemoteException
    {
      mHandler.post(6);
    }
    
    public void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
    {
      mControllerCallbacks.unregister(paramIMediaControllerCallback);
    }
  }
  
  private class MessageHandler
    extends Handler
  {
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    private static final int MSG_ADJUST_VOLUME = 16;
    private static final int MSG_COMMAND = 15;
    private static final int MSG_CUSTOM_ACTION = 13;
    private static final int MSG_FAST_FORWARD = 9;
    private static final int MSG_MEDIA_BUTTON = 14;
    private static final int MSG_NEXT = 7;
    private static final int MSG_PAUSE = 5;
    private static final int MSG_PLAY = 1;
    private static final int MSG_PLAY_MEDIA_ID = 2;
    private static final int MSG_PLAY_SEARCH = 3;
    private static final int MSG_PLAY_URI = 18;
    private static final int MSG_PREVIOUS = 8;
    private static final int MSG_RATE = 12;
    private static final int MSG_REWIND = 10;
    private static final int MSG_SEEK_TO = 11;
    private static final int MSG_SET_VOLUME = 17;
    private static final int MSG_SKIP_TO_ITEM = 4;
    private static final int MSG_STOP = 6;
    
    public MessageHandler(Looper paramLooper)
    {
      super();
    }
    
    private void onMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      int k = 1;
      if ((paramKeyEvent == null) || (paramKeyEvent.getAction() != 0)) {}
      label28:
      int i;
      label143:
      int j;
      label156:
      label359:
      label364:
      label370:
      do
      {
        return;
        long l;
        if (mState == null)
        {
          l = 0L;
          switch (paramKeyEvent.getKeyCode())
          {
          default: 
            return;
          case 79: 
          case 85: 
            if ((mState != null) && (mState.getState() == 3))
            {
              i = 1;
              if ((0x204 & l) == 0L) {
                break label359;
              }
              j = 1;
              if ((0x202 & l) == 0L) {
                break label364;
              }
            }
            break;
          }
        }
        for (;;)
        {
          if ((i == 0) || (k == 0)) {
            break label370;
          }
          mCallback.onPause();
          return;
          l = mState.getActions();
          break label28;
          if ((0x4 & l) == 0L) {
            break;
          }
          mCallback.onPlay();
          return;
          if ((0x2 & l) == 0L) {
            break;
          }
          mCallback.onPause();
          return;
          if ((0x20 & l) == 0L) {
            break;
          }
          mCallback.onSkipToNext();
          return;
          if ((0x10 & l) == 0L) {
            break;
          }
          mCallback.onSkipToPrevious();
          return;
          if ((1L & l) == 0L) {
            break;
          }
          mCallback.onStop();
          return;
          if ((0x40 & l) == 0L) {
            break;
          }
          mCallback.onFastForward();
          return;
          if ((0x8 & l) == 0L) {
            break;
          }
          mCallback.onRewind();
          return;
          i = 0;
          break label143;
          j = 0;
          break label156;
          k = 0;
        }
      } while ((i != 0) || (j == 0));
      mCallback.onPlay();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (mCallback == null) {}
      Intent localIntent;
      do
      {
        return;
        switch (what)
        {
        default: 
          return;
        case 1: 
          mCallback.onPlay();
          return;
        case 2: 
          mCallback.onPlayFromMediaId((String)obj, paramMessage.getData());
          return;
        case 3: 
          mCallback.onPlayFromSearch((String)obj, paramMessage.getData());
          return;
        case 18: 
          mCallback.onPlayFromUri((Uri)obj, paramMessage.getData());
          return;
        case 4: 
          mCallback.onSkipToQueueItem(((Long)obj).longValue());
          return;
        case 5: 
          mCallback.onPause();
          return;
        case 6: 
          mCallback.onStop();
          return;
        case 7: 
          mCallback.onSkipToNext();
          return;
        case 8: 
          mCallback.onSkipToPrevious();
          return;
        case 9: 
          mCallback.onFastForward();
          return;
        case 10: 
          mCallback.onRewind();
          return;
        case 11: 
          mCallback.onSeekTo(((Long)obj).longValue());
          return;
        case 12: 
          mCallback.onSetRating((RatingCompat)obj);
          return;
        case 13: 
          mCallback.onCustomAction((String)obj, paramMessage.getData());
          return;
        case 14: 
          paramMessage = (KeyEvent)obj;
          localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
          localIntent.putExtra("android.intent.extra.KEY_EVENT", paramMessage);
        }
      } while (mCallback.onMediaButtonEvent(localIntent));
      onMediaButtonEvent(paramMessage);
      return;
      paramMessage = (MediaSessionCompat.MediaSessionImplBase.Command)obj;
      mCallback.onCommand(command, extras, stub);
      return;
      MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(((Integer)obj).intValue(), 0);
      return;
      MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(((Integer)obj).intValue(), 0);
    }
    
    public void post(int paramInt)
    {
      post(paramInt, null);
    }
    
    public void post(int paramInt, Object paramObject)
    {
      obtainMessage(paramInt, paramObject).sendToTarget();
    }
    
    public void post(int paramInt1, Object paramObject, int paramInt2)
    {
      obtainMessage(paramInt1, paramInt2, 0, paramObject).sendToTarget();
    }
    
    public void post(int paramInt, Object paramObject, Bundle paramBundle)
    {
      paramObject = obtainMessage(paramInt, paramObject);
      ((Message)paramObject).setData(paramBundle);
      ((Message)paramObject).sendToTarget();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */