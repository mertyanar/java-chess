package edu.beykent.chessproject.game.pieces;

import edu.beykent.chessproject.game.Move;
import edu.beykent.chessproject.game.PieceSprites;

//TODO: Fix En Passant
public class Pawn extends Piece {
	
	public Pawn(boolean isWhite) {
		super(isWhite,"P");
		if (isWhite) {
			this.setImage(PieceSprites.getWhitePawnSprite());
		} else {
			this.setImage(PieceSprites.getBlackPawnSprite());
		}
	}

	@Override
	public Move isMoveValid(Piece[][] board, int fromRow, int fromColumn, int toRow, int toColumn) {
		if (isWhite) {
			// White Pawn Normal Move
			if (fromRow - toRow == 1 && toColumn - fromColumn == 0) {
				if (board[toRow][toColumn] != null) {
					return null;
				}
				if (toRow == 7) {
					return new Move(Move.MoveType.Promotion,fromRow,fromColumn,toRow,toColumn,isWhite);
				}
				return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
			
			// White Pawn Double Step Move
			if (fromRow == 6 && fromRow - toRow == 2 && toColumn - fromColumn == 0) {
				if (board[toRow][toColumn] != null) {
					return null;
				}
				return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
			
			//White Pawn Takes Normal
			if(fromRow - toRow == 1 && Math.abs(toColumn - fromColumn) == 1 &&
					board[toRow][toColumn] != null && board[toRow][toColumn].isWhite != isWhite) {
				if (toRow == 7) {
					return new Move(Move.MoveType.Promotion,fromRow,fromColumn,toRow,toColumn,isWhite);
				}
				return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
			
			//White Pawn Takes enPassant
			if(fromRow - toRow == 1 && Math.abs(toColumn - fromColumn) == 1 &&
					board[toRow-1][toColumn] instanceof Pawn && board[toRow-1][toColumn].isWhite != isWhite
					&& board[toRow-1][toColumn].justMoved) {
				return new Move(Move.MoveType.EnPassant,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
			
			
			
		} else {
			// Black Pawn Normal Move
			if (fromRow - toRow == -1 && toColumn - fromColumn == 0) {
				if (board[toRow][toColumn] != null) {
					return null;
				}
				if (toRow == 0) {
					return new Move(Move.MoveType.Promotion,fromRow,fromColumn,toRow,toColumn,isWhite);
				}
				return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
						
			// Black Pawn Double Step Move
			if (fromRow == 1 && fromRow - toRow == -2 && toColumn - fromColumn == 0) {
				if (board[toRow][toColumn] != null) {
					return null;
				}
				return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
				
			//Black Pawn Takes Normal
			if(fromRow - toRow == -1 && Math.abs(toColumn - fromColumn) == 1 &&
					board[toRow][toColumn] != null && board[toRow][toColumn].isWhite != isWhite) {
				if (toRow == 0) {
					return new Move(Move.MoveType.Promotion,fromRow,fromColumn,toRow,toColumn,isWhite);
				}
				return new Move(Move.MoveType.Normal,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
			
			//Black Pawn Takes enPassant 
			if(fromRow - toRow == -1 && Math.abs(toColumn - fromColumn) == 1 &&
					board[toRow+1][toColumn] instanceof Pawn && board[toRow+1][toColumn].isWhite != isWhite &&
					board[toRow+1][toColumn].justMoved) {
				return new Move(Move.MoveType.EnPassant,fromRow,fromColumn,toRow,toColumn,isWhite);
			}
		}
		return null;
	}
}
