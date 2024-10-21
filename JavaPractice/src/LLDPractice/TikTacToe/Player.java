package LLDPractice.TikTacToe;


public class Player {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    private PlayingPiece playingPiece;
    public Player(String name, PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }

}
