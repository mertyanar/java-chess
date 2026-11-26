package edu.beykent.chessproject.game;

import java.awt.Image;

import edu.beykent.chessproject.game.pieces.*;

//TODO: Implement Castling is road in threat
//TODO: Write the rest of documentation Too bored to do that rn
//TODO: Implement Checkmate
//TODO: Clean the code
//TODO: Change the boolean functions to return Move counterparts
/***********************************************************************************************************************
*
*	GAME CLASS DOCUMENTATION
*		
*		Arguments for public functions uses (UCI) Universal Chess Interface notation
*  to represent a move (d2d4)
*		And uses (FEN) Forsyth-Edwards Notation style piece naming to represent pieces
*  (P for Black pawn and p for White pawn)
*  
*  functions:
*  
*  -Functions for turn order
*   public boolean getIsWhitesTurn() //returns is it whites turn
*   public void setWhitesTurn(boolean isWhitesTurn) // sets is it white's turn
*   public boolean getIsBlacksTurn() //returns is it whites turn
*   public void setBlacksTurn(boolean isWhitesTurn) // sets is it black's turn
*  
*  -Functions for game control
*   public void createDefaultBoard() // Resets the game. Gets called automatically when class is initialized
*   public void setPiece(String input) //Input syntax for set piece is FEN+POSITION for example: setPiece(Pd2)
*	public String getPiece(String input) //Returns piece in FEN syntax for example: P
*	public Image getPieceImage(String input) // Returns an Image to represent the piece. Can be used to create an ui
*	public void playMove(String input) //Plays the move uses UCI syntax for example playMove(d2d4)
*	public void isMoveValid(String input) //Checks if the move is valid uses UCI syntax for example isMoveValid(d2d4)
*	public boolean isWhiteInCheck()
*	public boolean isBlackInCheck()
*
*  -Functions for UI settings (No piece has image to represent and path for their images must be declared using these functions)
*   public Image getPieceImage(String input) // Returns an Image to represent the piece. Can be used to create an ui
*   public Image getWhitePawnSprite() 
*	public void setWhitePawnSprite(Image whitePawnSprite) 
*	public Image getWhiteBishopSprite() 
*	public void setWhiteBishopSprite(Image whiteBishopSprite) 
*	public Image getWhiteKnightSprite() 
*	public void setWhiteKnightSprite(Image whiteKnightSprite) 
*	public Image getWhiteRookSprite() 
*	public void setWhiteRookSprite(Image whiteRookSprite) 
*	public Image getWhiteQueenSprite() 
*	public void setWhiteQueenSprite(Image whiteQueenSprite) 
*	public Image getWhiteKingSprite() 
*	public void setWhiteKingSprite(Image whiteKingSprite) 
*	public Image getBlackPawnSprite() 
*	public void setBlackPawnSprite(Image blackPawnSprite) 
*	public Image getBlackBishopSprite() 
*	public void setBlackBishopSprite(Image blackBishopSprite) 
*	public Image getBlackKnightSprite() 
*	public void setBlackKnightSprite(Image blackKnightSprite)
*	public Image getBlackRookSprite()
*	public void setBlackRookSprite(Image blackRookSprite)
*	public Image getBlackQueenSprite()
*	public void setBlackQueenSprite(Image blackQueenSprite)
*	public Image getBlackKingSprite()
*	public void setBlackKingSprite(Image blackKingSprite)
*	
************************************************************************************************************************/



public class Game {
	Piece[][] board;
	boolean isWhitesTurn;
	
	int whiteKingRow;
	int whiteKingColumn;
	
	int blackKingRow;
	int blackKingColumn;
	
	public Game() {
		createDefaultBoard();
	}
	
	public Image getWhitePawnSprite() {
		return PieceSprites.getWhitePawnSprite();
	}
	
	public void setWhitePawnSprite(Image whitePawnSprite) {
		PieceSprites.setWhitePawnSprite(whitePawnSprite);
	}
	
	public Image getWhiteBishopSprite() {
		return PieceSprites.getWhiteBishopSprite();
	}
	
	public void setWhiteBishopSprite(Image whiteBishopSprite) {
		PieceSprites.setWhiteBishopSprite(whiteBishopSprite);
	}
	
