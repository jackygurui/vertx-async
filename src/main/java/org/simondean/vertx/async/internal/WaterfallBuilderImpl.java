package org.simondean.vertx.async.internal;

import org.simondean.vertx.async.WaterfallBuilder;
import org.simondean.vertx.async.Waterfall;
import io.vertx.core.AsyncResultHandler;

import java.util.function.Consumer;

public class WaterfallBuilderImpl implements WaterfallBuilder {
  @Override
  public <T> Waterfall<T> task(Consumer<AsyncResultHandler<T>> task) {
    return new DefaultWaterfall<>(task);
  }
}
