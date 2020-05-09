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

			// 親子判定
			String parent = layer.getParentNodeId();
			if(parent == null || parent.isEmpty()) {
				treeNodeList.add(treeNode);
			} else {
				for(TreeNodeDto entry : treeNodeList) {
					if(parent.equals(entry.getId())) {
						entry.getChildren().add(treeNode);
					}
				}
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
