const expert_table_cols = [{
    field: 'no',
    title: '专家编号'
}, {
    field: 'card',
    title: ''
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
    title: ''
}];

function loadAllExperts() {
    $.axx({
        type: 'get',
        url: '/experts/all',
        success: function (json) {
            $('#expert_list_table').bootstrapTable("load", json.content);
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    })
}


function showExpertTab() {
    $('#extractExpertTab').tab('show');
    loadAllExperts();
}

function setupExpertPage() {
    $('#expert_list_table').bootstrapTable({
        columns: expert_table_cols,
        pagination: false,
        clickToSelect: true,
    });
}

