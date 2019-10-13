package io.libsoft.gameoflife.view;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.BooleanProperty;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class BoardView extends GridPane {

  private BooleanProperty[][] board;
  private List<TileView> draggedSquares;

  public BoardView(BooleanProperty[][] board) {
    this.board = board;
    draggedSquares = new ArrayList<>();
    init();
  }

  private void init() {
    setOnMouseDragged(event -> {
      Node picked = event.getPickResult().getIntersectedNode();
      if(picked instanceof TileView){
        ((TileView) picked).setAlive();
      }
    });

    setOnMouseClicked(event -> {
      Node picked = event.getPickResult().getIntersectedNode();
      if(picked instanceof TileView){
        ((TileView) picked).flip();
      }
    });

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        add(new TileView(board[i][j]), j, i);
      }
    }


  }
}
