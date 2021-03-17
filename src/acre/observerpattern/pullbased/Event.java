package acre.observerpattern.pullbased;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Event {

  private String status;
  private final List<EventListener> listeners;

  public Event() {
    this.listeners = new ArrayList<>();
  }

  public void addListener(EventListener eventListener) {
    this.listeners.add(eventListener);
  }

  public void updateStatus(boolean a) {
    this.status = UUID.randomUUID().toString();
    // notify everyone
    if (a) {
      this.listeners.forEach(EventListener::notifyObserver);
    }
  }

  public String getStatus() {
    return this.status;
  }
}
