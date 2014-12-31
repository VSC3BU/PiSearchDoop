package vsc3bu.interfaces;

import java.util.Date;
import java.util.List;


/**
 * キュー
 * 
 */
public interface IJobQueue {
	
	/**
	 * 処理中を含む処理待ち行列（キュー）を返す。<br>
	 * 
	 * 先頭のJobが先頭。
	 * 
	 * @return 処理待ち行列（キュー）
	 */
	List<IJob> getQueue();
	
	/**
	 * 処理済みのJobリストを返す。<br>
	 * 
	 * 先頭のJobが一番古い。
	 * 
	 * @return 処理済みのJobリスト
	 */
	List<IJob> getGarbageJobList();
	
	/**
	 * このキューを作成した日時を返す。<br>
	 * 
	 * @return このキューを作成した日時
	 */
	Date getDate();
	
}
