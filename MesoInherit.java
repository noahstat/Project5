import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class MesoInherit extends MesoStation
{
	protected static ArrayList<String> stations;
	protected static TreeSet<String> sortedStations;
	
	public MesoInherit(String stId) 
	{
		//make the object
		super(stId);
		
		//try to read in so we have that data, there will be an array for every MesoInherit object
		try {
			readIn();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MesoInherit(MesoStation mesoStation) 
	{
		super(mesoStation.getStID());
		//try to read in so we have that data, there will be an array for every MesoInherit object
				try {
					MesoInherit.readIn();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

	protected static void readIn() throws IOException {
		//try to read in the file with a scanner
		
		try {
			String str = "Mesonet.txt";
			File file = new File(str);
			Scanner in = new Scanner(file);

			String station;
			
			//while there is a next line...
			while (in.hasNext()) {
				//read in the string
				station = in.next();
				
				//add the station in
				stations.add(station);
			}
			in.close();
			
			//now to make the sorted version of the stations
			sortedStations = new TreeSet<String>(stations);
			
		}//close the scanner at the end of the try block for good luck

		// catch the exception
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		for(int i = 0; i < stations.length; ++i)
//		{
//			System.out.println((i + 1) + ". " + stations[i]);
//		}
	}
	
	//make sure we can add a station to the sorted list
	public void addStation(String station) {
		sortedStations.add(station);
	}
	
}
