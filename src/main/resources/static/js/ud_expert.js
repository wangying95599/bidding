let selectedExpertNum = 0, expertTotal = 0;
const expert_table_cols = [{
    checkbox: true,
}, {
    field: 'no',
    title: '专家编号'
}, {
    field: 'card',
    title: 'card'
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
    title: '所在区域'
}, {
    field: 'record_flag',
    title: 'record_flag'
}];

function loadAllExperts() {
    $.axx({
        type: 'get',
        url: '/expert/all',
        success: function (json) {
            expertTotal = json.content.length;
            $('#expert_table').bootstrapTable("load", json.content);
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

function toggleExpertRelatedButton(selectedNum) {
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

function setupExpertPage() {
    $('#expert_table').bootstrapTable({
        columns: expert_table_cols,
        pagination: false,
        clickToSelect: true,
        onCheck: function () {
            selectedExpertNum++;
            toggleExpertRelatedButton(selectedExpertNum);
        },
        onUncheck: function () {
            selectedExpertNum--;
            toggleExpertRelatedButton(selectedExpertNum);
        },
        onCheckAll: function () {
            selectedExpertNum = expertTotal;
            toggleExpertRelatedButton(selectedExpertNum);
        },
        onUncheckAll: function () {
            selectedExpertNum = 0;
            toggleExpertRelatedButton(selectedExpertNum);
        },
    });
}

