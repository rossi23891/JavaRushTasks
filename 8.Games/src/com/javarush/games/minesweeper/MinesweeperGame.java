package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;


public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countMinesOnField;
    private int countFlags;//for unused flags
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }


    private void createGame() {
        for (int col = 0; col < gameField.length; col++) {
            for (int row = 0; row < gameField.length; row++) {
                int randomNumber = getRandomNumber(10);
                boolean randomMine = false;
                if (randomNumber < 1) {
                    randomMine = true;
                    countMinesOnField++;
                }
                gameField[row][col] = new GameObject(col, row, randomMine);
                setCellColor(col, row, Color.LIGHTSALMON);
                setCellValue(col, row, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> cellNeighbors = new ArrayList<>();
        int col = gameObject.x;
        int row = gameObject.y;

        if (col > 0 && col < gameField.length - 1 && row > 0 && row < gameField.length - 1) {
            cellNeighbors.add(gameField[row - 1][col - 1]);
            cellNeighbors.add(gameField[row - 1][col]);
            cellNeighbors.add(gameField[row - 1][col + 1]);
            cellNeighbors.add(gameField[row][col - 1]);
            cellNeighbors.add(gameField[row][col + 1]);
            cellNeighbors.add(gameField[row + 1][col - 1]);
            cellNeighbors.add(gameField[row + 1][col]);
            cellNeighbors.add(gameField[row + 1][col + 1]);
        } else if (col == 0 && row > 0 && row < gameField.length - 1) {
            cellNeighbors.add(gameField[row - 1][col]);
            cellNeighbors.add(gameField[row - 1][col + 1]);
            cellNeighbors.add(gameField[row][col + 1]);
            cellNeighbors.add(gameField[row + 1][col + 1]);
            cellNeighbors.add(gameField[row + 1][col]);
        } else if (col > 0 && col < gameField.length - 1 && row == 0) {
            cellNeighbors.add(gameField[row][col - 1]);
            cellNeighbors.add(gameField[row + 1][col - 1]);
            cellNeighbors.add(gameField[row + 1][col]);
            cellNeighbors.add(gameField[row + 1][col + 1]);
            cellNeighbors.add(gameField[row][col + 1]);
        } else if (col == gameField.length - 1 && row > 0 && row < gameField.length - 1) {
            cellNeighbors.add(gameField[row - 1][col]);
            cellNeighbors.add(gameField[row - 1][col - 1]);
            cellNeighbors.add(gameField[row][col - 1]);
            cellNeighbors.add(gameField[row + 1][col - 1]);
            cellNeighbors.add(gameField[row + 1][col]);
        } else if (col > 0 && col < gameField.length - 1 && row == gameField.length - 1) {
            cellNeighbors.add(gameField[row][col - 1]);
            cellNeighbors.add(gameField[row - 1][col - 1]);
            cellNeighbors.add(gameField[row - 1][col]);
            cellNeighbors.add(gameField[row - 1][col + 1]);
            cellNeighbors.add(gameField[row][col + 1]);
        } else if (col == 0 && row == 0) {
            cellNeighbors.add(gameField[row + 1][col]);
            cellNeighbors.add(gameField[row + 1][col + 1]);
            cellNeighbors.add(gameField[row][col + 1]);
        } else if (col == gameField.length - 1 && row == 0) {
            cellNeighbors.add(gameField[row][col - 1]);
            cellNeighbors.add(gameField[row + 1][col - 1]);
            cellNeighbors.add(gameField[row + 1][col]);
        } else if (col == gameField.length - 1 && row == gameField.length - 1) {
            cellNeighbors.add(gameField[row][col - 1]);
            cellNeighbors.add(gameField[row - 1][col - 1]);
            cellNeighbors.add(gameField[row - 1][col]);
        } else if (col == 0 && row == gameField.length - 1) {
            cellNeighbors.add(gameField[row - 1][col]);
            cellNeighbors.add(gameField[row - 1][col + 1]);
            cellNeighbors.add(gameField[row][col + 1]);
        }
        return cellNeighbors;
    }

    private void countMineNeighbors() {
        for (int col = 0; col < gameField.length; col++) {
            for (int row = 0; row < gameField.length; row++) {
                if (!gameField[row][col].isMine) {
                    List<GameObject> tobeCount = getNeighbors(gameField[row][col]);
                    for (GameObject gameObject : tobeCount) {
                        if (gameObject.isMine) {
                            gameField[row][col].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void openTile(int col, int row) {
        if (gameField[row][col].isOpen || gameField[row][col].isFlag || isGameStopped) {
            return;
        }
        gameField[row][col].isOpen = true;
        countClosedTiles--;
        setCellColor(col, row, Color.LIGHTSKYBLUE);
        setCellTextColor(col, row, Color.BLACK);

        if (gameField[row][col].isMine) {
            setCellValueEx(col, row, Color.RED, MINE);
            gameOver();

        } else {
            setCellNumber(col, row, gameField[row][col].countMineNeighbors);
        }
        if (!gameField[row][col].isMine) {
            score += 5;
            setScore(score);
            if (countClosedTiles == countMinesOnField) {
                win();
            }
            if (gameField[row][col].countMineNeighbors == 0) {
                List<GameObject> theCellNeighbors = getNeighbors(gameField[row][col]);
                for (GameObject theCellNeighbor : theCellNeighbors) {
                    if (!theCellNeighbor.isOpen) {
                        openTile(theCellNeighbor.x, theCellNeighbor.y);
                    }
                }
                setCellValue(col, row, "");
            } else {
                setCellNumber(col, row, gameField[row][col].countMineNeighbors);
            }
        }
    }

    @Override
    public void onMouseLeftClick(int col, int row) {

        if (isGameStopped) {
            restart();
        } else {
            openTile(col, row);
        }
    }

    @Override
    public void onMouseRightClick(int col, int row) {
        markTile(col, row);
    }

    private void markTile(int col, int row) {
        if (!isGameStopped) {
            if (!gameField[row][col].isOpen && countFlags != 0 && !gameField[row][col].isFlag) {
                gameField[row][col].isFlag = true;
                countFlags--;
                setCellValue(col, row, FLAG);
                setCellColor(col, row, Color.MEDIUMORCHID);
            } else if (gameField[row][col].isFlag) {
                gameField[row][col].isFlag = false;
                countFlags++;
                setCellValue(col, row, "");
                setCellColor(col, row, Color.LIGHTSALMON);
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BROWN, "Взры-ы-ы-в", Color.WHITE, 75);
        try {
            Thread.sleep(1000);
            showMines();
        } catch (InterruptedException e) {
        }
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.DARKGOLDENROD, "You're the winner", Color.WHITE, 40);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();

    }

    private void showMines(){
        if(isGameStopped){
            for (int col = 0; col < gameField.length; col++) {
                for (int row = 0; row < gameField.length; row++) {
                    if(gameField[row][col].isMine){
                        gameField[row][col].isOpen=true;
                        setCellValueEx(col, row, Color.RED, MINE);
                    }
                }
            }
        }
    }
}

