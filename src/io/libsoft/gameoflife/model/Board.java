package io.libsoft.gameoflife.model;

import java.util.Arrays;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Board {


  private BooleanProperty[][] currentBoard;
  private boolean[][] updateBoard;
  private int rows, columns;

  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    currentBoard = new BooleanProperty[rows][columns];
    updateBoard = new boolean[rows][columns];
    newBoard();
  }

  private void newBoard() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        currentBoard[i][j] = new SimpleBooleanProperty();
      }
    }
  }


  public void update() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        updateBoard[i][j] = isAlive(currentBoard[i][j].getValue(), i, j);
      }
    }
    updateCurrentBoard();

  }

  private void updateCurrentBoard() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        currentBoard[i][j].setValue(updateBoard[i][j]);
      }
    }
  }

  private boolean isAlive(boolean alive, int row, int column) {
    int aliveNeighbors = countAliveNeighbors(row, column);
    boolean survival;
    if (alive){
      if (aliveNeighbors < 2){
        survival = false;
      } else
        survival = aliveNeighbors < 4;
    } else {
      survival = aliveNeighbors == 3;
    }
    return survival;
  }

  private int countAliveNeighbors(int row, int column) {
    int count = 0;

    // compute directly adjacent
    count += column > 0 && currentBoard[row][column - 1].getValue() ? 1 : 0;
    count += column < columns-1 && currentBoard[row][column + 1].getValue() ? 1 : 0;
    count += row > 0 && currentBoard[row - 1][column].getValue() ? 1 : 0;
    count += row < rows-1 && currentBoard[row + 1][column].getValue() ? 1 : 0;

    // compute diagonals
    count += column > 0 && row > 0 && currentBoard[row - 1][column - 1].getValue() ? 1 : 0;
    count += column > 0 && row < rows-1  && currentBoard[row + 1][column - 1].getValue() ? 1 : 0;
    count += column < columns-1 && row > 0  && currentBoard[row - 1][column + 1].getValue() ? 1 : 0;
    count += column < columns-1 &&  row < rows-1  && currentBoard[row + 1][column + 1].getValue() ? 1 : 0;

    return count;
  }

  public void set(int row, int column){
    currentBoard[row][column].setValue(true);
  }

  public BooleanProperty[][] getCurrentBoard() {
    return currentBoard;
  }

  public void reset() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        currentBoard[i][j].setValue(false);
      }
    }


  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        sb.append(" ").append(currentBoard[i][j].getValue() ? 1:0);
      }
      sb.append("\n");
    }


    return sb.toString();
  }
}
