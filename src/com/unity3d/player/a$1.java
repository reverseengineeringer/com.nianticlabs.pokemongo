package com.unity3d.player;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

final class a$1
  implements Camera.PreviewCallback
{
  long a = 0L;
  
  a$1(a parama, a.a parama1) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (c.a != paramCamera) {
      return;
    }
    b.onCameraFrame(c, paramArrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.a.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */