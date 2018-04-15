let selectedExpertNum = 0, expertTotal = 0;
const expert_modal_mapper = {// mapper the modal input id to the java model field name
    expert_id_input: 'expertId',
    expert_no_input: 'no',
    expert_card_input: 'card',
    expert_name_input: 'name',
    expert_phone_input: 'phone',
    expert_company_input: 'company',
    expert_record_flag_input: 'recordFlag',
    set_region: {name: 'regionList', isCheckbox: true}
};
const expert_table_cols = [{
    checkbox: true,
}, {
    field: 'no',
    title: '专家编号'
}, {
    field: 'card',
    title: '身份证号'
}, {
    field: 'name',
    title: '姓名'
}, {
    field: 'phone',
    title: '手机'
}, {
    field: 'company',
    title: '所在单位'
}, {
    field: 'region',
    title: '所在区域',
    visible: false
}, {
    field: 'record_flag',
    title: 'record_flag',
    visible: false
}];

var expert_col_major_from = [
    {
        field: 'id',
        visible: false
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
        formatter: expert_delete_major_from
    }
];

var expert_col_major_to = [
    {
        field: 'id',
        visible: false
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
        formatter: expert_delete_major_to
    }
];

function toggleExpertRelatedButton() {
    const selectedNum = $('#expert_table').bootstrapTable('getSelections').length;
    if (selectedNum === 0) {
        $('#createExpertButton').show();
        $('#editExpertButton').hide();
        $('#deleteExpertButton').hide();
    } else if (selectedNum === 1) {
        $('#createExpertButton').hide();
        $('#editExpertButton').show();
        $('#deleteExpertButton').show();
    } else if (selectedNum > 1) {
        $('#createExpertButton').hide();
        $('#editExpertButton').hide();
        $('#deleteExpertButton').show();
    }
}

function loadAllExperts() {
    $.axx({
        type: 'get',
        url: '/expert/all',
        success: function (json) {
            expertTotal = json.content.length;
            $('#expert_table').bootstrapTable("load", json.content);
            toggleExpertRelatedButton();
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    })
}

function showExpertTab() {
    $('#expertMaintenanceTab').tab('show');
    loadAllExperts();
}

function showExpertModal() {
    $('#expertModal').modal({
        show: true,
        remote: 'expertModal.html'
    });
}

function setMajorTable() {
    const fromOptions = {
        pagination: false,
        clickToSelect: true,
        uniqueId: 'majorCode',//唯一的标识
        searchAlign: 'left',
        columns: expert_col_major_from,
        toolbar: '#expert_major_from_toolbar'
    };

    $('#expert_modal_major_table_from').bootstrapTable(fromOptions);
    const toOptions = {
        pagination: false,
        clickToSelect: true,
        uniqueId: 'majorCode',//唯一的标识
        columns: expert_col_major_to,
        onEditableSave: function (field, row, oldValue, $el) {
        }
    };
    $('#expert_modal_major_table_to').bootstrapTable(toOptions);
}

function search_expert_major() {
    var val = $("#expert_modal_search_major_input").val();
    if (!val) {
        return;
    }
    var urlValue = "/major/search/name/";
    if ("code" == $("input:radio[name='search_expert_major_radio']:checked").val()) {
        urlValue = "/major/search/code/";
    }
    urlValue += val;

    $('#expert_modal_major_table_from').bootstrapTable('showLoading');

    $.ajax({
        type: 'GET',
        url: urlValue,
        success: function (json) {
            // console.log(json.content);
            $('#expert_modal_major_table_from').bootstrapTable("load", json.content);
            $('#expert_modal_major_table_from').bootstrapTable('hideLoading');
        }
    });
}

function setupExpertPage() {
    $('#expert_table').bootstrapTable({
        columns: expert_table_cols,
        pagination: false,
        clickToSelect: true,
        singleSelect: true,
        search: true,
        toolbar: '#expert_table_toolbar',
        onCheck: toggleExpertRelatedButton,
        onUncheck: toggleExpertRelatedButton
    });

    $('#expertModal').on('shown.bs.modal', function (event) {
        var modal = $(this);
        let selectedExpert = $('#expert_table').bootstrapTable('getSelections')[0];
        if (selectedExpert) {
            modal.find('.modal-title').text("编辑专家");
            setModalData(modal, expert_modal_mapper, selectedExpert);
        } else {
            modal.find('.modal-title').text("新建专家");
            setModalData(modal, expert_modal_mapper);
        }
        // initExpertTable('expert_modal_major_table_from', null, "expert_major_from_toolbar", 'expert_modal_major_table_to');
        setMajorTable();
    });

    $('#expertModal').on('hidden.bs.modal', function (event) {
        $(this).removeData("bs.modal");
    });

    $('#input-1a').fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/fileUpload/expert",
        uploadAsync: true,
        allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",

        layoutTemplates: {
            actionDelete: '',
            actionUpload: '',
        }
    });
    //同步上传错误结果处理
    $('#input-1a').on('filebatchuploaderror', function (event, data, msg) {

        console.log("sync error")
        $("#fileUpload").modal("hide");
        //records_detail_1
        // lookUploadFile(documentFile.documentLocalId);
        console.log("宋建强3" + "1" + event + "2" + data + "3" + msg);
    });

    //同步上传成功结果处理
    $('#input-1a').on('filebatchuploadsuccess', function (event, data, reviewId, index) {
        console.log("sync success");
        console.log("宋建强4" + "1" + event + "2" + data + "4" + index);
    });
}
function expert_remove(tableName, id, idKey) {
    $("#" + tableName).bootstrapTable('remove', {field: idKey, values: [id]});

};
function expert_add(id) {
    row = $("#expert_modal_major_table_from").bootstrapTable('getRowByUniqueId', id);
    // console.log(row);
    if (row) {
        $("#expert_modal_major_table_from").bootstrapTable('remove', {field: 'majorCode', values: [id]});
        $("#expert_modal_major_table_to").bootstrapTable('append', row);
    }
};
function expert_add_common(id) {
    var result = [
        '<button  type="button" class="btn btn-link btn-xs" onclick="expert_add(\'' + id + '\')">选择</button>',]
        .join('');
    return result;
}
function expert_delete_major_from(value, row, index) {
    return expert_delete_major('expert_modal_major_table_from', row.majorCode) + expert_add_common(row.majorCode);
}

