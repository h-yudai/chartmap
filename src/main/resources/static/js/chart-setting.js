var ChartSetting = function() {}

ChartSetting.prototype = {
	chart: null,
	showDialog: function() {
		var self = this;
		// 設定画面表示
		$('#chartSettingDialog').dialog({
			modal: false,
			title: "設定",
			width: 550,
//			height: 420,
			position: {my: "left top", at: "left+258 top", of: "#map"},
			buttons: {
				"新規作成": function() {
					// 設定値取得
					var settingParam = self.getSettnigParam();
					// 入力チェック
					if(self.isRequiredError(settingParam)) {
						alert("データを選択してください");
						return;
					}
					// チャートデータ取得
					$.ajax({
						url: host + "/chart/getChartData",
						type: "GET",
						dataType: "json",
						data: settingParam,
						contentType: "application/json; charset=UTF-8"
					}).done(function(data, textStatus, jqXHR){
						// チャート生成
						self.createChart(data);
						// チャート表示
						self.showChart();
					}).fail(function(jqXHR, textStatus, errorThrown){
						alert("チャートデータの取得に失敗しました。");
					});
				},
				"データ追加": function() {
					// チャートが作成済みの場合のみ実行
					var isNotCreateDlg = false;
					try {
						if(!$('#chart_div').dialog('isOpen')) {
							isNotCreateDlg = true;
						}
					} catch(e) {
						isNotCreateDlg = true;
					}
					if(isNotCreateDlg) {
						alert("チャートが作成されていません。");
						return;
					}
					// 設定値取得
					var settingParam = self.getSettnigParam();
					// 入力チェック
					if(self.isRequiredError(settingParam)) {
						alert("データを選択してください");
						return;
					}
					// チャートデータ取得
					$.ajax({
						url: host + "/chart/getChartData",
						type: "GET",
						dataType: "json",
						data: settingParam,
						contentType: "application/json; charset=UTF-8"
					}).done(function(data, textStatus, jqXHR){
						// チャート生成
						self.addChart(data);
					}).fail(function(jqXHR, textStatus, errorThrown){
						alert("チャートデータの取得に失敗しました。");
					});
				}
			},
			open: function() {
				self.createGrid();
			}
		});
	},
	getSettnigParam: function() {
		var settingParam = {};
		if($('.jsgrid-selected-row-ext').length != 0) {
			settingParam.table = $('.jsgrid-selected-row-ext')[0].children[0].innerHTML;
		}
		settingParam.vCol = $("#chart_setting_col_v").val();
		settingParam.hCol = $("#chart_setting_col_h").val();
		settingParam.agg = $("#chart_setting_aggregation").val();
		return settingParam;
	},
	isRequiredError: function(settingParam) {
		var isRequiredError = false;
		if(!settingParam.table) isRequiredError = true;
		if(!settingParam.vCol) isRequiredError = true;
		if(!settingParam.hCol) isRequiredError = true;
		if(!settingParam.agg) isRequiredError = true;
		return isRequiredError;
	},
	createGrid: function() {
		// 対象データ取得
		$.ajax({
			url: host + "/chart/getChartTarget",
			type: "GET",
			dataType: "json"
		}).done(function(data, textStatus, jqXHR){
			// グリッド生成
			$("#chart_setting_target").jsGrid({
				height: "180px",
				width: "97%",
				sorting: true,
				paging: true,
				pageSize: 10,
				pageButtonCount: 5,
				noDataContent: "Not found",
				data: data,
				fields: [
					{ name: "tableName", title: "テーブル名", type: "text", width: 50 },
					{ name: "layerName", title: "レイヤ名", type: "text", width: 50 },
					{ name: "columns", type: "text", visible: false }
				],
				rowClick: function(e) {
					// 選択行ハイライト
					$(".jsgrid-row").removeClass("jsgrid-selected-row-ext");
					$(".jsgrid-alt-row").removeClass("jsgrid-selected-row-ext");
					$('.jsgrid-selected-row').addClass('jsgrid-selected-row-ext');
					// 縦軸、横軸の項目更新
					$('#chart_setting_col_v > option').remove();
					$('#chart_setting_col_h > option').remove();
					var columns = e.item.columns.split(',');
					for(let i = 0; i < columns.length; i++) {
						var col = columns[i];
						$('#chart_setting_col_v').append($('<option>').html(col).val(col));
						$('#chart_setting_col_h').append($('<option>').html(col).val(col));
					}
				}
			});
		}).fail(function(jqXHR, textStatus, errorThrown){
			alert("グリッドの作成に失敗しました。");
		});
	},
	createChart: function(chartData) {
		// 生成済みのチャートを破棄
		if(this.chart) {
			this.chart.destroy();
		}
		// データを配列に展開
		var labels = [];
		var values = [];
		for(let i = 0; i < chartData.length; i++) {
			var entry = chartData[i];
			labels.push(entry.label);
			values.push(entry.value);
		}
		// チャート生成
		var ctx = document.getElementById('chart_cvs').getContext('2d');
		this.chart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: labels,
				datasets: [
					{
						label: $("#chart_setting_label").val(),
						backgroundColor: Chart.helpers.color('rgb(255, 99, 132)').alpha(0.5).rgbString(),
						borderColor: Chart.helpers.color('rgb(255, 99, 132)').alpha(0.5).rgbString(),
						borderWidth: 1,
						data: values
					}
				]
			},
			options: {
				responsive: true,
				legend: {
					position: 'top',
				},
				scales: {
					xAxes: [{
						display: true
					}],
					yAxes: [{
						display: true,
						scaleLabel: {
							display: true,
							labelString: $("#chart_setting_unit").val()
						}
					}]
				},
				title: {
					display: true,
					text: $("#chart_setting_title").val()
				}
			}
		});
	},
	addChart: function(chartData) {
		var labels = [];
		var values = [];
		for(let i = 0; i < chartData.length; i++) {
			var entry = chartData[i];
			labels.push(entry.label);
			values.push(entry.value);
		}
		var dataset = {
			label: $("#chart_setting_label").val(),
			backgroundColor: Chart.helpers.color('rgb(99, 255, 132)').alpha(0.5).rgbString(),
			borderColor: Chart.helpers.color('rgb(99, 255, 132)').alpha(0.5).rgbString(),
			borderWidth: 1,
			data: values
		}
		chartSetting.chart.data.datasets.push(dataset);
		chartSetting.chart.update()
	},
	showChart: function() {
		$("#chart_div").dialog({
			modal: false,
			title: "チャート",
			width: 450,
			height: 540,
			position: {my: "right top", at: "right top", of: "#map"},
			buttons: {
				"画像出力": function() {
					var canvas = document.getElementById('chart_cvs');
					var base64 = canvas.toDataURL("image/png");
					var a = document.createElement('a');
					a.href = base64
					a.download = 'chart.png';
					a.click();
				}
			}
		});
	}
}
