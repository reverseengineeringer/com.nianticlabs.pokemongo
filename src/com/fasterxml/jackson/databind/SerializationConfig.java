package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class SerializationConfig
  extends MapperConfigBase<SerializationFeature, SerializationConfig>
  implements Serializable
{
  protected static final PrettyPrinter DEFAULT_PRETTY_PRINTER = new DefaultPrettyPrinter();
  private static final long serialVersionUID = 1L;
  protected final PrettyPrinter _defaultPrettyPrinter;
  protected final FilterProvider _filterProvider;
  protected final int _generatorFeatures;
  protected final int _generatorFeaturesToChange;
  protected final int _serFeatures;
  protected JsonInclude.Include _serializationInclusion = null;
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramSerializationConfig, paramInt1);
    _serFeatures = paramInt2;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = paramInt3;
    _generatorFeaturesToChange = paramInt4;
  }
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, JsonInclude.Include paramInclude)
  {
    super(paramSerializationConfig);
    _serFeatures = _serFeatures;
    _serializationInclusion = paramInclude;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, PrettyPrinter paramPrettyPrinter)
  {
    super(paramSerializationConfig);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = paramPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, PropertyName paramPropertyName)
  {
    super(paramSerializationConfig, paramPropertyName);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, BaseSettings paramBaseSettings)
  {
    super(paramSerializationConfig, paramBaseSettings);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, ContextAttributes paramContextAttributes)
  {
    super(paramSerializationConfig, paramContextAttributes);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, SimpleMixInResolver paramSimpleMixInResolver)
  {
    super(paramSerializationConfig, paramSimpleMixInResolver);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, SimpleMixInResolver paramSimpleMixInResolver, RootNameLookup paramRootNameLookup)
  {
    super(paramSerializationConfig, paramSimpleMixInResolver, paramRootNameLookup);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, SubtypeResolver paramSubtypeResolver)
  {
    super(paramSerializationConfig, paramSubtypeResolver);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, FilterProvider paramFilterProvider)
  {
    super(paramSerializationConfig);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = paramFilterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  private SerializationConfig(SerializationConfig paramSerializationConfig, Class<?> paramClass)
  {
    super(paramSerializationConfig, paramClass);
    _serFeatures = _serFeatures;
    _serializationInclusion = _serializationInclusion;
    _filterProvider = _filterProvider;
    _defaultPrettyPrinter = _defaultPrettyPrinter;
    _generatorFeatures = _generatorFeatures;
    _generatorFeaturesToChange = _generatorFeaturesToChange;
  }
  
  public SerializationConfig(BaseSettings paramBaseSettings, SubtypeResolver paramSubtypeResolver, SimpleMixInResolver paramSimpleMixInResolver, RootNameLookup paramRootNameLookup)
  {
    super(paramBaseSettings, paramSubtypeResolver, paramSimpleMixInResolver, paramRootNameLookup);
    _serFeatures = collectFeatureDefaults(SerializationFeature.class);
    _filterProvider = null;
    _defaultPrettyPrinter = DEFAULT_PRETTY_PRINTER;
    _generatorFeatures = 0;
    _generatorFeaturesToChange = 0;
  }
  
  private final SerializationConfig _withBase(BaseSettings paramBaseSettings)
  {
    if (_base == paramBaseSettings) {
      return this;
    }
    return new SerializationConfig(this, paramBaseSettings);
  }
  
  public PrettyPrinter constructDefaultPrettyPrinter()
  {
    PrettyPrinter localPrettyPrinter2 = _defaultPrettyPrinter;
    PrettyPrinter localPrettyPrinter1 = localPrettyPrinter2;
    if ((localPrettyPrinter2 instanceof Instantiatable)) {
      localPrettyPrinter1 = (PrettyPrinter)((Instantiatable)localPrettyPrinter2).createInstance();
    }
    return localPrettyPrinter1;
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    if (isEnabled(MapperFeature.USE_ANNOTATIONS)) {
      return super.getAnnotationIntrospector();
    }
    return AnnotationIntrospector.nopInstance();
  }
  
  public PrettyPrinter getDefaultPrettyPrinter()
  {
    return _defaultPrettyPrinter;
  }
  
  public VisibilityChecker<?> getDefaultVisibilityChecker()
  {
    Object localObject2 = super.getDefaultVisibilityChecker();
    Object localObject1 = localObject2;
    if (!isEnabled(MapperFeature.AUTO_DETECT_GETTERS)) {
      localObject1 = ((VisibilityChecker)localObject2).withGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
      localObject2 = ((VisibilityChecker)localObject1).withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject1 = localObject2;
    if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
      localObject1 = ((VisibilityChecker)localObject2).withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    return (VisibilityChecker<?>)localObject1;
  }
  
  public FilterProvider getFilterProvider()
  {
    return _filterProvider;
  }
  
  public final int getSerializationFeatures()
  {
    return _serFeatures;
  }
  
  public JsonInclude.Include getSerializationInclusion()
  {
    if (_serializationInclusion != null) {
      return _serializationInclusion;
    }
    return JsonInclude.Include.ALWAYS;
  }
  
  public final boolean hasSerializationFeatures(int paramInt)
  {
    return (_serFeatures & paramInt) == paramInt;
  }
  
  public void initialize(JsonGenerator paramJsonGenerator)
  {
    if ((SerializationFeature.INDENT_OUTPUT.enabledIn(_serFeatures)) && (paramJsonGenerator.getPrettyPrinter() == null))
    {
      PrettyPrinter localPrettyPrinter = constructDefaultPrettyPrinter();
      if (localPrettyPrinter != null) {
        paramJsonGenerator.setPrettyPrinter(localPrettyPrinter);
      }
    }
    boolean bool = SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN.enabledIn(_serFeatures);
    if ((_generatorFeaturesToChange != 0) || (bool))
    {
      int k = paramJsonGenerator.getFeatureMask();
      int j = (_generatorFeaturesToChange ^ 0xFFFFFFFF) & k | _generatorFeatures;
      int i = j;
      if (bool) {
        i = j | JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN.getMask();
      }
      if (k != i) {
        paramJsonGenerator.setFeatureMask(i);
      }
    }
  }
  
  public <T extends BeanDescription> T introspect(JavaType paramJavaType)
  {
    return getClassIntrospector().forSerialization(this, paramJavaType, this);
  }
  
  public BeanDescription introspectClassAnnotations(JavaType paramJavaType)
  {
    return getClassIntrospector().forClassAnnotations(this, paramJavaType, this);
  }
  
  public BeanDescription introspectDirectClassAnnotations(JavaType paramJavaType)
  {
    return getClassIntrospector().forDirectClassAnnotations(this, paramJavaType, this);
  }
  
  public final boolean isEnabled(JsonGenerator.Feature paramFeature, JsonFactory paramJsonFactory)
  {
    int i = paramFeature.getMask();
    if ((_generatorFeaturesToChange & i) != 0) {
      return (_generatorFeatures & paramFeature.getMask()) != 0;
    }
    return paramJsonFactory.isEnabled(paramFeature);
  }
  
  public final boolean isEnabled(SerializationFeature paramSerializationFeature)
  {
    return (_serFeatures & paramSerializationFeature.getMask()) != 0;
  }
  
  public String toString()
  {
    return "[SerializationConfig: flags=0x" + Integer.toHexString(_serFeatures) + "]";
  }
  
  public boolean useRootWrapping()
  {
    if (_rootName != null) {
      return !_rootName.isEmpty();
    }
    return isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
  }
  
  public SerializationConfig with(Base64Variant paramBase64Variant)
  {
    return _withBase(_base.with(paramBase64Variant));
  }
  
  public SerializationConfig with(JsonGenerator.Feature paramFeature)
  {
    int i = _generatorFeatures | paramFeature.getMask();
    int j = _generatorFeaturesToChange | paramFeature.getMask();
    if ((_generatorFeatures == i) && (_generatorFeaturesToChange == j)) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, _serFeatures, i, j);
  }
  
  public SerializationConfig with(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return _withBase(_base.withAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public SerializationConfig with(MapperFeature paramMapperFeature, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = _mapperFeatures | paramMapperFeature.getMask(); i == _mapperFeatures; i = _mapperFeatures & (paramMapperFeature.getMask() ^ 0xFFFFFFFF)) {
      return this;
    }
    return new SerializationConfig(this, i, _serFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    return _withBase(_base.withPropertyNamingStrategy(paramPropertyNamingStrategy));
  }
  
  public SerializationConfig with(SerializationFeature paramSerializationFeature)
  {
    int i = _serFeatures | paramSerializationFeature.getMask();
    if (i == _serFeatures) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, i, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(SerializationFeature paramSerializationFeature, SerializationFeature... paramVarArgs)
  {
    int j = _serFeatures | paramSerializationFeature.getMask();
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].getMask();
      i += 1;
    }
    if (j == _serFeatures) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, j, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig with(ContextAttributes paramContextAttributes)
  {
    if (paramContextAttributes == _attributes) {
      return this;
    }
    return new SerializationConfig(this, paramContextAttributes);
  }
  
  public SerializationConfig with(HandlerInstantiator paramHandlerInstantiator)
  {
    return _withBase(_base.withHandlerInstantiator(paramHandlerInstantiator));
  }
  
  public SerializationConfig with(ClassIntrospector paramClassIntrospector)
  {
    return _withBase(_base.withClassIntrospector(paramClassIntrospector));
  }
  
  public SerializationConfig with(VisibilityChecker<?> paramVisibilityChecker)
  {
    return _withBase(_base.withVisibilityChecker(paramVisibilityChecker));
  }
  
  public SerializationConfig with(SubtypeResolver paramSubtypeResolver)
  {
    if (paramSubtypeResolver == _subtypeResolver) {
      return this;
    }
    return new SerializationConfig(this, paramSubtypeResolver);
  }
  
  public SerializationConfig with(TypeResolverBuilder<?> paramTypeResolverBuilder)
  {
    return _withBase(_base.withTypeResolverBuilder(paramTypeResolverBuilder));
  }
  
  public SerializationConfig with(TypeFactory paramTypeFactory)
  {
    return _withBase(_base.withTypeFactory(paramTypeFactory));
  }
  
  public SerializationConfig with(DateFormat paramDateFormat)
  {
    SerializationConfig localSerializationConfig = new SerializationConfig(this, _base.withDateFormat(paramDateFormat));
    if (paramDateFormat == null) {
      return localSerializationConfig.with(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    return localSerializationConfig.without(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }
  
  public SerializationConfig with(Locale paramLocale)
  {
    return _withBase(_base.with(paramLocale));
  }
  
  public SerializationConfig with(TimeZone paramTimeZone)
  {
    return _withBase(_base.with(paramTimeZone));
  }
  
  public SerializationConfig with(MapperFeature... paramVarArgs)
  {
    int j = _mapperFeatures;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].getMask();
      i += 1;
    }
    if (j == _mapperFeatures) {
      return this;
    }
    return new SerializationConfig(this, j, _serFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return _withBase(_base.withAppendedAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public SerializationConfig withDefaultPrettyPrinter(PrettyPrinter paramPrettyPrinter)
  {
    if (_defaultPrettyPrinter == paramPrettyPrinter) {
      return this;
    }
    return new SerializationConfig(this, paramPrettyPrinter);
  }
  
  public SerializationConfig withFeatures(JsonGenerator.Feature... paramVarArgs)
  {
    int k = _generatorFeatures;
    int j = _generatorFeaturesToChange;
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      int n = paramVarArgs[i].getMask();
      k |= n;
      j |= n;
      i += 1;
    }
    if ((_generatorFeatures == k) && (_generatorFeaturesToChange == j)) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, _serFeatures, k, j);
  }
  
  public SerializationConfig withFeatures(SerializationFeature... paramVarArgs)
  {
    int j = _serFeatures;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].getMask();
      i += 1;
    }
    if (j == _serFeatures) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, j, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig withFilters(FilterProvider paramFilterProvider)
  {
    if (paramFilterProvider == _filterProvider) {
      return this;
    }
    return new SerializationConfig(this, paramFilterProvider);
  }
  
  public SerializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return _withBase(_base.withInsertedAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public SerializationConfig withRootName(PropertyName paramPropertyName)
  {
    if (paramPropertyName == null)
    {
      if (_rootName != null) {}
    }
    else {
      while (paramPropertyName.equals(_rootName)) {
        return this;
      }
    }
    return new SerializationConfig(this, paramPropertyName);
  }
  
  public SerializationConfig withSerializationInclusion(JsonInclude.Include paramInclude)
  {
    if (_serializationInclusion == paramInclude) {
      return this;
    }
    return new SerializationConfig(this, paramInclude);
  }
  
  public SerializationConfig withView(Class<?> paramClass)
  {
    if (_view == paramClass) {
      return this;
    }
    return new SerializationConfig(this, paramClass);
  }
  
  public SerializationConfig withVisibility(PropertyAccessor paramPropertyAccessor, JsonAutoDetect.Visibility paramVisibility)
  {
    return _withBase(_base.withVisibility(paramPropertyAccessor, paramVisibility));
  }
  
  public SerializationConfig without(JsonGenerator.Feature paramFeature)
  {
    int i = _generatorFeatures & (paramFeature.getMask() ^ 0xFFFFFFFF);
    int j = _generatorFeaturesToChange | paramFeature.getMask();
    if ((_generatorFeatures == i) && (_generatorFeaturesToChange == j)) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, _serFeatures, i, j);
  }
  
  public SerializationConfig without(SerializationFeature paramSerializationFeature)
  {
    int i = _serFeatures & (paramSerializationFeature.getMask() ^ 0xFFFFFFFF);
    if (i == _serFeatures) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, i, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig without(SerializationFeature paramSerializationFeature, SerializationFeature... paramVarArgs)
  {
    int j = _serFeatures & (paramSerializationFeature.getMask() ^ 0xFFFFFFFF);
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j &= (paramVarArgs[i].getMask() ^ 0xFFFFFFFF);
      i += 1;
    }
    if (j == _serFeatures) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, j, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig without(MapperFeature... paramVarArgs)
  {
    int j = _mapperFeatures;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j &= (paramVarArgs[i].getMask() ^ 0xFFFFFFFF);
      i += 1;
    }
    if (j == _mapperFeatures) {
      return this;
    }
    return new SerializationConfig(this, j, _serFeatures, _generatorFeatures, _generatorFeaturesToChange);
  }
  
  public SerializationConfig withoutFeatures(JsonGenerator.Feature... paramVarArgs)
  {
    int k = _generatorFeatures;
    int j = _generatorFeaturesToChange;
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      int n = paramVarArgs[i].getMask();
      k &= (n ^ 0xFFFFFFFF);
      j |= n;
      i += 1;
    }
    if ((_generatorFeatures == k) && (_generatorFeaturesToChange == j)) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, _serFeatures, k, j);
  }
  
  public SerializationConfig withoutFeatures(SerializationFeature... paramVarArgs)
  {
    int j = _serFeatures;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j &= (paramVarArgs[i].getMask() ^ 0xFFFFFFFF);
      i += 1;
    }
    if (j == _serFeatures) {
      return this;
    }
    return new SerializationConfig(this, _mapperFeatures, j, _generatorFeatures, _generatorFeaturesToChange);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.SerializationConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */