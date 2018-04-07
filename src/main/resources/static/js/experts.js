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

function showEditProjectModal() {
    const project = $("#project_list_table").bootstrapTable("getSelections")[0];
    $('#commonModal').modal({
        backdrop: 'static',//点击空白不关闭
        keyboard: true, //esc时关闭
        remote: 'createProjectModal.html'
    });
    setFormWithJson('createProjectForm', project);
}

function setFormWithJson(formId, jsonValue) {
    var obj = $('#' + formId);
    $.each(jsonValue, function (name, ival) {
        var $oinput = obj.find("input:[name=" + name + "]");
        if ($oinput.attr("type") == "radio" || $oinput.attr("type") == "checkbox") {
            $oinput.each(function () {
                if (Object.prototype.toString.apply(ival) == '[object Array]') {//是复选框，并且是数组
                    for (var i = 0; i < ival.length; i++) {
                        if ($(this).val() == ival[i])
                            $(this).attr("checked", "checked");
                    }
                } else {
                    if ($(this).val() == ival)
                        $(this).attr("checked", "checked");
                }
            });
        } else if ($oinput.attr("type") == "textarea") {//多行文本框
            obj.find("[name=" + name + "]").html(ival);
        } else {
            obj.find("[name=" + name + "]").val(ival);
        }
    });
}

function showCreateExtractModal() {
    $('#commonModal').modal({
        backdrop: 'static',//点击空白不关闭
        keyboard: true, //esc时关闭
        remote: 'createExtractModal.html'
    });
}

function addAProject() {
    let str = '{"purchaseCode":"1","purchaseProject":"","purchaseCompany":"","proxyOrg":"XX代理","extractCompany":"","biddingTime":null,"biddingLocation":"","biddingPeriod":"","purchaseType":"竞争性谈判","smsInfo":""}';
    console.log(JSON.stringify(str));
    let p = {
        purchaseCode: '1',
        purchaseProject: 'ttt'
    };
    console.log(JSON.stringify(p));
    $.axx({
        type: 'post',
        url: '/projects/create',
        data: JSON.stringify(p),
        contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
        success: function (json) {
            loadAllProjects();
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    })
}

function createProject() {
    $.axx({
        type: 'post',
        url: '/projects/create',
        data: JSON.stringify($('#createProjectForm').serializeJson()),
        contentType: 'application/json',        //有关不能传递复杂类型的问题：这个要设置
        success: function (json) {
            $('#commonModal').hide();
            $('body').removeClass('modal-open');
            $('.modal-backdrop').remove();
        },
        error: function (res) {
            console.log(res);
            alert(res);
        }
    });
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
