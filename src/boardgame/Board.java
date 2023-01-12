package boardgame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	public Board(Integer rows, Integer columns) throws BoardException {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Crie um tabuleiro com no minimo 1 por 1");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)){
			throw new BoardException("Erro na posicao do tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if(!positionExists(position)){
			throw new BoardException("Erro na posicao do tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça aqui" + position);
		}
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)){
			throw new BoardException("Erro na posicao do tabuleiro");
		}
		return piece(position) != null;
		
	}

}
