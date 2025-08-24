import java.util.Scanner;

public class MultiplicationExam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){
            int score = 0;

            // Ask 10 questions
            for(int i= 1; i<= 10; i++){
                int a = (int) (Math.random() * 10) +1;
                int b = (int) (Math.random() * 10) +1;

                System.out.println("Question " + i + ": " + a + "x" +b + "=");
                int answer = input.nextInt();

                if (answer == a * b){
                    System.out.println("Correct!");
                    score++;
                }
                else {
                    System.out.println("Incorrect. The right answer is " +(a * b));
                }
            }

            if (score == 10) {
                System.out.println("Congratulations! You mastered the multiplication tables!");
                break;
            }
            else {
                System.out.println("You scored "+score + " /10. Lets try again!\n");
            }
        }
        input.close();
    }
}
