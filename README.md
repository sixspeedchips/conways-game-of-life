# John Conway's Game of Life

    An implementation of Conway's game of life in JavaFX
 
### About
Here is a simple implementation of the original Game of Life by mathmetician John Conway. The rules are simple:
* Any live cell with fewer than two live neighbours dies, as if by underpopulation.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overpopulation.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

To play, draw a pattern by dragging the mouse across the squares. Clicking on a square will flip it from dead->alive or vice-versa.
Controls:
* SPACE to pause
* R to reset the board. 
* K to add random cells
* LEFT to slow down
* RIGHT to speed up
* DOWN to reset speed to 200 ms per update
### Requirements
* Java 8+
* JavaFX
    