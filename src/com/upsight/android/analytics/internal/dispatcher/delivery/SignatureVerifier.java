package com.upsight.android.analytics.internal.dispatcher.delivery;

public abstract interface SignatureVerifier
{
  public abstract boolean verify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.SignatureVerifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */