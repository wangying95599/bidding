//set界面的四个table set_table_cor,set_table_person,set_table_major_from,set_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//
var set_data_cor=[{
	"state":false,
    "id": '1',
    'name': "张三",
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "张三2",
    "removerow" : ""
}];
var set_data_person=[{
	"state":false,
    "id": '1',
    'name': "张三",
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "张三2",
    "removerow" : ""
}];
var set_data_major_from=[{
	"state":false,
    "id": '1',
    'name': "张三",
	"no": '1',
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "张三2",
	"no": '2',
    "removerow" : ""
}];
var set_data_major_to=[{
	"state":false,
    "id": '1',
    'name': "张三",
	"size": '1',
    "removerow" : ""
},
{
	"state":false,
    "id": '2',
    'name': "张三2",
	"size": '2',
    "removerow" : ""
}];
function set_remove (tableName,id) {
	//console.log('set_remove_cor');
	console.log('1 '+tableName);
	console.log('2 '+id);	
	
	$("#"+tableName).bootstrapTable('remove', {field: 'id', values: [id]});

};
function set_add (id) {
	//console.log('set_remove_cor');
	console.log('set_add.id ');	
	console.log(id);	
	
	row= $("#set_table_major_from").bootstrapTable('getRowByUniqueId',id);
	//var selectedData = $('#set_table_major_from').bootstrapTable('getAllSelections');
	
	console.log(row);
	
	$("#set_table_major_from").bootstrapTable('remove', {field: 'id', values: [id]});
	$("#set_table_major_to").bootstrapTable('append', row);

};

var set_col_cor=[  
	{   field: 'id',  
        visible: false
    },
    {   field: 'state',  
        checkbox: true  
    },
	{  
        title: '回避单位名称',  
        field: 'name',  
        align: 'center',  
        sortable: true 
    } ,
	{
		field: 'removerow',
		title: '',
		 align: 'center', 
		formatter : set_delete_cor
	}
 ]  ;

var set_col_person=[  
	{   field: 'id',  
        visible: false
    },
    {   field: 'state',  
        checkbox: true  
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
    } ,
	{
		field: 'removerow',
		title: '',
		 align: 'center', 
		formatter : set_delete_person
	}
 ]  ;
 var set_col_major_from=[  
	{   field: 'id',  
        visible: false
    },
    {   field: 'state',  
        checkbox: true  
    },
	{  
        title: '编码',  
        field: 'no',  
        align: 'center',  
        sortable: true 
    } ,
	{  
        title: '专业名称',  
        field: 'name',  
        align: 'center',  
        sortable: true 
    } ,
	{
		field: 'removerow',
		title: '',
		 align: 'center', 
		formatter : set_delete_major_from
	}
 ]  ;
 var set_col_major_to=[  
	{   field: 'id',  
        visible: false
    },
    {   field: 'state',  
        checkbox: true  
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
		
    } ,
	{
		field: 'removerow',
		title: '',
		align: 'center', 
		formatter : set_delete_major_to
	}
 ]  ;
function initSet(){
	
	
	//
    $('#set_table_cor').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,
        columns:set_col_cor
    }); 
	
	
    $('#set_table_person').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,
        columns:set_col_person
    }); 
    $('#set_table_major_from').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,
		uniqueId : 'id',//唯一的标识
        columns:set_col_major_from
    }); 
    $('#set_table_major_to').bootstrapTable({  
        pagination:false,  
		clickToSelect: true,		
        columns:set_col_major_to,
		onEditableSave: function (field, row, oldValue, $el) {
            
        }
    }); 
	loadJSData();
}
//已经设置过了，需要加载各表格数据
function loadJSData(){
	$('#set_table_cor').bootstrapTable("load", set_data_cor); 
	$('#set_table_person').bootstrapTable("load", set_data_person); 
	$('#set_table_major_from').bootstrapTable("load", set_data_major_from); 
	$('#set_table_major_to').bootstrapTable("load", set_data_major_to); 
}



$(document).ready(function(){  
 
    initSet();
});  
function set_delete_cor(value, row, index) {
	return set_delete_common('set_table_cor',row.id);
}
function set_delete_person(value, row, index) {
	return set_delete_common('set_table_person',row.id);
}
function set_delete_major_from(value, row, index) {
	return set_delete_common('set_table_major_from',row.id)+set_add_common(index);
}
function set_delete_major_to(value, row, index) {
	return set_delete_common('set_table_major_to',row.id);
}
function set_delete_common(tableName,id) {
	var result= [
			'<button  type="button" class="btn btn-primary btn-xs" onclick="set_remove(\''+tableName+'\',\''+id+'\')">删除</button>', ]
			.join('');
	console.log(result);
	return result;
}
function set_add_common(id) {
	console.log(id);
	
	var result= [
			'<button  type="button" class="btn btn-primary btn-xs" onclick="set_add(\''+id+'\')">选择</button>', ]
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
 