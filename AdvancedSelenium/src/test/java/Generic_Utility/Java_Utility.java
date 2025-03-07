package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	
	/**
	 *  This method is used to generate random number from 1 to 1000
	 * @return random number
	 */
	public int getRandomValue() {
		Random ran = new Random();
		int randNum = ran.nextInt(1000);
		return randNum;
	}
}
