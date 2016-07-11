package android.support.v4.media.session;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;

class MediaSessionCompat$MediaSessionImplBase$MessageHandler
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
  
  public MediaSessionCompat$MediaSessionImplBase$MessageHandler(MediaSessionCompat.MediaSessionImplBase paramMediaSessionImplBase, Looper paramLooper)
  {
    super(paramLooper);
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
      if (MediaSessionCompat.MediaSessionImplBase.access$2600(this$0) == null)
      {
        l = 0L;
        switch (paramKeyEvent.getKeyCode())
        {
        default: 
          return;
        case 79: 
        case 85: 
          if ((MediaSessionCompat.MediaSessionImplBase.access$2600(this$0) != null) && (MediaSessionCompat.MediaSessionImplBase.access$2600(this$0).getState() == 3))
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
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPause();
        return;
        l = MediaSessionCompat.MediaSessionImplBase.access$2600(this$0).getActions();
        break label28;
        if ((0x4 & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPlay();
        return;
        if ((0x2 & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPause();
        return;
        if ((0x20 & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSkipToNext();
        return;
        if ((0x10 & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSkipToPrevious();
        return;
        if ((1L & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onStop();
        return;
        if ((0x40 & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onFastForward();
        return;
        if ((0x8 & l) == 0L) {
          break;
        }
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onRewind();
        return;
        i = 0;
        break label143;
        j = 0;
        break label156;
        k = 0;
      }
    } while ((i != 0) || (j == 0));
    MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPlay();
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (MediaSessionCompat.MediaSessionImplBase.access$2500(this$0) == null) {}
    Intent localIntent;
    do
    {
      return;
      switch (what)
      {
      default: 
        return;
      case 1: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPlay();
        return;
      case 2: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPlayFromMediaId((String)obj, paramMessage.getData());
        return;
      case 3: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPlayFromSearch((String)obj, paramMessage.getData());
        return;
      case 18: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPlayFromUri((Uri)obj, paramMessage.getData());
        return;
      case 4: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSkipToQueueItem(((Long)obj).longValue());
        return;
      case 5: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onPause();
        return;
      case 6: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onStop();
        return;
      case 7: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSkipToNext();
        return;
      case 8: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSkipToPrevious();
        return;
      case 9: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onFastForward();
        return;
      case 10: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onRewind();
        return;
      case 11: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSeekTo(((Long)obj).longValue());
        return;
      case 12: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onSetRating((RatingCompat)obj);
        return;
      case 13: 
        MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onCustomAction((String)obj, paramMessage.getData());
        return;
      case 14: 
        paramMessage = (KeyEvent)obj;
        localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
        localIntent.putExtra("android.intent.extra.KEY_EVENT", paramMessage);
      }
    } while (MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onMediaButtonEvent(localIntent));
    onMediaButtonEvent(paramMessage);
    return;
    paramMessage = (MediaSessionCompat.MediaSessionImplBase.Command)obj;
    MediaSessionCompat.MediaSessionImplBase.access$2500(this$0).onCommand(command, extras, stub);
    return;
    MediaSessionCompat.MediaSessionImplBase.access$1700(this$0, ((Integer)obj).intValue(), 0);
    return;
    MediaSessionCompat.MediaSessionImplBase.access$1800(this$0, ((Integer)obj).intValue(), 0);
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

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */