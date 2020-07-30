let map;
let layers = [];
let layerNodes = [];
let layerOrderSeq = 0;
let layerSetting;
let chartSetting;

const host = location.protocol + "//" + location.host;
const mapProj = "EPSG:3857";
const mapCenter = [135.1521925642337, 35.851730140544944];

$(function(){
	// 地図初期化
	initMap();
	// レイヤ初期化
	initLayer();
	// ボタン初期化
	initButton();
	// Drawerメニューを開く
	toggleDrawerMenu();
	// オブジェクト初期化
	layerSetting = new LayerSetting();
	chartSetting = new ChartSetting();
})

/**
 * 地図初期化
 */
function initMap() {
	map = new ol.Map({
		target: 'map',
		view: new ol.View({
			projection: mapProj,
			center: ol.proj.transform(mapCenter, 'EPSG:4326', mapProj),
			zoom: 5
		})
	});
	map.addControl(new ol.control.ScaleLine({units: 'metric'}));
}

/**
 * レイヤ初期化
 */
function initLayer() {
	// 背景地図
	$.ajax({
		url: host + "/json/baselayer.json",
		type: "GET",
		dataType: "json"
	}).done(function(data, textStatus, jqXHR){
		// レイヤ数分ループ
		for(let i = 0; i < data.length; i++) {
			// レイヤ生成
			createLayer(data[i]);
		}
		// レイヤツリー生成
		createTree("baselayer_tree", data);
	}).fail(function(jqXHR, textStatus, errorThrown){
		alert("背景地図レイヤの初期化に失敗しました。");
	});
	// オーバーレイ
	$.ajax({
		url: host + "/layer/getLayerTree",
		type: "GET",
		dataType: "json"
	}).done(function(data, textStatus, jqXHR){
		// レイヤ数分ループ
		for(let i = 0; i < data.length; i++) {
			// レイヤ生成
			createLayer(data[i]);
		}
		// レイヤツリー生成
		createTree("overlay_tree", data);
	}).fail(function(jqXHR, textStatus, errorThrown){
		alert("オーバーレイレイヤの初期化に失敗しました。");
	});
}

/**
 * レイヤ生成
 */
function createLayer(data) {
	if(data.a_attr) {
		var obj = new Layer(data);
		if(obj.layer) {
			// 地図に追加
			map.addLayer(obj.layer);
			// グローバル変数で保持
			layers.push(obj);
		}
	}
	// 子要素に対して再帰
	if(data.children) {
		for(let i = 0; i < data.children.length; i++) {
			createLayer(data.children[i]);
		}
	}
}

/**
 * レイヤツリー生成
 */
function createTree(domId, data) {
	// レイヤツリー生成
	$("#" + domId).jstree({
		"core": {"data": data, "check_callback": true},
		"types": {
			"map": {"icon": "/icon/map_32px.png"},
			"leaf": {"icon": "/icon/layer_32px.png"}
		},
		"checkbox": {"keep_selected_style": false},
		"plugins": ["wholerow", "themes", "checkbox", "changed", "types", "contextmenu", "dnd"]
	}).on("changed.jstree", function(e, data) {
		// レイヤ表示切り替え
		var selected = data.changed.selected;
		var deselected = data.changed.deselected;
		for(let i = 0; i < selected.length; i++) {
			changeLayer(selected[i], true);
		}
		for(let i = 0; i < deselected.length; i++) {
			changeLayer(deselected[i], false);
		}
	}).on('open_node.jstree', function() {
		// 凡例設定
		var logendNodes = $("[id^=legend_]");
		logendNodes.addClass("no_checkbox");
		for(let i = 0; i < logendNodes.length; i++) {
			var imgNode = logendNodes[i].lastChild.lastChild;
			if(imgNode && imgNode.style) {
				var bgImg = imgNode.style["background-image"]
				if(bgImg) {
					imgNode.remove();
					var legendUrl = bgImg.split('"')[1];
					var imgTag = document.createElement("img");
					imgTag.setAttribute("src", legendUrl);
					logendNodes[i].lastChild.appendChild(imgTag);
				}
			}
		}
	});
}

/**
 * ボタン初期化
 */
