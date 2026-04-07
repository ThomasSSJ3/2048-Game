package com.game2048.view;

public interface GameView {

  void displayGame();
  void displayGrid(int[][] cells, int size);
  void displayScore(int score);
  void displayWin();
  void displayLose();
  String getAction();

}