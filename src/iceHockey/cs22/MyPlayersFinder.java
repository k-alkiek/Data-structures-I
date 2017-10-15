package eg.edu.alexu.csd.datastructure.iceHockey.cs22;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Khaled
 *
 */
public class MyPlayersFinder implements IPlayersFinder {

	private int numberOfPlayers = 0;
	private int rows;
	private int columns;
	private boolean[][] pixelsVisited;
	private String[] photo;
	private int team;

	/**
	 * Recursive method that performs DFS on the grid.
	 * 
	 * @param r
	 *            row of the cell to visit
	 * @param c
	 *            column of the cell to visit
	 * @param data
	 *            data of the current person up till now
	 *
	 */
	private int[] findPlayer(int r, int c, int[] data) {
		pixelsVisited[r][c] = true;

		if (r > 0 && !pixelsVisited[r - 1][c] && 
				sameColor(photo[r - 1].charAt(c))) {
			data[0]++;
			data[1] = Math.min(data[1], r - 1);
			findPlayer(r - 1, c, data);
		}
		if (r < rows - 1 && !pixelsVisited[r + 1][c] && 
				sameColor(photo[r + 1].charAt(c))) {
			data[0]++;
			data[2] = Math.max(data[2], r + 2);
			findPlayer(r + 1, c, data);

		}
		if (c > 0 && !pixelsVisited[r][c - 1] && 
				sameColor(photo[r].charAt(c - 1))) {
			data[0]++;
			data[3] = Math.min(data[3], c - 1);
			findPlayer(r, c - 1, data);

		}
		if (c < columns - 1 && !pixelsVisited[r][c + 1] && 
				sameColor(photo[r].charAt(c + 1))) {
			data[0]++;
			data[4] = Math.max(data[4], c + 2);
			findPlayer(r, c + 1, data);

		}
		return data;
	}

	/**
	 * Returns a boolean value of whether the value of a cell is the same color
	 * of the team it is searching for.
	 * 
	 * @param pixel
	 *            value of the cell
	 * @param team
	 *            value of the color of the team
	 */
	private boolean sameColor(int pixel) {
		if (Character.getNumericValue(pixel) == team) {
			return true;
		}
		return false;
	}

	@Override
	public Point[] findPlayers(String[] pPhoto, int pTeam, int threshold) {
		this.numberOfPlayers = 0;
		this.pixelsVisited = new boolean[100][100];
		this.photo = pPhoto;
		this.team = pTeam;
		rows = photo.length;
		columns = photo[0].length();
		Point[] playerLocations = new Point[500];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (!pixelsVisited[i][j] && 
						sameColor(photo[i].charAt(j))) {
					
					int[] data = new int[] { 1, i, i + 1, j, j + 1 };
					int[] output = findPlayer(i, j, data);
					if (output[0] * 4 >= threshold) {
						Point player = new Point(output[3] + output[4], 
								output[1] + output[2]);
						playerLocations[numberOfPlayers] = player;
						numberOfPlayers++;
					}
				}
			}
		}

		Point[] playerLocationsToReturn = new Point[numberOfPlayers];
		System.arraycopy(playerLocations, 0, 
				playerLocationsToReturn, 0, numberOfPlayers);

		Arrays.sort(playerLocationsToReturn, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				int xComp = Integer.compare(a.x, b.x);
				if (xComp == 0) {
					return Integer.compare(a.y, b.y);
				} else {
					return xComp;
				}
			}
		});

		return playerLocationsToReturn;
	}

}
