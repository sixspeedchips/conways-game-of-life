# John Conway's Game of Life

    A simple implementation of Conway's game of life in JavaFX
 
### About
Here is a simple implementation of the original Game of Life by mathmetician John Conway. The rules are simple:
* Any live cell with fewer than two live neighbours dies, as if by underpopulation.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overpopulation.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

To play, draw a pattern by dragging the mouse across the squares. Clicking on a square will flip it from dead->alive or vice-versa.
The controls are SPACE to pause and R to reset the board. 

### Requirements
* Java 8+
* JavaFX
    