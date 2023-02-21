package com.example.scopes.singleton;

import com.example.scopes.prototype.LookupPartTimeWorker;
import com.example.scopes.prototype.PartTimeWorker;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Worker {

  private static final Logger LOG = LoggerFactory.getLogger(Worker.class);
  private static final AtomicInteger counter = new AtomicInteger(0);

  private final PartTimeWorker partTimeWorker;

  public Worker(final PartTimeWorker partTimeWorker) {
    this.partTimeWorker = partTimeWorker;
  }

  public void doSomeWork() {
    LOG.info("Worker instance No{}", counter.get());
    partTimeWorker.justDoIt();
    getLookupPartTimeWorker().justDoIt();
  }

  @Lookup
  public LookupPartTimeWorker getLookupPartTimeWorker() {
    return null;
  }
}