	public Image getWhiteKnightSprite() {
		return PieceSprites.getWhiteKnightSprite();
	}
	
	public void setWhiteKnightSprite(Image whiteKnightSprite) {
		PieceSprites.setWhiteKnightSprite(whiteKnightSprite);
	}
	
	public Image getWhiteRookSprite() {
		return PieceSprites.getWhiteRookSprite();
	}
	
	public void setWhiteRookSprite(Image whiteRookSprite) {
		PieceSprites.setWhiteRookSprite(whiteRookSprite);
	}
	
	public Image getWhiteQueenSprite() {
		return PieceSprites.getWhiteQueenSprite();
	}
	
	public void setWhiteQueenSprite(Image whiteQueenSprite) {
		PieceSprites.setWhiteQueenSprite(whiteQueenSprite);
	}
	
	public Image getWhiteKingSprite() {
		return PieceSprites.getWhiteKingSprite();
	}
	
	public void setWhiteKingSprite(Image whiteKingSprite) {
		PieceSprites.setWhiteKingSprite(whiteKingSprite);
	}
	
	public Image getBlackPawnSprite() {
		return PieceSprites.getBlackPawnSprite();
	}
	
	public void setBlackPawnSprite(Image blackPawnSprite) {
		PieceSprites.setBlackPawnSprite(blackPawnSprite);
	}
	
	public Image getBlackBishopSprite() {
		return PieceSprites.getBlackBishopSprite();
	}
	
	public void setBlackBishopSprite(Image blackBishopSprite) {
		PieceSprites.setBlackBishopSprite(blackBishopSprite);
	}
	
	public Image getBlackKnightSprite() {
		return PieceSprites.getBlackKnightSprite();
	}
	
	public void setBlackKnightSprite(Image blackKnightSprite) {
		PieceSprites.setBlackKnightSprite(blackKnightSprite);
	}
	
	public Image getBlackRookSprite() {
		return PieceSprites.getBlackRookSprite();
	}
	
	public void setBlackRookSprite(Image blackRookSprite) {
		PieceSprites.setBlackRookSprite(blackRookSprite);
	}
	
	public Image getBlackQueenSprite() {
		return PieceSprites.getBlackQueenSprite();
	}
	
	public void setBlackQueenSprite(Image blackQueenSprite) {
		PieceSprites.setBlackQueenSprite(blackQueenSprite);
	}
	
	public Image getBlackKingSprite() {
		return PieceSprites.getBlackKingSprite();
	}
	
	public void setBlackKingSprite(Image blackKingSprite) {
		PieceSprites.setBlackKingSprite(blackKingSprite);
	}
	
	
	public boolean getIsWhitesTurn() {
		return isWhitesTurn;
	}
	
	public void setWhitesTurn(boolean isWhitesTurn) {
		this.isWhitesTurn = isWhitesTurn;
	}
	
	public boolean getIsBlacksTurn() {
		return !isWhitesTurn;
	}
	
	public void setBlacksTurn(boolean isBlacksTurn) {
		this.isWhitesTurn = !isBlacksTurn;
	}
	
	//For example Pa5
	public void setPiece(String input) {
		input = input.replace(" ","");
		char fenChar = input.charAt(0);
		int inputColumn = (int)(input.charAt(1)) - (int)'a';
		int inputRow = 8 - ((int)(input.charAt(2)) - (int)'0');
		setPiece(fenChar, inputRow, inputColumn);
	}
	
	public String getPiece(String input) {
		input = input.replace(" ","");
		int inputColumn = (int)(input.charAt(1)) - (int)'a';
		int inputRow = 8 - ((int)(input.charAt(2)) - (int)'0');
		return getPiece(inputRow,inputColumn).getPieceChar();
	}
	
	public Image getPieceImage(String input) {
		input = input.replace(" ","");
		int inputColumn = (int)(input.charAt(1)) - (int)'a';
		int inputRow = 8 - ((int)(input.charAt(2)) - (int)'0');
		return getPiece(inputRow,inputColumn).getImage();
	}
	
