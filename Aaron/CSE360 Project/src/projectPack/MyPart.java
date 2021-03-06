package projectPack;
//Aaron Prieger
import java.util.Scanner;
import java.io.*;

public class MyPart{
	public static void main(String []args) throws IOException{
		// Open the file playerdata.txt, if the file doesn't exist, create a new one
		File playerData = new File("playerdata.txt");
		if (!playerData.exists()){
			playerData.createNewFile();
		}
		
		// Create a Scanner object and prompt user for the amount of players
		Scanner input = new Scanner(System.in);
		System.out.println("How many players will play?");
		int playerNum = input.nextInt();
		
		// Create the array of players based on the input size
		Player[] playerArray = new Player[playerNum];
		
		// Loop through amount of players prompting the user for the player names
		// if a name is found in the text file, load that name and wins and losses to a player
		String playerName;
		for (int i = 0; i < playerNum; i++){
			// Prompt for a name
			System.out.println("Player " + (i+1) + ": Enter Name");
			playerName = input.next();
			
			// new file reader object to read from playerdata.txt
			FileReader readData = new FileReader(playerData);
			BufferedReader buffer = new BufferedReader(readData);
			String line = null;
			boolean nameFound = false;
			
			// loop through the length of the text file to search for each players name
	        while((line = buffer.readLine()) != null){
	        	Scanner delimLine = new Scanner(line).useDelimiter("\\t");
	        	String dataName = delimLine.next();
	        	
	        	// if the name is found in the text file, copy the name, wins and losses to the player object
	        	if (dataName.equals(playerName)){
	        		playerArray[i] = new Player();
	        		playerArray[i].setName(playerName);
	        		playerArray[i].setWins(delimLine.nextInt());
	        		playerArray[i].setLosses(delimLine.nextInt());
	        		playerArray[i].setPoints(0);
	        		nameFound = true;
	    	        System.out.println("Added returning player " + playerArray[i].getName() + ", with " + playerArray[i].getWins() + " wins/" + playerArray[i].getLosses() + " losses.");
	        	}
	        }
	        if (nameFound == false){
	        	playerArray[i] = new Player();
	        	playerArray[i].setName(playerName);
	        	playerArray[i].setWins(0);
        		playerArray[i].setLosses(0);
        		playerArray[i].setPoints(0);
    	        System.out.println("Added new player " + playerArray[i].getName() + ", with " + playerArray[i].getWins() + " wins/" + playerArray[i].getLosses() + " losses.");
	        }
	        
		}
	}
}
