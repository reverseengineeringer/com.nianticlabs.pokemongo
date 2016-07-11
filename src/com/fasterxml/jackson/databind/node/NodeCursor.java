package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class NodeCursor
  extends JsonStreamContext
{
  protected String _currentName;
  protected Object _currentValue;
  protected final NodeCursor _parent;
  
  public NodeCursor(int paramInt, NodeCursor paramNodeCursor)
  {
    _type = paramInt;
    _index = -1;
    _parent = paramNodeCursor;
  }
  
  public abstract boolean currentHasChildren();
  
  public abstract JsonNode currentNode();
  
  public abstract JsonToken endToken();
  
  public final String getCurrentName()
  {
    return _currentName;
  }
  
  public Object getCurrentValue()
  {
    return _currentValue;
  }
  
  public final NodeCursor getParent()
  {
    return _parent;
  }
  
  public final NodeCursor iterateChildren()
  {
    JsonNode localJsonNode = currentNode();
    if (localJsonNode == null) {
      throw new IllegalStateException("No current node");
    }
    if (localJsonNode.isArray()) {
      return new ArrayCursor(localJsonNode, this);
    }
    if (localJsonNode.isObject()) {
      return new ObjectCursor(localJsonNode, this);
    }
    throw new IllegalStateException("Current node of type " + localJsonNode.getClass().getName());
  }
  
  public abstract JsonToken nextToken();
  
  public abstract JsonToken nextValue();
  
  public void overrideCurrentName(String paramString)
  {
    _currentName = paramString;
  }
  
  public void setCurrentValue(Object paramObject)
  {
    _currentValue = paramObject;
  }
  
  protected static final class ArrayCursor
    extends NodeCursor
  {
    protected Iterator<JsonNode> _contents;
    protected JsonNode _currentNode;
    
    public ArrayCursor(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
    {
      super(paramNodeCursor);
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
  
  protected static final class ObjectCursor
    extends NodeCursor
  {
    protected Iterator<Map.Entry<String, JsonNode>> _contents;
    protected Map.Entry<String, JsonNode> _current;
    protected boolean _needEntry;
    
    public ObjectCursor(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
    {
      super(paramNodeCursor);
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
  
  protected static final class RootCursor
    extends NodeCursor
  {
    protected boolean _done = false;
    protected JsonNode _node;
    
    public RootCursor(JsonNode paramJsonNode, NodeCursor paramNodeCursor)
    {
      super(paramNodeCursor);
      _node = paramJsonNode;
    }
    
    public boolean currentHasChildren()
    {
      return false;
    }
    
    public JsonNode currentNode()
    {
      return _node;
    }
    
    public JsonToken endToken()
    {
      return null;
    }
    
    public JsonToken nextToken()
    {
      if (!_done)
      {
        _done = true;
        return _node.asToken();
      }
      _node = null;
      return null;
    }
    
    public JsonToken nextValue()
    {
      return nextToken();
    }
    
    public void overrideCurrentName(String paramString) {}
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.node.NodeCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */