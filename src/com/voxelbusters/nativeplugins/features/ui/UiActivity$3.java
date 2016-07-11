package com.voxelbusters.nativeplugins.features.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.widget.EditText;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import java.util.HashMap;

class UiActivity$3
  implements DialogInterface.OnClickListener
{
  UiActivity$3(UiActivity paramUiActivity, EditText paramEditText, String[] paramArrayOfString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = val$promptField.getText().toString();
    HashMap localHashMap = new HashMap();
    localHashMap.put("button-pressed", val$tempButtonList[val$index]);
    localHashMap.put("input", paramDialogInterface);
    NativePluginHelper.sendMessage("SingleFieldPromptDialogClosed", localHashMap);
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.ui.UiActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */