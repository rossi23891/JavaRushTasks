package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> { // описывает эффективность хода
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
    public int compareTo(MoveEfficiency mEf) {
        if (this.numberOfEmptyTiles != mEf.numberOfEmptyTiles) {
            return Integer.compare(this.numberOfEmptyTiles, mEf.numberOfEmptyTiles);
        } else {
            return Integer.compare(this.score, mEf.score);
        }
    }
}
