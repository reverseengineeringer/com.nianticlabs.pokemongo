package com.upsight.android.internal;

import com.upsight.android.internal.logger.LoggerModule;
import com.upsight.android.internal.persistence.PersistenceModule;
import com.upsight.android.internal.persistence.storable.StorableModule;
import dagger.Module;

@Module(includes={UpsightContextModule.class, ContextModule.class, PropertiesModule.class, ObjectMapperModule.class, SchedulersModule.class, StorableModule.class, PersistenceModule.class, LoggerModule.class})
public final class CoreModule {}

/* Location:
 * Qualified Name:     com.upsight.android.internal.CoreModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */