package acre.observerpattern.pullbased;

import java.util.UUID;

public class EventListener implements Observer {

  private Event event;
  private final String uuid = UUID.randomUUID().toString().substring(6);

  public EventListener(Event event) {
    this.event = event;
    this.event.addListener(this);
  }

  public void listen(Event event) {
    this.event = event;
    this.event.addListener(this);
  }

  /*
   listener active pulling, so event do not need to hold
   listener reference
   */

  @Override
  public void pullStatus() {
    System.out.println(uuid + " Active pulling " + event.getStatus());
  }

  @Override
  public void notifyObserver() {
    System.out.println(uuid + " Some one notified " + event.getStatus());
  }
}
