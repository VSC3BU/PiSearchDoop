package vsc3bu.interfaces;

import java.util.Date;
import java.util.List;


/**
 * Jobの進捗状況
 *
 */
public interface IJobProgress {

	/**
	 * Jobの処理ステータス
	 */
	enum JobProgressStatus{
		
		/** 未知 */
		UNKNOWN,
		/** 待っている */
		WAITING,
		/** 実行している */
		RUNNING,
		/** 終了した（成功） */
		DONE_SUCCESS,
		/** 終了した（失敗） */
		DONE_ERROR,
		
	}
	

	/**
	 * 対象Jobを返す。<br>
	 * 
	 * @return 対象Job
	 */
	IJob getJob();
	
	/**
	 * Jobの処理ステータスを返す。<br>
	 * 
	 * @return Jobの処理ステータス
	 */
	JobProgressStatus getStatus();
	
	/**
	 * Jobの処理開始日時を返す。<br>
	 * 
	 * @return Jobの処理開始日時
	 */
	Date getStartTime();
	
	/**
	 * Jobの終了日時を返す。<br>
	 * 
	 * @return Jobの終了日時
	 */
	Date getFinishTime();
	
	/**
	 * mapの処理進捗（パーセンテージ）を返す。<br>
	 * 
	 * @return mapの処理進捗（パーセンテージ）
	 */
	Float getMapProgressPercentage();
	
	/**
	 * reduceの処理進捗（パーセンテージ）を返す。<br>
	 * 
	 * @return reduceの処理進捗（パーセンテージ）
	 */
	Float getReduceProgressPercentage();
	
	/**
	 * hadoopが言う、進捗状況文字列を返す。<br>
	 * 
	 * @return hadoopが言う、進捗状況文字列
	 */
	String getStatusStr();
	
	/**
	 * hadoopが進捗を表現（レポート）するURLを返す。<br>
	 * 
	 * @return hadoopが進捗を表現（レポート）するURL
	 */
	String getProgressTrackingURL();
	
	
	/**
	 * hadoopが言う、エラー文字列を返す。<br>
	 * 
	 * @return hadoopが言う、エラー文字列
	 */
	List<String> getErrors();
	
	
}


