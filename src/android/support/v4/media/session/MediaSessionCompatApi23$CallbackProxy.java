package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi23$CallbackProxy<T extends MediaSessionCompatApi23.Callback>
  extends MediaSessionCompatApi21.CallbackProxy<T>
{
  public MediaSessionCompatApi23$CallbackProxy(T paramT)
  {
    super(paramT);
  }
  
  public void onPlayFromUri(Uri paramUri, Bundle paramBundle)
  {
    ((MediaSessionCompatApi23.Callback)mCallback).onPlayFromUri(paramUri, paramBundle);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompatApi23.CallbackProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */