//set界面的四个table set_table_cor,set_table_person,set_table_major_from,set_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

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
	console.log(row);
	if(row){
		$("#set_table_major_from").bootstrapTable('remove', {field: 'id', values: [id]});
		$("#set_table_major_to").bootstrapTable('append', row);
	}
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
        field: 'company',  
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
        field: 'majorCode',  
        align: 'center',  
        sortable: true 
    } ,
	{  
        title: '专业名称',  
        field: 'majorName',  
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
        field: 'majorName',  
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
 function search_set_company(){
	  var value = $("#search_set_company_input").val();
      $.ajax({
          type:'GET',
          url:"/expert/search/company/"+value,
          success:function (json) {
              console.log(json.content);
             // $('#set_table_cor').bootstrapTable("append", json.content);
          	$.each(json.content, function(i, field){  
        	    console.log(i);   
        	    console.log(field);
        	    row = $('#set_table_cor').bootstrapTable("getRowByUniqueId", field.company);
        	    if(!row){
        	    	$('#set_table_cor').bootstrapTable("append", field);
        	    }
        	}); 
          }
      });
};
function search_set_expert(){

	var val = $("#search_set_expert_input").val();
	if(!val){
		return;
	}
	var urlValue="/expert/search/name/";
	if("phone" == $("input:radio[name='search_set_expert_radio']:checked").val()){
		urlValue="/expert/search/phone/";
	}
	urlValue+=val;
	
	
    $.ajax({
        type:'GET',
        url:urlValue,
        success:function (json) {
            console.log(json.content);
           
          	$.each(json.content, function(i, field){  
        	    console.log(i);   
        	    console.log(field);
        	    row = $('#set_table_person').bootstrapTable("getRowByUniqueId", field.id);
        	    if(!row){
        	    	$('#set_table_person').bootstrapTable("append", field);
        	    }
        	}); 
        }
    });
};
function search_set_major(){
	var val = $("#search_set_major_input").val();
	if(!val){
		return;
	}
	var urlValue="/major/search/name/";
	if("code" == $("input:radio[name='search_set_major_radio']:checked").val()){
		urlValue="/major/search/code/";
	}
	urlValue+=val;
	
	
    $.ajax({
        type:'GET',
        url:urlValue,
        success:function (json) {
            console.log(json.content);
           
          	$.each(json.content, function(i, field){  
        	    console.log(i);   
        	    console.log(field);
        	    row = $('#set_table_major_from').bootstrapTable("getRowByUniqueId", field.id);
        	    if(!row){
        	    	$('#set_table_major_from').bootstrapTable("append", field);
        	    }
        	}); 
        }
    });
}
function set_extract_submit(){
	console.log("  set_extract_submit start   ");
    var deliver = {'projectId':123};
    console.log(deliver);
    
    var companyArray = $("#set_table_cor").bootstrapTable("getData");
    var companyIds = $.map(companyArray,function (obj) {
        return obj.company;
    });
    
    var expertArray = $("#set_table_person").bootstrapTable("getData");
    var expertIds = $.map(expertArray,function (obj) {
        return obj.id;
    });
    
    var majorArray = $("#set_table_major_to").bootstrapTable("getData");
    var majorIds = $.map(majorArray,function (obj) {
        return obj.id;
    });
    
    var regionArray = $("input[name='set_region']:checked");
    var regionIds = $.map(regionArray,function (obj) {
        return obj.id;
    });

//    deliver.companyList = companyIds;
    deliver.expertList = expertIds;
    deliver.majorList = majorIds;
//    deliver.regionList = regionIds;
    console.log(deliver);
    var data = {set: deliver, expertList: expertIds,majorList:majorIds};
    $.axx({
        type:'post',
        url:'/extractset/create',
        data: deliver,
        success:function (json) {
            alert("设置成功");
           // $("#turnOver").removeClass("hidden").hide().fadeIn(500).siblings().addClass("hidden");
            //getTurnOverFromMe1();
        }
    });
}
function initSet(){
	$("input:radio[name='search_set_expert_radio']:first").attr('checked','true');
	$("input:radio[name='search_set_major_radio']:first").attr('checked','true');
	
	//
    $('#set_table_cor').bootstrapTable({  
        pagination:false,  
        uniqueId : 'company',//唯一的标识
		clickToSelect: true,
        columns:set_col_cor
    }); 
	
	
    $('#set_table_person').bootstrapTable({  
        pagination:false,  
        uniqueId : 'id',//唯一的标识
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
		uniqueId : 'id',//唯一的标识
        columns:set_col_major_to,
		onEditableSave: function (field, row, oldValue, $el) {
            
        }
    }); 
    
	$("#search_set_company_button").click(search_set_company);
	
	$("#search_set_expert_button").click(search_set_expert);
	
	$("#search_set_major_button").click(search_set_major);
	
	$("#set_extract_submit_button").click(set_extract_submit);
	
	loadJSData();
}
//已经设置过了，需要加载各表格数据
function loadJSData(){
//	$('#set_table_cor').bootstrapTable("load", set_data_cor); 
//	$('#set_table_person').bootstrapTable("load", set_data_person); 
//	$('#set_table_major_from').bootstrapTable("load", set_data_major_from); 
//	$('#set_table_major_to').bootstrapTable("load", set_data_major_to); 
	

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
	return set_delete_common('set_table_major_from',row.id)+set_add_common(row.id);
}
function set_delete_major_to(value, row, index) {
	return set_delete_common('set_table_major_to',row.id);
}
function set_delete_common(tableName,id) {
	var result= [
			'<button  type="button" class="btn btn-primary btn-xs" onclick="set_remove(\''+tableName+'\','+id+')">删除</button>', ]
			.join('');
	console.log(result);
	return result;
}
function set_add_common(id) {
	console.log(id);
	
	var result= [
			'<button  type="button" class="btn btn-primary btn-xs" onclick="set_add('+id+')">选择</button>', ]
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
 