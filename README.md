# tdd-practice

This project is for tdd practice with JUnit5 and nice questions.

## Q1. Mars Rover Kata
### Description
Develop an API that moves a rover around on a grid

Rules:

1. You are given the initial starting point (0, 0, N) of a rover.
2. 0,0 are X, Y co-ordinates on a grid of (10, 10)
3. N is the direction it is facing (i.e. N,S,E,W)
4. L nad R allow the rover to rotate left and right.
5. M allows the rover to move one point in the current direction.
6. The rover receives a char array of commands e.g. RMMLM and returns the finishing point after the moves e.g. 2:1:N
7. The rover wraps around if it reaches the end of the grid.
8. The grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle e.g. 0:2:2:N

### Answer with video
https://www.youtube.com/watch?v=24vzFAvOzo0

## Q2. PrimeFactors
### Answer with video
https://www.youtube.com/watch?v=9flsVKN4tZM

## Q3. bowling game
### Answer with video
https://www.youtube.com/watch?v=9flsVKN4tZM

## 04. Word Warp
### Answer with video
https://www.youtube.com/watch?v=RdSgcDiYUaM

## 05. Bank-kata
Create a simple bank application with the following features:

- Deposit into Account
- Withdraw from an Account
- Print a bank statement to the console

##### Acceptance criteria
Statement should have transactions in the following format:
> DATE | AMOUNT | BALANCE   
10/04/2014 | 500.00 | 1400.00   
02/04/2014 | -100.00 | 900.00  
01/04/2014 | 1000.00 | 1000.00

##### Starting point and constraints
1. Start with a class the following structure:
```java
public class Account {
    public void deposit(int amount);
    public void withdraw(int amount);
    public void printStatement();
}
```
2. You are not allowed to add any other public method to this class.
3. Use Strings and Integers for dates and amounts (keep it simple)
4. Don't worry about spacing in the statement printed on the console.

### Answer with video
https://www.youtube.com/watch?v=XHnuMjah6ps (part-1)
https://www.youtube.com/watch?v=gs0rqDdz3ko (part-2)
https://www.youtube.com/watch?v=R9OAt9AOrzI (part-3)
