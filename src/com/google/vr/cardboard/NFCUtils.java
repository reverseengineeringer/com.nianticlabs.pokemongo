package com.google.vr.cardboard;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.util.Log;

public class NFCUtils
{
  private static final String TAG = NFCUtils.class.getSimpleName();
  Context context;
  NfcAdapter nfcAdapter;
  BroadcastReceiver nfcBroadcastReceiver;
  IntentFilter[] nfcIntentFilters;
  
  private IntentFilter createNfcIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.nfc.action.NDEF_DISCOVERED");
    localIntentFilter.addAction("android.nfc.action.TECH_DISCOVERED");
    localIntentFilter.addAction("android.nfc.action.TAG_DISCOVERED");
    return localIntentFilter;
  }
  
  protected boolean isNFCEnabled()
  {
    return (nfcAdapter != null) && (nfcAdapter.isEnabled());
  }
  
  public void onCreate(Activity paramActivity)
  {
    context = paramActivity.getApplicationContext();
    nfcAdapter = NfcAdapter.getDefaultAdapter(context);
    nfcBroadcastReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        Log.i(NFCUtils.TAG, "Got an NFC tag!");
        onNFCTagDetected((Tag)paramAnonymousIntent.getParcelableExtra("android.nfc.extra.TAG"));
      }
    };
    paramActivity = createNfcIntentFilter();
    paramActivity.addDataScheme("cardboard");
    IntentFilter localIntentFilter1 = createNfcIntentFilter();
    localIntentFilter1.addDataScheme("http");
    localIntentFilter1.addDataAuthority("goo.gl", null);
    IntentFilter localIntentFilter2 = createNfcIntentFilter();
    localIntentFilter2.addDataScheme("http");
    localIntentFilter2.addDataAuthority("google.com", null);
    localIntentFilter2.addDataPath("/cardboard/cfg.*", 2);
    nfcIntentFilters = new IntentFilter[] { paramActivity, localIntentFilter1, localIntentFilter2 };
  }
  
  protected void onNFCTagDetected(Tag paramTag) {}
  
  public void onPause(Activity paramActivity)
  {
    if (isNFCEnabled()) {
      nfcAdapter.disableForegroundDispatch(paramActivity);
    }
    paramActivity.unregisterReceiver(nfcBroadcastReceiver);
  }
  
  public void onResume(Activity paramActivity)
  {
    paramActivity.registerReceiver(nfcBroadcastReceiver, createNfcIntentFilter());
    Object localObject = new Intent("android.nfc.action.NDEF_DISCOVERED");
    ((Intent)localObject).setPackage(paramActivity.getPackageName());
    localObject = PendingIntent.getBroadcast(context, 0, (Intent)localObject, 0);
    if (isNFCEnabled()) {
      nfcAdapter.enableForegroundDispatch(paramActivity, (PendingIntent)localObject, nfcIntentFilters, (String[][])null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.NFCUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */