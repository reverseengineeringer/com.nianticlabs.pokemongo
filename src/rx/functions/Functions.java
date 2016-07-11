package rx.functions;

public final class Functions
{
  private Functions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static FuncN<Void> fromAction(Action0 paramAction0)
  {
    new FuncN()
    {
      public Void call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 0) {
          throw new RuntimeException("Action0 expecting 0 arguments.");
        }
        val$f.call();
        return null;
      }
    };
  }
  
  public static <T0> FuncN<Void> fromAction(Action1<? super T0> paramAction1)
  {
    new FuncN()
    {
      public Void call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 1) {
          throw new RuntimeException("Action1 expecting 1 argument.");
        }
        val$f.call(paramAnonymousVarArgs[0]);
        return null;
      }
    };
  }
  
  public static <T0, T1> FuncN<Void> fromAction(Action2<? super T0, ? super T1> paramAction2)
  {
    new FuncN()
    {
      public Void call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 2) {
          throw new RuntimeException("Action3 expecting 2 arguments.");
        }
        val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1]);
        return null;
      }
    };
  }
  
  public static <T0, T1, T2> FuncN<Void> fromAction(Action3<? super T0, ? super T1, ? super T2> paramAction3)
  {
    new FuncN()
    {
      public Void call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 3) {
          throw new RuntimeException("Action3 expecting 3 arguments.");
        }
        val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2]);
        return null;
      }
    };
  }
  
  public static <R> FuncN<R> fromFunc(Func0<? extends R> paramFunc0)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 0) {
          throw new RuntimeException("Func0 expecting 0 arguments.");
        }
        return (R)val$f.call();
      }
    };
  }
  
  public static <T0, R> FuncN<R> fromFunc(Func1<? super T0, ? extends R> paramFunc1)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 1) {
          throw new RuntimeException("Func1 expecting 1 argument.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0]);
      }
    };
  }
  
  public static <T0, T1, R> FuncN<R> fromFunc(Func2<? super T0, ? super T1, ? extends R> paramFunc2)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 2) {
          throw new RuntimeException("Func2 expecting 2 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1]);
      }
    };
  }
  
  public static <T0, T1, T2, R> FuncN<R> fromFunc(Func3<? super T0, ? super T1, ? super T2, ? extends R> paramFunc3)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 3) {
          throw new RuntimeException("Func3 expecting 3 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2]);
      }
    };
  }
  
  public static <T0, T1, T2, T3, R> FuncN<R> fromFunc(Func4<? super T0, ? super T1, ? super T2, ? super T3, ? extends R> paramFunc4)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 4) {
          throw new RuntimeException("Func4 expecting 4 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2], paramAnonymousVarArgs[3]);
      }
    };
  }
  
  public static <T0, T1, T2, T3, T4, R> FuncN<R> fromFunc(Func5<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc5)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 5) {
          throw new RuntimeException("Func5 expecting 5 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2], paramAnonymousVarArgs[3], paramAnonymousVarArgs[4]);
      }
    };
  }
  
  public static <T0, T1, T2, T3, T4, T5, R> FuncN<R> fromFunc(Func6<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc6)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 6) {
          throw new RuntimeException("Func6 expecting 6 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2], paramAnonymousVarArgs[3], paramAnonymousVarArgs[4], paramAnonymousVarArgs[5]);
      }
    };
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, R> FuncN<R> fromFunc(Func7<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc7)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 7) {
          throw new RuntimeException("Func7 expecting 7 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2], paramAnonymousVarArgs[3], paramAnonymousVarArgs[4], paramAnonymousVarArgs[5], paramAnonymousVarArgs[6]);
      }
    };
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, R> FuncN<R> fromFunc(Func8<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc8)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 8) {
          throw new RuntimeException("Func8 expecting 8 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2], paramAnonymousVarArgs[3], paramAnonymousVarArgs[4], paramAnonymousVarArgs[5], paramAnonymousVarArgs[6], paramAnonymousVarArgs[7]);
      }
    };
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> FuncN<R> fromFunc(Func9<? super T0, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc9)
  {
    new FuncN()
    {
      public R call(Object... paramAnonymousVarArgs)
      {
        if (paramAnonymousVarArgs.length != 9) {
          throw new RuntimeException("Func9 expecting 9 arguments.");
        }
        return (R)val$f.call(paramAnonymousVarArgs[0], paramAnonymousVarArgs[1], paramAnonymousVarArgs[2], paramAnonymousVarArgs[3], paramAnonymousVarArgs[4], paramAnonymousVarArgs[5], paramAnonymousVarArgs[6], paramAnonymousVarArgs[7], paramAnonymousVarArgs[8]);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */