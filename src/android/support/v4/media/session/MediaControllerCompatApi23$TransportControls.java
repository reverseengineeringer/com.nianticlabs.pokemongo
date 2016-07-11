package android.support.v4.media.session;

import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Bundle;

public class MediaControllerCompatApi23$TransportControls
  extends MediaControllerCompatApi21.TransportControls
{
  public static void playFromUri(Object paramObject, Uri paramUri, Bundle paramBundle)
  {
    ((MediaController.TransportControls)paramObject).playFromUri(paramUri, paramBundle);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompatApi23.TransportControls
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */