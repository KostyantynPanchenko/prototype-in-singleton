package com.example.scopes.tester;

import com.example.scopes.singleton.Worker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ScopesTester {

  private final Worker worker;

  public ScopesTester(final Worker worker) {
    this.worker = worker;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onReadeEvent() {
    worker.doSomeWork();
    worker.doSomeWork();
    worker.doSomeWork();
  }
}