	//For example e2d4
	public void playMove(String input) {
		input = input.replace(" ","");
		int inputFromColumn = (int)(input.charAt(0)) - (int)'a';
		int inputFromRow = 8 - ((int)(input.charAt(1)) - (int)'0');
		int inputToColumn = (int)(input.charAt(2)) - (int)'a';
		int inputToRow = 8 - ((int)(input.charAt(3)) - (int)'0');
		playMove(inputFromRow, inputFromColumn, inputToRow, inputToColumn);
	}
	
	public void isMoveValid(String input) {
		input = input.replace(" ","");
		int inputFromColumn = (int)(input.charAt(0)) - (int)'a';
		int inputFromRow = 8 - ((int)(input.charAt(1)) - (int)'0');
		int inputToColumn = (int)(input.charAt(2)) - (int)'a';
		int inputToRow = 8 - ((int)(input.charAt(3)) - (int)'0');
		isMoveValid(inputFromRow, inputFromColumn, inputToRow, inputToColumn);
	}
	
	public boolean isWhiteInCheck() {
		return isPieceUnderAttack(true, whiteKingRow, whiteKingColumn);
	}
	
	public boolean isBlackInCheck() {
		return isPieceUnderAttack(false, blackKingRow, blackKingColumn);
	}
	
	public void createDefaultBoard() {
		isWhitesTurn = true;
		this.board = new Piece[8][8];
		
		whiteKingRow = 7;
		whiteKingColumn = 3;
		blackKingRow = 0;
		blackKingColumn = 3;
		
		//White
		board[7][0] = new Rook(true);
		board[7][1] = new Knight(true);
		board[7][2] = new Bishop(true);
		board[7][3] = new King(true);
		board[7][4] = new Queen(true);
		board[7][5] = new Bishop(true);
		board[7][6] = new Knight(true);
		board[7][7] = new Rook(true);
		
		board[6][0] = new Pawn(true);
		board[6][1] = new Pawn(true);
		board[6][2] = new Pawn(true);
		board[6][3] = new Pawn(true);
		board[6][4] = new Pawn(true);
		board[6][5] = new Pawn(true);
		board[6][6] = new Pawn(true);
		board[6][7] = new Pawn(true);
		
		//Black
		board[0][0] = new Rook(false);
		board[0][1] = new Knight(false);
		board[0][2] = new Bishop(false);
		board[0][3] = new King(false);
		board[0][4] = new Queen(false);
		board[0][5] = new Bishop(false);
		board[0][6] = new Knight(false);
		board[0][7] = new Rook(false);
		
		board[1][0] = new Pawn(false);
		board[1][1] = new Pawn(false);
		board[1][2] = new Pawn(false);
		board[1][3] = new Pawn(false);
		board[1][4] = new Pawn(false);
		board[1][5] = new Pawn(false);
		board[1][6] = new Pawn(false);
		board[1][7] = new Pawn(false);
		
	}
	
	void setPiece(char FENchar, int row, int column) {
		switch(FENchar) {
		case 'P':
			board[row][column] = new Pawn(true);
			break;
		case 'p':
			board[row][column] = new Pawn(false);
			break;
		case 'B':
			board[row][column] = new Bishop(true);
			break;
		case 'b':
			board[row][column] = new Bishop(false);
			break;
		case 'N':
			board[row][column] = new Knight(true);
			break;
		case 'n':
			board[row][column] = new Knight(false);
			break;
		case 'R':
			board[row][column] = new Rook(true);
			break;
		case 'r':
			board[row][column] = new Rook(false);
			break;
		case 'Q':
			//For example e2d4
			board[row][column] = new Queen(true);
			break;
		case 'q':
			board[row][column] = new Queen(false);
			break;
		case 'K':
			board[row][column] = new King(true);
			break;
		case 'k':
			board[row][column] = new King(false);
			break;
		default:
			board[row][column] = null;
			break;
		}
	}
	
	Piece getPiece(int row, int column) {
		return board[row][column];
	}
	
	void setPiece(Piece piece, int row, int column) {
		board[row][column] = piece;
	}
	
	Image getPieceImage(int row, int column) {
		if(board[row][column] == null) {
			return null;
		}
		return board[row][column].getImage();
	}
	
	String getPieceText(int row, int column) {
		if(board[row][column] == null) {
			return "";
		}
		return board[row][column].toString();
	}
	
	boolean isPointNotInBoard(int point) {
		if (point < 8 && point > -1) {
			return false;
		}
		return true;
	}
	
