package acre.observerpattern.pullbased;

public class Application {
  public static void main(String[] args) throws Exception {
    pullBased();
  }


  public static void pushBase() throws Exception {
    Event event = new Event();
    EventListener listener1 = new EventListener(event);
    EventListener listener2 = new EventListener(event);

    for (int i = 0; i < 5; i++) {
      event.updateStatus(true);
      Thread.sleep(1000);
    }
  }

  public static void pullBased() throws Exception {
    Event event = new Event();
    EventListener listener1 = new EventListener(event);
    EventListener listener2 = new EventListener(event);

    new Thread(() -> {
      while (true) {
        listener1.pullStatus();
      }
    }).start();

    new Thread(() -> {
      while (true) {
        listener2.pullStatus();
      }
    }).start();

    for (int i = 0; i < 5; i++) {
      event.updateStatus(false);
      Thread.sleep(1000);
    }
  }
}
