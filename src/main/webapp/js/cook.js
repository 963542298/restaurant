layui.use(['form', 'layer', 'laypage'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage;

    var vue= new Vue({
        el: "#app",
        data: {
            list:{}
        },
        methods:{
            editDetailsState:function (detailsid) {
                editDetailsState(detailsid);
            }
        },
        created: function() {
            loadList();
        }
    })

    function editDetailsState(detailsid) {
        $.post("http://localhost:8080/restaurant/details/editDetailsState.action",{"detailsId":detailsid},function(result){
            if(result.code==0){
                layer.msg("修改成功");
                //重新加载
                loadList();
            }else{
                layer.msg("修改失败");
            }
        })
    }


    function loadList() {

        $.post("http://localhost:8080/restaurant/details/findAllDetails.action",function(result){
            vue.list=result.data;
        })
    }
})