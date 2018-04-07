//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//
let selectedNum = 0, projectTotal = 0;

function getProjectId() {
	$table=$("#project_list_table");
    if ($table.bootstrapTable("getSelections").length != 1) {
        throw "select error";
    } else {
        return $table.bootstrapTable("getSelections")[0].id;
    }
}

//project,no,bid,date,extract,name,build，company,agent,org,purchase,mode,expert,state

var project_list_col = [
    {
        checkbox: true
    },
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
    },
];

function toggleProjectRelatedButtons(selectedNum) {
    // const selectedNum = $("#project_list_table").bootstrapTable('getSelections').length;
    if (selectedNum === 1) {
        $('#createProjectButton').hide();
        $('#editProjectButton').show();
        $('#removeProjectButton').show();
    } else if (selectedNum > 1) {
        $('#createProjectButton').hide();
        $('#editProjectButton').hide();
        $('#removeProjectButton').show();
    } else if (selectedNum === 0) {
        $('#createProjectButton').show();
        $('#editProjectButton').hide();
        $('#removeProjectButton').hide();
    }
}

function init() {
    $('#project_list_table').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        uniqueId: 'id',//唯一的标识
        totalField: '总数：',
        columns: project_list_col,
        onCheck: function () {
            selectedNum++;
            toggleProjectRelatedButtons(selectedNum);
        },
        onUncheck: function () {
            selectedNum--;
            toggleProjectRelatedButtons(selectedNum);
        },
        onCheckAll: function () {
            selectedNum = projectTotal;
            toggleProjectRelatedButtons(selectedNum);
        },
        onUncheckAll: function () {
            selectedNum = 0;
            toggleProjectRelatedButtons(selectedNum);
        },
    });

    loadAllProjects();
}

//已经设置过了，需要加载各表格数据
function loadAllProjects() {
    selectedNum = 0;
    $.axx({
        type: 'get',
        url: '/projects/all',
        success: function (json) {
            projectTotal = json.content.length;
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
 