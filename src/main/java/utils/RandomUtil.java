package utils;

public class RandomUtil {

	public static int randomize(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}
}
