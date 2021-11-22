/*
LANG: JAVA
PROG: //INSERT PROGRAM
*/
import java.io.*;
import java.util.*;

public class TEMPLATE {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("")); //REPLACE WITH FILE, MAY HAVE TO SPECIFY FULL FILE PATH
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(""))); //REPLACE WITH FILE
        //scanner for immediate testing
        Scanner input = new Scanner(System.in);
        f.close();
        out.close();
        input.close();
    }
}
//use String Tokenizer when you need to separate segments of words/"tokens"/data written on the same line.
//String Tokenizer requires java.util.* package
/* String Tokenizer:
StringTokenizer st = new StringTokenizer(f.readLine());
st.nextToken(); //this returns the next token on the current line that "st" is on
*/