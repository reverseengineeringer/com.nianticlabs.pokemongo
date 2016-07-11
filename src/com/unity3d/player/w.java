package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import java.io.FileInputStream;
import java.io.IOException;

public final class w
  extends FrameLayout
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl
{
  private static boolean a = false;
  private final UnityPlayer b;
  private final Context c;
  private final SurfaceView d;
  private final SurfaceHolder e;
  private final String f;
  private final int g;
  private final int h;
  private final boolean i;
  private final long j;
  private final long k;
  private final FrameLayout l;
  private final Display m;
  private int n;
  private int o;
  private int p;
  private int q;
  private MediaPlayer r;
  private MediaController s;
  private boolean t = false;
  private boolean u = false;
  private int v = 0;
  private boolean w = false;
  private int x = 0;
  private boolean y;
  
  protected w(UnityPlayer paramUnityPlayer, Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    super(paramContext);
    b = paramUnityPlayer;
    c = paramContext;
    l = this;
    d = new SurfaceView(paramContext);
    e = d.getHolder();
    e.addCallback(this);
    e.setType(3);
    l.setBackgroundColor(paramInt1);
    l.addView(d);
    m = ((WindowManager)c.getSystemService("window")).getDefaultDisplay();
    f = paramString;
    g = paramInt2;
    h = paramInt3;
    i = paramBoolean;
    j = paramLong1;
    k = paramLong2;
    if (a) {
      a("fileName: " + f);
    }
    if (a) {
      a("backgroundColor: " + paramInt1);
    }
    if (a) {
      a("controlMode: " + g);
    }
    if (a) {
      a("scalingMode: " + h);
    }
    if (a) {
      a("isURL: " + i);
    }
    if (a) {
      a("videoOffset: " + j);
    }
    if (a) {
      a("videoLength: " + k);
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    y = true;
  }
  
  private void a()
  {
    doCleanUp();
    for (;;)
    {
      try
      {
        r = new MediaPlayer();
        if (i)
        {
          r.setDataSource(c, Uri.parse(f));
          r.setDisplay(e);
          r.setScreenOnWhilePlaying(true);
          r.setOnBufferingUpdateListener(this);
          r.setOnCompletionListener(this);
          r.setOnPreparedListener(this);
          r.setOnVideoSizeChangedListener(this);
          r.setAudioStreamType(3);
          r.prepare();
          if ((g != 0) && (g != 1)) {
            break;
          }
          s = new MediaController(c);
          s.setMediaPlayer(this);
          s.setAnchorView(this);
          s.setEnabled(true);
          s.show();
          return;
        }
        if (k != 0L)
        {
          FileInputStream localFileInputStream1 = new FileInputStream(f);
          r.setDataSource(localFileInputStream1.getFD(), j, k);
          localFileInputStream1.close();
          continue;
        }
        localObject = getResources().getAssets();
      }
      catch (Exception localException)
      {
        if (a) {
          a("error: " + localException.getMessage() + localException);
        }
        onDestroy();
        return;
      }
      try
      {
        Object localObject = ((AssetManager)localObject).openFd(f);
        r.setDataSource(((AssetFileDescriptor)localObject).getFileDescriptor(), ((AssetFileDescriptor)localObject).getStartOffset(), ((AssetFileDescriptor)localObject).getLength());
        ((AssetFileDescriptor)localObject).close();
      }
      catch (IOException localIOException)
      {
        FileInputStream localFileInputStream2 = new FileInputStream(f);
        r.setDataSource(localFileInputStream2.getFD());
        localFileInputStream2.close();
      }
    }
  }
  
  private static void a(String paramString)
  {
    Log.v("Video", "VideoPlayer: " + paramString);
  }
  
  private void b()
  {
    if (isPlaying()) {}
    do
    {
      return;
      if (a) {
        a("startVideoPlayback");
      }
      updateVideoLayout();
    } while (w);
    start();
  }
  
  public final boolean canPause()
  {
    return true;
  }
  
  public final boolean canSeekBackward()
  {
    return true;
  }
  
  public final boolean canSeekForward()
  {
    return true;
  }
  
  protected final void doCleanUp()
  {
    if (r != null)
    {
      r.release();
      r = null;
    }
    p = 0;
    q = 0;
    u = false;
    t = false;
  }
  
  public final int getBufferPercentage()
  {
    if (i) {
      return v;
    }
    return 100;
  }
  
  public final int getCurrentPosition()
  {
    if (r == null) {
      return 0;
    }
    return r.getCurrentPosition();
  }
  
  public final int getDuration()
  {
    if (r == null) {
      return 0;
    }
    return r.getDuration();
  }
  
  public final boolean isPlaying()
  {
    int i1;
    if ((u) && (t))
    {
      i1 = 1;
      if (r != null) {
        break label36;
      }
      if (i1 != 0) {
        break label34;
      }
    }
    label34:
    label36:
    while ((r.isPlaying()) || (i1 == 0))
    {
      return true;
      i1 = 0;
      break;
      return false;
    }
    return false;
  }
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (a) {
      a("onBufferingUpdate percent:" + paramInt);
    }
    v = paramInt;
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (a) {
      a("onCompletion called");
    }
    onDestroy();
  }
  
  public final void onControllerHide() {}
  
  protected final void onDestroy()
  {
    onPause();
    doCleanUp();
    UnityPlayer.a(new Runnable()
    {
      public final void run()
      {
        w.a(w.this).hideVideoPlayer();
      }
    });
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) || ((g == 2) && (paramInt != 0) && (!paramKeyEvent.isSystem())))
    {
      onDestroy();
      return true;
    }
    if (s != null) {
      return s.onKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected final void onPause()
  {
    if (a) {
      a("onPause called");
    }
    if (!w)
    {
      pause();
      w = false;
    }
    if (r != null) {
      x = r.getCurrentPosition();
    }
    y = false;
  }
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (a) {
      a("onPrepared called");
    }
    u = true;
    if ((u) && (t)) {
      b();
    }
  }
  
  protected final void onResume()
  {
    if (a) {
      a("onResume called");
    }
    if ((!y) && (!w)) {
      start();
    }
    y = true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((g == 2) && ((i1 & 0xFF) == 0))
    {
      onDestroy();
      return true;
    }
    if (s != null) {
      return s.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (a) {
      a("onVideoSizeChanged called " + paramInt1 + "x" + paramInt2);
    }
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      if (a) {
        a("invalid video width(" + paramInt1 + ") or height(" + paramInt2 + ")");
      }
    }
    do
    {
      return;
      t = true;
      p = paramInt1;
      q = paramInt2;
    } while ((!u) || (!t));
    b();
  }
  
  public final void pause()
  {
    if (r == null) {
      return;
    }
    r.pause();
    w = true;
  }
  
  public final void seekTo(int paramInt)
  {
    if (r == null) {
      return;
    }
    r.seekTo(paramInt);
  }
  
  public final void start()
  {
    if (r == null) {
      return;
    }
    r.start();
    w = false;
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (a) {
      a("surfaceChanged called " + paramInt1 + " " + paramInt2 + "x" + paramInt3);
    }
    if ((n != paramInt2) || (o != paramInt3))
    {
      n = paramInt2;
      o = paramInt3;
      updateVideoLayout();
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (a) {
      a("surfaceCreated called");
    }
    a();
    seekTo(x);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (a) {
      a("surfaceDestroyed called");
    }
    doCleanUp();
  }
  
  protected final void updateVideoLayout()
  {
    if (a) {
      a("updateVideoLayout");
    }
    Object localObject;
    if ((n == 0) || (o == 0))
    {
      localObject = (WindowManager)c.getSystemService("window");
      n = ((WindowManager)localObject).getDefaultDisplay().getWidth();
      o = ((WindowManager)localObject).getDefaultDisplay().getHeight();
    }
    int i2 = n;
    int i1 = o;
    float f1 = p / q;
    float f2 = n / o;
    if (h == 1) {
      if (f2 <= f1) {
        i1 = (int)(n / f1);
      }
    }
    for (;;)
    {
      if (a) {
        a("frameWidth = " + i2 + "; frameHeight = " + i1);
      }
      localObject = new FrameLayout.LayoutParams(i2, i1, 17);
      l.updateViewLayout(d, (ViewGroup.LayoutParams)localObject);
      return;
      i2 = (int)(o * f1);
      continue;
      if (h == 2)
      {
        if (f2 >= f1) {
          i1 = (int)(n / f1);
        } else {
          i2 = (int)(o * f1);
        }
      }
      else if (h == 0)
      {
        i2 = p;
        i1 = q;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */