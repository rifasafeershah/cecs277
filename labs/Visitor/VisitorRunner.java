/**
 * Main program that utilizes the visitor pattern.
 * @author	Michael Zaragoza and Rifa Safeer Shah
 * @date	12/02/2019
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VisitorRunner {

    public static void main(String[] args) {
        //Creates the list of DVDs and games
        ItemElement [] items = {
                new Game(GameRating.MATURE, GameGenre.HORROR, 1965, "Creature from the black Lagoon"),
                new Game(GameRating.TEEN, GameGenre.HORROR, 2019, "Danganronpa Trilogy"),
                new Game(GameRating.EVERYONE, GameGenre.SCIENCE_FICTION, 2012, "Star Wars 1st Class"),
                new DVD ("Heart of Darkness", 1965, MovieGenre.ADVENTURE),
                new DVD("Indiana Jones and the Last Crusade", 1989, MovieGenre.ADVENTURE),
                new DVD("The Goonies" ,1985, MovieGenre.ADVENTURE)
        };
        RentalVisitor visitor = new RentalVisitorImpl();
        for (ItemElement element: items) {
            System.out.println (element);
            element.accept(visitor);
        }
        System.out.println ("Now for the statistics");
        //Calculates average year
        System.out.println ("Average year was " + visitor.averageYear());

        //Counts the movies
        System.out.println("Counts for the movies");
        Map<MovieGenre, Integer> movieGenresCount = new HashMap<>();
        ArrayList<MovieGenre> dvdGenres = visitor.countsDVDs();
        for (MovieGenre m: dvdGenres) {
            if (movieGenresCount.containsKey(m)) {
                movieGenresCount.put(m, movieGenresCount.get(m) + 1);
            }
            else {
                movieGenresCount.put(m, 1);
            }
        }
        for (MovieGenre mgc: movieGenresCount.keySet()) {
            System.out.println("Genre: " + mgc + " came up " + movieGenresCount.get(mgc));
        }
        //Counts the games
        System.out.println("Counts for the games");
        Map<GameGenre, Integer> gameGenreCount = new HashMap<>();
        ArrayList<GameGenre> gameGenres = visitor.countsGames();
        for (GameGenre g: gameGenres) {
            if (gameGenreCount.containsKey(g)) {
                gameGenreCount.put(g, gameGenreCount.get(g) + 1);
            }
            else {
                gameGenreCount.put(g, 1);
            }
        }
        for (GameGenre ggc: gameGenreCount.keySet()) {
            System.out.println("Genre: " + ggc + " came up " + gameGenreCount.get(ggc));
        }
        System.out.println("Completed satisfactorily.");
    }

}
