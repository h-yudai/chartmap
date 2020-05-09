package jp.gis.chartmap.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LayerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LayerExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("node_id like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("node_id not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNull() {
            addCriterion("node_type is null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNotNull() {
            addCriterion("node_type is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeEqualTo(String value) {
            addCriterion("node_type =", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotEqualTo(String value) {
            addCriterion("node_type <>", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThan(String value) {
            addCriterion("node_type >", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("node_type >=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThan(String value) {
            addCriterion("node_type <", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThanOrEqualTo(String value) {
            addCriterion("node_type <=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLike(String value) {
            addCriterion("node_type like", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotLike(String value) {
            addCriterion("node_type not like", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIn(List<String> values) {
            addCriterion("node_type in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotIn(List<String> values) {
            addCriterion("node_type not in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeBetween(String value1, String value2) {
            addCriterion("node_type between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotBetween(String value1, String value2) {
            addCriterion("node_type not between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIsNull() {
            addCriterion("parent_node_id is null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIsNotNull() {
            addCriterion("parent_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdEqualTo(String value) {
            addCriterion("parent_node_id =", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotEqualTo(String value) {
            addCriterion("parent_node_id <>", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdGreaterThan(String value) {
            addCriterion("parent_node_id >", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_node_id >=", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLessThan(String value) {
            addCriterion("parent_node_id <", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLessThanOrEqualTo(String value) {
            addCriterion("parent_node_id <=", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLike(String value) {
            addCriterion("parent_node_id like", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotLike(String value) {
            addCriterion("parent_node_id not like", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIn(List<String> values) {
            addCriterion("parent_node_id in", values, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotIn(List<String> values) {
            addCriterion("parent_node_id not in", values, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdBetween(String value1, String value2) {
            addCriterion("parent_node_id between", value1, value2, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotBetween(String value1, String value2) {
            addCriterion("parent_node_id not between", value1, value2, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andLayerIdIsNull() {
            addCriterion("layer_id is null");
            return (Criteria) this;
        }

        public Criteria andLayerIdIsNotNull() {
            addCriterion("layer_id is not null");
            return (Criteria) this;
        }

        public Criteria andLayerIdEqualTo(String value) {
            addCriterion("layer_id =", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotEqualTo(String value) {
            addCriterion("layer_id <>", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdGreaterThan(String value) {
            addCriterion("layer_id >", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("layer_id >=", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdLessThan(String value) {
            addCriterion("layer_id <", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdLessThanOrEqualTo(String value) {
            addCriterion("layer_id <=", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdLike(String value) {
            addCriterion("layer_id like", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotLike(String value) {
            addCriterion("layer_id not like", value, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdIn(List<String> values) {
            addCriterion("layer_id in", values, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotIn(List<String> values) {
            addCriterion("layer_id not in", values, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdBetween(String value1, String value2) {
            addCriterion("layer_id between", value1, value2, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerIdNotBetween(String value1, String value2) {
            addCriterion("layer_id not between", value1, value2, "layerId");
            return (Criteria) this;
        }

        public Criteria andLayerNameIsNull() {
            addCriterion("layer_name is null");
            return (Criteria) this;
        }

        public Criteria andLayerNameIsNotNull() {
            addCriterion("layer_name is not null");
            return (Criteria) this;
        }

        public Criteria andLayerNameEqualTo(String value) {
            addCriterion("layer_name =", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotEqualTo(String value) {
            addCriterion("layer_name <>", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameGreaterThan(String value) {
            addCriterion("layer_name >", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("layer_name >=", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLessThan(String value) {
            addCriterion("layer_name <", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLessThanOrEqualTo(String value) {
            addCriterion("layer_name <=", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameLike(String value) {
            addCriterion("layer_name like", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotLike(String value) {
            addCriterion("layer_name not like", value, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameIn(List<String> values) {
            addCriterion("layer_name in", values, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotIn(List<String> values) {
            addCriterion("layer_name not in", values, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameBetween(String value1, String value2) {
            addCriterion("layer_name between", value1, value2, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerNameNotBetween(String value1, String value2) {
            addCriterion("layer_name not between", value1, value2, "layerName");
            return (Criteria) this;
        }

        public Criteria andLayerTypeIsNull() {
            addCriterion("layer_type is null");
            return (Criteria) this;
        }

        public Criteria andLayerTypeIsNotNull() {
            addCriterion("layer_type is not null");
            return (Criteria) this;
        }

        public Criteria andLayerTypeEqualTo(String value) {
            addCriterion("layer_type =", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotEqualTo(String value) {
            addCriterion("layer_type <>", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeGreaterThan(String value) {
            addCriterion("layer_type >", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("layer_type >=", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeLessThan(String value) {
            addCriterion("layer_type <", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeLessThanOrEqualTo(String value) {
            addCriterion("layer_type <=", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeLike(String value) {
            addCriterion("layer_type like", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotLike(String value) {
            addCriterion("layer_type not like", value, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeIn(List<String> values) {
            addCriterion("layer_type in", values, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotIn(List<String> values) {
            addCriterion("layer_type not in", values, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeBetween(String value1, String value2) {
            addCriterion("layer_type between", value1, value2, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerTypeNotBetween(String value1, String value2) {
            addCriterion("layer_type not between", value1, value2, "layerType");
            return (Criteria) this;
        }

        public Criteria andLayerUrlIsNull() {
            addCriterion("layer_url is null");
            return (Criteria) this;
        }

        public Criteria andLayerUrlIsNotNull() {
            addCriterion("layer_url is not null");
            return (Criteria) this;
        }

        public Criteria andLayerUrlEqualTo(String value) {
            addCriterion("layer_url =", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlNotEqualTo(String value) {
            addCriterion("layer_url <>", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlGreaterThan(String value) {
            addCriterion("layer_url >", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("layer_url >=", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlLessThan(String value) {
            addCriterion("layer_url <", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlLessThanOrEqualTo(String value) {
            addCriterion("layer_url <=", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlLike(String value) {
            addCriterion("layer_url like", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlNotLike(String value) {
            addCriterion("layer_url not like", value, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlIn(List<String> values) {
            addCriterion("layer_url in", values, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlNotIn(List<String> values) {
            addCriterion("layer_url not in", values, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlBetween(String value1, String value2) {
            addCriterion("layer_url between", value1, value2, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerUrlNotBetween(String value1, String value2) {
            addCriterion("layer_url not between", value1, value2, "layerUrl");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityIsNull() {
            addCriterion("layer_opacity is null");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityIsNotNull() {
            addCriterion("layer_opacity is not null");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityEqualTo(BigDecimal value) {
            addCriterion("layer_opacity =", value, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityNotEqualTo(BigDecimal value) {
            addCriterion("layer_opacity <>", value, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityGreaterThan(BigDecimal value) {
            addCriterion("layer_opacity >", value, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("layer_opacity >=", value, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityLessThan(BigDecimal value) {
            addCriterion("layer_opacity <", value, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("layer_opacity <=", value, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityIn(List<BigDecimal> values) {
            addCriterion("layer_opacity in", values, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityNotIn(List<BigDecimal> values) {
            addCriterion("layer_opacity not in", values, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("layer_opacity between", value1, value2, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOpacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("layer_opacity not between", value1, value2, "layerOpacity");
            return (Criteria) this;
        }

        public Criteria andLayerOrderIsNull() {
            addCriterion("layer_order is null");
            return (Criteria) this;
        }

        public Criteria andLayerOrderIsNotNull() {
            addCriterion("layer_order is not null");
            return (Criteria) this;
        }

        public Criteria andLayerOrderEqualTo(Integer value) {
            addCriterion("layer_order =", value, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderNotEqualTo(Integer value) {
            addCriterion("layer_order <>", value, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderGreaterThan(Integer value) {
            addCriterion("layer_order >", value, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("layer_order >=", value, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderLessThan(Integer value) {
            addCriterion("layer_order <", value, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderLessThanOrEqualTo(Integer value) {
            addCriterion("layer_order <=", value, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderIn(List<Integer> values) {
            addCriterion("layer_order in", values, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderNotIn(List<Integer> values) {
            addCriterion("layer_order not in", values, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderBetween(Integer value1, Integer value2) {
            addCriterion("layer_order between", value1, value2, "layerOrder");
            return (Criteria) this;
        }

        public Criteria andLayerOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("layer_order not between", value1, value2, "layerOrder");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}