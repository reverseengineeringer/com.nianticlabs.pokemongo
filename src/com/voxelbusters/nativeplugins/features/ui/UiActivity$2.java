package com.voxelbusters.nativeplugins.features.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import java.util.HashMap;

class UiActivity$2
  implements DialogInterface.OnClickListener
{
  UiActivity$2(UiActivity paramUiActivity, String[] paramArrayOfString, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = val$tempButtonList[val$index];
    String str = val$tag;
    HashMap localHashMap = new HashMap();
    localHashMap.put("button-pressed", paramDialogInterface);
    localHashMap.put("caller", str);
    NativePluginHelper.sendMessage("AlertDialogClosed", localHashMap);
    UiHandler.getInstance().onFinish(str);
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.ui.UiActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */