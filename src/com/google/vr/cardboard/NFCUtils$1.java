package com.google.vr.cardboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

class NFCUtils$1
  extends BroadcastReceiver
{
  NFCUtils$1(NFCUtils paramNFCUtils) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i(NFCUtils.access$000(), "Got an NFC tag!");
    this$0.onNFCTagDetected((Tag)paramIntent.getParcelableExtra("android.nfc.extra.TAG"));
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.NFCUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */