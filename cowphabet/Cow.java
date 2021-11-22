package cowphabet;
import java.util.*;

public class Cow {
	/*
	loop to see if next letter is ahead of current letter
		no: +1
	*/
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String alpha = input.nextLine();
		String letters = input.nextLine();
		int times = 1;
		for (int i=0;i<letters.length()-1;i++){
			if (alpha.indexOf(letters.charAt(i))<alpha.indexOf(letters.charAt(i+1))){
				continue;
			}
			times++;
		}
		System.out.println(times);
		input.close();
	}
}
