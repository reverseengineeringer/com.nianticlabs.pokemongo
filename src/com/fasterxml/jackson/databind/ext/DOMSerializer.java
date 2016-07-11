package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class DOMSerializer
  extends StdSerializer<Node>
{
  protected final DOMImplementationLS _domImpl;
  
  public DOMSerializer()
  {
    super(Node.class);
    try
    {
      DOMImplementationRegistry localDOMImplementationRegistry = DOMImplementationRegistry.newInstance();
      _domImpl = ((DOMImplementationLS)localDOMImplementationRegistry.getDOMImplementation("LS"));
      return;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("Could not instantiate DOMImplementationRegistry: " + localException.getMessage(), localException);
    }
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper != null) {
      paramJsonFormatVisitorWrapper.expectAnyFormat(paramJavaType);
    }
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("string", true);
  }
  
  public void serialize(Node paramNode, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if (_domImpl == null) {
      throw new IllegalStateException("Could not find DOM LS");
    }
    paramJsonGenerator.writeString(_domImpl.createLSSerializer().writeToString(paramNode));
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ext.DOMSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */