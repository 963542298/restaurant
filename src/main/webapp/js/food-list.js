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


        },
        created: function () {//创建时加载
            showAllFood()
        }
    })

    /**
     * 查询订单
     */
    function showAllFood(){
        $.post("http://localhost:8080/restaurant/food/showAllFood.action",function (result){
            console.log(result)
            if(result.code == 0){//查询成功
                app.list = result.data;
            }
        })
    }

})