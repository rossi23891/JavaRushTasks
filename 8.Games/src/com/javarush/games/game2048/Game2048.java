package com.javarush.games.game2048;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;


public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score=0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        for (int c = 0; c < gameField.length; c++) {
            for (int r = 0; r < gameField[0].length; r++) {
                gameField[r][c]=0;
            }
        }
        createNewNumber();
        createNewNumber();

    }

    private void drawScene() {
        for (int c = 0; c < gameField.length; c++) {
            for (int r = 0; r < gameField[0].length; r++) {
                setCellColoredNumber(c,r,gameField[r][c]);
            }
        }
    }

    private void createNewNumber() {
        if(getMaxTileValue()!=2048){
            while (true) {
                int r = getRandomNumber(SIDE);
                int c = getRandomNumber(SIDE);
                int probability = getRandomNumber(10);
                if (gameField[r][c] == 0) {
                    if (probability == 9) {
                        gameField[r][c] = 4;
                        break;
                    } else if (probability < 9) {
                        gameField[r][c] = 2;
                        break;
                    }
                }
            }
        } else{
            win();
        }
    }

    private Color getColorByValue(int value) {
        Color color;
        switch (value) {
            case 2:
                color = Color.AQUAMARINE;
                break;
            case 4:
                color = Color.LIGHTCORAL;
                break;
            case 8:
                color = Color.LIGHTYELLOW;
                break;
            case 16:
                color = Color.DARKVIOLET;
                break;
            case 32:
                color = Color.DEEPPINK;
                break;
            case 64:
                color = Color.GREEN;
                break;
            case 128:
                color = Color.GOLD;
                break;
            case 256:
                color = Color.OLIVE;
                break;
            case 512:
                color = Color.ORANGE;
                break;
            case 1024:
                color = Color.LIGHTGREY;
                break;
            case 2048:
                color = Color.RED;
                break;
            default:
                color = Color.THISTLE;
                break;
        }
        return color;
    }

    private void setCellColoredNumber(int c, int r, int value){
        Color cellColor = getColorByValue(value);
        String cellValue = String.valueOf(value);
        if(value==0){
            cellValue = "";
        }
        setCellValueEx(c,r,cellColor,cellValue);

    }

    private boolean compressRow(int[]row){
        boolean isPositionChanged=false;

        for (int i = 0; i < row.length-1; i++) {
            if(row[i]==0){
                for (int j = i+1; j < row.length; j++) {
                    if(row[j]!=0){
                        row[i]=row[j];
                        row[j]=0;
                        isPositionChanged=true;
                        break;
                    }
                }
            }
        }
        return isPositionChanged;
    }

    private boolean mergeRow(int[]row){
        boolean isMerged = false;
        for (int i = 0; i < row.length-1; i++) {
            if(row[i]!=0){
                if(row[i]==row[i+1]){
                    row[i]+=row[i+1];
                    row[i+1]=0;
                    isMerged=true;
                    score+=row[i];
                    setScore(score);
                }
            }
        }
        return isMerged;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    public void onKeyPress(Key key) {
        if(isGameStopped){
            if(key==Key.SPACE){
                isGameStopped=false;
                setScore(0);
                createGame();
                drawScene();

            }else{
                return;
            }
        }
        if(canUserMove()){
            if(key == Key.LEFT){
                moveLeft();
                drawScene();
            }else if(key==Key.RIGHT){
                moveRight();
                drawScene();
            }else if(key ==Key.UP){
                moveUp();
                drawScene();
            }else if(key ==Key.DOWN){
                moveDown();
                drawScene();
            }
        }else{
            gameOver();
        }
    }

    private void moveLeft(){
        boolean isChanged=false;

        for (int r = 0; r < SIDE; r++) {
            int[] rowSet = gameField[r];
            if(compressRow(rowSet)){
                isChanged=true;
            }
            if(mergeRow(rowSet)){
                isChanged=true;
            }
            if(compressRow(rowSet)){
                isChanged=true;
            }
        }
        if(isChanged){
            createNewNumber();
        }
    }
    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
        int[][] temp = new int[SIDE][SIDE];
        for (int row = 0; row<SIDE; row++) {
            for (int col = 0; col <SIDE ; col++) {
                temp[row][col]=gameField[SIDE-1-col][row];
            }
        }
        gameField=temp;
    }

    private int getMaxTileValue(){
        int max = 0;
        for (int row = 0; row<gameField.length; row++) {
            for (int col = 0; col <gameField[0].length ; col++) {
                if(gameField[row][col]>max){
                    max=gameField[row][col];
                }
            }
        }
        return max;
    }

    private void win(){
        isGameStopped=true;
        showMessageDialog(Color.DEEPSKYBLUE,"Ура,победа!",Color.WHITE,75);
    }

    private void  gameOver(){
        isGameStopped=true;
        showMessageDialog(Color.DEEPSKYBLUE,"Вы проиграли :(",Color.WHITE,70);
    }

    private boolean canUserMove(){
        boolean canMove = false;
        boolean hasEqual = false;
        int zeroCount=0;
        for (int row = 0; row<gameField.length; row++) {
            for (int col = 0; col <gameField[0].length ; col++) {
                if(gameField[row][col]==0){
                    zeroCount++;
                }
            }
        }
        for (int row = 0; row<gameField.length; row++) {// check rows
            for (int col = 0; col <gameField[0].length-1 ; col++) {
                if(gameField[row][col]==gameField[row][col+1]){
                    hasEqual=true;
                }
            }
        }
        for (int col = 0; col<gameField[0].length; col++) {// check rows
            for (int row = 0; row <gameField.length-1 ; row++) {
                if(gameField[row][col]==gameField[row+1][col]){
                    hasEqual=true;
                }
            }
        }
        if(zeroCount>0){
            canMove=true;
        }
        if(hasEqual){
            canMove=true;
        }
        return canMove;
    }
}
