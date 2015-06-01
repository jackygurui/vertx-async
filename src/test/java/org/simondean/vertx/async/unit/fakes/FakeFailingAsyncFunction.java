package org.simondean.vertx.async.unit.fakes;

import org.vertx.java.core.AsyncResultHandler;
import org.vertx.java.core.impl.DefaultFutureResult;

public class FakeFailingAsyncFunction<T, R> extends FakeAsyncFunction<T, R> {
  private final Throwable cause;

  public FakeFailingAsyncFunction(Throwable cause) {
    this.cause = cause;
  }

  @Override
  public void accept(T value, AsyncResultHandler<R> handler) {
    addConsumedValue(value);
    incrementRunCount();
    handler.handle(new DefaultFutureResult<>(cause));
  }

  public Throwable cause() {
    return cause;
  }
}