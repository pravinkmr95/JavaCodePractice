package LeetcodeJava;

public class WordSearch {
    public boolean dfs(char[][] board, int i, int j, String word, int wordIndex){
        if (wordIndex == word.length()){
            return true;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0){
            return false;
        }
        if (word.charAt(wordIndex) != board[i][j]){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$';
        if (dfs(board, i-1, j, word, wordIndex+1) ||
                dfs(board, i, j-1, word, wordIndex+1) ||
                dfs(board, i+1, j, word, wordIndex+1) ||
                dfs(board, i, j+1, word, wordIndex+1)){
            return true;
        }
        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
        
        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(wordSearch.exist(board1, "SEE"));

        char[][] board2 = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(wordSearch.exist(board2, "AAB"));
    }
}
