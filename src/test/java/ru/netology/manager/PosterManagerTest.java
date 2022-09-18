package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void testAddAndFindAll() {
        PosterManager poster = new PosterManager();
        poster.addFilm("Film1");
        poster.addFilm("Film2");
        poster.addFilm("Film3");

        String[] expected = {"Film1", "Film2", "Film3"};
        String[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastDefaultLimit() {
        PosterManager poster = new PosterManager();
        poster.addFilm("Film1");
        poster.addFilm("Film2");
        poster.addFilm("Film3");
        poster.addFilm("Film4");
        poster.addFilm("Film5");
        poster.addFilm("Film6");
        poster.addFilm("Film7");
        poster.addFilm("Film8");
        poster.addFilm("Film9");
        poster.addFilm("Film10");

        String[] expected = {"Film10", "Film9", "Film8","Film7", "Film6", "Film5","Film4", "Film3", "Film2","Film1"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastFilmsEqualLimit() {
        PosterManager poster = new PosterManager(3);
        poster.addFilm("Film1");
        poster.addFilm("Film2");
        poster.addFilm("Film3");

        String[] expected = {"Film3", "Film2", "Film1"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastFilmsMoreThanLimit() {
        PosterManager poster = new PosterManager(3);
        poster.addFilm("Film1");
        poster.addFilm("Film2");
        poster.addFilm("Film3");
        poster.addFilm("Film4");
        poster.addFilm("Film5");

        String[] expected = {"Film5", "Film4", "Film3"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShowLastFilmsLessThanLimit() {
        PosterManager poster = new PosterManager(25);
        poster.addFilm("Film1");
        poster.addFilm("Film2");
        poster.addFilm("Film3");

        String[] expected = {"Film3", "Film2","Film1"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
