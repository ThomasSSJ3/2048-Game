package com.game2048.model;

import java.security.SecureRandom;
import java.util.Random;

public class Grid {

  private int size;
  private int[][] cells;
  private int score = 0;
  private Random random;

  public Grid(int size) {
    this.size = size;

    cells = new int[size][size];
    for (int i=0 ; i<size ; i++) {
      for (int j=0 ; j<size ; j++) {
        cells[i][j] = 0;
      }
    }

    try {
			random = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			e.printStackTrace();
		}
  }

  public void addRandomTile() {
    int iRandom;
    int jRandom;

    do {
      iRandom = random.nextInt(size);    
      jRandom = random.nextInt(size);
    } while (cells[iRandom][jRandom] != 0);

    if (random.nextInt(10) == 0) {
      cells[iRandom][jRandom] = 4;
    } else {
      cells[iRandom][jRandom] = 2;
    }
  }

  public void move(Direction direction) {
    if (direction == Direction.UP) {
      shiftUp();
      fusionUp();
      shiftUp();
    } else if (direction == Direction.DOWN) {
      shiftDown();
      fusionDown();
      shiftDown();
    } else if (direction == Direction.LEFT) {
      shiftLeft();
      fusionLeft();
      shiftLeft();
    } else if (direction == Direction.RIGHT) {
      shiftRight();
      fusionRight();
      shiftRight();
    }
  }

  private void shiftUp() {
    for (int i=0 ; i<size ; i++) {
      for (int j=0 ; j<size ; j++) {
        int k = 0;
        while ((i+k<size-1) && (cells[i+k][j] == 0)) {
          k++;
        }
        if (k != 0) {
          cells[i][j] = cells[i+k][j];
          cells[i+k][j] = 0;
        }
      }
    }
  }

  private void shiftDown() {
    for (int i=size-1 ; i>0 ; i--) {
      for (int j=0 ; j<size ; j++) {
        int k = 0;
        while ((i-k<size-1) && (cells[i-k][j] == 0)) {
          k++;
        }
        if (k != 0) {
          cells[i][j] = cells[i-k][j];
          cells[i-k][j] = 0;
        }
      }
    }
  }

  private void shiftLeft() {
    for (int i=0 ; i<size ; i++) {
      for (int j=0 ; j<size ; j++) {
        int k = 0;
        while ((j+k<size-1) && (cells[i][j+k] == 0)) {
          k++;
        }
        if (k != 0) {
          cells[i][j] = cells[i][j+k];
          cells[i][j+k] = 0;
        }
      }
    }
  }

  private void shiftRight() {
    for (int i=0 ; i<size ; i++) {
      for (int j=size-1 ; j>0 ; j--) {
        int k = 0;
        while ((k<j) && (cells[i][j-k] == 0)) {
          k++;
        }
        if (k != 0) {
          cells[i][j] = cells[i][j-k];
          cells[i][j-k] = 0;
        }
      }
    }
  }

  private void fusionUp() {
    for (int i=0 ; i<size ; i++) {
      for (int j=0; j<size ; j++) {
        if ((cells[i][j] != 0) && (cells[i][j] == cells[i+1][j])) {
          cells[i][j] *= 2;
          cells[i+1][j] = 0;
          score += cells[i][j];
        }
      }
    }
  }

  private void fusionDown() {
    for (int i=0 ; i<size ; i++) {
      for (int j=0; j<size ; j++) {
        if ((cells[i][j] != 0) && (cells[i][j] == cells[i-1][j])) {
          cells[i][j] *= 2;
          cells[i-1][j] = 0;
          score += cells[i][j];
        }
      }
    }
  }

  private void fusionLeft() {
    for (int i=0 ; i<size ; i++) {
      for (int j=0; j<size ; j++) {
        if ((cells[i][j] != 0) && (cells[i][j] == cells[i][j+1])) {
          cells[i][j] *= 2;
          cells[i][j+1] = 0;
          score += cells[i][j];
        }
      }
    }
  }

  private void fusionRight() {
    for (int i=0 ; i<size ; i++) {
      for (int j=size-1 ; j>0 ; j--) {
        if ((cells[i][j] != 0) && (cells[i][j] == cells[i][j-1])) {
          cells[i][j] *= 2;
          cells[i][j-1] = 0;
          score += cells[i][j];
        }
      }
    }
  }

  public int getSize() {
    return size;
  }

  public int[][] getCells() {
    return cells;
  }

  public int getScore() {
    return score;
  }

}