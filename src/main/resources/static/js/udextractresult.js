//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

var extractResult_data = [{
    "id": '1',
    'name': "********",
    "projectName": '测试',
    "randomNo": 'DL181',
    "date": '2018-3-27',
    "major": '电子信息-计算机'
},
    {
        "id": '2',
        'name': "********",
        "projectName": '测试',
        "randomNo": '3D1LA1',
        "date": '2018-3-27',
        "major": '电子信息-计算机'

    }];


var extractResult_col = [
    {
        field: 'id',
        visible: false
    },

    {
        title: '项目名称',
        field: 'projectName',
        align: 'center',
        sortable: true
    },
    {
        title: '专业',
        field: 'major',
        align: 'center',
        sortable: true
    },
    {
        title: '姓名',
        field: 'name',
        align: 'center',
        sortable: true
    },
    {
        title: '性别',
        field: 'sex',
        align: 'center',
        sortable: true
    },
    {
        title: '电话',
        field: 'phone',
        align: 'center',
        sortable: true
    },
    {
        title: '工作单位',
        field: 'location',
        align: 'center',
        sortable: true
    }
];

function initExtractResult() {


    //
    $('#ext_table_extractResult').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: extractResult_col
    });


    loadExtractResultData();
}

//已经设置过了，需要加载各表格数据
function loadExtractResultData() {
    $('#ext_table_extractResult').bootstrapTable("load", extractResult_data);

}


$(document).ready(function () {

    initExtractResult();
});  
