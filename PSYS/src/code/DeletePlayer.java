package code;

public class DeletePlayer extends Console{
	// フィールド
		private PlayerList pl;
//		private int id = -1;
		private String data;

		/**
		 * コンストラクタ DeletePersonStatus
		 * @param String firstMess
		 * @param String promptMess
		 * @param boolean IsEndStatus
		 * @param PersonList pl
		 */
		DeletePlayer( String firstMess, String promptMess,
		                 boolean IsEndStatus, PlayerList pl ) {
			super( firstMess, promptMess, IsEndStatus );
			this.pl = pl;
			this.data = "";
		}

		// 最初に出力するメッセージを表示する
		/** displayFirstMess
		 * @throws Exception
		 */
		public void displayFirstMess() throws Exception {
			// IDの入力
			System.out.print( "選手名を入力してください。\n>" );
			data = inputMessage();
/*			try {
				id = Integer.parseInt( data ); // 従業員ID
			} catch( NumberFormatException e ) {
				System.out.println( "数値に変換できないデータが入力されています。" );
				System.out.println( "再入力してください。" );
				displayFirstMess();
				return;
        	}*/

			Player p = pl.get( data );
			if( p == null ) {
				System.out.println( "指定の名前の選手は存在しません。" );
				System.out.println( "再入力してください。" );
				displayFirstMess();
				return;
			}

			// 選手の情報の表示
			System.out.println( p.toString() + "\n" );
		}

		// Yが入力された場合指定されたレコードを削除，
		// N(またはそれ以外)の場合何もせずに
		// 初期状態に遷移するようにしている
		/** getNextStatus
		 * @param String s
		 * @return ConsoleStatus
		 */
		public Console getNextStatus( String s ) {
			if( s.equals( "Y" ) ) {
				System.out.println( "削除しました。" );
				pl.delete( pl,data);
//				SystemMain.men--;
			}

			return super.getNextStatus( " " );
		}
}
