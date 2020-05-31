package jp.gis.chartmap.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TreeNodeDto {
	private String id;
	private String text;
	private String type;
	private String icon;
	private TreeNodeStateDto state;
	private List<TreeNodeDto> children = new ArrayList<TreeNodeDto>();
	private TreeNodeAttrDto a_attr;
}
