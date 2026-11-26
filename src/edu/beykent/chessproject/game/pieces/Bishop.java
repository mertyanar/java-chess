package edu.beykent.chessproject.game.pieces;

import edu.beykent.chessproject.game.Move;
import edu.beykent.chessproject.game.PieceSprites;

public class Bishop extends Piece {

	public Bishop(boolean isWhite) {
		super(isWhite, "B");
		if (isWhite) {
			this.setImage(PieceSprites.getWhiteBishopSprite());
		} else {
			this.setImage(PieceSprites.getBlackBishopSprite());
		}
	}

	@Override
	public Move isMoveValid(Piece[][] board, int fromRow, int fromColumn, int toRow, int toColumn) {
		// Check if its same place
		if(fromRow == toRow && fromColumn == toColumn) {
			return null;
		}
		
		// Check if there is already a piece from same team
		if(board[toRow][toColumn] != null && board[toRow][toColumn].isWhite == isWhite) {
			return null;
		}
		
		//Check if move is possible
		if(Math.abs(fromRow - toRow) != Math.abs (fromColumn - toColumn)) {
			return null;
		}
		
		if(isObstaclesOnTheWay(board,fromRow,fromColumn,toRow,toColumn)) {
			return null;
		}
		return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
	}

}
