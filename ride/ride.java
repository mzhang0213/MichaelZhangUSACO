package ride;

/*
LANG: JAVA
PROG: ride
*/
import java.io.*;
class ride {
    public static int getIntByCharPos(char c) {
        int theInt = 0;
        switch (c) {
            case 'A': theInt = 1; break;
            case 'B': theInt = 2; break;
            case 'C': theInt = 3; break;
            case 'D': theInt = 4; break;
            case 'E': theInt = 5; break;
            case 'F': theInt = 6; break;
            case 'G': theInt = 7; break;
            case 'H': theInt = 8; break;
            case 'I': theInt = 9; break;
            case 'J': theInt = 10; break;
            case 'K': theInt = 11; break;
            case 'L': theInt = 12; break;
            case 'M': theInt = 13; break;
            case 'N': theInt = 14; break;
            case 'O': theInt = 15; break;
            case 'P': theInt = 16; break;
            case 'Q': theInt = 17; break;
            case 'R': theInt = 18; break;
            case 'S': theInt = 19; break;
            case 'T': theInt = 20; break;
            case 'U': theInt = 21; break;
            case 'V': theInt = 22; break;
            case 'W': theInt = 23; break;
            case 'X': theInt = 24; break;
            case 'Y': theInt = 25; break;
            case 'Z': theInt = 26; break;
            default: break;
        }
        return theInt;
    }
    public static int cowculate(String s) {
        int finalNum = getIntByCharPos(s.charAt(0));
        for (int i=1;i<s.length();i++){
            finalNum *= getIntByCharPos(s.charAt(i));
        }
        return finalNum % 47;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        System.out.println(cowculate("APPLE")+"\n"+cowculate("URSA"));
        if (cowculate(f.readLine()) == cowculate(f.readLine())){
            out.write("GO\n");
        } else {
            out.write("STAY\n");
        }
        f.close();
        out.close();
    }
}
