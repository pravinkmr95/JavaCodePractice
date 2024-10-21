package LLDPractice.TikTacToe;

import java.util.*;

public class TikTacToe {
    PlayingPiece[][] gameBoard;
    int boardSize;
    public TikTacToe(int size){
        initializeGame(size);
        this.boardSize = size;
    }

    protected void initializeGame(int size){
        gameBoard = new PlayingPiece[size][size];
    }

    public boolean isCurrentPlayerWinner(PlayingPiece playingPiece){
        // check rows
        for (PlayingPiece[] row: this.gameBoard){
            if (Arrays.stream(row).filter((a) -> a != null && a.symbol.equals(playingPiece.symbol)).count() == this.boardSize){
                return true;
            }
        }
        PlayingPiece[] temp = new PlayingPiece[this.boardSize];
        for (int j=0; j < this.boardSize; j++){
            int k=0;
            for (int i=0; i<this.boardSize; i++){
                //System.out.println(this.gameBoard[i][j]);
                temp[k++] = this.gameBoard[i][j];
            }
            if (Arrays.stream(temp).filter((a) -> a != null && a.symbol.equals(playingPiece.symbol)).count() == this.boardSize){
                return true;
            }
        }
        int k=0;
        for (int i=0; i<this.boardSize; i++){
            temp[k++] = this.gameBoard[i][i];
        }
        if (Arrays.stream(temp).filter((a) -> a != null && a.symbol.equals(playingPiece.symbol)).count() == this.boardSize){
            return true;
        }
        k=0;
        for (int i=0; i<this.boardSize; i++){
            temp[k++] = this.gameBoard[i][this.boardSize-1-i];
        }
        if (Arrays.stream(temp).filter((a) -> a != null && a.symbol.equals(playingPiece.symbol)).count() == this.boardSize){
            return true;
        }
        return false;
    }

    public void printBoard(){
        for (PlayingPiece[] row: this.gameBoard){
            for (int i=0; i<this.boardSize; i++){
                if (row[i] != null){
                    System.out.print(row[i].symbol + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public boolean areAllPositionsFilled(){
        for (int i=0; i<this.boardSize; i++){
            for (int j=0; j<this.boardSize; j++){
                if (this.gameBoard[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void startGame(){
        PlayingPiece pieceX = new PlayingPiece(PieceTypes.X.name());
        Player player1 = new Player("PlayerX", pieceX);

        PlayingPiece pieceO = new PlayingPiece(PieceTypes.O.name());
        Player player2 = new Player("PlayerO", pieceO);

        Deque<Player> queue = new ArrayDeque<>();
        queue.offer(player1);
        queue.offer(player2);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter position space separated " + queue.peek().getName());
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            if (strings.length != 2){
                System.out.println("Invalid input. Please enter the positions in correct format. Ie, 1 2");
                continue;
            }
            int i = Integer.parseInt(strings[0]);
            int j = Integer.parseInt(strings[1]);
            if (i >= this.boardSize || i < 0 || j >= this.boardSize || j < 0){

                System.out.println("Invalid input. Please enter the positions within the range. Ie, 1 2");
                continue;
            }
            if (this.gameBoard[i][j] != null){
                System.out.println("Position already filled. Please enter the right position");
                printBoard();
                continue;
            }
            Player currentPlayer = queue.poll();
            System.out.println("Current player is " + currentPlayer.getName());
            this.gameBoard[i][j] = currentPlayer.getPlayingPiece();
            if (isCurrentPlayerWinner(currentPlayer.getPlayingPiece())){
                printBoard();
                System.out.println("Winner is " + currentPlayer.getName());
                break;
            }

            if (areAllPositionsFilled()){
                printBoard();
                System.out.println("...Game draw...");
                break;
            }
            queue.offer(currentPlayer);
            printBoard();
        }
    }
}
