package jp.gis.chartmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.gis.chartmap.service.LayerService;

/**
 * 地図コントローラ
 */
@Controller
public class MapController {
	@Autowired
	LayerService layerService;

	/**
	 * 地図画面表示
	 * @param model
	 * @return 遷移先
	 */
	@RequestMapping(value="/map")
	public String showMap(Model model) {
		return "contents/map";
	}
}
