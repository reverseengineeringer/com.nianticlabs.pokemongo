package com.voxelbusters.nativeplugins;

import android.content.Context;
import android.content.Intent;

class NativePluginHelper$1
  implements Runnable
{
  NativePluginHelper$1(Intent paramIntent) {}
  
  public void run()
  {
    NativePluginHelper.getCurrentContext().startActivity(val$intent);
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.NativePluginHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */