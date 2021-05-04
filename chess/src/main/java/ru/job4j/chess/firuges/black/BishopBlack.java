package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if(!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }

        int x = position.getX();
        int y = position.getY();
        Cell[] steps = new Cell[Math.abs(deltaX(position, dest))];
        x = deltaX(position, dest) > 0 ? x - 1 : x + 1;
        y = deltaY(position, dest) > 0 ? y - 1 : y + 1;

        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(deltaX(source, dest)) == Math.abs(deltaY(source, dest));
    }

    private int deltaX(Cell source, Cell dest) {
        return source.getX() - dest.getX();
    }

    private int deltaY(Cell source, Cell dest) {
        return source.getY() - dest.getY();
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
