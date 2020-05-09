package jp.gis.chartmap.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.gis.chartmap.dto.ChartDataDto;
import jp.gis.chartmap.dto.ChartTargetDto;

@Mapper
public interface ChartDao {
	List<ChartTargetDto> selectChartTarget();
	List<ChartDataDto> selectChartDataBySum(@Param("table") String table, @Param("vCol") String vCol, @Param("hCol") String hCol);
	List<ChartDataDto> selectChartDataByAvg(@Param("table") String table, @Param("vCol") String vCol, @Param("hCol") String hCol);
	List<ChartDataDto> selectChartDataByCtr(@Param("table") String table, @Param("vCol") String vCol, @Param("hCol") String hCol);
	List<ChartDataDto> selectChartDataByMax(@Param("table") String table, @Param("vCol") String vCol, @Param("hCol") String hCol);
	List<ChartDataDto> selectChartDataByMin(@Param("table") String table, @Param("vCol") String vCol, @Param("hCol") String hCol);
}
