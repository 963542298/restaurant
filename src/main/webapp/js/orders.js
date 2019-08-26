layui.use(['form', 'layer', 'laypage'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage;

    //创建VUEAPP
    var app = new Vue({
        el: "#app", //app作用域
        data: {
            list:{}
        },
        methods: { //定义VUE中函数
            findDetailsByOrdersId:function(ordersid){
                findDetailsByOrdersId(ordersid);
            }

        },
        created: function () {//创建时加载
            getOrderAll()
        }
    })

    /**
     * 查询订单
     */
    function getOrderAll(){
        $.post("http://127.0.0.1:8080/restaurant/orders/queryAll.action",function (result){
            console.log(result)
            if(result.code == 0){//查询成功
                app.list = result.data;
            }
        })
    }

    /**
     * 查询单个订单详情
     */
    function findDetailsByOrdersId(ordersid) {
        $.post("http://127.0.0.1:8080/restaurant/")
    }
})