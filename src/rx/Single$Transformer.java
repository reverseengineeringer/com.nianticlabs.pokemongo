package rx;

import rx.functions.Func1;

public abstract interface Single$Transformer<T, R>
  extends Func1<Single<T>, Single<R>>
{}

/* Location:
 * Qualified Name:     rx.Single.Transformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */