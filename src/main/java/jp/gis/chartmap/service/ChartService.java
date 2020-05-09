package jp.gis.chartmap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.gis.chartmap.dao.ChartDao;
import jp.gis.chartmap.dto.ChartDataDto;
import jp.gis.chartmap.dto.ChartTargetDto;

/**
 * チャートサービス
 */
@Service
public class ChartService {
	@Autowired
	ChartDao chartDao;

	/**
	 * 処理対象データを取得する
	 * @return 処理対象データ
	 */
	public List<ChartTargetDto> getChartTarget() {
		List<ChartTargetDto> chartTargetList = chartDao.selectChartTarget();
		return chartTargetList;
	}

	/**
	 * チャートデータを取得する
	 * @return チャートデータ
	 */
	public List<ChartDataDto> getChartData(String table, String vCol, String hCol, String agg) {
		List<ChartDataDto> chartDataList = new ArrayList<ChartDataDto>();
		if(agg.equals("SUM")) {
			// 合計値
			chartDataList = chartDao.selectChartDataBySum(table, vCol, hCol);
		} else if(agg.equals("AVG")) {
			// 平均値
			chartDataList = chartDao.selectChartDataByAvg(table, vCol, hCol);
		} else if(agg.equals("CTR")) {
			// 中央値
			chartDataList = chartDao.selectChartDataByCtr(table, vCol, hCol);
		} else if(agg.equals("MAX")) {
			// 最大値
			chartDataList = chartDao.selectChartDataByMax(table, vCol, hCol);
		} else if(agg.equals("MIN")) {
			// 最小値
			chartDataList = chartDao.selectChartDataByMin(table, vCol, hCol);
		}
		return chartDataList;
	}
}
