function getMajorTree() {

    var tree = [];
    var recycleNodes = [];
    $.ajax({
        type: 'GET',
        url: '/major/tree/0',
        data: {},
        dataType: 'json',
        success: function (json) {
            models = json.content;
            for (var i = 0; i < models.length; i++) {
                var nodes = [];
                tree.push(new TreeModel(models[i].majorName, models[i].majorCode, nodes));
            }
            initMajorTree(tree);

        }
    });

}

//树状对象
function TreeModel(text, id, node) {
    this.text = text;
    this.id = id;
    this.href = '#majorTab';
    this.nodes = node;
}

function initMajorTree(depart) {
    var list = {
        bootstrap2: false,
        showTags: true,
        levels: 0,
        enableLinks: true,
        selectedIcon: "glyphicon glyphicon-map-marker",
        showBorder: false,
        data: depart
    };
    $('#majorTree').treeview(list);
    // console.log(depart);

    //获取左侧树节点信息
    $('#majorTree').on('nodeSelected', function (event, data) {
        if (data.nodes != null) {
            var select_node = $('#majorTree').treeview('getSelected');
            $('#tabNav a[href="#majorTab"]').tab('show');
            if (select_node[0].state.expanded) {
                $('#majorTree').treeview('collapseNode', select_node);
                select_node[0].state.selected = false;
            }
            else {
                $('#majorTree').treeview('expandNode', select_node);
                select_node[0].state.selected = false;
            }
        } else {


        }
    });
    $('#majorTree').on("nodeExpanded", function (event, node) {
        getChildMajor($('#majorTree'), node);
    });
}

function getChildMajor(tree, node) {
    console.log(node);
    $.axx({
        url: '/major/tree/' + node.id,
        type: 'get',
        data: {},
        // dataType:'json',
        success: function (json) {
            var models = json.content;
            //tree.treeview('deleteNode',[node.nodeId]);
            if (models.length == 0)
                node.nodes == null;
            for (var j = 0; j < models.length; j++) {
                tree.treeview('addNode', [node.nodeId,
                    {node: new TreeModel(models[j].majorName, models[j].majorCode, [])}]);
            }
        }
    });
}


getMajorTree();


