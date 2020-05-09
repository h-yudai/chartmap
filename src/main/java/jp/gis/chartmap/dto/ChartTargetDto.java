package jp.gis.chartmap.dto;

import lombok.Data;

@Data
public class ChartTargetDto {
	private String tableName;
	private String layerName;
	private String columns;
}
