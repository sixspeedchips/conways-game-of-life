package io.libsoft.gameoflife.view;

import io.libsoft.gameoflife.model.Board;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainView extends Application {

  private Timer timer;
  private BooleanProperty paused;
  private Board board;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    board = new Board(100, 100);
    timer = new Timer(200);
    paused = new SimpleBooleanProperty(true);
    setTriggers();
    stage.setScene(createScene(new BoardView(board.getCurrentBoard())));
    stage.setTitle("Life");
    stage.show();

  }

  private void setTriggers() {
    timer.getTrigger().addListener((observable, oldValue, newValue) -> {
      if (newValue) {
        board.update();
        timer.getTrigger().setValue(false);
      }
    });
    paused.addListener((observable, oldValue, newValue) -> {
      if (!newValue) {
        timer.start();
      } else {
        timer.stop();
      }
    });
  }


  private Scene createScene(Node... nodes) {
    StackPane root = new StackPane(nodes);

    Scene scene = new Scene(root);
    scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      if (event.getCode().equals(KeyCode.SPACE)) {
        paused.setValue(!paused.getValue());
      }
      if (event.getCode().equals(KeyCode.R)) {
        board.reset();
      }
      if (event.getCode().equals(KeyCode.K)) {
        board.flipRandom();
      }
      if (event.getCode().equals(KeyCode.RIGHT)) {
        timer.speedUp();
      }
      if (event.getCode().equals(KeyCode.LEFT)) {
        timer.slowDown();
      }
      if (event.getCode().equals(KeyCode.DOWN)) {
        timer.reset();
      }
    });

    return scene;
  }
}
