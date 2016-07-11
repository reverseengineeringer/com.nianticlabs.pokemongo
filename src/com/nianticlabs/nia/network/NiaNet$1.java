package com.nianticlabs.nia.network;

final class NiaNet$1
  extends ThreadLocal<byte[]>
{
  protected byte[] initialValue()
  {
    return new byte[32768];
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.network.NiaNet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */