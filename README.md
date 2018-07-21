# tdd-practice

This project is for tdd practice with JUnit5 and nice example from Sandro Mancuso.

https://www.youtube.com/watch?v=24vzFAvOzo0

### Mars Rover Kata

Develop an API that moves a rover around on a grid

Rules:

1. You are given the initial starting point (0, 0, N) of a rover.
2. 0,0 are X, Y co-ordinates on a grid of (10, 10)
3. N is the direction it is facing (i.e. N,S,E,W)
4. L nad R allow the rover to rotate left and right.
5. M allows the rover to move one point in the current direction.
6. The rover receives a char array of commands e.g. RMMLM and returns the finishing point after the moves e.g. 2:1:N
7. The rover wraps around if it reaches the end of the grid.
8. The grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover moves up to the
last possible point and reports the obstacle e.g. 0:2:2:N

### How to practice
I made two tags, `problem` and `answer`. Enjoy practicing TDD.