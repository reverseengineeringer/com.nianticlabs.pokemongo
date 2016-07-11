package com.voxelbusters.nativeplugins.features.ui;

import android.widget.Toast;
import com.voxelbusters.nativeplugins.NativePluginHelper;

class UiHandler$1
  implements Runnable
{
  UiHandler$1(UiHandler paramUiHandler, String paramString, int paramInt) {}
  
  public void run()
  {
    Toast.makeText(NativePluginHelper.getCurrentContext(), val$message, val$toastLength).show();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.ui.UiHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */