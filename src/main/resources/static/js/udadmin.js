//set界面的四个table set_table_cor,set_table_person,white_table_from,white_table_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//
function getProjectId() {
	$table=$("project_list_table");
    if ($table.bootstrapTable("getSelections").length != 1) {
        alert('请选择一个记录');
        throw "select error";
    } else {
        return $table.bootstrapTable("getSelections")[0].flowId;
    }
}
function set_remove(tableName, id) {
    //console.log('set_remove_cor');
    console.log('1 ' + tableName);
    console.log('2 ' + id);

    $("#" + tableName).bootstrapTable('remove', {field: 'expertId', values: [id]});

};

function set_add(id) {
    //console.log('set_remove_cor');
    console.log('set_add.id ');
    console.log(id);

    row = $("#white_table_from").bootstrapTable('getRowByUniqueId', id);
    console.log(row);
    if (row) {
        $("#white_table_from").bootstrapTable('remove', {field: 'expertId', values: [id]});
        $("#white_table_to").bootstrapTable('append', row);
    }
};




var set_col_from = [
    {
        field: 'expertId',
        visible: false
    },
    {
        field: 'state',
        checkbox: true
    },
    {
        title: '专家姓名',
        field: 'name',
        align: 'center',
        sortable: true
    },
    {
        title: '专家电话',
        field: 'phone',
        align: 'center',
        sortable: true
    },
    {
        field: 'removerow',
        title: '',
        align: 'center',
        formatter: set_delete_from
    }
];
var set_col_to = [
    {
        field: 'expertId',
        visible: false
    },
    {
        field: 'state',
        checkbox: true
    },
    {
        title: '专家姓名',
        field: 'name',
        align: 'center',
        sortable: true
    },
    {
        title: '专家电话',
        field: 'phone',
        align: 'center',
        sortable: true
    },
    {
        field: 'removerow',
        title: '',
        align: 'center',
        formatter: set_delete_to
    }
];



function search_set_expert() {

    var val = $("#search_expert_input").val();
    if (!val) {
        return;
    }
    var urlValue = "/expert/search/name/";
    if ("phone" == $("input:radio[name='search_expert_radio']:checked").val()) {
        urlValue = "/expert/search/phone/";
    }
    urlValue += val;


    $.ajax({
        type: 'GET',
        url: urlValue,
        success: function (json) {
            console.log(json.content);
            $('#white_table_from').bootstrapTable("removeAll");
            $('#white_table_from').bootstrapTable("load", json.content);

        }
    });
};


function set_extract_submit() {
    console.log("  set_extract_submit start   ");
    
    var projectId=getProjectId();
    var deliver={"projectId":projectId};
    white = $("#white_table_to").bootstrapTable("getData");

    deliver.whiteList=white;

    var data = {set: deliver};
    console.log(JSON.stringify(deliver));
    $.axx({
        type: 'post',
        url: '/white',
        data: JSON.stringify(deliver),
        contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
        success: function (json) {
            alert("设置成功");
            
        }
    });
}

function initSet() {
    $("input:radio[name='search_expert_radio']:first").attr('checked', 'true');
   
    $('#white_table_from').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        uniqueId: 'expertId',//唯一的标识
        columns: set_col_from
    });
    $('#white_table_to').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        uniqueId: 'expertId',//唯一的标识
        columns: set_col_to,
        onEditableSave: function (field, row, oldValue, $el) {

        }
    });


    $("#search_expert_button").click(search_set_expert);

    $("#search_expert_submit_button").click(set_extract_submit);

   
}


$('#whiteExpert').on('show.bs.modal', function (event) {
    console.log("show.bs.modal");
    console.log(event);
	var projectId=getProjectId();
    $.axx({
        type:'GET',
        url:"/white/get/"+projectId,
        success:function (json) {
            var models = json.content;
            console.log(models);
          
            $('#white_table_to').bootstrapTable("load", models);
            
        }
    });	
});


$(document).ready(function () {

    initSet();
});


function set_delete_from(value, row, index) {
	console.log(row);
    return set_delete_common('white_table_from', row.expertId) + set_add_common(row.expertId);
}

function set_delete_to(value, row, index) {
    return set_delete_common('white_table_to', row.expertId);
}

function set_delete_common(tableName, id) {
    var result = [
        '<button  type="button" class="btn btn-primary btn-xs" onclick="set_remove(\'' + tableName + '\',' + id + ')">删除</button>',]
        .join('');
    console.log(result);
    return result;
}

function set_add_common(id) {
    console.log(id);

    var result = [
        '<button  type="button" class="btn btn-primary btn-xs" onclick="set_add(' + id + ')">选择</button>',]
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
 