package com.voxelbusters.nativeplugins.features.sharing;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.voxelbusters.nativeplugins.NativePluginHelper;

class SharingActivity$2
  implements DialogInterface.OnKeyListener
{
  SharingActivity$2(SharingActivity paramSharingActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      NativePluginHelper.sendMessage("SharingFinished", "failed");
      this$0.finish();
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.sharing.SharingActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */