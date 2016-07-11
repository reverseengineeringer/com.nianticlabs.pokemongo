package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;

public final class NodeCursor$ArrayCursor
  extends NodeCursor
{
  protected Iterator<JsonNode> _contents;
  protected JsonNode _currentNode;
  
  public NodeCursor$ArrayCursor(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
  {
    super(1, paramNodeCursor);
    _contents = paramJsonNode.elements();
  }
  
  public boolean currentHasChildren()
  {
    return ((ContainerNode)currentNode()).size() > 0;
  }
  
  public JsonNode currentNode()
  {
    return _currentNode;
  }
  
  public JsonToken endToken()
  {
    return JsonToken.END_ARRAY;
  }
  
  public JsonToken nextToken()
  {
    if (!_contents.hasNext())
    {
      _currentNode = null;
      return null;
    }
    _currentNode = ((JsonNode)_contents.next());
    return _currentNode.asToken();
  }
  
  public JsonToken nextValue()
  {
    return nextToken();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.NodeCursor.ArrayCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */