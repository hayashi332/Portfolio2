package code;

public class DispPlayer extends Console{
	// フィールド
		private Player pe;

		/**
		 * コンストラクタ DisplayPersonStatus
		 * @param String firstMess
		 * @param String promptMess
		 * @param boolean IsEndStatus
		 * @param WorkList workList
		 */
		DispPlayer( String firstMess, String promptMess,
		                     boolean IsEndStatus) {
			super( firstMess, promptMess, IsEndStatus );
			this.pe = null;
		}

		/** setPersonRecord
		 * @param Person pe
		 */
		public void setPlayerRecord( Player pe ) {
			this.pe = pe;
		}

		/**
		 * displayFirstMess
		 */
		public void displayFirstMess() {
			displayPlayer();
		}

		// 選択された選手のデータを
		// 表示する処理
		/**
		 * displayPerson
		 */
		public void displayPlayer() {
			// 選手のレコードの内容を出力
			System.out.println( pe.toString() );

		}

		// 入力内容が何であろうと，
		// 前の状態に戻る
		/** getNextStatus
		 * @param String s
		 * @return ConsoleStatus
		 */
		public Console getNextStatus( String s ) {
			return super.getNextStatus( " " );
		}
}
