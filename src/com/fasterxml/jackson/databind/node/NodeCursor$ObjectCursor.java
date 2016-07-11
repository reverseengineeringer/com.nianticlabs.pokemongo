package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

public final class NodeCursor$ObjectCursor
  extends NodeCursor
{
  protected Iterator<Map.Entry<String, JsonNode>> _contents;
  protected Map.Entry<String, JsonNode> _current;
  protected boolean _needEntry;
  
  public NodeCursor$ObjectCursor(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(2, paramNodeCursor);
    _contents = ((ObjectNode)paramJsonNode).fields();
    _needEntry = true;
  }
  
  public boolean currentHasChildren()
  {
    return ((ContainerNode)currentNode()).size() > 0;
  }
  
  public JsonNode currentNode()
  {
    if (_current == null) {
      return null;
    }
    return (JsonNode)_current.getValue();
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_OBJECT;
  }
  
  public JsonToken nextToken()
  {
    if (_needEntry)
    {
      if (!_contents.hasNext())
      {
        _currentName = null;
        _current = null;
        return null;
      }
      _needEntry = false;
      _current = ((Map.Entry)_contents.next());
      if (_current == null) {}
      for (String str = null;; str = (String)_current.getKey())
      {
        _currentName = str;
        return JsonToken.FIELD_NAME;
      }
    }
    _needEntry = true;
    return ((JsonNode)_current.getValue()).asToken();
  }
  
  public JsonToken nextValue()
  {
    JsonToken localJsonToken2 = nextToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME) {
      localJsonToken1 = nextToken();
    }
    return localJsonToken1;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.NodeCursor.ObjectCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */