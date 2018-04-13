//set界面的四个table set_table_cor,set_table_person,set_table_major_from,set_table_major_to
//$("#data_module_table").bootstrapTable('append', data.data);//data.data----->新增的数据
//$("#table_Id").bootstrapTable('remove', {field: 'id', values: [id]});//field:根据field的值来判断要删除的行  values：删除行所对应的值
//$('#table_Id').bootstrapTable('updateRow', {index: checkIndex, row: data.data});//index---->更新行的索引。row---->要更新的数据
//

function set_remove(tableName, id, idKey) {
    //console.log('set_remove_cor');
    console.log('1 ' + tableName);
    console.log('2 ' + id);

    var idStr = 'id';
    if (idKey) {
        idStr = idKey;
    }
    console.log('3 ' + idStr);
    $("#" + tableName).bootstrapTable('remove', {field: idStr, values: [id]});

};

function set_add(id) {
    //console.log('set_remove_cor');
    console.log('set_add.id ');
    console.log(id);

    row = $("#set_table_major_from").bootstrapTable('getRowByUniqueId', id);
    console.log(row);
    if (row) {
        $("#set_table_major_from").bootstrapTable('remove', {field: 'id', values: [id]});
        $("#set_table_major_to").bootstrapTable('append', row);
    }
};

var set_col_cor = [
    {
        field: 'id',
        visible: false
    },
    {
        field: 'state',
        checkbox: true
    },
    {
        title: '回避单位名称',
        field: 'company',
        align: 'center',
        sortable: true
    },
    {
        field: 'removerow',
        title: '',
        align: 'center',
        formatter: set_delete_cor
    }
];

var set_col_person = [
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
        formatter: set_delete_person
    }
];
var set_col_major_from = [
    {
        field: 'id',
        visible: false
    },
    {
        field: 'state',
        checkbox: true
    },
    {
        title: '编码',
        field: 'majorCode',
        align: 'center',
        sortable: true
    },
    {
        title: '专业名称',
        field: 'majorName',
        align: 'center',
        sortable: true
    },
    {
        field: 'removerow',
        title: '',
        align: 'center',
        formatter: set_delete_major_from
    }
];
var set_col_major_to = [
    {
        field: 'id',
        visible: false
    },
    {
        field: 'state',
        checkbox: true
    },

    {
        title: '专业名称',
        field: 'majorName',
        align: 'center',
        sortable: true
    },
    {
        title: '人数',
        field: 'majorNumber',
        align: 'center',
        formatter: nullFormatter,
        editable: {
            type: 'text',
            title: '人数',
            validate: function (v) {
                if (!v) return '必须设置人数';
                if (isNaN(v)) return '人数必须是数字';
                var age = parseInt(v);
                if (age <= 0) return '人数必须是正整数';

            }
        }

    },
    {
        field: 'removerow',
        title: '',
        align: 'center',
        formatter: set_delete_major_to
    }
];

function search_set_company() {
    var value = $("#search_set_company_input").val();
    $.ajax({
        type: 'GET',
        url: "/expert/search/company/" + value,
        success: function (json) {
            console.log(json.content);
            // $('#set_table_cor').bootstrapTable("append", json.content);
            $.each(json.content, function (i, field) {
                console.log(i);
                console.log(field);
                let row = $('#set_table_cor').bootstrapTable("getRowByUniqueId", field.company);
                if (!row) {
                    $('#set_table_cor').bootstrapTable("append", field);
                }
            });
        }
    });
};

function search_set_expert() {

    var val = $("#search_set_expert_input").val();
    if (!val) {
        return;
    }
    var urlValue = "/expert/search/name/";
    if ("phone" == $("input:radio[name='search_set_expert_radio']:checked").val()) {
        urlValue = "/expert/search/phone/";
    }
    urlValue += val;


    $.ajax({
        type: 'GET',
        url: urlValue,
        success: function (json) {
            console.log(json.content);

            $.each(json.content, function (i, field) {
//                console.log(i);
//                console.log(field);
                row = $('#set_table_person').bootstrapTable("getRowByUniqueId", field.expertId);
                if (!row) {
                    $('#set_table_person').bootstrapTable("append", field);
                }
            });
        }
    });
};

function search_set_major() {
    var val = $("#search_set_major_input").val();
    if (!val) {
        return;
    }
    var urlValue = "/major/search/name/";
    if ("code" == $("input:radio[name='search_set_major_radio']:checked").val()) {
        urlValue = "/major/search/code/";
    }
    urlValue += val;

    $('#set_table_major_from').bootstrapTable('showLoading');


    $.ajax({
        type: 'GET',
        url: urlValue,
        success: function (json) {
            console.log(json.content);
            $('#set_table_major_from').bootstrapTable("removeAll");
            $('#set_table_major_from').bootstrapTable("load", json.content);
            $('#set_table_major_from').bootstrapTable('hideLoading');
        }
    });
}

function set_extract_submit() {
    console.log("  set_extract_submit start   ");
    var deliver = {'projectId': getProjectId()};
    console.log(deliver);

    var companyArray = $("#set_table_cor").bootstrapTable("getData");
    var expertArray = $("#set_table_person").bootstrapTable("getData");
    var majorArray = $("#set_table_major_to").bootstrapTable("getData");

    var regionArray = $("input[name='set_region']:checked");
    var region = [];
    $.each(regionArray, function (i, item) {
        region.push({"region": item.value});
    });

    deliver.companyList = companyArray;
    deliver.expertList = expertArray;
    deliver.majorList = majorArray;
    deliver.regionList = region;

    console.log(deliver.companyList);
    console.log(companyArray);

    var data = {set: deliver};
    console.log(JSON.stringify(data));
    $.axx({
        type: 'post',
        url: '/extractset/create',
        data: JSON.stringify(deliver),
        contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
        success: function (json) {
            alert("设置成功");
            // $("#turnOver").removeClass("hidden").hide().fadeIn(500).siblings().addClass("hidden");
            //getTurnOverFromMe1();
        }
    });
}

function initExpertTable(fromTable, fromTableColumns, fromTableToolbar, toTable, toTableColumns, toTableToolbar) {
    const fromOptions = {
        pagination: false,
        clickToSelect: true,
        uniqueId: 'id',//唯一的标识
        searchAlign:'left',
        columns: fromTableColumns ? fromTableColumns : set_col_major_from,
    };
    if (fromTableToolbar) {
        fromOptions.toolbar = '#' + fromTableToolbar;
    }
    $('#' + fromTable).bootstrapTable(fromOptions);
    const toOptions = {
        pagination: false,
        clickToSelect: true,
        uniqueId: 'id',//唯一的标识
        columns: toTableColumns ? toTableColumns : set_col_major_to,
        onEditableSave: function (field, row, oldValue, $el) {
        }
    };
    if (toTableToolbar) {
        toOptions.toolbar = '#' + toTableToolbar;
    }
    $('#' + toTable).bootstrapTable(toOptions);
}

function initSet() {
	console.log("initSet");
	
    $("input:radio[name='search_set_expert_radio']:first").attr('checked', 'true');
    $("input:radio[name='search_set_major_radio']:first").attr('checked', 'true');

    //
    $('#set_table_cor').bootstrapTable({
        pagination: false,
        uniqueId: 'company',//唯一的标识
        clickToSelect: true,
        columns: set_col_cor
    });

    $('#set_table_person').bootstrapTable({
        pagination: false,
        uniqueId: 'expertId',//唯一的标识
        clickToSelect: true,
        columns: set_col_person
    });

    initExpertTable('set_table_major_from', set_col_major_from, 'set_table_major_from_toolbar', 'set_table_major_to', set_col_major_to);

    $("#search_set_company_button").click(search_set_company);

    $("#search_set_expert_button").click(search_set_expert);

    $("#search_set_major_button").click(search_set_major);

    $("#set_extract_submit_button").click(set_extract_submit);

    loadJSData();
}

//已经设置过了，需要加载各表格数据
function loadJSData() {
//	$('#set_table_cor').bootstrapTable("load", set_data_cor); 
//	$('#set_table_person').bootstrapTable("load", set_data_person); 
//	$('#set_table_major_from').bootstrapTable("load", set_data_major_from); 
//	$('#set_table_major_to').bootstrapTable("load", set_data_major_to); 

}

function clearAllSetValue() {
    var extractSetForm = $('#extractSet');

    extractSetForm.find('#project_name_set').val(null);
    extractSetForm.find('#project_purchaser_set').val(null);
    extractSetForm.find('#proxy_org_set').val(null);
    extractSetForm.find('#project_extract_set').val(null);
    extractSetForm.find('#bidding_time_set').val(null);
    extractSetForm.find('#bidding_location_set').val(null);
    extractSetForm.find('#bidding_period_set').val(null);

    $('#set_table_cor').bootstrapTable("removeAll");
    $('#set_table_person').bootstrapTable("removeAll");
    $('#set_table_major_to').bootstrapTable("removeAll");
    $('#set_table_major_from').bootstrapTable("removeAll");

    $("input[name='set_region']").removeAttr("checked");

    $("#search_set_company_input").val(null);
    $("#search_set_expert_input").val(null);
    $("#search_set_major_input").val(null);

}

$('#extractSet').on('show.bs.modal', function (event) {
    console.log("extractSet show.bs.modal");
    console.log(event);
    clearAllSetValue();

    projectId = getProjectId();
    $.axx({
        type: 'GET',
        url: "/extractset/get/" + projectId,
        success: function (json) {
            var models = json.content;
            console.log(models);
            console.log(models.regionList);
            let selectedProject = $('#project_list_table').bootstrapTable('getSelections')[0];
            if (selectedProject) {
                var extractSetForm = $('#extractSet');

                extractSetForm.find('#project_name_set').val(selectedProject.purchaseProject);
                extractSetForm.find('#project_purchaser_set').val(selectedProject.purchaseCompany);
                extractSetForm.find('#proxy_org_set').val(selectedProject.proxyOrg);
                extractSetForm.find('#project_extract_set').val(selectedProject.extractCompany);
                extractSetForm.find('#bidding_time_set').val(selectedProject.biddingTime);
                extractSetForm.find('#bidding_location_set').val(selectedProject.biddingLocation);
                extractSetForm.find('#bidding_period_set').val(selectedProject.biddingPeriod);

            }
            if (models.companyList) {
                $('#set_table_cor').bootstrapTable("load", models.companyList);
            }
            if (models.expertList) {
                $('#set_table_person').bootstrapTable("load", models.expertList);
            }
            if (models.majorList) {
                $('#set_table_major_to').bootstrapTable("load", models.majorList);
            }
            //console.log(models.regionList);
            if (models.regionList) {
                //（jquery1.9以上，checkbox attr不能重复操作）可使用prop代替
                $.each(models.regionList, function (i, item) {
                    $("input[name='set_region'][value=" + item.region + "]").prop("checked", "checked");
                });
            }

        }
    });
});


$(document).ready(function () {

    initSet();
});

function set_delete_cor(value, row, index) {
    return set_delete_common('set_table_cor', row.id);
}

function set_delete_person(value, row, index) {

    var tableName = 'set_table_person';
    var id = row.expertId;
    var result = [
        '<button  type="button" class="btn btn-link btn-xs" onclick="set_remove(\'' + tableName + '\',' + id + ',\'expertId\')">删除</button>',]
        .join('');
    //console.log(result);
    return result;
}

function set_delete_major_from(value, row, index) {
    return set_delete_common('set_table_major_from', row.id) + set_add_common(row.id);
}

function set_delete_major_to(value, row, index) {
    return set_delete_common('set_table_major_to', row.id);
}

function set_delete_common(tableName, id) {
    var result = [
        '<button  type="button" class="btn btn-link btn-xs" onclick="set_remove(\'' + tableName + '\',' + id + ')">删除</button>',]
        .join('');
    console.log(result);
    return result;
}

function set_add_common(id) {
    console.log(id);

    var result = [
        '<button  type="button" class="btn btn-link btn-xs" onclick="set_add(' + id + ')">选择</button>',]
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
 