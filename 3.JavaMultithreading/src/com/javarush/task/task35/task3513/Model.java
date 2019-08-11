package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {// game field manipulations
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        resetGameTiles();
    }

    public void resetGameTiles(){
        for (int row = 0; row <gameTiles.length ; row++) {
            for (int col = 0; col < gameTiles[0].length; col++) {
                gameTiles[row][col] = new Tile();
            }
        }
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
}
