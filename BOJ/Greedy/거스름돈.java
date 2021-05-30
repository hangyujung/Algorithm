import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int price = scan.nextInt();
        int rest = 1000-price;

        int[] coins = {500,100,50,10,5,1};


        int answer = 0;
        for(int i=0;i<coins.length;i++){

            if(rest>=coins[i]){
                answer+=rest/coins[i];
                rest=rest%coins[i];
            }
        }
        System.out.println(answer);
    }
}
