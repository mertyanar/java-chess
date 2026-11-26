package edu.beykent.chessproject.game.pieces;

import edu.beykent.chessproject.game.Move;
import edu.beykent.chessproject.game.PieceSprites;

public class Knight extends Piece {

	public Knight(boolean isWhite) {
		super(isWhite, "N");
		if (isWhite) {
			this.setImage(PieceSprites.getWhiteKnightSprite());
		} else {
			this.setImage(PieceSprites.getBlackKnightSprite());
		}
	}

	@Override
	public Move isMoveValid(Piece[][] board, int fromRow, int fromColumn, int toRow, int toColumn) {
		// TODO: Write comments here Too bored to do it rn
		if(board[toRow][toColumn] != null && board[toRow][toColumn].isWhite == isWhite) {
			return null;
		}
		if(Math.abs(fromRow - toRow) == 2 && Math.abs(fromColumn - toColumn) == 1) {
			return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
		}
		if(Math.abs(fromRow - toRow) == 1 && Math.abs(fromColumn - toColumn) == 2) {
			return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
		}
		return null;
	}

}
