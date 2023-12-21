public class App {

    public static final int START_POSITION = 0;
    public static final int OPTION_NO_MOVE = 0;
    public static final int OPTION_LADDER = 1;
    public static final int OPTION_SNAKE = 2;
    public static final int WINNING_POSITION = 100;

    public static void main(String[] args) throws Exception {
        System.out.println("Snake and Ladder Game");
        System.out.println("Starting from Position: 0");
        System.out.println();

        int currentPosition = START_POSITION;

        while(currentPosition != WINNING_POSITION)
        {
            int diceOutcome = (int)Math.floor((Math.random() * 6) + 1);
            System.out.println("Outcome of Dice Roll is: " + diceOutcome);

            int currentOption = (int)Math.floor(Math.random() * 3);

            switch (currentOption) {
                case OPTION_NO_MOVE:
                    System.out.println("Player stays in the same position");
                    currentPosition += 0;
                    break;

                case OPTION_LADDER:
                    if(currentPosition + diceOutcome > 100){
                        System.out.println("Player stays in the same place.");
                    }else{
                        System.out.println("Player moves ahead by: " + diceOutcome);
                        currentPosition += diceOutcome;
                    }
                    break;
                    
                case OPTION_SNAKE:
                    if(currentPosition - diceOutcome < START_POSITION){
                        System.out.println("Player moves behind by: " + currentPosition);
                        currentPosition = START_POSITION;
                    }
                    else{
                        System.out.println("Player moves behind by: " + diceOutcome);
                        currentPosition -= diceOutcome;
                    }
                    break;
            }

            System.out.println("Current position: " + currentPosition);
        }
    }
}