function initButton() {
	// アイコン
	$("#btn_chart").button({icons: {primary: "ui-icon-calculator"}});
	$("#btn_insert").button({icons: {primary: "ui-icon-plus"}});
	$("#btn_update").button({icons: {primary: "ui-icon-pencil"}});
	$("#btn_delete").button({icons: {primary: "ui-icon-trash"}});
	$("#btn_save").button({icons: {primary: "ui-icon-disk"}});
	// レイヤ追加ボタンクリックイベント
	$("#btn_insert").click(function(){
		treeNodeInsert();
	});
	// レイヤ更新ボタンクリックイベント
	$("#btn_update").click(function(){
		treeNodeUpdate();
	});
	// レイヤ削除ボタンクリックイベント
	$("#btn_delete").click(function(){
		treeNodeDelete();
	});
	// レイヤ保存ボタンクリックイベント
	$("#btn_save").click(function(){
		var message = "現在表示中のレイヤツリーを保存します。よろしいいですか？";
		if(!confirm(message)) {
			return;
		}
		treeNodeSave();
	});
	// チャート作成ボタンクリックイベント
	$('#btn_chart').click(function(){
		chartSetting.showDialog();
	});
	// Drawerメニューヘッダークリックイベント
	$("#drawer_menu h3").click(function(){
		$(this).next().slideToggle("fast");
	});
	// Drawerメニュー開閉ボタンクリックイベント
	$('#drawer_menu_btn').click(function(){
		toggleDrawerMenu();
	});
}

/**
 * レイヤ表示切り替え
 */
function changeLayer(id, isVisible) {
	for(let i = 0; i < layers.length; i++) {
		if(layers[i].id == id) {
			layers[i].layer.setVisible(isVisible);
			break;
		}
	}
}

/**
 * Drawerメニュー開閉
 */
function toggleDrawerMenu() {
	// クラス属性切り替え
	$('#drawer_menu').toggleClass('open');
	$('#drawer_menu_btn').toggleClass('open');
	$('.ol-scale-line').toggleClass('open');

	// ボタンアイコン切り替え
	var drawerMenuBtn = document.getElementById('drawer_menu_btn');
	if(drawerMenuBtn.classList.contains('open')) {
		$('#drawer_menu_btn_img').attr("src", "/icon/close_black.png");
	} else {
		$('#drawer_menu_btn_img').attr("src", "/icon/hamburger_black.png");
	}
}

/**
 * レイヤツリーノード追加
 */
function treeNodeInsert() {
	layerSetting.showDialog();
};

/**
 * レイヤツリーノード更新
 */
function treeNodeUpdate() {
	var ref = $('#overlay_tree').jstree(true);
	var sel = ref.get_selected();
	if(!sel.length) {
		return false;
	}
	sel = sel[0];
	ref.edit(sel);
};

/**
 * レイヤツリーノード削除
 */
function treeNodeDelete() {
	var ref = $('#overlay_tree').jstree(true);
	var sel = ref.get_selected();
	if(!sel.length) {
		return false;
	}
	ref.delete_node(sel);
};

/**
 * レイヤツリーノード保存
 */
function treeNodeSave() {
	// 変数初期化
	layerNodes = [];
	layerOrderSeq = 0;

	// パラメータ取得
	var nodes = $('#overlay_tree').jstree(true).get_json();
	for(let i = 0; i < nodes.length; i++) {
		getNodeParam(nodes[i]);
	}

	// 保存
	$.ajax({
		url: host + "/layer/saveLayerTree",
		type: "POST",
		dataType: "json",
		data: JSON.stringify(layerNodes),
		contentType: "application/json; charset=UTF-8"
	}).done(function(data, textStatus, jqXHR) {
		alert("レイヤツリーの保存が完了しました。");
	}).fail(function(jqXHR, textStatus, errorThrown){
		alert("レイヤツリーの保存に失敗しました。");
	});
};

/**
 * レイヤツリーノードのパラメータ取得
 */
function getNodeParam(node, parentNodeId) {
	// 凡例は除外
	if(node.id.indexOf("legend_") === 0){
		return;
	}
	// パラメータ取得
	var param = {};
	param.nodeId = node.id;
	param.nodeType = node.type;
	param.parentNodeId = parentNodeId;
	param.layerId = node.a_attr.layerid;
	param.layerName = node.text;
	param.layerType = node.a_attr.type;
	param.layerUrl = node.a_attr.url;
	param.layerOpacity = node.a_attr.opacity;
	param.layerOrder = layerOrderSeq++;
	layerNodes.push(param);

	// 子要素に対して再帰
	var children = node.children;
	if(children.length > 0) {
		for(let i = 0; i < children.length; i++) {
			getNodeParam(children[i], node.id);
		}
	}
}
