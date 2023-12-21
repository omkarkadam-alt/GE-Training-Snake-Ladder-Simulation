public class App {

    public static final int START_POSITION = 0;
    public static final int OPTION_NO_MOVE = 0;
    public static final int OPTION_LADDER = 1;
    public static final int OPTION_SNAKE = 2;
    public static final int WINNING_POSITION = 100;
    public static final int PLAYER_1 = 0;
    public static final int PLAYER_2 = 1; 

    public static void main(String[] args) throws Exception {
        System.out.println("Snake and Ladder Game");
        System.out.println("Starting from Position: 0");
        System.out.println();

        int currentPositionPlayer1 = START_POSITION;
        int currentPositionPlayer2 = START_POSITION;
        int totalDiceRolls = 0;

        int currentPlayer = PLAYER_1;

        int winnerPlayer = -1;

        while(currentPositionPlayer1 != WINNING_POSITION && currentPositionPlayer2 != WINNING_POSITION)
        {
            int diceOutcome = (int)Math.floor((Math.random() * 6) + 1);
            System.out.println("Outcome of Dice Roll is: " + diceOutcome);

            totalDiceRolls++;

            int currentOption = (int)Math.floor(Math.random() * 3);

            switch (currentOption) {
                case OPTION_NO_MOVE:
                    System.out.println("Player stays in the same position");

                    if(currentPlayer == PLAYER_1)
                        currentPlayer = PLAYER_2;
                    else
                        currentPlayer = PLAYER_1;

                    break;

                case OPTION_LADDER:
                    if(currentPlayer == PLAYER_1){
                        if(currentPositionPlayer1 + diceOutcome > 100){
                            System.out.println("Player 1 stays in the same place.");
                        }else{
                            System.out.println("Player 1 moves ahead by: " + diceOutcome);
                            currentPositionPlayer1 += diceOutcome;
                            if(currentPositionPlayer1 == WINNING_POSITION)
                                winnerPlayer = PLAYER_1; 
                        }
                    }else{
                        if(currentPositionPlayer2 + diceOutcome > 100){
                            System.out.println("Player 2 stays in the same place.");
                        }else{
                            System.out.println("Player 2 moves ahead by: " + diceOutcome);
                            currentPositionPlayer2 += diceOutcome;
                            if(currentPositionPlayer2 == WINNING_POSITION)
                                winnerPlayer = PLAYER_2;
                        }
                    }

                    break;
                    
                case OPTION_SNAKE:
                    if(currentPlayer == PLAYER_1){
                        if(currentPositionPlayer1 - diceOutcome < START_POSITION){
                            System.out.println("Player 1 moves behind by: " + currentPositionPlayer1);
                            currentPositionPlayer1 = START_POSITION;
                        }
                        else{
                            System.out.println("Player 1 moves behind by: " + diceOutcome);
                            currentPositionPlayer1 -= diceOutcome;
                        }
                        currentPlayer = PLAYER_2;
                    }else{
                        if(currentPositionPlayer2 - diceOutcome < START_POSITION){
                            System.out.println("Player 2 moves behind by: " + currentPositionPlayer2);
                            currentPositionPlayer2 = START_POSITION;
                        }
                        else{
                            System.out.println("Player 2 moves behind by: " + diceOutcome);
                            currentPositionPlayer2 -= diceOutcome;
                        }
                        currentPlayer = PLAYER_1;
                    }

                    break;
            }

            System.out.println("Current position of Player 1: " + currentPositionPlayer1);
            System.out.println("Current position of Player 2: " + currentPositionPlayer2);
        }

        System.out.println("Toal Dice rolls played: " + totalDiceRolls);
        if(winnerPlayer == PLAYER_1)
            System.out.println("Winner of the game is: PLAYER 1");
        else
            System.out.println("Winner of the game is: PLAYER 2");
    }
}

