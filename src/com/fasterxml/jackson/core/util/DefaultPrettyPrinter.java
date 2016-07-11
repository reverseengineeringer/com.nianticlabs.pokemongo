package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.IOException;
import java.io.Serializable;

public class DefaultPrettyPrinter
  implements PrettyPrinter, Instantiatable<DefaultPrettyPrinter>, Serializable
{
  public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
  private static final long serialVersionUID = 1L;
  protected Indenter _arrayIndenter = FixedSpaceIndenter.instance;
  protected transient int _nesting = 0;
  protected Indenter _objectIndenter = DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
  protected final SerializableString _rootSeparator;
  protected boolean _spacesInObjectEntries = true;
  
  public DefaultPrettyPrinter()
  {
    this(DEFAULT_ROOT_VALUE_SEPARATOR);
  }
  
  public DefaultPrettyPrinter(SerializableString paramSerializableString)
  {
    _rootSeparator = paramSerializableString;
  }
  
  public DefaultPrettyPrinter(DefaultPrettyPrinter paramDefaultPrettyPrinter)
  {
    this(paramDefaultPrettyPrinter, _rootSeparator);
  }
  
  public DefaultPrettyPrinter(DefaultPrettyPrinter paramDefaultPrettyPrinter, SerializableString paramSerializableString)
  {
    _arrayIndenter = _arrayIndenter;
    _objectIndenter = _objectIndenter;
    _spacesInObjectEntries = _spacesInObjectEntries;
    _nesting = _nesting;
    _rootSeparator = paramSerializableString;
  }
  
  public DefaultPrettyPrinter(String paramString) {}
  
  protected DefaultPrettyPrinter _withSpaces(boolean paramBoolean)
  {
    if (_spacesInObjectEntries == paramBoolean) {
      return this;
    }
    DefaultPrettyPrinter localDefaultPrettyPrinter = new DefaultPrettyPrinter(this);
    _spacesInObjectEntries = paramBoolean;
    return localDefaultPrettyPrinter;
  }
  
  public void beforeArrayValues(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void beforeObjectEntries(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public DefaultPrettyPrinter createInstance()
  {
    return new DefaultPrettyPrinter(this);
  }
  
  public void indentArraysWith(Indenter paramIndenter)
  {
    Object localObject = paramIndenter;
    if (paramIndenter == null) {
      localObject = NopIndenter.instance;
    }
    _arrayIndenter = ((Indenter)localObject);
  }
  
  public void indentObjectsWith(Indenter paramIndenter)
  {
    Object localObject = paramIndenter;
    if (paramIndenter == null) {
      localObject = NopIndenter.instance;
    }
    _objectIndenter = ((Indenter)localObject);
  }
  
  @Deprecated
  public void spacesInObjectEntries(boolean paramBoolean)
  {
    _spacesInObjectEntries = paramBoolean;
  }
  
  public DefaultPrettyPrinter withArrayIndenter(Indenter paramIndenter)
  {
    Object localObject = paramIndenter;
    if (paramIndenter == null) {
      localObject = NopIndenter.instance;
    }
    if (_arrayIndenter == localObject) {
      return this;
    }
    paramIndenter = new DefaultPrettyPrinter(this);
    _arrayIndenter = ((Indenter)localObject);
    return paramIndenter;
  }
  
  public DefaultPrettyPrinter withObjectIndenter(Indenter paramIndenter)
  {
    Object localObject = paramIndenter;
    if (paramIndenter == null) {
      localObject = NopIndenter.instance;
    }
    if (_objectIndenter == localObject) {
      return this;
    }
    paramIndenter = new DefaultPrettyPrinter(this);
    _objectIndenter = ((Indenter)localObject);
    return paramIndenter;
  }
  
  public DefaultPrettyPrinter withRootSeparator(SerializableString paramSerializableString)
  {
    if ((_rootSeparator == paramSerializableString) || ((paramSerializableString != null) && (paramSerializableString.equals(_rootSeparator)))) {
      return this;
    }
    return new DefaultPrettyPrinter(this, paramSerializableString);
  }
  
  public DefaultPrettyPrinter withRootSeparator(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = new SerializedString(paramString)) {
      return withRootSeparator(paramString);
    }
  }
  
  public DefaultPrettyPrinter withSpacesInObjectEntries()
  {
    return _withSpaces(true);
  }
  
  public DefaultPrettyPrinter withoutSpacesInObjectEntries()
  {
    return _withSpaces(false);
  }
  
  public void writeArrayValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeRaw(',');
    _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting -= 1;
    }
    if (paramInt > 0) {
      _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
    }
    for (;;)
    {
      paramJsonGenerator.writeRaw(']');
      return;
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (!_objectIndenter.isInline()) {
      _nesting -= 1;
    }
    if (paramInt > 0) {
      _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
    }
    for (;;)
    {
      paramJsonGenerator.writeRaw('}');
      return;
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
    _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (_spacesInObjectEntries)
    {
      paramJsonGenerator.writeRaw(" : ");
      return;
    }
    paramJsonGenerator.writeRaw(':');
  }
  
  public void writeRootValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (_rootSeparator != null) {
      paramJsonGenerator.writeRaw(_rootSeparator);
    }
  }
  
  public void writeStartArray(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting += 1;
    }
    paramJsonGenerator.writeRaw('[');
  }
  
  public void writeStartObject(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw('{');
    if (!_objectIndenter.isInline()) {
      _nesting += 1;
    }
  }
  
  public static class FixedSpaceIndenter
    extends DefaultPrettyPrinter.NopIndenter
  {
    public static final FixedSpaceIndenter instance = new FixedSpaceIndenter();
    
    public boolean isInline()
    {
      return true;
    }
    
    public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException
    {
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public static abstract interface Indenter
  {
    public abstract boolean isInline();
    
    public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException;
  }
  
  @Deprecated
  public static class Lf2SpacesIndenter
    extends DefaultIndenter
  {
    @Deprecated
    public static final Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
    
    @Deprecated
    public Lf2SpacesIndenter()
    {
      super(DefaultIndenter.SYS_LF);
    }
    
    @Deprecated
    public Lf2SpacesIndenter(String paramString)
    {
      super(paramString);
    }
    
    public Lf2SpacesIndenter withLinefeed(String paramString)
    {
      if (paramString.equals(getEol())) {
        return this;
      }
      return new Lf2SpacesIndenter(paramString);
    }
  }
  
  public static class NopIndenter
    implements DefaultPrettyPrinter.Indenter, Serializable
  {
    public static final NopIndenter instance = new NopIndenter();
    
    public boolean isInline()
    {
      return true;
    }
    
    public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException
    {}
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.DefaultPrettyPrinter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */