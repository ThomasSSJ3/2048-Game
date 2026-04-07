package com.game2048.controller;

import com.game2048.model.Direction;
import com.game2048.model.Grid;
import com.game2048.view.GameView;

public class GameController {

  private GameView view;
  private Grid grid;
  private boolean isWon = false;

  public GameController(GameView view, int size) {
    this.view = view;
    grid = new Grid(size);
  }

  public void startGame() {
    view.displayGame();
    grid.addRandomTile();
    grid.addRandomTile();

    while(!grid.isGameLost()) {
      view.displayScore(grid.getScore());
      view.displayGrid(grid.getCells(), grid.getSize());

      if ((!isWon) && (grid.isGameWon())) {
        view.displayWin();
        isWon = true;
      }

      String choice;
      do {
        choice = view.getAction();
      } while (!moveFromChoice(choice));

      grid.addRandomTile();
    }

    view.displayScore(grid.getScore());
    view.displayGrid(grid.getCells(), grid.getSize());
    if (grid.isGameLost()) {
      view.displayLose();
    }
  }

  private boolean moveFromChoice(String choice) {
    if (("z".equals(choice)) || ("Z".equals(choice))) {
      grid.move(Direction.UP);
      return true;
    } else if (("s".equals(choice)) || ("S".equals(choice))) {
      grid.move(Direction.DOWN);
      return true;
    } else if (("q".equals(choice)) || ("Q".equals(choice))) {
      grid.move(Direction.LEFT);
      return true;
    } else if (("d".equals(choice)) || ("D".equals(choice))) {
      grid.move(Direction.RIGHT);
      return true;
    } else {
      return false;
    }
  }

}