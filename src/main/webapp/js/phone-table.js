layui.use(['form', 'layer'], function() {
    var layer = parent.layer === undefined ? layui.layer : parent.layer;


    //创建VUEAPP
    var app = new Vue({
        el: "#app", //app作用域
        data: {
            list:{}
        },
        methods: { //定义VUE中函数
        },
        created: function () {//创建时加载
            loadType();
        }
    });

    //加载菜品类型
    function loadType(){
        //192.168.2.202
        $.post("http://192.168.2.202:8080/restaurant/type/showAllType.action",function(result){
            if(result.code == 0){
                app.list = result.data;
            } else {
                layer.msg("菜品类型加载失败")
            }
        })
    }

    var app2 = new Vue({
        el: "#app2", //app作用域
        data: {
            typeList:{}
        },
        methods: { //定义VUE中函数
        },
        created: function () {//创建时加载
            loadFood();
        }
    });

    //加载菜品
    function loadFood(){
        $.post("http://192.168.2.202:8080/restaurant/type/typeAndFood.action",function(result){
            if(result.code == 0){
                app2.typeList = result.data;
            }
        })
    }


    //发送订单请求
    var tableCode = getQueryString("tableCode");
    $("#ok").click(function () {
        //取得所有的数量框
        var pList = $(".result");
        var foodList = [];
        var integerList = [];
        for(var i = 0; i<pList.length;i++){
            var num = parseInt($(".result").eq(i).html());
            if(num > 0){
                //取得食物id和数量
                var food = $(".result").eq(i).parent().prev().find("p");
                var foodid = food.attr("id");
                foodList.push(foodid);
                integerList.push(num);
            }
        }

        $.post("http://192.168.2.202:8080/restaurant/orders/addOrders.action",
            {"foodList":foodList.toString(),"integerList":integerList.toString(),"id":tableCode}
            ,function (result) {
                if(result.code == 0){
                    layer.msg("下单成功");
                } else {
                    layer.msg("下单成功");
                }
            })
    })
})




