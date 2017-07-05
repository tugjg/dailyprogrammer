package TalkingClock;
import java.util.Scanner;
public class TalkingClock{

    public static final String[] hour = new String[] {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
    public static final String[] min = new String[] {"oh ", "twenty ", "thirty ", "forty ", "fifty "};
    public static final String[] min_ext = new String[] {" ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine "};
    public static final String[] min_special = new String[] {"ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
    public static String[] getUserTime(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the time in 24 hour format, ex: HR:MN");
        String userInput = keyboard.nextLine();
        String[]inputTime = userInput.split(":");
        return inputTime;
    }
    public static int userInputHr(String[] inputTime){
        int hr = Integer.parseInt(inputTime[0]);
        return hr;
    }
    public static int userInputMn(String[] inputTime){
        int mn = Integer.parseInt(inputTime[1]);
        return mn;
    }
    public static int[]  mnSplit(String[] inputTime){
        String[]mn_split = inputTime[1].split("", 0);
        int[]mn_split_int = new int[mn_split.length];
        mn_split_int[0] = Integer.parseInt(mn_split[0]);
        mn_split_int[1] = Integer.parseInt(mn_split[1]);
        return mn_split_int;
    }
    public static String hourString(String[] inputTime){
        String hourString;
        int hr = userInputHr(inputTime); 
        if(hr<12){
            hourString = hour[hr];
        }
        else{
            hourString = hour[hr%12];
        }
        return hourString;
    }
    public static String minuteString(String[] inputTime){
        String minuteString = "";
        int mn = userInputMn(inputTime);
        int[]mn_split_int = mnSplit(inputTime);
        if(mn_split_int[0] == 0){
            if(mn_split_int[1]==0){
                minuteString = "";
            }
            else{
                minuteString+=min[mn_split_int[0]]+min_ext[mn_split_int[1]];
            }
        }else if(mn_split_int[0] == 1){
             minuteString+=min_special[mn_split_int[1]];
        }else{
             minuteString+=min[mn_split_int[0]-1] +min_ext[mn_split_int[1]];
            }

        return minuteString;
    }

    public static String amPm(String [] inputTime){
        int userInputHr = userInputHr(inputTime);
        String amPm = "";
        if(userInputHr<12){
            amPm = "am";
        }
        else{
            amPm = "pm";
        }
        return amPm;
    }


    public static String stringTime(){
        String[] inputTime = getUserTime();

        return("It's "+hourString(inputTime)+ " " +minuteString(inputTime)+amPm(inputTime));
    }


    public static void main(String[] args){
        System.out.println(stringTime());
    }

}

