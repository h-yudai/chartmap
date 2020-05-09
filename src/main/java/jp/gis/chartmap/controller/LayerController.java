package jp.gis.chartmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.gis.chartmap.common.ApiResult;
import jp.gis.chartmap.dto.TreeNodeDto;
import jp.gis.chartmap.entity.Layer;
import jp.gis.chartmap.service.LayerService;

/**
 * レイヤコントローラ
 */
@Controller
public class LayerController {
	@Autowired
	LayerService layerService;

	/**
	 * レイヤツリー情報取得
	 * @param model
	 * @return 処理結果
	 */
	@RequestMapping(value="/layer/getLayerTree")
	@ResponseBody
	public List<TreeNodeDto> readLayerTree(Model model) {
		List<TreeNodeDto> treeNodeList = layerService.getLayerTree();
		return treeNodeList;
	}

	/**
	 * レイヤツリー情報保存
	 * @param layerList
	 * @return 処理結果
	 */
	@RequestMapping(value="/layer/saveLayerTree")
	@ResponseBody
	public ApiResult saveLayerTree(@RequestBody List<Layer> layerList) {
		ApiResult result = new ApiResult();
		String message = layerService.saveLayerTree(layerList);
		result.setMessage(message);
		return result;
	}
}
