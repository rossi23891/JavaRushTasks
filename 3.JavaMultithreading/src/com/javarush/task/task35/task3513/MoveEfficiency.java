package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable{ // описывает эффективность хода
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(Object o) {
        MoveEfficiency mEf = (MoveEfficiency)o;
        if(this.numberOfEmptyTiles!=mEf.numberOfEmptyTiles){
            return Integer.compare(this.numberOfEmptyTiles,mEf.numberOfEmptyTiles);
        }else {
            if(this.score!=mEf.score){
                return Integer.compare(this.score,mEf.score);
            }
        }
        return 0;
    }
}