	boolean isSimulatedMoveValid(int fromRow, int fromColumn, int toRow, int toColumn) {
		if (fromRow == toRow && fromColumn == toColumn) {
			return false;
		}
		
		Piece pieceSelected = board[fromRow][fromColumn];
		Piece pieceCaptured = board[toRow][toColumn];
		
		if (pieceSelected == null) {
			return false;
		}
		
		if (pieceSelected.isMoveValid(board,fromRow,fromColumn,toRow,toColumn) != null) {
			board[toRow][toColumn] = board[fromRow][fromColumn];
			board[fromRow][fromColumn] = null;
			
			int simWhiteKingRow = whiteKingRow;
			int simWhiteKingColumn = whiteKingColumn;
			int simBlackKingRow = blackKingRow;
			int simBlackKingColumn = blackKingColumn;
			
			
			if (fromRow == whiteKingRow && fromColumn == whiteKingColumn) {
				simWhiteKingRow = toRow;
				simWhiteKingColumn = toColumn;
			}else if (fromRow == blackKingRow && fromColumn == blackKingColumn) {
				simBlackKingRow = toRow;
				simBlackKingColumn = toColumn;
			}
			
			boolean isKingInCheck;
			if (pieceSelected.getIsWhite()) {
				isKingInCheck = isPieceUnderAttack(true,simWhiteKingRow,simWhiteKingColumn);
			} else {
				isKingInCheck = isPieceUnderAttack(false,simBlackKingRow,simBlackKingColumn);
			}
			
			board[fromRow][fromColumn] = pieceSelected;
			board[toRow][toColumn] = pieceCaptured;
			
			return !isKingInCheck;
		}
		return false;
	}

	Move getSimulatedValidMove(int fromRow, int fromColumn, int toRow, int toColumn) {
		if (fromRow == toRow && fromColumn == toColumn) {
			return null;
		}
		
		Piece pieceSelected = board[fromRow][fromColumn];
		Piece pieceCaptured = board[toRow][toColumn];
		
		if (pieceSelected == null) {
			return null;
		}
		
		Move playedMove = pieceSelected.isMoveValid(board,fromRow,fromColumn,toRow,toColumn);
		
		if (playedMove != null) {
			board[toRow][toColumn] = board[fromRow][fromColumn];
			board[fromRow][fromColumn] = null;
			
			int simWhiteKingRow = whiteKingRow;
			int simWhiteKingColumn = whiteKingColumn;
			int simBlackKingRow = blackKingRow;
			int simBlackKingColumn = blackKingColumn;
			
			
			if (fromRow == whiteKingRow && fromColumn == whiteKingColumn) {
				simWhiteKingRow = toRow;
				simWhiteKingColumn = toColumn;
			}else if (fromRow == blackKingRow && fromColumn == blackKingColumn) {
				simBlackKingRow = toRow;
				simBlackKingColumn = toColumn;
			}
			
			boolean isKingInCheck;
			if (pieceSelected.getIsWhite()) {
				isKingInCheck = isPieceUnderAttack(true,simWhiteKingRow,simWhiteKingColumn);
			} else {
				isKingInCheck = isPieceUnderAttack(false,simBlackKingRow,simBlackKingColumn);
			}
			
			board[fromRow][fromColumn] = pieceSelected;
			board[toRow][toColumn] = pieceCaptured;
			
			if (!isKingInCheck) {
				return playedMove;
			}
		}
		return null;
	}
	
	Move getMove(int fromRow, int fromColumn, int toRow, int toColumn) {
		if(isPointNotInBoard(fromRow) || isPointNotInBoard(fromColumn) || isPointNotInBoard(toRow) || isPointNotInBoard(toColumn)) {
			return null;
		}
		Piece piece = board[fromRow][fromColumn];
		if (piece == null) {
			return null;
		}
		if (piece.getIsWhite() != isWhitesTurn) {
			return null;
		}
		return getSimulatedValidMove(fromRow,fromColumn,toRow,toColumn);
	}
	
