package io.libsoft.gameoflife.view;

import io.libsoft.gameoflife.model.Board;
import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Timer extends AnimationTimer {


  private long startTime;
  private BooleanProperty trigger = new SimpleBooleanProperty(false);
  private long millis;

  public Timer(long millis) {
    this.millis = millis;
  }

  @Override
  public void start() {
    super.start();
    startTime = System.nanoTime();
  }

  @Override
  public void handle(long now) {
    long time = TimeUnit.MILLISECONDS.convert(now - startTime, TimeUnit.NANOSECONDS);

    if( time > millis){

      startTime = System.nanoTime();
      trigger.setValue(true);

    }
  }

  public BooleanProperty getTrigger() {
    return trigger;
  }

  public void speedUp() {
    millis = Math.max(millis - 10,0);
  }

  public void slowDown() {
    millis = Math.min(millis + 10, 3000);
  }


  public void reset() {
    millis = 200;
  }
}
