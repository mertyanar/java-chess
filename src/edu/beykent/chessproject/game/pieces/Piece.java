package edu.beykent.chessproject.game.pieces;

import java.awt.Image;

import edu.beykent.chessproject.game.Move;

public abstract class Piece {
	String pieceChar;
	Image pieceIcon;
	boolean isWhite;
	boolean hasMoved;
	boolean justMoved;
	
	public abstract Move isMoveValid(Piece[][] board, int fromRow, int fromColumn, int toRow, int toColumn);
	
	//Check for obstacles along the way (Doesnt check the target location to handle taking pieces)
	public boolean isObstaclesOnTheWay(Piece[][] board, int fromRow, int fromColumn, int toRow, int toColumn) {
		int rowd = Integer.signum(toRow-fromRow);
		int columnd = Integer.signum(toColumn-fromColumn);
		
		int r = fromRow + rowd;
		int c = fromColumn + columnd;
		
		while (r != toRow || c != toColumn) {
			if (board[r][c] != null) {
				return true;
			}
			r += rowd;
			c += columnd;
		}
		
		return false;
	}
	
	public void moved() {
		justMoved = true;
		hasMoved = true;
	}
	
	public void anotherPieceMoved() {
		justMoved = false;
	}
	
	public Piece(boolean isWhite, String pieceChar) {
		setIsWhite(isWhite);
		setPieceChar(pieceChar);
	}
	
	public Image getImage() {
		return pieceIcon;
	}
	
	public void setImage(Image image) {
		this.pieceIcon = image;
	}
	
	public boolean getIsWhite() {
		return isWhite;
	}
	
	public void setIsWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	public String getPieceChar() {
		return pieceChar;
	}
	
	public void setPieceChar(String pieceChar) {
		this.pieceChar = pieceChar;
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	@Override
	public String toString() {
		if (pieceChar == null) {
			return " ";
		}
		if (isWhite) {
			return pieceChar.toLowerCase();
		}
		return pieceChar.toUpperCase();
	}
}
