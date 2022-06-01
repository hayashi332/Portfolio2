package code;

public class SystemMain {
	/**
	 * フィールド
	 */
	private PlayerList plist; // 選手リスト
//	private SportsList slist; // 競技リスト

	private String pfilename = "C:\\pleiades\\workspace\\PSYS\\src\\database\\player.csv";	//databaseの場所
//	private String sfilename = "C:\\aptools\\pleiades-2020-03-ultimate-win-64bit-jre\\workspacejava8\\PSYS\\src\\player.csv";


	private Console sts1; //	クラスのオブジェクトの宣言
	private AddPlayer sts2;
	private NameSelect sts3;   //もとは検索＝console　こっちは分岐がない
	private UpPlayer sts4;
	private Battle sts5;
	private DeletePlayer sts6;
	private DispPlayerByName sts7;
	private DispPlayer sts8;
	private Exit sts9;
//	public static int men ;

	public static void main(String[] args) {
			try {
				SystemMain manager = new SystemMain(); //

				manager.load();
				manager.run();
				manager.save();

			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
	}
	/**
	 * コンストラクタ SystemMain
	 */
	SystemMain() {


		this.plist = new PlayerList();     //見やすくするために、フィールドのところと分けている。
//		this.slist = new SportsList();
		statusSetting();
	}
	/**
	 * statusSetting
	 */
	public void statusSetting() { //あくまでセッティングしているだけなのでここで実行はしていない。

		// システム起動時の，機能選択や、画面表示設定の状態
		sts1 = new Console(
				"_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/\n" +
						"  オリンピックシミュレーションゲーム\n" +
						"  メニュー\n"  +
						"  登録(T)\n" +
						"  検索（K）\n" +
						"  練習(P)\n" +
						"  バトル（B）\n" +
						"  削除（S)\n" +
						"  終了(X)\n" +
						"_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/\n",
				"どの機能を実行しますか？\n[T,K,P,B,S,X]>",
				false);


	// 選手を追加する状態
	sts2 = new AddPlayer(
			"",
			"終了すると登録した選手が反映されます。\nエンターキーを押すとメニューに戻ります。>",
			false,
			plist);
												//sts3（検索）は保留
	// 練習する状態
	sts4 = new UpPlayer(
			"",
			"練習が終わりました。\nエンターキーを押すとメニューに戻ります。>",
			false,
			plist
			);

	// バトルする状態
	sts5 = new Battle(
			"",
			"バトルを終了します。\nエンターキーを押すとメニューに戻ります。>",
			false,
			plist,
			plist);

	// 削除する状態
	sts6 = new DeletePlayer(								//削除のエンター枠保留
			"",
			"この選手情報を削除しますか？（Y はい  N いいえ）[Y,N]>",
			false,
			plist);

	// システムを終了する状態
	sts9 = new Exit(
			"",
			"",
			true);

	sts8 = new DispPlayer(
			"",
			"エンターキーを押すと検索結果一覧に戻ります。\n>",
			false
			); //ここのワークリストを消した
	sts7 = new DispPlayerByName(
			"",
			"エンターを押すと検索結果一覧に戻ります。\n>",
			false,
			plist
			);
	sts3 = new NameSelect(
			"氏名を入力してください。\n",
			"[(氏名)]>",
			false,
			sts7);
	sts1.setNextStatus("T", sts2);           //追加する必要有る可能性
	sts1.setNextStatus("K", sts3);
	sts1.setNextStatus("P", sts4);
	sts1.setNextStatus("B", sts5);
	sts1.setNextStatus("S", sts6);
	sts1.setNextStatus("X", sts9);

//	sts3.setNextStatus(" ", sts1);     //検索処理から戻る処理保留
	sts2.setNextStatus(" ", sts1);
	sts4.setNextStatus(" ", sts1);
	sts5.setNextStatus(" ", sts1);
	sts6.setNextStatus(" ", sts1);
	sts7.setNextStatus(" ", sts1);
	sts8.setNextStatus(" ", sts1);
}

// システムの起動
/** run
 * @throws Exception
 */
public void run() throws Exception {
	// メインルーチン
	Console sts = sts1;
	String cmd;

	while (!sts.getIsEndStatus()) {
		// 最初に出力するメッセージ
		sts.displayFirstMess();
		// 次の状態に遷移することを促すためのメッセージ
		sts.displayPromptMess();
		// キー入力を受け付ける
		cmd = sts.inputMessage();
		// キー入力されたコマンドによって，
		// 次の状態に遷移する
		sts = sts.getNextStatus(cmd);    //stsに次の実行処理を格納して繰り返しの最初から次の処理に移る
	}

	// 終了状態になったら，その旨のメッセージを出力して
	// 終了（保存）処理を行う
	sts.displayFirstMess();
}
// マスタファイルの読込み
/** load
 * @throws Exception
 */
public void load() throws Exception {
	// 各CSVファイルからレコードを読み取る
	FileLoader pload = new FileLoader(pfilename);
//	FileLoader sload = new FileLoader(sfilename);

	pload.read(plist);
//	sload.read(slist);
}

// マスタファイルの保存
/** save
 * @throws Exception
 */
public void save() throws Exception {
	FileSaver psave = new FileSaver(pfilename);
//	FileSaver ssave = new FileSaver(sfilename);

	psave.write(plist);
//	ssave.write(slist);
}

}
