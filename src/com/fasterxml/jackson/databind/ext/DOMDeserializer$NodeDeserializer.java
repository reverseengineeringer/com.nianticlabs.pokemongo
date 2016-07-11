package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationContext;
import org.w3c.dom.Node;

public class DOMDeserializer$NodeDeserializer
  extends DOMDeserializer<Node>
{
  private static final long serialVersionUID = 1L;
  
  public DOMDeserializer$NodeDeserializer()
  {
    super(Node.class);
  }
  
  public Node _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return parse(paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ext.DOMDeserializer.NodeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */