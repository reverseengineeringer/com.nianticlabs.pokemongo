package com.voxelbusters.nativeplugins.features.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.widget.EditText;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import java.util.HashMap;

class UiActivity$4
  implements DialogInterface.OnClickListener
{
  UiActivity$4(UiActivity paramUiActivity, String[] paramArrayOfString, int paramInt, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("button-pressed", val$finalButtonList[val$index]);
    paramDialogInterface.put("username", val$usernameField.getText().toString());
    paramDialogInterface.put("password", val$passwordField.getText().toString());
    NativePluginHelper.sendMessage("LoginPromptDialogClosed", paramDialogInterface);
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.ui.UiActivity.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */