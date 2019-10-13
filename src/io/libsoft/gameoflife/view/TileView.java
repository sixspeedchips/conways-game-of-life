package io.libsoft.gameoflife.view;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.property.BooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TileView extends Rectangle {

  private BooleanProperty tile;
  private Duration d = Duration.millis(90);
  public TileView(BooleanProperty tile) {
    this.tile = tile;
    setWidth(10);
    setHeight(10);
    setArcWidth(5);
    setArcHeight(5);
//    setStroke(Color.GRAY);
//    setStrokeWidth(1);
    setFill(tile.getValue() ? Color.BLACK : Color.WHITE);
    tile.addListener((observable, oldValue, newValue) -> {
      if (newValue) {
        FillTransition ft = new FillTransition(d,this);
        ft.setToValue(Color.BLACK);
        ft.play();
      } else {
        FillTransition ft = new FillTransition(d,this);
        ft.setToValue(Color.WHITE);
        ft.play();
      }
    });
  }

  public void flip() {
    tile.setValue(!tile.getValue());
  }

  public void setAlive() {
    tile.setValue(true);
  }

}
