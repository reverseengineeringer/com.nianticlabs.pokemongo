package rx.plugins;

class RxJavaObservableExecutionHookDefault
  extends RxJavaObservableExecutionHook
{
  private static RxJavaObservableExecutionHookDefault INSTANCE = new RxJavaObservableExecutionHookDefault();
  
  public static RxJavaObservableExecutionHook getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     rx.plugins.RxJavaObservableExecutionHookDefault
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */