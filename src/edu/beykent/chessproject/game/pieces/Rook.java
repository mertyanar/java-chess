package edu.beykent.chessproject.game.pieces;

import edu.beykent.chessproject.game.Move;
import edu.beykent.chessproject.game.PieceSprites;

public class Rook extends Piece {

	public Rook(boolean isWhite) {
		super(isWhite, "R");
		if (isWhite) {
			this.setImage(PieceSprites.getWhiteRookSprite());
		} else {
			this.setImage(PieceSprites.getBlackRookSprite());
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
		if(fromRow - toRow != 0 && fromColumn - toColumn != 0) {
			return null;
		}
		if(isObstaclesOnTheWay(board,fromRow,fromColumn,toRow,toColumn)) {
			return null;
		}
		return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
	}

}
