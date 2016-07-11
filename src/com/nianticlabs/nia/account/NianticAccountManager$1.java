package com.nianticlabs.nia.account;

import android.content.Context;
import android.content.Intent;

class NianticAccountManager$1
  implements Runnable
{
  NianticAccountManager$1(NianticAccountManager paramNianticAccountManager, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent(NianticAccountManager.access$000(this$0), AccountsActivity.class);
    localIntent.putExtra(AccountsActivity.EXTRA_OAUTH_CLIENT_ID, val$clientId);
    NianticAccountManager.access$100(this$0).startActivity(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.account.NianticAccountManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */