package com.nianticlabs.nia.network;

import java.nio.ByteBuffer;

final class NiaNet$2
  extends ThreadLocal<ByteBuffer>
{
  protected ByteBuffer initialValue()
  {
    return ByteBuffer.allocateDirect(32768);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.network.NiaNet.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */