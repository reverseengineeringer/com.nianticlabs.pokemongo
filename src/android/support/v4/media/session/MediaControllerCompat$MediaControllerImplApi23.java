package android.support.v4.media.session;

import android.content.Context;
import android.os.RemoteException;

class MediaControllerCompat$MediaControllerImplApi23
  extends MediaControllerCompat.MediaControllerImplApi21
{
  public MediaControllerCompat$MediaControllerImplApi23(Context paramContext, MediaSessionCompat.Token paramToken)
    throws RemoteException
  {
    super(paramContext, paramToken);
  }
  
  public MediaControllerCompat$MediaControllerImplApi23(Context paramContext, MediaSessionCompat paramMediaSessionCompat)
  {
    super(paramContext, paramMediaSessionCompat);
  }
  
  public MediaControllerCompat.TransportControls getTransportControls()
  {
    Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
    if (localObject != null) {
      return new MediaControllerCompat.TransportControlsApi23(localObject);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */