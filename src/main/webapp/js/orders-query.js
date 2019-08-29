layui.use(['form', 'layer', 'laypage'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        length,
        list = new Array();

        //创建VUEAPP
        app = new Vue({
        el: "#app", //app作用域
        data: {
            list:{}
        },
        methods: { //定义VUE中函数

        },
        created: function () {//创建时加载
            getDetails()
        }
    })


    function getDetails() {
        var ordersid = getQueryString("ordersid");
        $.post("http://localhost:8080/restaurant/details/queryAllDetails.action",
            {"ordersid":ordersid},function (result) {
                if(result.code == 0){//查询成功
                    app.list = result.data;
                } else {
                    layer.msg(result.message)
                }
            })
    }

    function getQueryString(name) {
        var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
        var r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }
})