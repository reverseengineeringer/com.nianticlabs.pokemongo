package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.net.InetAddress;

public class InetAddressSerializer
  extends StdScalarSerializer<InetAddress>
{
  public InetAddressSerializer()
  {
    super(InetAddress.class);
  }
  
  public void serialize(InetAddress paramInetAddress, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramSerializerProvider = paramInetAddress.toString().trim();
    int i = paramSerializerProvider.indexOf('/');
    paramInetAddress = paramSerializerProvider;
    if (i >= 0) {
      if (i != 0) {
        break label40;
      }
    }
    label40:
    for (paramInetAddress = paramSerializerProvider.substring(1);; paramInetAddress = paramSerializerProvider.substring(0, i))
    {
      paramJsonGenerator.writeString(paramInetAddress);
      return;
    }
  }
  
  public void serializeWithType(InetAddress paramInetAddress, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonGenerationException
  {
    paramTypeSerializer.writeTypePrefixForScalar(paramInetAddress, paramJsonGenerator, InetAddress.class);
    serialize(paramInetAddress, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForScalar(paramInetAddress, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.InetAddressSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */