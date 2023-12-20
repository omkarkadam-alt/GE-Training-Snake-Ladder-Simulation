public class App {

    public static final int START_POSITION = 0;
    public static final int OPTION_NO_MOVE = 0;
    public static final int OPTION_LADDER = 1;
    public static final int OPTION_SNAKE = 2;

    public static void main(String[] args) throws Exception {
        System.out.println("Snake and Ladder Game");
        System.out.println("Starting from Position: 0");
        System.out.println();

        int currentPosition = START_POSITION;

        int diceOutcome = (int)Math.floor((Math.random() * 6) + 1);
        System.out.println("Outcome of Dice Roll is: " + diceOutcome);

        int currentOption = (int)Math.floor(Math.random() * 3);

        switch (currentOption) {
            case OPTION_NO_MOVE:
                currentPosition += 0;
                System.out.println("Player stays in the same position");
                break;
            case OPTION_LADDER:
                currentPosition += diceOutcome;
                System.out.println("Player moves ahead by: " + diceOutcome);
                break;
            case OPTION_SNAKE:
                currentPosition -= diceOutcome;
                System.out.println("Player moves behind by: " + diceOutcome);
                break;
        }
    }
}
