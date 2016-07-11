package rx.plugins;

import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins
{
  static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {};
  private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
  private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference();
  private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference();
  private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference();
  
  public static RxJavaPlugins getInstance()
  {
    return INSTANCE;
  }
  
  private static Object getPluginImplementationViaProperty(Class<?> paramClass)
  {
    String str1 = paramClass.getSimpleName();
    String str2 = System.getProperty("rxjava.plugin." + str1 + ".implementation");
    if (str2 != null) {
      try
      {
        paramClass = Class.forName(str2).asSubclass(paramClass).newInstance();
        return paramClass;
      }
      catch (ClassCastException paramClass)
      {
        throw new RuntimeException(str1 + " implementation is not an instance of " + str1 + ": " + str2);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new RuntimeException(str1 + " implementation class not found: " + str2, paramClass);
      }
      catch (InstantiationException paramClass)
      {
        throw new RuntimeException(str1 + " implementation not able to be instantiated: " + str2, paramClass);
      }
      catch (IllegalAccessException paramClass)
      {
        throw new RuntimeException(str1 + " implementation not able to be accessed: " + str2, paramClass);
      }
    }
    return null;
  }
  
  public RxJavaErrorHandler getErrorHandler()
  {
    Object localObject;
    if (errorHandler.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaErrorHandler.class);
      if (localObject != null) {
        break label43;
      }
      errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
    }
    for (;;)
    {
      return (RxJavaErrorHandler)errorHandler.get();
      label43:
      errorHandler.compareAndSet(null, (RxJavaErrorHandler)localObject);
    }
  }
  
  public RxJavaObservableExecutionHook getObservableExecutionHook()
  {
    Object localObject;
    if (observableExecutionHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class);
      if (localObject != null) {
        break label43;
      }
      observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
    }
    for (;;)
    {
      return (RxJavaObservableExecutionHook)observableExecutionHook.get();
      label43:
      observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook)localObject);
    }
  }
  
  public RxJavaSchedulersHook getSchedulersHook()
  {
    Object localObject;
    if (schedulersHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaSchedulersHook.class);
      if (localObject != null) {
        break label43;
      }
      schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
    }
    for (;;)
    {
      return (RxJavaSchedulersHook)schedulersHook.get();
      label43:
      schedulersHook.compareAndSet(null, (RxJavaSchedulersHook)localObject);
    }
  }
  
  public void registerErrorHandler(RxJavaErrorHandler paramRxJavaErrorHandler)
  {
    if (!errorHandler.compareAndSet(null, paramRxJavaErrorHandler)) {
      throw new IllegalStateException("Another strategy was already registered: " + errorHandler.get());
    }
  }
  
  public void registerObservableExecutionHook(RxJavaObservableExecutionHook paramRxJavaObservableExecutionHook)
  {
    if (!observableExecutionHook.compareAndSet(null, paramRxJavaObservableExecutionHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + observableExecutionHook.get());
    }
  }
  
  public void registerSchedulersHook(RxJavaSchedulersHook paramRxJavaSchedulersHook)
  {
    if (!schedulersHook.compareAndSet(null, paramRxJavaSchedulersHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + schedulersHook.get());
    }
  }
  
  void reset()
  {
    INSTANCEerrorHandler.set(null);
    INSTANCEobservableExecutionHook.set(null);
    INSTANCEschedulersHook.set(null);
  }
}

/* Location:
 * Qualified Name:     rx.plugins.RxJavaPlugins
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */