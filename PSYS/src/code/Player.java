package code;

public class Player extends Record{
	/**
	 * フィールド
	 */
	private String name; // 氏名
	private int sou; //走力
	private int ken; //肩力
	private int kin; //筋力
	private int zikyu; // 持久力
	private int juu; // 柔軟力
	private int cou; // 練習した回数

	Player(String name, int sou, int ken, int kin, int zikyu, int juu,
			int cou) { //IDフラグ取り除き
		this.name = name;
		this.sou = sou;
		this.ken = ken;
		this.kin = kin;
		this.zikyu = zikyu;
		this.juu = juu;
		this.cou = cou;

	}

	/** コンストラクタ Person
	 * @param String record
	 * @throws Exception
	 */
	Player(String record) throws Exception {
		setData(record);
	}

	/** setData
	 * @param String record
	 * @throws Exception
	 */
	public void setData(String record) throws Exception {
		String[] n = record.split(","); // レコードを","で分割
		try {
			if (n.length != 7) //もとは８
				throw new ArrayIndexOutOfBoundsException("不正なレコードを読み込みました。");

//			setID(Integer.parseInt(n[0]));
			name = n[0];
			sou = Integer.parseInt(n[1]);
		    ken = Integer.parseInt(n[2]);
			kin = Integer.parseInt(n[3]);
			zikyu= Integer.parseInt(n[4]);
			juu = Integer.parseInt(n[5]);
			cou = Integer.parseInt(n[6]);

		} catch (NumberFormatException e) {
			System.out.println("数値に変換できない値がレコードに含まれています。");
			throw e;
		}
	}

	/** toString
	 * @return String
	 */
	public String toString() {
		String ts =" 名前:" + name
				+ "\n走力:" + sou + " 肩力:" + ken + " 筋力:" + kin
				+ "\n持久力:" + zikyu + "柔軟力:" + juu
				+ "\n練習回数:" + cou;
		return ts;
	}

	// 抽象メソッドwriteForCSVの実装
	/** writeForCSV
	 * @return String
	 */
	public String writeForCSV() {
		String s = ""+ name + "," + sou + "," + ken + "," + kin +
				"," + zikyu +"," + juu + "," + cou ;

		return s;
	}
	public String getName() {
		return name;
	}
	public int getSou() {
		return sou;
	}

	public int getKen() {
		return ken;
	}

	public int getKin() {
		return kin;
	}

	public int getZikyu() {
		return zikyu;
	}

	public int getJuu() {
		return juu;
	}

	public int getCou() {
		return cou;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSou(int sou) {
		this.sou = sou;
	}

	public void setKen(int ken) {
		this.ken = ken;
	}

	public void setKin(int kin) {
		this.kin = kin;
	}

	public void setZikyu(int zikyu) {
		this.zikyu = zikyu;
	}

	public void setJuu(int juu) {
		this.juu = juu;
	}

	public void setCou(int cou) {
		this.cou = cou;
	}
}
