let selectedExpertNum = 0, expertTotal = 0;
const expert_modal_mapper = {// mapper the modal input id to the java model field name
    expert_id_input: 'expertId',
    expert_no_input: 'no',
    expert_card_input: 'card',
    expert_name_input: 'name',
    expert_phone_input: 'phone',
    expert_company_input: 'company',
    set_region: {name: 'regionList', isCheckbox: true}
};
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
            toggleExpertRelatedButton();
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
            setModalData(modal, expert_modal_mapper, selectedExpert);
        } else {
            setModalData(modal, expert_modal_mapper);
        }
        // initExpertTable('set_table_major_from', set_col_major_from, 'set_table_major_from_toolbar', 'set_table_major_to', set_col_major_to);
        initExpertTable('expert_modal_major_table_from', null, null, 'expert_modal_major_table_to');
    })
}

function saveExpert() {
    let expert = $('#expertForm').serializeJson();

    let regionList = [];
    if (expert.set_region) {
        if (isArray(expert.set_region)) {
            expert.set_region.forEach(function (region) {
                regionList.push({region: regionMap[region]});
            });
            delete expert.set_region;
        } else {
            regionList.push({region: regionMap[expert.set_region]});
        }
    }
    expert.regionList = regionList;

    let majorList = [];
    expert.majorList = majorList;
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

