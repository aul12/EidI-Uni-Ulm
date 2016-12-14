import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final int n = s.nextInt();
		
		ArrayList<ArrayList<Integer>> inbounds = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < n; i++){
			inbounds.add(null);
		}
		
		for(int i = 0; i < n; i++){
			int nRoads = s.nextInt(); 				//Anzahl outgoing
			for(int c = 0; c < nRoads; c++){
				int tempDest = s.nextInt();			//aktuelles Ziel
				if(inbounds.get(tempDest) == null)  //Noch keine inbounds fuer kreuzung tempdest
					inbounds.add(tempDest, new ArrayList<Integer>());
				inbounds.get(tempDest).add(i); 		//Aktuelle kreuzung, die zu kreuzung tempdest fuehrt eintragen
			}
		}
		s.close();
		
		//output
		for(int i = 0; i < n; i++){
			if(inbounds.get(i) == null)
				System.out.print(0);  				//Kreuzung i hat keine inbounds
			else
			{
				System.out.printf("%d ", inbounds.get(i).size()); //Anzahl inbounds
				for(int inboundFrom: inbounds.get(i)){
					System.out.printf("%d ", inboundFrom); 		  //Alle eingehenden kreuzungen ausgeben
				}
			}
			System.out.println();
		}
	}
}