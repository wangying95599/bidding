function getTree() {

    // alert("usrId   "+usrId)
    var tree = [];
    var recycleNodes = [];
    $.axx({
        type:'GET',
        url: '/major/tree/0',
        data:{},
        dataType:'json',
        success:function(json){
            models = json.content;
            for(var i=0;i<models.length;i++){
                var nodes=[
                    {
                        text: "件级档案",
                        id: models[i].id,
                        deptName: models[i].name,
                        description:models[i].description,
                        tabName: "#arranged"
                    }
                ];
                tree.push(new obj(models[i].name,models[i].id,nodes));
               
            }
           departTree(tree);
            
        }
    });

}
function departTree(depart){
   var list = {
        bootstrap2: false,
        showTags: true,
        levels:0,
        enableLinks:true,
        selectedIcon:"glyphicon glyphicon-map-marker",
        showBorder:false,
        data: depart
    };
    $('#majorTree').treeview(list);
    // console.log(depart);

    //获取左侧树节点信息
    $('#majorTree').on('nodeSelected',function(event, data) {
        if (data.nodes != null) {
            var select_node = $('#majorTree').treeview('getSelected');
            if (select_node[0].state.expanded) {
                $('#majorTree').treeview('collapseNode', select_node);
                select_node[0].state.selected = false;
            }
            else {
                $('#majorTree').treeview('expandNode', select_node);
                select_node[0].state.selected = false;
            }
        } else {
            var num = $(this).index()
            deptId = data.id;
            var list = data.tabName;
            var text = data.text;
            //   console.log('id'+data.id);
            deptName = data.deptName;
            simpleDeptName=data.description;
            var str = "";
            listType = list;

            getFromLocalTable();
           
            var temporary = list == "#fromOA" ? "#fromLocal" : list;
            $(temporary).removeClass("hidden").hide().fadeIn(500).siblings().addClass("hidden");
            $("button[data-target='#biaoDan'],button[data-target='#modify'],.selectFile,.selectFile1").addClass("hidden");
            $('.breadcrumb').empty().append(
                "<li class='active' style='color: #4876FF' href=" + temporary + ">" + text +
                "</li>").removeClass("hidden");
            // defaultMessage;
        }
    });
}
function getFromLocalTable() {
    $('#btn_add,#btn_delete').removeClass("hidden");
    url = "/documents/page/" + deptId + "/type/1";
    initBootstrapTable('get', $('#fromLocalTable'), url, fromLocalCol, sortQueryParams, false, "application/x-www-form-urlencoded", '#localtoolbar');
}

//回收站部门列表
function recycleTree(nodes) {
    var list = {
        bootstrap2: false,
        showTags: true,
        levels:0,
        enableLinks:true,
        selectedIcon:"glyphicon glyphicon-map-marker",
        showBorder:false,
        data: nodes
    };
    $('#recycleOneTree').treeview(list);

    $('#recycleOneTree').on("nodeSelected",function (event,data) {
        if (data.nodes != null) {
            var select_node = $('#recycleOneTree').treeview('getSelected');
            if (select_node[0].state.expanded) {
                $('#recycleOneTree').treeview('collapseNode', select_node);
                select_node[0].state.selected = false;
            }
            else {
                $('#recycleOneTree').treeview('expandNode', select_node);
                select_node[0].state.selected = false;
            }
        } else {
            showRecycleBin(data.id,data.href.charAt(1));
            $('#recycleBin').removeClass("hidden").hide().fadeIn(500).siblings().addClass("hidden");
        }
    })
}
getTree();