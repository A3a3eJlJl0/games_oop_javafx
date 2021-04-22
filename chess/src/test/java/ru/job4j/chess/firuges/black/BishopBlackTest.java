package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {
    @Test
    public void position() {
        Figure bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position(), is(Cell.C1));
    }

    @Test
    public void copy() {
        Figure bishop = new BishopBlack(Cell.C4);
        bishop = bishop.copy(Cell.D5);
        assertThat(bishop.position(), is(Cell.D5));
    }

    @Test
    public void correctWay() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(Cell.G5);
        Cell[] expected = new Cell[] { Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        assertThat(way, is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void incorrectWay() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(Cell.G3);
    }
}