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

    $('#expertModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('title') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text(recipient);
        let selectedExpert = $('#expert_table').bootstrapTable('getSelections')[0];
        if (selectedExpert) {
            console.log(selectedExpert);
            modal.find('#expert_id_input').val(selectedExpert.expertId);
            modal.find('#expert_no_input').val(selectedExpert.no);
            modal.find('#expert_card_input').val(selectedExpert.card);
            modal.find('#expert_name_input').val(selectedExpert.name);
            modal.find('#expert_phone_input').val(selectedExpert.phone);
            modal.find('#expert_company_input').val(selectedExpert.company);
        }
    })
}

function saveExpert() {
    let expert = $('#expertForm').serializeJson();
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

