package jp.gis.chartmap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.gis.chartmap.entity.Layer;
import jp.gis.chartmap.entity.LayerExample;

@Mapper
public interface LayerMapper {
    long countByExample(LayerExample example);

    int deleteByExample(LayerExample example);

    int deleteByPrimaryKey(String nodeId);

    int insert(Layer record);

    int insertSelective(Layer record);

    List<Layer> selectByExample(LayerExample example);

    Layer selectByPrimaryKey(String nodeId);

    int updateByExampleSelective(@Param("record") Layer record, @Param("example") LayerExample example);

    int updateByExample(@Param("record") Layer record, @Param("example") LayerExample example);

    int updateByPrimaryKeySelective(Layer record);

    int updateByPrimaryKey(Layer record);
}