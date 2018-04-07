function change_panel(id, id_hide) {
    $('#panel' + id).show();
    $('#panel' + id_hide).hide();
    $('#nav' + id).toggleClass("active");
    $('#nav' + id_hide).toggleClass("active");
}

Array.prototype.contains = function (needle) {
    for (i in this) {
        if (this[i] == needle) return true;
    }
    return false;
}
var names = new Array();

function toggle_expert(name) {
    var idx = $.inArray(name, names);
    console.log(name + idx);
    if (idx != -1) {
        console.log(name + 'in array');
        names.pop(name);
    } else {
        names.push(name);
    }
    var content = "";
    $.each(names, function (index, value) {
        content += "<li>" + names[index] + "</li>";
    });
    $("#total").empty();
    $("#total").append(names.length);

    $("#expert_list").empty();
    $("#expert_list").append(content);
}

function showCreateProjectModal() {
    $('#commonModal').modal({
        backdrop: 'static',//点击空白不关闭
        keyboard: true, //esc时关闭
        remote: 'createProjectModal.html'
    });
}

function showCreateExtractModal() {
    $('#commonModal').modal({
        backdrop: 'static',//点击空白不关闭
        keyboard: true, //esc时关闭
        remote: 'createExtractModal.html'
    });
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

// function deleteProject(){
//     const selectedProject = $('#project_list_table').bootstrapTable('getSelections');
//     const ids = selectedProject.map(function (item) {
//         return item.id;
//     });
//     console.log(ids);
//     $.axx({
//         type: 'delete',
//         url: '/projects',
//         data: JSON.stringify(ids),
//         contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
//         success: function (json) {
//             loadAllProjects();
//         },
//         error: function (res) {
//             console.log(res);
//             alert(res);
//         }
//     });
// }
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

function createExtract() {
    let t = JSON.stringify($('#createProjectForm').serializeJson());
    let t2 = {purchaseCode: 'aaa'};
    $.axx({
        type: 'post',
        url: '/projects/create',
        data: JSON.stringify($('#createProjectForm').serializeJson()),
        contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
        success: function (json) {
            $('#commonModal').hide();
        }
    });
}
