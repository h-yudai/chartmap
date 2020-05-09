function Layer(treeNode) {
	if(!treeNode && !treeNode.id && !treeNode.a_attr) {
		console.log("There is no parameter to initialize the layer.");
		return;
	}
	this.id = treeNode.id;
	var attr = treeNode.a_attr;
	try {
		// 配信タイプ（OSM／XYZ／WMS）
		(attr.type) ? this.type = attr.type : this.type = "";
		// レイヤID
		(attr.layerid) ? this.layerid = attr.layerid : this.layerid = "";
		// URL
		(attr.url) ? this.url = attr.url : this.url = "";
		// 透過度
		(attr.opacity) ? this.opacity = Number(attr.opacity) : this.opacity = 1.0;
		// レイヤ初期化
		this.initLayer();
	} catch(e) {
		console.error(e);
	}
}

Layer.prototype = {
	source: null,
	layer: null,
	initLayer: function() {
		try {
			if(this.type == "OSM") {
				this.source = new ol.source.OSM();
			}
			if(this.type == "XYZ") {
				this.source = new ol.source.XYZ({
					url: this.url,
					projection: mapProj
				});
			}
			if(this.type == "WMS") {
				this.source = new ol.source.TileWMS({
					url: this.url,
					params: {'LAYERS': this.layerid, 'TILED': true},
					serverType: 'geoserver',
					projection: mapProj,
					transition: 0
				});
			}
			if(!this.source) {
				return false;
			}
			this.layer = new ol.layer.Tile({
				source: this.source,
				opacity: this.opacity,
				visible: false
			});
		} catch(e) {
			console.error(e);
		}
		return this.layer;
	}
}
