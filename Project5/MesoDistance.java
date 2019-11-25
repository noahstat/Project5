import java.util.TreeSet;

public class MesoDistance extends MesoInherit {

	protected final int STATION_SIZE = 4;
	protected int distance;
	protected TreeSet<String> sortedSame;

	public MesoDistance() {
		super("MESO");
		distance = 0;
	}

	MesoDistance(String stID) {
		super(stID);
		distance = 0;
	}

	public int getAllDist() {
		String station = super.getStID();
		int thisDist = 0;

		// go through the list of stations
		for (String compare : sortedStations) {
			// search through the strings to get the hamming distance
			for (int i = 0; i < STATION_SIZE; ++i) {
				// if they are not the same increase the hamming distance
				if (station.charAt(i) != compare.charAt(i))
					++thisDist;
			}

			// if the distance is the same as the one we are looking for add it to the list
			if (thisDist == distance)
				sortedSame.add(compare);

			// reset this
			thisDist = 0;
		}

		// the size the the number of stations with that distance
		return sortedSame.size();

	}

	public int[] compare(String station) {
		int thisDist = 0;
		int[] distances = new int[5];

		for (String compare : sortedStations) {
			// search through the strings to get the hamming distance
			for (int i = 0; i < STATION_SIZE; ++i) {
				// if they are not the same increase the hamming distance
				if (station.charAt(i) != compare.charAt(i))
					++thisDist;
			}

			// if the distance is 0 add it to zero so we can return all of the data we found
			if (thisDist == 0)
				++distances[0];
			else if (thisDist == 1)
				++distances[1];
			else if (thisDist == 2)
				++distances[2];
			else if (thisDist == 3)
				++distances[3];
			else
				++distances[4];

			// reset this
			thisDist = 0;
		}

		return distances;
	}

}
