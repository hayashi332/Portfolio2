package code;

public class Exit extends Console{
	/* コンストラクタ ExitStatus
	 * @param String firstMess
	 * @param String promptMess
	 * @param boolean IsEndStatus
	 */
	Exit( String firstMess, String promptMess, boolean IsEndStatus ) {
		super( firstMess, promptMess, IsEndStatus );
	}

	// システムを終了する特別なメッセージ
	/**
	 * displayFirstMess
	 */
	public void displayFirstMess() {
		System.out.println( "システムを終了します。" );
	}

}
