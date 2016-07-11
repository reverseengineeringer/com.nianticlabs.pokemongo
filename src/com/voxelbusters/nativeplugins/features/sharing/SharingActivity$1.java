package com.voxelbusters.nativeplugins.features.sharing;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.voxelbusters.nativeplugins.NativePluginHelper;

class SharingActivity$1
  implements DialogInterface.OnClickListener
{
  SharingActivity$1(SharingActivity paramSharingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NativePluginHelper.sendMessage("SharingFinished", "failed");
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.sharing.SharingActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */