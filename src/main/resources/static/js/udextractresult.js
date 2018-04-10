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
        field: 'projectName',
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
    }
];

function initExtractResult() {


    //
    $('#ext_table_extractResult').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        columns: extractResult_col
    });

    $('#ext_table_voice').bootstrapTable({
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
$('#voiceNotice').on('show.bs.modal', function (event) {
    console.log("show.bs.modal");
    console.log(event);
    loadVoiceData();
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

function startVoice(){
	projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/voice/start/"+projectId,
        success:function (json) {
        	loadVoiceData();
        }
    });	
}
function pauseVoice(){
	projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/voice/pause/"+projectId,
        success:function (json) {
        	loadVoiceData();
        }
    });	
}
function printResult(){
	
}
function loadVoiceData() {
	projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/voice/get/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
            $('#ext_table_voice').bootstrapTable("load", models);
            
        }
    });	
	
}

function notifyFormatter(data) {

    if (data == "" || data == null || data == " ") {
        return '未通知';
    }
    return data;
}
function nameFormatter(data) {
    return "**********";
}
function phoneFormatter(data) {
    return "**********";
}
function confirmFormatter(data) {

    if (data == "" || data == null || data == " ") {
        return '等待通知';
    }
    return data;
}


$(document).ready(function () {

    initExtractResult();
    
    $("#voiceNotice_start").click(startVoice);
    $("#voiceNotice_pause").click(pauseVoice);
    $("#voiceNotice_print").click(printResult);
});  
