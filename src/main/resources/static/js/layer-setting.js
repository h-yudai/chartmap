var LayerSetting = function() {}

LayerSetting.prototype = {
	showDialog: function() {
		var self = this;
		// 設定画面表示
		$('#layerSettingDialog').dialog({
			modal: false,
			title: "設定",
			width: 512,
			height: 256,
			position: {my: "left top", at: "left+258 top", of: "#map"},
			buttons: {
				"OK": function() {
					var nodeParam = {};
					// タブの選択状態を判定
					if($('.is-active').index() == 0) {
						// ノード種別
						nodeParam.type = "leaf";
						// 属性
						nodeParam.a_attr = {};
						// レイヤID
						nodeParam.a_attr.layerid = $("#layer_id").val();
						// レイヤ名
						nodeParam.text = $("#layer_name").val();
						// レイヤ種別
						nodeParam.a_attr.type = $("#layer_type").val();
						// レイヤURL
						nodeParam.a_attr.url = $("#layer_url").val();
						// 透過度
						nodeParam.a_attr.opacity = $("#layer_opacity").val();
					} else {
						// ノード種別
						nodeParam.type = "default";
						// フォルダ名
						nodeParam.text = $("#folder_name").val();
					}
					// レイヤツリーにノードを追加
					var tree = $('#overlay_tree').jstree(true);
					tree.create_node("#", nodeParam, "last");
				}
			},
			open: function() {
				// タブのクリックイベント
				$('.tab').click(function() {
					$('.is-active').removeClass('is-active');
					$(this).addClass('is-active');
					$('.is-show').removeClass('is-show');
					const index = $(this).index();
					$('.panel').eq(index).addClass('is-show');
				});
			}
		})
	}
}
