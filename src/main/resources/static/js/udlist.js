//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

var project_list_data = [{
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

function project_list_add(id) {
    //console.log('project_list_remove_cor');
    console.log('project_list_add.id ');
    console.log(id);

    row = $("#project_list_table").bootstrapTable('getRowByUniqueId', id);
    //var selectedData = $('#project_list_table').bootstrapTable('getAllSelections');

    console.log(row);

    $("#project_list_table").bootstrapTable('remove', {field: 'id', values: [id]});
    $("#project_list_table_major_to").bootstrapTable('append', row);

};
//project,no,bid,date,extract,name,build，company,agent,org,purchase,mode,expert,state

var project_list_col = [
    {
        field: 'id',
        visible: false
    },
    {
        title: '项目编号',
        field: 'purchaseCode',
        align: 'center',
        sortable: true
    },
    {
        title: '评标时间',
        field: 'biddingTime',
        align: 'center',
        sortable: true
    },
    {
        title: '项目名称',
        field: 'purchaseProject',
        align: 'center',
        sortable: true
    },
    {
        title: '抽取时间',
        field: 'extractDate',
        align: 'center',
        sortable: true
    },
    {
        title: '建设单位',
        field: 'purchaseCompany',
        align: 'center',
        sortable: true
    },
    {
        title: '代理机构',
        field: 'proxyOrg',
        align: 'center',
        sortable: true
    },
    {
        title: '抽取单位',
        field: 'extractCompany',
        align: 'center',
        sortable: true
    },
    {
        title: '采购方式',
        field: 'purchaseType',
        align: 'center',
        sortable: true
    },
    {
        title: '专家选取状态',
        field: 'expertState',
        align: 'center',
        sortable: true
    }
];

function init() {
    $('#project_list_table').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        uniqueId: 'id',//唯一的标识
        columns: project_list_col
    });

    loadAllProjects();
}

//已经设置过了，需要加载各表格数据
function loadAllProjects(refresh) {
    $.axx({
        type: 'get',
        url: '/projects/all',
        success: function (json) {
            let i = json.content.length;
            $('#project_list_table').bootstrapTable("load", json.content);
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    })
}


$(document).ready(function () {

    init();
});

function project_list_add_common(id) {
    console.log(id);

    var result = [
        '<button  type="button" class="btn btn-primary btn-xs" onclick="ext_add(\'' + id + '\')">选择</button>',]
        .join('');
    console.log(result);
    return result;
}

function nullFormatter(data) {

    if (data == "" || data == null || data == " ") {
        return '未填';
    }
    return data;
}

function timeFormatter(data) {
    if (data != null) {
        data = transfromTime(data, true);
    }
    return data;
}  
 