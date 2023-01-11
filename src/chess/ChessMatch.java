package chess;

import PieceChess.King;
import PieceChess.Rook;
import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
	private Board board;

	public ChessMatch() {
		this.board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}

	private void initialSetup() {
		board.placePiece(new Rook(this.board, Color.WHITE), new Position(7, 7));
		board.placePiece(new Rook(this.board, Color.WHITE), new Position(7, 0));
		board.placePiece(new King(this.board, Color.WHITE), new Position(7, 4));
	}
}
