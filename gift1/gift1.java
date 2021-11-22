package gift1;

/*
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static int getIndexOfName(String name, String[] names) {
        //cheese
        for (int i=0;i<names.length;i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        System.out.println("bruh index > name fail");
        return -1;
    }
    public static void splitAndUpdate(ArrayList<Integer> theArray, String[] players, String dude, int totalMoney, int numRecievers, BufferedReader f) throws IOException {
        if (numRecievers != 0){
            //split money and calc leftovers
            int leftovers = totalMoney % numRecievers;
            //subtract from dude
            theArray.set(getIndexOfName(dude, players), theArray.get(getIndexOfName(dude, players)) + ((-1*totalMoney) + leftovers));
            //add to acc
            for (int lotsaPeople=0;lotsaPeople<numRecievers;lotsaPeople++){
                String reciever = f.readLine();
                theArray.set(getIndexOfName(reciever, players), theArray.get(getIndexOfName(reciever, players)) + ((totalMoney - leftovers) / numRecievers));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int numPlayers = Integer.parseInt(f.readLine());
        ArrayList<Integer> playerVals = new ArrayList<Integer>();
        String[] players = new String[numPlayers];
        for (int i=0; i<numPlayers; i++){
            players[i] = f.readLine();
            playerVals.add(0);
        }
        //final calc
        for (int j=0;j<numPlayers;j++){
            String sss = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int tmTm = Integer.parseInt(st.nextToken());
            int nrNr = Integer.parseInt(st.nextToken());
            splitAndUpdate(playerVals, players, sss, tmTm, nrNr, f);
        }
        //print the dubs only dab on them haters
        for (int yay=0;yay<numPlayers;yay++){
            out.write(players[yay] + " " + playerVals.get(yay) + "\n");
        }
        out.close();
        f.close();
    }
}