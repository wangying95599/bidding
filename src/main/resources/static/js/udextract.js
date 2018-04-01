//ext界面的四个table ext_table_cor,ext_table_person,ext_table,ext_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//
var ext_data_cor=[{
	"state":false,
    "id": '1',
    'name': "张三"
    
},
{
	"state":false,
    "id": '2',
    'name': "张三2"
    
}];
var ext_data_person=[{
	"state":false,
    "id": '1',
    'name': "张三"
    
},
{
	"state":false,
    "id": '2',
    'name': "张三2"
    
}];
var ext_data_major_to=[{
	"state":false,
    "id": '1',
    'name': "张三",
	"no": '1'
    
},
{
	"state":false,
    "id": '2',
    'name': "张三2",
	"no": '2'
    
}];
var ext_data=[{
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

function ext_add (id) {
	//console.log('ext_remove_cor');
	console.log('ext_add.id ');	
	console.log(id);	
	
	row= $("#ext_table").bootstrapTable('getRowByUniqueId',id);
	//var selectedData = $('#ext_table').bootstrapTable('getAllSelections');
	
	console.log(row);
	
	$("#ext_table").bootstrapTable('remove', {field: 'id', values: [id]});
	$("#ext_table_major_to").bootstrapTable('append', row);

};

var ext_col_cor=[  
	{   field: 'id',  
        visible: false
    },
    
	{  
        title: '回避单位名称',  
        field: 'name',  
        align: 'center',  
        sortable: true 
    } 
 ]  ;

var ext_col_person=[  
	{   field: 'id',  
        visible: false
    },
   
	{  
        title: '专家姓名',  
        field: 'name',  
        align: 'center',  
        sortable: true 
    } ,
	{  
        title: '专家电话',  
        field: 'phone',  
        align: 'center',  
        sortable: true 
    } 
 ]  ;
 var ext_col=[  
	{   field: 'id',  
        visible: false
    },
    
	{  
        title: '项目名称',  
        field: 'projectName',  
        align: 'center',  
        sortable: true 
    } ,
	{  
        title: '评审专业',  
        field: 'major',  
        align: 'center',  
        sortable: true 
    },
	{  
        title: '专家姓名',  
        field: 'name',  
        align: 'center',  
        sortable: true 
    } ,
	{  
        title: '随机编码',  
        field: 'randomNo',  
        align: 'center',  
        sortable: true 
    },
	{  
        title: '抽取时间',  
        field: 'date',  
        align: 'center',  
        sortable: true 
    } 
 ]  ;
 var ext_col_major_to=[  
	{   field: 'id',  
        visible: false
    },
    
	
	{  
        title: '专业名称',  
        field: 'name',  
        align: 'center',  
        sortable: true 
    } ,
	{  
        title: '人数',  
        field: 'size',  
        align: 'center',  
		formatter: nullFormatter,
		editable: {
			type: 'text',
			title: '人数',
			validate: function (v) {
				if(!v) return '必须设置人数';
				 if (isNaN(v)) return '人数必须是数字';
                 var age = parseInt(v);
                 if (age <= 0) return '人数必须是正整数';
				
			}
		}
		
    } 
 ]  ;
function initExtract(){
	
	
	//
    $('#ext_table_cor').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,
        columns:ext_col_cor
    }); 
	
	
    $('#ext_table_person').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,
        columns:ext_col_person
    }); 
    $('#ext_table').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,
		uniqueId : 'id',//唯一的标识
        columns:ext_col
    }); 
    $('#ext_table_major_to').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,		
        columns:ext_col_major_to
		
    }); 
	loadExtractData();
}
//已经设置过了，需要加载各表格数据
function loadExtractData(){
	$('#ext_table_cor').bootstrapTable("load", ext_data_cor); 
	$('#ext_table_person').bootstrapTable("load", ext_data_person); 
	
	$('#ext_table_major_to').bootstrapTable("load", ext_data_major_to); 
	$('#ext_table').bootstrapTable("load", ext_data); 
}



$(document).ready(function(){  
 
    initExtract();
});  

function ext_add_common(id) {
	console.log(id);
	
	var result= [
			'<button  type="button" class="btn btn-primary btn-xs" onclick="ext_add(\''+id+'\')">选择</button>', ]
			.join('');
	console.log(result);
	return result;
}
function nullFormatter(data) {  
  
    if(data==""||data==null||data==" ") {  
        return '未填';  
    }  
        return data;  
}  
function timeFormatter(data) {  
    if(data !=null){  
        data = transfromTime(data,true);  
    }  
    return data;  
}  


//创建抽取设置
function createExtractSet(assigneeId) {
    var deliver = $('#turnOverForm').serializeJson();
    console.log(deliver);
    var docArray = $("#turnFormDoc").bootstrapTable("getData");
    var docIds = $.map(docArray,function (obj) {
        return obj.id;
    });
    var revArray = $("#turnFormRec").bootstrapTable("getData");
    var revIds = $.map(revArray,function (obj) {
        return obj.id;
    });
    if(docArray.length==0&&revArray.length==0){
        alert("请选择要移交的文件");
        return;
    }

    deliver.docIds = docIds;
    deliver.revIds = revIds;
    deliver.assigneeId = assigneeId;
    var data = {flowFormAssist: deliver, docIds: docIds, revIds: revIds};
    $.axx({
        type:'post',
        url:'/flowFormDelivers',
        data:deliver,
        success:function (json) {
            alert("发起移交成功");
            $("#turnOver").removeClass("hidden").hide().fadeIn(500).siblings().addClass("hidden");
            getTurnOverFromMe1();
        }
    })
}
 