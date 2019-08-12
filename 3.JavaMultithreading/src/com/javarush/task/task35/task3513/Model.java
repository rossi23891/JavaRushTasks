package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {// game field manipulations
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score;
    public int maxTile;
    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public void resetGameTiles() {
        for (int row = 0; row < gameTiles.length; row++) {
            for (int col = 0; col < gameTiles[0].length; col++) {
                gameTiles[row][col] = new Tile();
            }
        }
        score = 0;
        maxTile = 0;
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int row = 0; row < gameTiles.length; row++) {
            for (int col = 0; col < gameTiles[0].length; col++) {
                if (gameTiles[row][col].value == 0) {
                    emptyTiles.add(gameTiles[row][col]);
                }
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            Tile toBeAdded = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
            toBeAdded.setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == 0) {
                for (int j = i + 1; j < tiles.length; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i].setValue(tiles[j].value);
                        tiles[j].value = 0;
                        isCompressed = true;
                        break;
                    }
                }
            }
        }
        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value != 0) {
                if (tiles[i].value == tiles[i + 1].value) {
                    tiles[i].setValue(tiles[i].value + tiles[i + 1].value);
                    tiles[i + 1].setValue(0);
                    score += tiles[i].value;
                    if (tiles[i].value > maxTile) {
                        maxTile = tiles[i].value;
                    }
                    isMerged = true;
                }
            }
        }
        compressTiles(tiles);
        return isMerged;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;

        for (int r = 0; r < gameTiles.length; r++) {
            Tile[] rowSet = gameTiles[r];
            if (compressTiles(rowSet)) {
                isChanged = true;
            }
            if (mergeTiles(rowSet)) {
                isChanged = true;
            }
            if (compressTiles(rowSet)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }

    public void up() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }

    public void down() {
        saveState(gameTiles);
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                temp[row][col] = gameTiles[FIELD_WIDTH - 1 - col][row];
            }
        }
        gameTiles = temp;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }
        for (int row = 0; row < FIELD_WIDTH; row++) {// check  possible rows merge
            for (int col = 0; col < FIELD_WIDTH - 1; col++) {
                if (gameTiles[row][col].value == gameTiles[row][col + 1].value) {
                    return true;
                }
            }
        }
        for (int col = 0; col < FIELD_WIDTH; col++) {// check possible columns merge
            for (int row = 0; row < FIELD_WIDTH - 1; row++) {
                if (gameTiles[row][col].value == gameTiles[row + 1][col].value) {
                    return true;
                }
            }
        }
        return false;
    }


    private void saveState(Tile[][] tiles) {
        Tile[][] gameTilesCopy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                gameTilesCopy[row][col] = new Tile(tiles[row][col].value);
            }
        }
        previousStates.push(gameTilesCopy);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() { // откат изменений
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged(){
        if(previousStates.isEmpty()){
            return false;
        }
        Tile[][] tileForCompare = previousStates.peek();
        return calculateTotalValue(tileForCompare)!=calculateTotalValue(gameTiles);
    }

    public int calculateTotalValue(Tile[][] tiles){
        int totalValue=0;
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                totalValue+=tiles[row][col].value;
            }
        }
       return totalValue;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency efficiency;
        if(!hasBoardChanged()){
            rollback();
            return new MoveEfficiency(-1,0,move);
        }
        int emptyTilesNumber = 0;
        for (int row = 0; row < FIELD_WIDTH; row++) {
            for (int col = 0; col < FIELD_WIDTH; col++) {
                if(gameTiles[row][col].value==0){
                    emptyTilesNumber++;
                }
            }
        }
        efficiency = new MoveEfficiency(emptyTilesNumber,score,move);
        rollback();
        return efficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency>priorityQueue = new PriorityQueue<>(4,Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::down));

        MoveEfficiency mostEffectiveMove = priorityQueue.poll();
        mostEffectiveMove.getMove().move();

    }

}
