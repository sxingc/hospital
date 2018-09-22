/**
 * 初始化科室管理详情对话框
 */
var DepartInfoDlg = {
    departInfoData : {}
};

/**
 * 清除数据
 */
DepartInfoDlg.clearData = function() {
    this.departInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DepartInfoDlg.set = function(key, val) {
    this.departInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DepartInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DepartInfoDlg.close = function() {
    parent.layer.close(window.parent.Depart.layerIndex);
}

/**
 * 收集数据
 */
DepartInfoDlg.collectData = function() {
    this
    .set('id')
    .set('departName');
}

/**
 * 提交添加
 */
DepartInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/depart/add", function(data){
        Feng.success("添加成功!");
        window.parent.Depart.table.refresh();
        DepartInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.departInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DepartInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/depart/update", function(data){
        Feng.success("修改成功!");
        window.parent.Depart.table.refresh();
        DepartInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.departInfoData);
    ajax.start();
}

$(function() {

});
