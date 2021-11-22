package friday;

/*
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;

public class friday {
    public static String getDayoftheweek(int dd) {
        int dayInWeek = dd % 7;
        switch (dayInWeek) {
            case 0:return"Monday";
            case 1:return"Tuesday";
            case 2:return"Wednesday";
            case 3:return"Thursday";
            case 4:return"Friday";
            case 5:return"Saturday";
            case 6:return"Sunday";
            default:System.out.println("uh-oh stinky");return"";
        }
    }
    //for these, the year will be the actual raw year rather than 1900 + x
    public static int addLeapYears(int year, int month) { //includes current year, adds an amount of days
        boolean isLeapYear = false;
        int days = ((year + 4) - 1900) / 4; //do leap years since 1900 and then subtract out caveats
        if (year % 4 == 0) {
            isLeapYear = true;
        }
        if (year%100==0&&year%400!=0){
            isLeapYear = false;
        }
        //caviat for century year:
        int centuryYear = year/100;
        for (int i=centuryYear;i>=19;i--){
            if (i%4!=0){
                days--;
            }
        }
        if (month<3&&isLeapYear){
            days--;
        }
        return days;
    }
    public static int addPastYears(int year) {
        return (year - 1900)*365;
    }
    public static int addPastMonths(int month) { //exclude leap years in this calculation
        //(j-1>7?(j+1)/2*31:j/2*31)+(j-1>7?(j-2)/2*30:(j-1)/2*30)
        int days = 0;
        //31 28 31 30 31 30 31 31 30 31 30 31
        //0 31 28 31 30 31 30 31 31 30 31 30
        //j  f  m  a  m  j  j  a8  s  o  n  d (excludes last)
        for (int i=2;i<=month;i++){ //auto exclude jan, always 12 months since this app runs by the year from jan 1 to dec 31
            //31-ers
            if (i <= 8) {
                if (i%2==0) days +=31; else {
                    if (i==3) days += 28; else days += 30;
                }
            //30-ers
            } else { //i > 8 || i >= 9
                if (i%2==0) days += 30; else days += 31;
            }
        }
        return days;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in")); //REPLACE WITH FILE
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out"))); //REPLACE WITH FILE
        //scanner for immediate testing
        Scanner input = new Scanner(System.in);
        //int today = 1;
        int[] daysThirteen = new int[7]; //order: mon, tues, wed, thur, fri, sat, sun
        int thisYear = Integer.parseInt(f.readLine());
        //for (int i=1;i<=12;i++) System.out.println(addPastMonths(i));
        for (int i=1900;i<=1900+thisYear-1;i++) {
            for (int j=1;j<=12;j++){
                daysThirteen[(addLeapYears(i, j)+addPastYears(i)+addPastMonths(j)+13-1)%7]++; //we subtract 1 because 13 is the "1st" day of the month but in our case the 0th index is monday so this subtraction makes monday the 0th day
                //System.out.println((addLeapYears(i, j)+addPastYears(i)+addPastMonths(1)+13-1)%7);
                //System.out.println((addLeapYears(i, j)+addPastYears(i)+addPastMonths(j)+13-1)%7  + "\n");
                //jan 13, 1900 is a saturday
            }
        }



        /*
        int leapYears = 0;
        for (int i=1900;i<=1900+thisYear-1;i++){
            boolean leapYear = i % 4 == 0 && (i % 100 != 0 && i % 400 != 0);
            if (leapYear) leapYears++;
            for (int j=1;j<=12;j++){
                */
                /*
                //index = (((i-1900+2)/4)+((i-1900)*365)+(j>3&&leapYear?1:0)+((j+1>7?(j-1)/2*31:j/2*31)+((j+1>7?j/2*31:(j-1)/2*30)-(j>2?leapYear?1:2:0))+13-1)%7;
                //int index = (((((i-1900+2)/4)+((i-1900)*365))+(j>3&& leapYear?1:0))+(j%2==0&&j!=3?((j-1)*30):((j-1)*31)+(j==3?28:0))+13)%7;
                int pastLeap = (i-1900+2)/4;
                int yearBoost = (i-1900)*365;
                int currentLeap = (j>3&& leapYear?1:0);
                int monthDays = (((j-1>7?(j+1)/2*31:j/2*31)+(j-1>7?(j-2)/2*30:(j-1)/2*30))-(j>2?leapYear?1:2:0));
                int index = (pastLeap+yearBoost+currentLeap+monthDays+13-1)%7;
                //oddMonths before july+1 j/2*31
                //evenMonths before july+1 (j-1)/2*30 except feb
                // j+1>8? (j-1)/2*31:j/2*31
                // j+1>8? j/2*30:(j-1)/2*30
                int february = (j==3?28:0);
                System.out.println(index);System.out.println(pastLeap);System.out.println(yearBoost);System.out.println(currentLeap);System.out.println(monthDays);System.out.println(february);System.out.println();System.out.println();
                */
                /*
                1:index
                2:pastLeap
                3:yearBoost
                4:currentLeap
                5:monthDays
                6:february
                */
                //jan:0 feb:31 mars:31+28 apr:31+28+31 may:31+28+31+30 jun:31+28+31+30+31
                //jan:31 feb:31+28 mars:31+28+31 apr:31+28+31+30 may:31+28+31+30+31 jun:31+28+31+30+31
                //System.out.println(getDayoftheweek((((((i-1900+2)/4)+((i-1900)*365))+(j > 2 && leapYear?1:0)+(j%2==0&&j!=2?30:31)+(j==2?28:0))+13)%7));
                /*
                daysThirteen[((i%400==0||i%100!=0?(i-1900+4)/4:0)+((i-1900)*365)+(((j-1>7?(j+1)/2*31:j/2*31)+(j-1>7?(j-2)/2*30:(j-1)/2*30))-(j>2?leapYear?1:2:0))+13-1)%7]++;
                //               past leap years  year boost                                              month days decider                    february     13th dayoftheweek
            }
        }
        */
        //1 3 1 2 2 2 1
        //11 1111 1111 111 1111 1111 111
        //2 4 4 3 4 4 3
        //print
        for (int ii=5;ii<11;ii++) out.write(daysThirteen[ii%7] + " ");
        out.write(daysThirteen[11%7] + "\n");
        f.close();
        out.close();
        input.close();
    }
}