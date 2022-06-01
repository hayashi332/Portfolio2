package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Battle extends Console{
	// フィールド
			private PlayerList p1;      //一人目
			private PlayerList p2;		//二人目

			private String[] messages = {
					"1:２００ｍ走\n",
					"2:１００００ｍ走\n",
					"3:水泳\n",
					"4:バドミントン\n",
					"5:空手\n",
					"6:フェンシング\n",
			};
			private String data;

			/**
			 * コンストラクタ UpdatePersonStatus
			 * @param String firstMess
			 * @param String promptMess
			 * @param boolean IsEndStatus
			 * @param PersonList pl
			 */
			Battle(String firstMess, String promptMess,
					boolean IsEndStatus, PlayerList p1,PlayerList p2) {
				super(firstMess, promptMess, IsEndStatus);
				this.p1 = p1;
				this.p2 = p2;
				this.data = "";
			}

			// 最初に出力するメッセージを表示する
			// このクラスでは従業員のデータの更新処理
			// のみを行う
			/** displayFirstMess
			 * @throws IOException
			 */
			public void displayFirstMess() throws IOException {
				Path path = Paths.get("C:\\pleiades\\workspace\\PSYS\\src\\database\\player.csv"); //databaseの場所
				long lineCount = Files.lines(path).count();
				if(lineCount<2) {
					System.out.println("登録選手が最低二人は必要です。");
					return;
				}

				int no, ret;
/*				if(SystemMain.men<=1) {
					System.out.println("\n登録選手が少なすぎます。");
					return;
				}*/

				// 一人目の名前の入力
				System.out.print("一人目の選手名を入力してください。\n>");
				data = inputMessage();
	/*			try {
					id = Integer.parseInt(data); // 従業員ID
				} catch (NumberFormatException e) {
					System.out.println("数値に変換できないデータが入力されています。");
					System.out.println("再入力してください。");
					displayFirstMess();
					return;
				}*/

				Player p = p1.get(data); //pに一人目のデータ
				if (p == null) {
					System.out.println("指定の名前の選手は存在しません。");
					System.out.println("再入力してください。");
					displayFirstMess();
					return;
				}
				System.out.println(p.toString());

				// 二人目の名前の入力
				System.out.print("二人目の選手名を入力してください。\n>");
				data = inputMessage();

				Player pp = p2.get(data); //ppに一人目のデータ
				if (pp == null) {
					System.out.println("指定の名前の選手は存在しません。");
					System.out.println("再入力してください。");
					displayFirstMess();
					return;
				}

				// 従業員の情報の出力
				System.out.println(pp.toString());

				System.out.println("\n競技を選択してください");
				// messagesの各文字列を順に表示する
				for (int idx = 0; idx < messages.length; idx++)
					System.out.print(messages[idx]);

				// 更新する項目の番号の入力
				System.out.print("\n競技コードを入力してください。\n>");
				data = inputMessage();
				ret = Integer.parseInt(data);
				if (ret > 6 || ret == 0) {
					System.out.println("1~6を入力してください。");
					displayFirstMess();
					return;
				}

				try {
					no = Integer.parseInt(data); // 更新する項目の番号

					// 更新する値の入力
//					System.out.print("\n更新後の値を入力してください。\n>");
//					data = inputMessage();
//						Random rand =new Random();
//						num = rand.nextInt(4); // ランダムででた数を入れる (０～３）
						switch (no) {
						case 1:
							tan(p,pp);
							break;
						case 2:
							tyou(p,pp);
							break;
						case 3:
							sui(p,pp);
							break;
						case 4:
							bado(p,pp);
							break;
						case 5:
							ka(p,pp);
							break;
						case 6:
							fe(p,pp);
							break;
						default:
							break;
						}

				} catch (NumberFormatException e) {
					System.out.println("数値に変換できないデータが入力されています。");
					System.out.println("再入力してください。");
					displayFirstMess();
					return;
				}
			}
			public void tan(Player p , Player pp) {
				int sou,zikyu,juu,num1,num2,an1,an2;
				String na1,na2;
				na1=p.getName();
				na2=pp.getName();

				Random rand =new Random();
				num1 = rand.nextInt(10)+1; //１～１０の乱数
				num2 = rand.nextInt(10)+1;

				sou=p.getSou();
				zikyu=p.getZikyu();
				juu=p.getJuu();
				an1=sou/2+zikyu/10+juu/10+num1;
				System.out.println(na1+"のボーナスは"+num1+"でスコア"+an1+"!!");

				sou=pp.getSou();
				zikyu=pp.getZikyu();
				juu=pp.getJuu();
				an2=sou/2+zikyu/10+juu/10+num2;
				System.out.println(na2+"のボーナスは"+num2+"でスコア"+an2+"!!");
				if(an1==an2) {
					System.out.println("引き分け");
				}
				else if(an1>an2) {
					System.out.println(na1+"の勝利！");
				}
				else {
					System.out.println(na2+"の勝利！");
				}

			}
			public void tyou(Player p , Player pp) {
				int sou,zikyu,juu,kin,num1,num2,an1,an2;
				String na1,na2;
				na1=p.getName();
				na2=pp.getName();

				Random rand =new Random();
				num1 = rand.nextInt(10)+1; //１～１０の乱数
				num2 = rand.nextInt(10)+1;

				sou=p.getSou();
				zikyu=p.getZikyu();
				kin=p.getKin();
				juu=p.getJuu();
				an1=sou/5+zikyu/2+kin/10+juu/5+num1;
				System.out.println(na1+"のボーナスは"+num1+"でスコア"+an1+"!!");

				sou=pp.getSou();
				zikyu=pp.getZikyu();
				kin=pp.getKin();
				juu=pp.getJuu();
				an2=sou/5+zikyu/2+kin/10+juu/5+num2;
				System.out.println(na2+"のボーナスは"+num2+"でスコア"+an2+"!!");
				if(an1==an2) {
					System.out.println("引き分け");
				}
				else if(an1>an2) {
					System.out.println(na1+"の勝利！");
				}
				else {
					System.out.println(na2+"の勝利！");
				}

			}
			public void sui (Player p , Player pp) {
				int ken,zikyu,juu,kin,num1,num2,an1,an2;
				String na1,na2;
				na1=p.getName();
				na2=pp.getName();

				Random rand =new Random();
				num1 = rand.nextInt(10)+1; //１～１０の乱数
				num2 = rand.nextInt(10)+1;

				ken=p.getKen();
				zikyu=p.getZikyu();
				juu=p.getJuu();
				kin=p.getKin();
				an1=ken/5+zikyu/2+kin/10+juu/5+num1;
				System.out.println(na1+"のボーナスは"+num1+"でスコア"+an1+"!!");

				ken=pp.getKen();
				zikyu=pp.getZikyu();
				juu=pp.getJuu();
				kin=pp.getKin();
				an2=ken/5+zikyu/2+kin/10+juu/5+num2;
				System.out.println(na2+"のボーナスは"+num2+"でスコア"+an2+"!!");
				if(an1==an2) {
					System.out.println("引き分け");
				}
				else if(an1>an2) {
					System.out.println(na1+"の勝利！");
				}
				else {
					System.out.println(na2+"の勝利！");
				}
			}
			public void bado (Player p , Player pp) {
				int sou,ken,zikyu,juu,num1,num2,an1,an2;
				String na1,na2;
				na1=p.getName();
				na2=pp.getName();

				Random rand =new Random();
				num1 = rand.nextInt(10)+1; //１～１０の乱数
				num2 = rand.nextInt(10)+1;

				sou=p.getSou();
				ken=p.getKen();
				zikyu=p.getZikyu();
				juu=p.getJuu();
				an1=sou/10+ken/2+zikyu/5+juu/2+num1;
				System.out.println(na1+"のボーナスは"+num1+"でスコア"+an1+"!!");

				sou=pp.getSou();
				ken=pp.getKen();
				zikyu=pp.getZikyu();
				juu=pp.getJuu();
				an2=sou/10+ken/2+zikyu/5+juu/2+num2;
				System.out.println(na2+"のボーナスは"+num2+"でスコア"+an2+"!!");
				if(an1==an2) {
					System.out.println("引き分け");
				}
				else if(an1>an2) {
					System.out.println(na1+"の勝利！");
				}
				else {
					System.out.println(na2+"の勝利！");
				}
			}
			public void fe (Player p , Player pp) {
				int sou,ken,zikyu,juu,num1,num2,an1,an2;
				String na1,na2;
				na1=p.getName();
				na2=pp.getName();

				Random rand =new Random();
				num1 = rand.nextInt(10)+1; //１～１０の乱数
				num2 = rand.nextInt(10)+1;

				sou=p.getSou();
				ken=p.getKen();
				zikyu=p.getZikyu();
				juu=p.getJuu();
				an1=sou/10+ken/5+zikyu/10+juu/5+num1;
				System.out.println(na1+"のボーナスは"+num1+"でスコア"+an1+"!!");

				sou=pp.getSou();
				ken=pp.getKen();
				zikyu=pp.getZikyu();
				juu=pp.getJuu();
				an2=sou/10+ken/5+zikyu/10+juu/5+num2;
				System.out.println(na2+"のボーナスは"+num2+"でスコア"+an2+"!!");
				if(an1==an2) {
					System.out.println("引き分け");
				}
				else if(an1>an2) {
					System.out.println(na1+"の勝利！");
				}
				else {
					System.out.println(na2+"の勝利！");
				}
			}
			public void ka (Player p , Player pp) {
				int ken,zikyu,juu,kin,num1,num2,an1,an2;
				String na1,na2;
				na1=p.getName();
				na2=pp.getName();

				Random rand =new Random();
				num1 = rand.nextInt(10)+1; //１～１０の乱数
				num2 = rand.nextInt(10)+1;

				ken=p.getKen();
				zikyu=p.getZikyu();
				juu=p.getJuu();
				kin=p.getKin();
				an1=ken/5+zikyu/5+kin/5+juu/5+num1;
				System.out.println(na1+"のボーナスは"+num1+"でスコア"+an1+"!!");

				ken=pp.getKen();
				zikyu=pp.getZikyu();
				juu=pp.getJuu();
				kin=pp.getKin();
				an2=ken/5+zikyu/5+kin/5+juu/5+num2;
				System.out.println(na2+"のボーナスは"+num2+"でスコア"+an2+"!!");
				if(an1==an2) {
					System.out.println("引き分け");
				}
				else if(an1>an2) {
					System.out.println(na1+"の勝利！");
				}
				else {
					System.out.println(na2+"の勝利！");
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
