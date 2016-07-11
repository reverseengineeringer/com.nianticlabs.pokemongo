package rx;

class Single$5$1
  extends SingleSubscriber<Single<? extends T>>
{
  Single$5$1(Single.5 param5, SingleSubscriber paramSingleSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onSuccess(Single<? extends T> paramSingle)
  {
    paramSingle.subscribe(val$child);
  }
}

/* Location:
 * Qualified Name:     rx.Single.5.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */