package com.voxelbusters.nativeplugins.utilities;

import android.widget.Toast;
import com.voxelbusters.nativeplugins.NativePluginHelper;

class Debug$1
  implements Runnable
{
  Debug$1(String paramString) {}
  
  public void run()
  {
    Toast.makeText(NativePluginHelper.getCurrentContext(), val$msg, 1).show();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.Debug.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */