package jp.gis.chartmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.gis.chartmap.dto.ChartDataDto;
import jp.gis.chartmap.dto.ChartTargetDto;
import jp.gis.chartmap.service.ChartService;

/**
 * チャートコントローラ
 */
@Controller
public class ChartController {
	@Autowired
	ChartService chartService;

	/**
	 * 処理対象データ取得
	 * @param model
	 * @return 処理結果
	 */
	@RequestMapping(value="/chart/getChartTarget")
	@ResponseBody
	public List<ChartTargetDto> getChartTarget(Model model) {
		List<ChartTargetDto> chartTargetList = chartService.getChartTarget();
		return chartTargetList;
	}

	/**
	 * チャートデータ取得
	 * @param table 対象テーブル
	 * @param vCol 縦軸の項目
	 * @param hCol 横軸の項目
	 * @param agg 集約方法
	 * @return 処理結果
	 */
	@RequestMapping(value="/chart/getChartData")
	@ResponseBody
	public List<ChartDataDto> getChartData(@RequestParam("table") String table,
			@RequestParam("vCol") String vCol, @RequestParam("hCol") String hCol, @RequestParam("agg") String agg) {
		List<ChartDataDto> chartDataList = chartService.getChartData(table, vCol, hCol, agg);
		return chartDataList;
	}
}
