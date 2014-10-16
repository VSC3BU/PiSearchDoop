
//タイマー
var refreshTimer;

//検索開始（サンプル）
function findBtn() {

	//入力チェック
	if($('#key').val() == ""){
		alert("検索する数値を入力してください。");
		return;
	}
	if(!$('#key').val().match(/^[0-9\-]+$/)){
		alert("半角数値以外は入力できません。");
		return;
	}

	abortRefresh();

	alert("サンプルページの為、実際の検索処理は行われません。");

	setProgress();

	$("#loading").attr('src', 'img/loading.gif');

	document.getElementById("findBtn").disabled = true;

}


//進捗状況を画面に表示（サンプル）
function setProgress() {

	// HTMLへデータを設定
	$("#status").html("検索中");
	$("#startDate").html("2014/10/10 11:11:11");

	refreshTimer = setTimeout(setAnswer, 7000);

}

//検索結果表示する（サンプル）
function setAnswer(){

	//行を全て削除
	$("#tablesorter > tbody").empty();

	for ( var i = 0, len = 100; i < len; i++) {
		printData(i);
	}

	//ソート機能を削除
	$('#tablesorter th').unbind();
	//ソート機能付きテーブルを再生成
	$("#tablesorter").tablesorter({
		widgets: ['zebra']
	});
	//キャッシュ対策
	$('#tablesorter').trigger("update");

	$("#status").html("検索終了");
	$("#finishDate").html("2014/10/10 11:11:18");
	$("#loading").attr('src', 'img/loading_blank.png');
}



//取得したデータを反映させる
function printData(no) {

	var table = document.getElementById("tablebody");

	var row = table.insertRow(-1);

	var cell1 = row.insertCell(-1);
	var cell2 = row.insertCell(-1);
	var cell3 = row.insertCell(-1);

	cell1.appendChild(document.createTextNode(no+1));
	cell2.appendChild(document.createTextNode(Math.round (Math.random () * 100000) + 1 ));
	cell3.appendChild(document.createTextNode("サンプルです。"));

}

//エラーが発生した際呼び出される関数
function onError(errMsg) {
	abortRefresh();
	alert("サーバー側でエラーが発生しました。");
	clearBtn();
}

//リフレッシュを中止する
function abortRefresh() {
	if (refreshTimer) {
		clearTimeout(refreshTimer);
		refreshTimer = null;
	}
}

//クリア
function clearBtn() {

	abortRefresh();

	$('#key').val("");
	$('#status').empty();
	$('#startDate').empty();
	$('#finishDate').empty();
	document.getElementById("findBtn").disabled = false;
	$("#loading").attr('src', 'img/loading_blank.png');
	createTable();
}

//初期表示のテーブルを生成する。
function createTable(){

	//行を全て削除
	$("#tablesorter > tbody").empty();
	$('#tablesorter th').unbind();

	for(var i = 0 , len = 16; i < len; i++){

		var table = document.getElementById("tablebody");
		var row = table.insertRow(-1);
		var cell1 = row.insertCell(-1);
		var cell2 = row.insertCell(-1);
		var cell3 = row.insertCell(-1);

		cell1.appendChild(document.createTextNode("　"));
		cell2.appendChild(document.createTextNode("　"));
		cell3.appendChild(document.createTextNode("　"));
	}

	//ソート機能付きテーブルを生成
	$("#tablesorter").tablesorter({
		widgets: ['zebra']
	});

}

/**
 * 画面ロード時に実行する
 */
$(document).ready(function(){
	createTable();
});