function expert_delete_major_to(value, row, index) {
    return expert_delete_major('expert_modal_major_table_to', row.majorCode);
}

function expert_delete_major(tableName, id) {
    var result = [
        '<button  type="button" class="btn btn-link btn-xs" onclick="expert_remove(\'' + tableName + '\',\'' + id + '\',\'majorCode\')">删除</button>',]
        .join('');
    // console.log(result);
    return result;
}

function saveExpert() {
    let expert = $('#expertForm').serializeJson();

    let regionList = [];
    if (expert.set_region) {
        if (isArray(expert.set_region)) {
            expert.set_region.forEach(function (regionValue) {
                regionList.push({region: regionValue});
            });
            delete expert.set_region;
        } else {
            regionList.push({region: expert.set_region});
        }
    }
    expert.regionList = regionList;

    const selectedMajor = $("#expert_modal_major_table_to").bootstrapTable("getData");

    // let majorList = [];
    expert.majorList = selectedMajor;
    if (expert.expertId) {//update
        $.axx({
            type: 'put',
            url: '/expert',
            contentType: 'application/json',
            data: JSON.stringify(expert),
            success: function (json) {
                loadAllExperts();
                $('#expertModal').modal('hide');
            },
            error: function (res) {
                console.log(res);
                alert(res);
            }
        });
    } else {//create
        $.axx({
            type: 'post',
            url: '/expert',
            contentType: 'application/json',
            data: JSON.stringify(expert),
            success: function (json) {
                loadAllExperts();
                $('#expertModal').modal('hide');
            },
            error: function (res) {
                console.log(res);
                alert(res);
            }
        });
    }
}

function deleteExperts() {
    const ids = $('#expert_table').bootstrapTable('getSelections').map(function (item) {
        return item.expertId;
    });
    $.axx({
        type: 'delete',
        url: '/expert',
        contentType: 'application/json',
        data: JSON.stringify(ids),
        success: function (json) {
            loadAllExperts();
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    });
}

