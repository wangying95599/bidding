let selectedNum = 0, projectTotal = 0;
const project_modal_mapper = {// mapper the modal input id to the java model field name
        project_id_input: 'id',
        project_code_input: 'purchaseCode',
        project_name_input: 'purchaseProject',
        project_purchaser_input: 'purchaseCompany',
        project_extract_input: 'extractCompany',
        bidding_time_input: 'biddingTime',
        bidding_location_input: 'biddingLocation',
        bidding_period_input: 'biddingPeriod',
        messages_text_area: 'smsInfo',
    }
;

function getProjectId() {
    $table = $("#project_list_table");
    if ($table.bootstrapTable("getSelections").length != 1) {
        throw "select error";
    } else {
        return $table.bootstrapTable("getSelections")[0].id;
    }
}

//project,no,bid,date,extract,name,build，company,agent,org,purchase,mode,expert,state

var project_list_col = [
    {
        checkbox: true
    },
    {
        field: 'id',
        visible: false
    },
    {
        title: '项目编号',
        field: 'purchaseCode',
        align: 'center',
        sortable: true
    },
    {
        title: '评标时间',
        field: 'biddingTime',
        align: 'center',
        sortable: true
    },
    {
        title: '项目名称',
        field: 'purchaseProject',
        align: 'center',
        sortable: true
    },
    {
        title: '抽取时间',
        field: 'extractDate',
        align: 'center',
        sortable: true
    },
    {
        title: '建设单位',
        field: 'purchaseCompany',
        align: 'center',
        sortable: true
    },
    {
        title: '代理机构',
        field: 'proxyOrg',
        align: 'center',
        sortable: true
    },
    {
        title: '抽取单位',
        field: 'extractCompany',
        align: 'center',
        sortable: true
    },
    {
        title: '采购方式',
        field: 'purchaseType',
        align: 'center',
        sortable: true
    },
    {
        title: '专家选取状态',
        field: 'expertState',
        align: 'center',
        sortable: true
    },
];

function toggleProjectRelatedButtons(selectedNum) {
    // const selectedNum = $("#project_list_table").bootstrapTable('getSelections').length;
    if (selectedNum === 1) {
        $('#createProjectButton').hide();
        $('#editProjectButton').show();
        $('#removeProjectButton').show();
        $('#extractSetButton').show();
        $('#extractSetButton').show();
        $('#extractExpertsButton').show();
        $('#noteButton').show();
    } else if (selectedNum > 1) {
        $('#createProjectButton').hide();
        $('#editProjectButton').hide();
        $('#removeProjectButton').show();
        $('#extractSetButton').hide();
        $('#extractSetButton').hide();
        $('#extractExpertsButton').hide();
        $('#noteButton').hide();
    } else if (selectedNum === 0) {
        $('#createProjectButton').show();
        $('#editProjectButton').hide();
        $('#removeProjectButton').hide();
        $('#extractSetButton').hide();
        $('#extractSetButton').hide();
        $('#extractExpertsButton').hide();
        $('#noteButton').hide();
    }
}

function loadAllProjects() {
    selectedNum = 0;
    $.axx({
        type: 'get',
        url: '/projects/all',
        success: function (json) {
            projectTotal = json.content.length;
            $('#project_list_table').bootstrapTable("load", json.content);
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    })
}

function setUpProjectPage() {
    $('#project_list_table').bootstrapTable({
        pagination: false,
        clickToSelect: true,
        uniqueId: 'id',//唯一的标识
        totalField: '总数：',
        columns: project_list_col,
        toolbar: '#project_table_toolbar',
        search: true,
        showLoading: true,
        onCheck: function () {
            selectedNum++;
            toggleProjectRelatedButtons(selectedNum);
        },
        onUncheck: function () {
            selectedNum--;
            toggleProjectRelatedButtons(selectedNum);
        },
        onCheckAll: function () {
            selectedNum = projectTotal;
            toggleProjectRelatedButtons(selectedNum);
        },
        onUncheckAll: function () {
            selectedNum = 0;
            toggleProjectRelatedButtons(selectedNum);
        },
    });
    loadAllProjects();

    $('#projectModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('title') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text(recipient);
        let selectedProject = $('#project_list_table').bootstrapTable('getSelections')[0];
        if (selectedProject) {
            console.log(selectedProject);
            setModalData(modal, project_modal_mapper, selectedProject);
        } else {
            setModalData(modal, project_modal_mapper);
        }
    });
}

function createProject() {
    const project = $('#createProjectForm').serializeJson();
    if (project.id) {
        $.axx({
            type: 'put',
            url: '/projects',
            data: JSON.stringify(project),
            contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
            success: function (json) {
                $('#projectModal').hide();
                $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
                loadAllProjects();
            },
            error: function (res) {
                console.log(res);
                alert(res);
            }
        });
    } else {
        $.axx({
            type: 'post',
            url: '/projects/create',
            data: JSON.stringify(project),
            contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
            success: function (json) {
                $('#projectModal').hide();
                $('body').removeClass('modal-open');
                $('.modal-backdrop').remove();
                loadAllProjects();
            },
            error: function (res) {
                console.log(res);
                alert(res);
            }
        });
    }
}

function deleteProject() {
    const selectedProject = $('#project_list_table').bootstrapTable('getSelections');
    const ids = selectedProject.map(function (item) {
        return item.id;
    });
    console.log(JSON.stringify(ids));
    $.axx({
        type: 'delete',
        url: '/projects/delete',
        data: JSON.stringify(ids),
        contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
        success: function (json) {
            loadAllProjects();
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    });
}