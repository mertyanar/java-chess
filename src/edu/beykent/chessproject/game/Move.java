package edu.beykent.chessproject.game;

public class Move {
	public enum MoveType{
		Normal,EnPassant,KingSideCastling,QueenSideCastling,Promotion
	}

	MoveType moveType;
	int fromRow;
	int fromColumn;
	int toRow;
	int toColumn;
	boolean isWhite;

	public Move(MoveType moveType, int fromRow, int fromColumn, int toRow, int toColumn, boolean isWhite) {
		setMoveType(moveType);
		setFromRow(fromRow);
		setFromColumn(fromColumn);
		setToRow(toRow);
		setToColumn(toColumn);
		setIsWhite(isWhite);
	}
	
	public MoveType getMoveType() {
		return moveType;
	}
	
	public int getFromRow() {
		return fromRow;
	}
	
	public int getFromColumn() {
		return fromColumn;
	}
	
	public int getToRow() {
		return toRow;
	}
	
	public int getToColumn() {
		return toColumn;
	}
	
	public boolean getIsWhite() {
		return isWhite;
	}
	
	public void setMoveType(MoveType moveType) {
		this.moveType = moveType;
	}
	
	public void setFromRow(int fromRow) {
		this.fromRow = fromRow;
	}
	
	public void setFromColumn(int fromColumn) {
		this.fromColumn = fromColumn;
	}
	
	public void setToRow(int toRow) {
		this.toRow = toRow;
	}
	
	public void setToColumn(int toColumn) {
		this.toColumn = toColumn;
	}
	
	public void setIsWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
}