	boolean isMoveValid(int fromRow, int fromColumn, int toRow, int toColumn) {
		if(isPointNotInBoard(fromRow) || isPointNotInBoard(fromColumn) || isPointNotInBoard(toRow) || isPointNotInBoard(toColumn)) {
			return false;
		}
		Piece piece = board[fromRow][fromColumn];
		if (piece == null) {
			return false;
		}
		if (piece.getIsWhite() != isWhitesTurn) {
			return false;
		}
		return isSimulatedMoveValid(fromRow,fromColumn,toRow,toColumn);
	}
	
	void playMove(int fromRow, int fromColumn, int toRow, int toColumn) {
		Move move = getMove(fromRow,fromColumn,toRow,toColumn);
		if (move == null) {
			return;
		}
		playMove(move);
	}
	
	void playMove(Move move) {
		if (move == null) {
			return;
		}

		board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
		board[move.fromRow][move.fromColumn] = null;
			
		for (Piece[] row: board){
			for (Piece i: row) {
				if (i != null) {
					i.anotherPieceMoved();
				}
			}
		}
			
		board[move.toRow][move.toColumn].moved();
		if (move.fromRow == whiteKingRow && move.fromColumn == whiteKingColumn) {
			whiteKingRow = move.toRow;
			whiteKingColumn = move.toColumn;
		}else if (move.fromRow == blackKingRow && move.fromColumn == blackKingColumn) {
			blackKingRow = move.toRow;
			blackKingColumn = move.toColumn;
		}
		
		switch(move.moveType) {
		case Move.MoveType.Normal:
			break;
		case Move.MoveType.QueenSideCastling:
			break;
		case Move.MoveType.KingSideCastling:
			break;
		case Move.MoveType.Promotion:
			//TODO: Implement asking for which piece to promote to
			setPiece(new Queen(move.isWhite),move.toRow,move.toColumn);
		case Move.MoveType.EnPassant:
			setPiece(null,move.fromColumn,move.toColumn);
		default:
			System.out.println("Unrecognized move type");
			break;
		}
		
		isWhitesTurn = !isWhitesTurn;
	}

	boolean isPieceUnderAttack(boolean isWhite, int row, int column) {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if(board[r][c] == null || board[r][c].getIsWhite() == isWhite) {
					continue;
				}
				if(board[r][c].isMoveValid(board,r, c, row, column) != null)
					return true;
			}
		}
		return false;
	}
	
	//DEBUG CODE
	public void printBoardHeader() {
		if(isWhitesTurn) {
			System.out.println("White's Turn To Play");
		}else {
			System.out.println("Black's Turn To Play");
		}
		System.out.println(" _a__b__c__d__e__f__g__h_");
	}
	
	public void printBoard() {
		printBoardHeader();
		for (int r = 0; r < 8; r++) {
			System.out.print(8 - r);
			System.out.print("|");
			for (int c = 0; c < 8; c++) {
				Piece piece = board[r][c];
				if(piece == null) {
					System.out.print("__");
				} else {
					System.out.print(piece + "_");
				}
				System.out.print("|");
			}
			System.out.print("\n");
		}
	}
	
	public void visualizePieceMovement(String input) {
		input = input.replace(" ","");
		int inputColumn = (int)(input.charAt(0)) - (int)'a';
		int inputRow = 8 - ((int)(input.charAt(1)) - (int)'0');
		visualizePieceMovement(inputRow, inputColumn);
	}
	
	void visualizePieceMovement(int row, int column) {
		if (isPointNotInBoard(row) || isPointNotInBoard(column)) {
			System.out.println("Point is not in the board");
			printBoard();
			return;
		}
		if(board[row][column] == null) {
			System.out.println("No Piece detected at given position");
			printBoard();
			return;
		}
		printBoardHeader();
		for (int boardRow = 0; boardRow < 8; boardRow++) {
			System.out.print(8 - boardRow);
			System.out.print("|");
			for (int boardColumn = 0; boardColumn < 8; boardColumn ++) {
				Piece piece = board[boardRow][boardColumn];
				if(isMoveValid(row,column,boardRow,boardColumn)) {;
					System.out.print((char)((int)'a' + boardColumn));
					System.out.print(8 - boardRow);
				} else if(piece == null) {
					System.out.print("__");
				}else {
					System.out.print(piece + "_");
				}
				System.out.print("|");
			}
			System.out.print("\n");
		}
	}
}
