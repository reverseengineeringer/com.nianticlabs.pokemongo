package com.upsight.android.internal;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class ObjectMapperModule
{
  @Provides
  @Singleton
  ObjectMapper provideObjectMapper()
  {
    ObjectMapper localObjectMapper = new ObjectMapper();
    localObjectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    localObjectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, false);
    localObjectMapper.configure(MapperFeature.AUTO_DETECT_SETTERS, false);
    localObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    localObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    localObjectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC);
    return localObjectMapper;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ObjectMapperModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */