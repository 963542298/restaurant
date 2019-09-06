layui.use(['form', 'layer', 'laypage'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage;

    var vue= new Vue({
        el: "#app",
        data: {
            list:{}
        },
        created: function() {
            loadList();
        }
    })
    function loadList() {

        $.post("http://localhost:8080/restaurant/details/findFinishDetails.action",function(result){
            vue.list=result.data;
        })
    }
})