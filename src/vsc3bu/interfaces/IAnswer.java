package vsc3bu.interfaces;

import java.util.List;

/**
 * 処理結果
 * 
 */
public interface IAnswer {
	
	/**
	 * 発見した桁をソート済みのリストで返す。<br>
	 * 
	 * @return ヒットしたソート済み桁リスト	
	 */
	List<Integer> getFindList();
	
	
	/**
	 * Jobを返す。<br>
	 * 
	 * @return Job
	 */
	IJob getJob();
	
}
