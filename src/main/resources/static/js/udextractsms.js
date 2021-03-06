//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

var extractResult_col = [
    {
        field: 'expert_id',
        visible: false
    },

    {
        title: '项目名称',
        field: 'purchaseProject',
        align: 'center',
        sortable: true
    },
    {
        title: '随机编码',
        field: 'randomCode',
        align: 'center',
        sortable: true
    },
    {
        title: '专业',
        field: 'majorName',
        align: 'center',
        sortable: true
    },
    {
        title: '专家姓名',
        field: 'name',
        align: 'center',
        formatter:nameFormatter,
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
        formatter:phoneFormatter,
        sortable: true
    },
    {
        title: '工作单位',
        field: 'company',
        align: 'center',
        sortable: true
    },
    {
        title: '通知状态',
        field: 'noticeStatus',
        align: 'center',
        sortable: true,
        formatter:notifyFormatter
    },
    {
        title: '确认状态',
        field: 'confirmStatus',
        align: 'center',
        sortable: true,
        formatter:confirmFormatter
    },
    {
        field: 'hconfirm',
        title: '操作',
        align: 'center',
        formatter: confirm_expert
    }
];
function confirm_expert(value, row, index) {
	var projectId=row.projectId;
    var expertId=row.expertId;
    var result = [
        '<button  type="button" class="btn btn-link btn-xs" onclick="f_confirm(' + projectId +','+expertId+')">人工确认</button>',]
        .join('');
    return result;
}
function f_confirm(projectId,expertId) {
//    console.log('2 ' + expertId);
    
    $.axx({
        type:'GET',
        url:"/sms/confirm/"+projectId+"/"+expertId,
        success:function (json) {

        	loadExtractResultData();
            
        }
    });	
};
function initExtractResult() {


    //
    $('#ext_table_extractResult').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: extractResult_col
    });

    $('#ext_table_sms').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: extractResult_col
    });
   
   
}

$('#extractResultInfo').on('show.bs.modal', function (event) {
    console.log("show.bs.modal");
    console.log(event);
    loadExtractResultData();
});
$('#smsNotice').on('show.bs.modal', function (event) {
    console.log("show.bs.modal");
    console.log(event);
    loadsmsData();
});


//已经设置过了，需要加载各表格数据
function loadExtractResultData() {
	projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/extract/get/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
            $('#ext_table_extractResult').bootstrapTable("load", models);
            
        }
    });	
	
}

function startSms(){
	projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/sms/start/"+projectId,
        success:function (json) {
        	loadsmsData();
        }
    });	
}

function printResult(){
	projectId=getProjectId();
	window.open('print.html?projectId='+projectId, '_blank');
}
function loadSmsData() {
	projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/sms/get/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
            $('#ext_table_sms').bootstrapTable("load", models);
            
        }
    });	
	
}

function notifyFormatter(value, row, index, field) {

    if (row.confirmStatus && (row.confirmStatus=='Y'||row.confirmStatus=='N')) {
        return '通知';
    }else{
    	return '未通知';
    }

}
function nameFormatter(data) {
	return data;
}
function phoneFormatter(data) {
	return data;
}
function confirmFormatter(data) {

    if (data == "" || data == null || data == " ") {
        return '等待确认';
    }else if(data=="Y"){
    	return '参加';
    }else if(data=="N"){
    	return '不参加';
    }
    return data;
}


$(document).ready(function () {

    initExtractResult();
    
    $("#smsNotice_start").click(startsms);
    $("#smsNotice_pause").click(pausesms);
    $("#smsNotice_print").click(printResult);
});  
