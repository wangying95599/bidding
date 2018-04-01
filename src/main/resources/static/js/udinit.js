var usrId;
var username;
var loginName;
var deptId;
var deptName;
var roleId;
var roleName;
var simpleDeptName;

var ARCHIVE_API = new Object();
ARCHIVE_API.dept_create = "/depts";
ARCHIVE_API.dept_list_root = "/depts";
ARCHIVE_API.dept_list_child = "/depts/{0}";
ARCHIVE_API.dept_update = "/depts";
ARCHIVE_API.dept_list_users = "/depts/{0}/users";
ARCHIVE_API.config_list = "/config";
ARCHIVE_API.user_detail = "/users/detail";
ARCHIVE_API.dept_byuser = "/depts/{0}/byuser";
BOSS_DEPT_ID = 4;
KMHK_DEPT_ID = 174;
INIT_PASSWORD = "0fedf119cd212806b710ca35cbfb4091";


//退出登录
function logOut() {
    $.axx({
        type: 'get',
        url: "logOut/users",
        data: {},
        success: function (json) {
            console.log(json.content);
            window.location.href = "/";
        }
    })
}


$(document).keydown(function (event) {
    if (event.keyCode == 13) {
        $('form').each(function () {
            event.preventDefault();
        });
    }
});


window.onload = function () {

    $.ajaxSetup({cache: false});

    getSessionUser();

}

function getSessionUser() {
    $.axx({
        url: ARCHIVE_API.user_detail,
        type: 'get',
        data: {},
        dataType: 'json',
        success: function (json) {
            contextUser = json.content;
            usrId = contextUser.id;
            username = contextUser.name;
            loginName = contextUser.loginName;
            $('#loginName').html(username)
            loadingUser(usrId);


        }
    })
}


function loadingUser(userId) {
    $.axx({
        type: 'get',
        url: "/users/loading/" + userId,
        data: {},
        success: function (json) {
            var model = json.content;
            deptId = model.dept_id;
            deptName = model.deptname;
            simpleDeptName = model.description;
            roleId = model.role_id == null ? 7 : model.role_id;
            roleName = model.rolename == null ? "普通用户" : model.rolename;
            /*$.each(model, function (key, value) {
                console.log(key + "     " + value);
            })*/
            //处理菜单的权限
            if (roleId == 1 || roleId == 2) {
                $('.notglobal').removeClass("hidden");
            } else {
                $('.notglobal').remove();
            }


        }
    })

}