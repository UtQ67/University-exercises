package uebungen.tatortImWald;

import java.util.Random;
import java.util.Stack;

public class Forest {

	// Laenge und Breite des Waldes
	private int width, height;

	// das Feld (Baum/Busch = false, Weg = true)
	private boolean field[][];

	// Startposition (im Bild: "S")
	private int start_x, start_y;

	// Zielposition (im Bild: "D")
	private int dest_x, dest_y;

	// Position des Suchers (Bild: "P")
	private int pos_x, pos_y;

	// Himmelrichtungen, in die sich der Sucher bewegen kann
	public static final int NORTH = 0, SOUTH = 1, WEST = 2, EAST = 3,
			NODIRECTION = -1;

	// zu jeder Richtung ihre Gegenrichtung
	private static final int[] reverseDirections = { 1, 0, 3, 2 };

	// Tabelle fuer die Ausgabe der Richtungen
	private static final String[] directionNames = { "North", "South", "West",
			"East" };

	// Stack für Weg
	private Stack trace = new Stack();

	// Zufallszahlengenerator
	private static Random rng = new Random(System.currentTimeMillis());

	// konstruiert einen x mal y grossen Wald.
	// Anmerkung: nur ungerade Zahlen zugelassen, da begrenzende Buesche noetig
	// sind
	public Forest(int x, int y) {
		if (x < 5 || y < 5 || (x & 1) != 1 || (y & 1) != 1) {
			System.out
					.println("Fehler im Konstruktor Forest: ungültige Groesse!");
		} else {
			width = x;
			height = y;
			makeNew();
		}
	}

	// erstellt neuen Wald
	private void makeNew() {
		field = new boolean[width][height];
		pos_x = start_x = rng.nextInt(width - 1) | 1;
		pos_y = start_y = rng.nextInt(height - 1) | 1;
		field[start_x][start_y] = true;
		startBuild(start_x, start_y, -1, false);
	}

	// erstellt einen Wald - rekursiv
	private boolean startBuild(int x, int y, int comeFrom, boolean exitPlaced) {
		int direction = rng.nextInt(4);
		int directionsDone = 0;

		while (directionsDone < 4) {
			if (direction != comeFrom) {
				switch (direction) {
				case NORTH:
					if (y > 2 && !field[x][y - 2]) {
						field[x][y - 1] = true;
						field[x][y - 2] = true;
						exitPlaced = startBuild(x, y - 2, SOUTH, exitPlaced);
					}
					break;
				case SOUTH:
					if (y < height - 3 && !field[x][y + 2]) {
						field[x][y + 1] = true;
						field[x][y + 2] = true;
						exitPlaced = startBuild(x, y + 2, NORTH, exitPlaced);
					}
					break;
				case EAST:
					if (x > 2 && !field[x - 2][y]) {
						field[x - 1][y] = true;
						field[x - 2][y] = true;
						exitPlaced = startBuild(x - 2, y, WEST, exitPlaced);
					}
					break;
				case WEST:
					if (x < width - 3 && !field[x + 2][y]) {
						field[x + 1][y] = true;
						field[x + 2][y] = true;
						exitPlaced = startBuild(x + 2, y, EAST, exitPlaced);
					}
					break;
				}
			}

			direction = (direction + 1) % 4;
			directionsDone++;
		}

		if (!exitPlaced) {
			exitPlaced = true;
			dest_x = x;
			dest_y = y;
		}

		return exitPlaced;
	}

	// prueft, ob sich der Sucher in eine bestimmte Richtung bewegen kann
	// true: ja, false: nein
	public boolean possibleMoveTo(int d) {
		switch (d) {
		case NORTH:
			if (pos_y < 2)
				return false;
			else
				return field[pos_x][pos_y - 1];
		case SOUTH:
			if (pos_y > height - 3)
				return false;
			else
				return field[pos_x][pos_y + 1];
		case WEST:
			if (pos_x < 2)
				return false;
			else
				return field[pos_x - 1][pos_y];
		case EAST:
			if (pos_x > width - 3)
				return false;
			else
				return field[pos_x + 1][pos_y];
		}
		return false;
	}

	// bewegt den Sucher in die angegebene Richtung oder macht eine
	// Fehlerausgabe
	public void moveTo(int d) {
		if (!possibleMoveTo(d)) {
			System.out
					.println("Fehler in Methode moveTo: Zug in diese Richtung nicht müglich!");
		}
		switch (d) {
		case NORTH:
			pos_y -= 1;
			break;
		case SOUTH:
			pos_y += 1;
			break;
		case WEST:
			pos_x -= 1;
			break;
		case EAST:
			pos_x += 1;
			break;
		}
	}

	// prueft, ob an der aktuellen Position des Suchers das Ziel ist
	public boolean found() {
		return (pos_x == dest_x && pos_y == dest_y);
	}

	// liefert die Gegenrichtung
	public static int getReverseDirection(int d) {
		return reverseDirections[d];
	}

	public void setTrace(int d) {
		trace.push(d);
	}

	public void showTrace() {
		while (!trace.empty()) {
			System.out.print(directionNames[(int) trace.pop()] + " ");
		}
	}

	// gibt eine graphische Uebersicht ueber die aktuelle Situation im Wald
	public void show() {
		System.out.println();
		System.out
				.println("S = start, D = destination, P = position of searcher");
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x == pos_x && y == pos_y) {
					System.out.print("P");
				} else if (x == start_x && y == start_y) {
					System.out.print("S");
				} else if (x == dest_x && y == dest_y) {
					System.out.print("D");
				} else
					System.out.print(field[x][y] ? " " : "*");
			}
			System.out.println();
		}
	}
}
