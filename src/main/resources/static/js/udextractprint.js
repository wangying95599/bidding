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
        title: '编码',
        field: 'randomCode',
        align: 'center',
        width: '100px',
        sortable: true
    },
    {
        title: '专业',
        field: 'majorName',
        align: 'center',
        sortable: true
    },
    {
        title: '姓名',
        field: 'name',
        width: '100px',
        align: 'center',
       
        sortable: true
    },
    {
        title: '性别',
        field: 'sex',
        width: '50px',
        align: 'center',
        sortable: true
    },
    {
        title: '电话',
        field: 'phone',
        align: 'center',
        width: '100px',
        sortable: true
    },
    {
        title: '工作单位',
        field: 'company',
        align: 'center',
        sortable: true
    },
    {
        title: '签到',
        field: 'signin',
        align: 'center',
        width: '150px',
        sortable: true,
        formatter:signinFormatter
    },
    {
        title: '签到时间',
        field: 'singinTime',
        align: 'center',
        width: '150px',
        sortable: true,
        formatter:signinFormatter
    }
];

function initprint_table() {


    //
    $('#print_table').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: print_table_col
    });

    loadprint_formData();
    loadprint_tableData();
}

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
}

function loadprint_formData() {
	
	var projectId = GetQueryString("projectId");
	console.log(projectId);
    $.ajax({
        type:'GET',
        url:"/projects/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
            
            
        }
    });	
	
}
function loadprint_tableData() {
	
	var projectId = GetQueryString("projectId");
	console.log(projectId);
    $.ajax({
        type:'GET',
        url:"/extract/get/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
            $('#print_table').bootstrapTable("load", models);
            
        }
    });	
	
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

$(document).ready(function () {

    initprint_table();
    
    
});  
