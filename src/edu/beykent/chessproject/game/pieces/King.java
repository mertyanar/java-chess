package edu.beykent.chessproject.game.pieces;

import edu.beykent.chessproject.game.Move;
import edu.beykent.chessproject.game.PieceSprites;
//TODO: add this kind of commenting to other classes too
//TODO: I WILL %100 FORGET IT THO
//TODO: Oh and add castling
public class King extends Piece {
	public King(boolean isWhite) {
		super(isWhite,"K");
		if (isWhite) {
			this.setImage(PieceSprites.getWhiteKingSprite());
		} else {
			this.setImage(PieceSprites.getBlackKingSprite());
		}
	}

	@Override
	public Move isMoveValid(Piece[][] board, int fromRow, int fromColumn, int toRow, int toColumn) {
		
		// Check if there is already a piece from same team
		if(board[toRow][toColumn] != null && board[toRow][toColumn].isWhite == isWhite) {
			return null;	
		}
		
		/* Check in a Plus pattern
		 *  _ _ _
		 * |_|X|_|
		 * |X|K|X|
		 * |_|X|_|
		*/
		if(Math.abs(toColumn - fromColumn) + Math.abs(toRow - fromRow) == 1) {
			return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);	
		}

		/* Check in a Cross pattern
		 *  _ _ _
		 * |X|_|X|
		 * |_|K| |
		 * |X|_|X|
		*/
		if(Math.abs(toColumn - fromColumn) * Math.abs(toRow - fromRow) == 1) {
			return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);	
		}
		
		//Check for castling Queen Side
		if(!hasMoved && toColumn - fromColumn == 2 && toRow == fromRow && !board[fromRow][7].hasMoved) {
			return new Move(Move.MoveType.QueenSideCastling,fromRow,fromColumn,toRow,toColumn,isWhite);	
		}
		
		//Check for castling King Side
		if(!hasMoved && toColumn - fromColumn == -2 && toRow == fromRow && !board[fromRow][0].hasMoved) {
			return new Move(Move.MoveType.KingSideCastling,fromRow,fromColumn,toRow,toColumn,isWhite);	
		}
		return null;
	}
}
