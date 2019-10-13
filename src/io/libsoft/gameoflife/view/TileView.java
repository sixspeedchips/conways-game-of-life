package io.libsoft.gameoflife.view;

import java.util.Collections;
import javafx.beans.property.BooleanProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TileView extends Rectangle {

  private BooleanProperty tile;

  public TileView(BooleanProperty tile) {
    this.tile = tile;
    setWidth(10);
    setHeight(10);
    setStroke(Color.GRAY);
    setStrokeWidth(1);
    setFill(tile.getValue() ? Color.BLACK: Color.WHITE);
    tile.addListener((observable, oldValue, newValue) -> {
      if(newValue){
        setFill(Color.BLACK);
      } else {
        setFill(Color.WHITE);
      }
    });
  }

  public void flip() {
    tile.setValue(!tile.getValue());
  }

  public void setAlive(){
    tile.setValue(true);
  }

}
