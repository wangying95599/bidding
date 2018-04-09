function getMajorTree() {

    var tree = [];
    var recycleNodes = [];
    $.ajax({
        type:'GET',
        url: '/major/tree/0',
        data:{},
        dataType:'json',
        success:function(json){
            models = json.content;
            for(var i=0;i<models.length;i++){
                var nodes=[];
                tree.push(new TreeModel(models[i].majorName,models[i].majorCode,nodes));
            }
           initMajorTree(tree);
            
        }
    });

}
//树状对象
function TreeModel(text,id,node){
    this.text=text;
    this.id=id;
    this.href='#';
    this.nodes=node;
}
function initMajorTree(depart){
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
            
            
        }
    });
    $('#majorTree').on("nodeExpanded",function(event, node) {
    	 getChildMajor( $('#majorTree'),node);
      });
}
function getChildMajor(tree,node) {
	console.log(node);
	  $.axx({
	    url: '/major/tree/'+node.id,
	    type: 'get',
	    data: {},
	    // dataType:'json',
	    success: function (json) {
	      var models = json.content;
	      //tree.treeview('deleteNode',[node.nodeId]);
	      if(models.length ==0)
	        node.nodes ==null;
	      for(var j=0;j<models.length;j++) {
	        tree.treeview('addNode', [node.nodeId,
	          {node: new TreeModel(models[j].majorName, models[j].majorCode,[])}]);
	      }
	    }
	  });
	}


getMajorTree();


$('#input-1a').fileinput({
    language: 'zh', //设置语言
    uploadUrl: "/fileUpload/expert",
    uploadAsync: true,
    allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
    showUpload: true, //是否显示上传按钮
    showCaption: true,//是否显示标题
    browseClass: "btn btn-primary", //按钮样式
    maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
    //minFileCount: 0,
     maxFileCount: 1, //表示允许同时上传的最大文件个数
    msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
   
    layoutTemplates: {
        actionDelete: '',
        actionUpload: '',
    }
});
//同步上传错误结果处理
$('#input-1a').on('filebatchuploaderror', function(event, data, msg) {

    console.log("sync error")
    $("#fileUpload").modal("hide");
    //records_detail_1
    // lookUploadFile(documentFile.documentLocalId);
    console.log("宋建强3"+"1"+event+"2"+data+"3"+msg);
});



//同步上传成功结果处理
$('#input-1a').on('filebatchuploadsuccess', function(event, data, reviewId, index) {

    console.log("sync success");
    console.log("宋建强4"+"1"+event+"2"+data+"4"+index);
});