package com.game2048.view;

import java.util.Scanner;

public class HeadlessView implements GameView {

  private Scanner clavier = new Scanner(System.in);

  @Override
  public void displayGame() {
    System.out.println("\n======= 2048-Game ======");
  }

  @Override
  public void displayGrid(int[][] cells, int size) {
    for (int i=0 ; i<size ; i++) {
      for (int j=0 ; j<size ; j++) {
        System.out.print("+-----");
      }
      System.out.println("+");
      for (int j=0 ; j<size ; j++) {
        if (cells[i][j] == 0) {       
          System.out.printf("|%5s", "");
        } else {
          System.out.printf("|%5s", String.valueOf(cells[i][j]));
        }
      }
      System.out.println("|");
    }
    for (int j=0 ; j<size ; j++) {
        System.out.print("+-----");
    }
    System.out.println("+\n");
  }

  @Override
  public void displayScore(int score) {
    System.out.println("\n-> Score : " + score);
  }

  @Override
  public void displayWin() {
    System.out.println("GG! The game is won!\n");
  }

  @Override
  public void displayLose() {
    System.out.println("OH no... The game is lost.\n");
  }

  @Override
  public String getAction() {
    System.out.print("Action (ZQSD) : ");
    return clavier.next();
  }
    
}