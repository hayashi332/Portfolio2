package code;

import java.util.ArrayList;
import java.util.List;

public class PlayerList implements RecordList{
	/**
	 * フィールド
	 */
	private List<Player> list;

	/**
	 * コンストラクタ PersonList
	 */
	PlayerList() {
		this.list = new ArrayList<Player>();
	}

	/** コンストラクタ PersonList
	 * @param List<Person> al
	 */
	PlayerList( List<Player> al ) {
		this.list = al;
	}

	/** size
	 * @return int
	 */
	public int size() {
		return list.size();
	}

	/** add
	 * @param Person p
	 */
	public void add( Player p ) {
		for( int idx = 0; idx < 1; idx++ ) {
//			Player pidx = list.get( idx );
//			if( pidx.getName().equals(p.getName()) )   // 同じIDのレコードがある場合 メソッド作成してから構文エラーが出る場合は変数に格納して
														//から ここの処理自体必要なのかわからない。
//				return;                       // 何もせず終了
//			else if {
//				list.add( idx, p );           // レコードを追加
//				return;
//			}
			list.add(idx,p);
		}
//		list.add( p );    // リスト末尾にレコードを追加
	}

	/** add
	 * @param String data
	 * @throws Exception
	 */
	public void add( String data ) throws Exception {
		Player p = new Player( data );
		add( p );
	}

	/** getRecord
	 * @param int idx
	 * @return Record
	 */
	public Record getRecord( int idx ) {
		if( idx >= list.size() )
			return null;
		else
			return list.get( idx );
	}

	/** delete
	 * @param int ID
	 * @return boolean
	 */
	public void delete( PlayerList p,String name) {
		int a;
		a=find(name);
		p.list.subList(a,a+1).clear();
//		p.list.remove(1);
//		p.list.remove(2);
//		p.list.remove(3);
//		p.list.remove(4);
//		p.list.remove(5);
//		p.list.remove(6);
}

	/**
	 * allDisplay
	 */
	public void allDisplay() {
		for( Player p : list ) {
			System.out.println( p.toString() );
		}
	}

	/** find
	 * @param int ID
	 * @return int
	 */
	public int find( String name ) {
		// 引数の名前と同じ名前をもつレコードの位置を検索
		for( int idx = 0; idx < list.size(); idx++ ) {
			Player pidx = list.get( idx );
			if( pidx.getName().equals(name) )
				return idx;
		}

		return -1;
	}

	/** get
	 * @param int ID
	 * @return Person
	 */
	public Player get( String name ) {
		Player p;

		// 引数のIDと同じIDをもつレコードが存在するならば，
		// そのレコードを返す
		int idx;
		if( (idx = find(name)) != -1 ) {
			p = list.get( idx );
			// 削除フラグ＝falseなら当該レコードを返す
//			if( !p.getEraseFlag() )
				return p;
//			else
//				return null;
		}
		else
			return null;
	}

	/** searchByName
	 * @param String name
	 * @return PersonList
	 */
	public PlayerList searchByName( String name ) {

		ArrayList<Player> l = new ArrayList<Player>();

		for( int idx = 0; idx < list.size(); idx++ ) {
			Player p = list.get( idx );
			// idx番目のレコードのnameに引数nameが含まれるか
			// どうかを確認する
			if( p.getName().indexOf( name ) != -1 )//&&!p.getEraseFlag()
				l.add( p );
		}

		return new PlayerList( l );
	}

}
