import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] buttons={300,60,10};
        Scanner scan = new Scanner(System.in);
        int[] answer=new int[buttons.length];
        int t = scan.nextInt();

        for(int i=0;i<buttons.length;i++){
            if(buttons[i]<=t){
                answer[i]+=t/buttons[i];
                t=t%buttons[i];
            }
        }

        if(t!=0) {
            System.out.println(-1);
            System.exit(0);
        }
        else {
            for(int i=0;i<answer.length;i++){

                System.out.print(answer[i]+ " ");
            }
        }
    }
}
