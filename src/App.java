public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Snake and Ladder Game");
        System.out.println("Starting from Position: 0");

        int START_POSITION = 0;

        int currPosition = START_POSITION;

        int diceOutcome = (int) Math.floor((Math.random() * 6) + 1);
        System.out.println("Outcome of Dice Roll is: " + diceOutcome);
    }
}
