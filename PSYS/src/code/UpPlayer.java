package code;

import java.io.IOException;
import java.util.Random;

public class UpPlayer extends Console{
	// フィールド
		private PlayerList pl;

		private String[] messages = {
				"1:走り込み（短距離）\n",
				"2:走り込み（長距離）\n",
				"3:ジム（筋力）\n",
				"4:ジム（肩力）\n",
				"5:ジム（柔軟）\n",
				"6:ジム（ランダム）\n",
		};
		private String data;

		/**
		 * コンストラクタ UpdatePersonStatus
		 * @param String firstMess
		 * @param String promptMess
		 * @param boolean IsEndStatus
		 * @param PersonList pl
		 */
		UpPlayer(String firstMess, String promptMess,
				boolean IsEndStatus, PlayerList pl) {
			super(firstMess, promptMess, IsEndStatus);
			this.pl = pl;
			this.data = "";
		}

		// 最初に出力するメッセージを表示する
		// このクラスでは従業員のデータの更新処理
		// のみを行う
		/** displayFirstMess
		 * @throws IOException
		 */
		public void displayFirstMess() throws IOException {
			int sg, num, ret,a,b,c,d,f,count;

			// IDの入力
			System.out.print("練習させる選手名を入力してください。\n>");
			data = inputMessage();
/*			try {
				id = Integer.parseInt(data); // 従業員ID
			} catch (NumberFormatException e) {
				System.out.println("数値に変換できないデータが入力されています。");
				System.out.println("再入力してください。");
				displayFirstMess();
				return;
			}*/

			Player p = pl.get(data);
			if (p == null) {
				System.out.println("指定の名前の選手は存在しません。");
				System.out.println("再入力してください。");
				displayFirstMess();
				return;
			}
			count=p.getCou();
			if(count==30) {
				System.out.println("これ以上練習することはできません。");
			}

			// 従業員の情報の出力
			System.out.println(p.toString());

			System.out.println("\n練習メニューを選択してください");
			// messagesの各文字列を順に表示する
			for (int idx = 0; idx < messages.length; idx++)
				System.out.print(messages[idx]);

			// 更新する項目の番号の入力
			System.out.print("\n練習コードを入力してください。\n>");
			data = inputMessage();
			ret = Integer.parseInt(data);
			if (ret > 6 || ret == 0) {
				System.out.println("\n1~6を入力してください。");
				displayFirstMess();
				return;
			}

			try {
//				no = Integer.parseInt(data); // 更新する項目の番号

				// 更新する値の入力
//				System.out.print("\n更新後の値を入力してください。\n>");
//				data = inputMessage();

				//セッタの前にそれぞれゲッタで今の値を獲得してから変数でプラスしてセットする
				if (ret == 1 || ret == 2 || ret == 3 || ret==4 || ret==5 || ret==6) { //普通にswitchでよかった
					Random rand =new Random();
					num = rand.nextInt(4); // ランダムででた数を入れる (０～３）
					if (ret == 1) {
						System.out.println("\n走力 ↑"+num);
						sg=p.getSou();
						sg+=num;
						p.setSou(sg);}
					else if (ret == 2) {
						System.out.println("\n持久力 ↑"+num);
						sg=p.getZikyu();
						sg+=num;
						p.setZikyu(sg);}
					else if (ret == 3) {
						System.out.println("\n筋力 ↑"+num);
						sg=p.getKin();
						sg+=num;
						p.setKin(sg);}
					else if (ret == 4) {
						System.out.println("\n肩力 ↑"+num);
						sg=p.getKen();
						sg+=num;
						p.setKen(sg);}
					else if (ret == 5) {
						System.out.println("\n柔軟力 ↑"+num);
						sg=p.getJuu();
						sg+=num;
						p.setJuu(sg);}

				    else if (ret==6) {
				    a =rand.nextInt(3);
				    b =rand.nextInt(3);
				    c =rand.nextInt(3);
				    d =rand.nextInt(3);
				    f =rand.nextInt(3);
				    System.out.println("\n走力 ↑"+a);
				    sg=p.getSou();
					sg+=a;
					p.setSou(sg);
					System.out.println("\n持久力 ↑"+b);
					sg=p.getZikyu();
					sg+=b;
					p.setZikyu(sg);
					System.out.println("\n筋力 ↑"+c);
					sg=p.getKin();
					sg+=c;
					p.setKin(sg);
					System.out.println("\n肩力 ↑"+d);
					sg=p.getKen();
					sg+=d;
					p.setKen(sg);
					System.out.println("\n柔軟力 ↑"+f);
					sg=p.getJuu();
					sg+=f;
					p.setJuu(sg);
				    }
				}sg=p.getCou();
				sg++;
				p.setCou(sg);

			} catch (NumberFormatException e) {
				System.out.println("数値に変換できないデータが入力されています。");
				System.out.println("再入力してください。");
				displayFirstMess();
				return;
			}
		}

		// 次の状態に遷移することを促すためのメッセージの表示
		// このクラスは，初期状態に戻ると決まっているため，何が
		// 入力されても初期状態に遷移するようにしている
		/** getNextStatus
		 * @param String s
		 * @return ConsoleStatus
		 */
		public Console getNextStatus(String s) {
			return super.getNextStatus(" ");
		}
}
