//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

var print_table_col = [
    {
        field: 'expert_id',
        visible: false
    },   
    {
        title: '专家姓名',
        field: 'name',
        width: '100px',
        align: 'center',
       
        sortable: true
    },
    {
        title: '证件号码',
        field: 'no',
        width: '250px',
        align: 'center',
       
        sortable: true
    },
    {
        title: '抽取专业',
        field: 'majorName',
        align: 'center',
        width: '150px',
        sortable: true
    },
    {
        title: '工作单位',
        field: 'company',
        width: '250px',
        align: 'center',
        sortable: true
    },
    {
        title: '手机号码',
        field: 'phone',
        align: 'center',
        width: '150px',
        sortable: true
    },
    {
        title: '是否正备选',
        field: 'expertOption',
        align: 'center',
        width: '75px',
        sortable: true
    },
    {
        title: '专家级别',
        field: 'expertType',
        align: 'center',
        width: '75px',
        sortable: true
    },
    {
        title: '产生方式',
        field: 'extractType',
        align: 'center',
        width: '100px',
        sortable: true
//        formatter:extractTypeFormatter
    }
];
var data=[{
	"state":false,
    "id": '1',
    'name': "评标专家通知结果",
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "注意保密",
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "XXXXXXXXXXXXXXXXXXXXXXXXXXXX张三3",
    'expertOption': "正选",
    'expertType': "1234565",
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "专家姓名",
    'no':'证件号码',
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "侯志新",
    'no':'222222222222222222',
    "removerow" : ""
}];
function initprint_table() {


    //
    $('#print_table').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        showHeader:false,
        columns: print_table_col
    });
    $('#print_table').bootstrapTable('load',data);
    $('#print_table').bootstrapTable('mergeCells', { index: 0, field: 'name', colspan: 8, rowspan: 1});
    $('#print_table').bootstrapTable('mergeCells', { index: 1, field: 'name', colspan: 8, rowspan: 1});
    $('#print_table').bootstrapTable('mergeCells', { index: 2, field: 'name', colspan: 5, rowspan: 1});
    $('#print_table').bootstrapTable('mergeCells', { index: 2, field: 'expertOption', colspan: 1, rowspan: 1});
    $('#print_table').bootstrapTable('mergeCells', { index: 2, field: 'expertType', colspan: 2, rowspan: 1});
}


function doPrint() {
    $('#print_id').print({
        globalStyles: true,
        mediaPrint: false,
        stylesheet:'./css/print.css',
        title:'',
    });
}

function signinFormatter(data) {
    return "";
}
function extractTypeFormatter(data) {
    return "系统随机抽取";
}

$(document).ready(function () {

    initprint_table();
    
    
});  
