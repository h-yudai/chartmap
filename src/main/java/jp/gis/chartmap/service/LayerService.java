package jp.gis.chartmap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.gis.chartmap.dto.TreeNodeAttrDto;
import jp.gis.chartmap.dto.TreeNodeDto;
import jp.gis.chartmap.dto.TreeNodeStateDto;
import jp.gis.chartmap.entity.Layer;
import jp.gis.chartmap.entity.LayerExample;
import jp.gis.chartmap.mapper.LayerMapper;

/**
 * レイヤサービス
 */
@Service
public class LayerService {
	@Autowired
	LayerMapper layerMapper;

	/**
	 * 親ノードを探索する
	 * @param 探索ノード
	 * @param ノードID
	 * @return 親ノード
	 */
	private TreeNodeDto searchNode(TreeNodeDto searchNode, String nodeId) {
		TreeNodeDto ret = null;
		if(nodeId != null && !nodeId.isEmpty()) {
			if(nodeId.equals(searchNode.getId())) {
				ret = searchNode;
			} else {
				// 子ノードに対して再帰
				if(searchNode.getChildren().size() > 0) {
					for(TreeNodeDto entry : searchNode.getChildren()) {
						ret = searchNode(entry, nodeId);
						break;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * レイヤツリー情報を取得する
	 * @return レイヤツリー情報
	 */
	public List<TreeNodeDto> getLayerTree() {
		// レイヤ情報取得
		LayerExample exp = new LayerExample();
		exp.setOrderByClause("layer_order");
		List<Layer> layerList = layerMapper.selectByExample(exp);

		// レイヤツリー情報生成
		List<TreeNodeDto> treeNodeList = new ArrayList<TreeNodeDto>();
		for(Layer layer : layerList) {
			TreeNodeDto treeNode = new TreeNodeDto();
			TreeNodeStateDto treeNodeState = new TreeNodeStateDto();
			TreeNodeAttrDto treeNodeAttr = new TreeNodeAttrDto();
			treeNodeAttr.setLayerid(layer.getLayerId());
			treeNodeAttr.setType(layer.getLayerType());
			treeNodeAttr.setUrl(layer.getLayerUrl());
			if(layer.getLayerOpacity() != null) {
				treeNodeAttr.setOpacity(Float.parseFloat(layer.getLayerOpacity().toString()));
			}
			treeNode.setId(layer.getNodeId());
			treeNode.setText(layer.getLayerName());
			treeNode.setType(layer.getNodeType());
			treeNode.setState(treeNodeState);
			treeNode.setA_attr(treeNodeAttr);

			// 親ノードに追加
			String parentNodeId = layer.getParentNodeId();
			boolean hasParent = false;
			for(TreeNodeDto entry : treeNodeList) {
				TreeNodeDto parentNode = searchNode(entry, parentNodeId);
				// 親ノードが存在する場合
				if(parentNode != null) {
					parentNode.getChildren().add(treeNode);
					hasParent = true;
					break;
				}
			}
			// 親ノードが存在しない場合
			if(!hasParent) {
				treeNodeList.add(treeNode);
			}

			// 凡例
			String nodeType = layer.getNodeType();
			if(nodeType != null && nodeType.equals("leaf")) {
				String layerId = layer.getLayerId();
				TreeNodeDto legend = new TreeNodeDto();
				legend.setId("legend_" + layerId);
				legend.setIcon("http://localhost:8081/geoserver/wms?REQUEST=GetLegendGraphic&VERSION=1.0.0&FORMAT=image/png&LEGEND_OPTIONS=fontName:Serif;fontAntiAliasing:true;bgColor:0xffffff&LAYER=" + layerId);
				treeNode.getChildren().add(legend);
			}
		}
		return treeNodeList;
	}

	/**
	 * レイヤツリー情報を保存する
	 * @param レイヤ情報
	 * @return 処理結果
	 */
	@Transactional
	public String saveLayerTree(List<Layer> layerList) {
		// レイヤ情報削除
		layerMapper.deleteByExample(null);

		for(Layer layer : layerList) {
			// レイヤ情報登録
			layerMapper.insert(layer);
		}
		return "success";
	}
}
