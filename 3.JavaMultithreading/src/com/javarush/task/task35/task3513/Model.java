package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {// game field manipulations
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score;
    public int maxTile;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public void resetGameTiles(){
        for (int row = 0; row <gameTiles.length ; row++) {
            for (int col = 0; col < gameTiles[0].length; col++) {
                gameTiles[row][col] = new Tile();
            }
        }
        score=0;
        maxTile=0;
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> emptyTiles = new ArrayList<>();
        for (int row = 0; row <gameTiles.length ; row++) {
            for (int col = 0; col < gameTiles[0].length; col++) {
                if(gameTiles[row][col].value==0){
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

    private boolean compressTiles(Tile[] tiles){
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length-1; i++) {
            if(tiles[i].value==0){
                for (int j = i+1; j < tiles.length; j++) {
                    if(tiles[j].value!=0){
                        tiles[i].setValue(tiles[j].value);
                        tiles[j].value=0;
                        isCompressed=true;
                        break;
                    }
                }
            }
        }
        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isMerged = false;
        for (int i = 0; i < tiles.length-1; i++) {
            if(tiles[i].value!=0){
                if(tiles[i].value==tiles[i+1].value){
                    tiles[i].setValue(tiles[i].value+tiles[i+1].value);
                    tiles[i+1].setValue(0);
                    score+=tiles[i].value;
                    if(tiles[i].value>maxTile){
                       maxTile = tiles[i].value;
                    }
                    isMerged=true;
                }
            }
        }
        compressTiles(tiles);
        return isMerged;
    }

    public void left(){
        boolean isChanged=false;

        for (int r = 0; r < gameTiles.length; r++) {
            Tile[] rowSet = gameTiles[r];
            if(compressTiles(rowSet)){
                isChanged=true;
            }
            if(mergeTiles(rowSet)){
                isChanged=true;
            }
            if(compressTiles(rowSet)){
                isChanged=true;
            }
        }
        if(isChanged){
            addTile();
        }
    }

    public void right(){
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }
    public void up(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }

    public void down(){
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int row = 0; row<FIELD_WIDTH; row++) {
            for (int col = 0; col <FIELD_WIDTH ; col++) {
                temp[row][col]=gameTiles[FIELD_WIDTH-1-col][row];
            }
        }
        gameTiles=temp;
    }

    public boolean canMove(){
        if(!getEmptyTiles().isEmpty()){
            return true;
        }
        for (int row = 0; row<FIELD_WIDTH; row++) {// check  possible rows merge
            for (int col = 0; col <FIELD_WIDTH-1 ; col++) {
                if(gameTiles[row][col].value==gameTiles[row][col+1].value){
                    return true;
                }
            }
        }
        for (int col = 0; col<FIELD_WIDTH; col++) {// check possible columns merge
            for (int row = 0; row <FIELD_WIDTH-1 ; row++) {
                if(gameTiles[row][col].value==gameTiles[row+1][col].value){
                    return true;
                }
            }
        }
        return false;
    }
}
