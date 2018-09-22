/**
 * 科室管理管理初始化
 */
var Depart = {
    id: "DepartTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Depart.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '科室编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '科室名称', field: 'departName', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Depart.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Depart.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加科室管理
 */
Depart.openAddDepart = function () {
    var index = layer.open({
        type: 2,
        title: '添加科室管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/depart/depart_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看科室管理详情
 */
Depart.openDepartDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '科室管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/depart/depart_update/' + Depart.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除科室管理
 */
Depart.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/depart/delete", function (data) {
            Feng.success("删除成功!");
            Depart.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("departId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询科室管理列表
 */
Depart.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Depart.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Depart.initColumn();
    var table = new BSTable(Depart.id, "/depart/list", defaultColunms);
    table.setPaginationType("client");
    Depart.table = table.init();
});
