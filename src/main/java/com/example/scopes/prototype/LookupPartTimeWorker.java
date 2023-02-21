package com.example.scopes.prototype;

import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
    proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LookupPartTimeWorker {

  private static final Logger LOG = LoggerFactory.getLogger(LookupPartTimeWorker.class);
  private static final AtomicInteger counter = new AtomicInteger(0);

  public LookupPartTimeWorker() {
    counter.incrementAndGet();
  }

  public void justDoIt() {
    LOG.info("LookupPartTimeWorker instance No{}", counter.get());
  }
}
