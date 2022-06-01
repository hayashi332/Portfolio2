package code;

import java.util.Random;

public class AddPlayer extends Console{
	// フィールド
		private PlayerList pl;

		private String messages = "氏名を入力してください。>";		//元の配列が必要ないので一つのString型でやる。




		private String namedata;
		private int co = 0;

		/**
		 * コンストラクタ AddPersonStatus
		 * @param String firstMess
		 * @param String promptMess
		 * @param boolean IsEndStatus
		 * @param PersonList pl
		 */
		AddPlayer( String firstMess, String promptMess,
		                 boolean IsEndStatus, PlayerList pl ) {
			super( firstMess, promptMess, IsEndStatus );
			this.pl = pl;
		}

		// 最初に出力するメッセージを表示する
		/** displayFirstMess
		 * @throws Exception
		 */
		public void displayFirstMess() throws Exception {
			// messagesの各文字列を順に表示しながら
				System.out.print( messages );
				namedata = inputMessage();
			    try {                                           //ナンバー以外の例外処理で通常の処理を行う。
			        Integer.parseInt(namedata);
			        System.out.println("文字以外が含まれています。");
			        return;
			    } catch (NumberFormatException e) {


				//乱数で能力の初期値を格納
				// 使い方   Random rand = new Random();
			    //int num = rand.nextInt(10) + 100;
				int randata[]=new int[5];			//乱数を格納する配列
				Random rand =new Random();           //５つの乱数を格納
		        for(int i = 0; i < randata.length; i++){
		            randata[i] = rand.nextInt(10)+1;
		        }




//			try {
				Player new_p = new Player(namedata, randata[0], randata[ 1 ], randata[2],randata[ 3 ],
						randata[4],co);

				// 新しいレコードを追加
				pl.add( new_p );
				System.out.println( "名前:" + new_p.getName() + ",\n"); 
				System.out.println( "走力" + new_p.getSou()+ ",\n");
				System.out.println( "肩力" + new_p.getKen()+ ",\n");
				System.out.println( "筋力" + new_p.getKen()+ ",\n");
				System.out.println( "持久力" + new_p.getZikyu()+ ",\n");
				System.out.println( "柔軟力" + new_p.getJuu()+ ",\n");
				System.out.println( "初期能力が決まりました。\n");

//			} catch( NumberFormatException e ) {
//				System.out.println( "数値に変換できないデータが入力されています。" );
//				System.out.println( "再入力してください。" );
//				displayFirstMess();
//				return;
//			}
//			SystemMain.men++;
			    }
		}

		// 次の状態に遷移することを促すためのメッセージの表示
		// このクラスは，初期状態に戻ると決まっているため，何が
		// 入力されても初期状態に遷移するようにしている
		/** getNextStatus
		 * @param String s
		 * @return ConsoleStatus
		 */
		public Console getNextStatus( String s ) {
			return super.getNextStatus( " " );
		}
}
