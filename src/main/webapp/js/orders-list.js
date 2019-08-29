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
     * 模糊查询
     */
    $("#query").click(function () {
        getOrderAll();
    })

    $("#reset").click(function () {
        $("#ordercode").val("");
        getOrderAll();
    })

    /**
     * 查询订单
     */
    //存储当前页的信息
    var curr;
    function getOrderAll(){
        //如果当前分页对象无值则进行赋值
        if(curr == undefined) {
            curr = 1;
        }

        var ordercode = $("#ordercode").val();
        $.post("http://localhost:8080/restaurant/orders/queryAll.action",
            {"page": curr,"orderCode":ordercode},
            function (result){
            if(result.code == 0){//查询成功
                app.list = result.data.list;
                var pageUtils = result.data;
                //分页代码
                laypage.render({
                    elem: "laypage", //当前要显示的dom对象[laypage]
                    count: pageUtils.total, //总共多少页
                    limit: pageUtils.pageSize, //显示页码的的显示总分
                    curr: curr, //当前页是第几页 便于分页插件显示
                    next: "下一页", //显示的文字
                    prev: "上一页", //显示的文字
                    skip: true, //是否显示跳转的UI
                    jump: function(obj, first) { //跳转时调用的函数
                        if(!first) { //first一个Boolean类，检测页面是否初始加载。非常有用，可避免无限刷新。
                            //将当前页赋给全局变量存储 便于下一次跳转
                            curr = obj.curr;
                            getOrderAll();
                        }
                    }
                });
            }
        })
    }

    /**
     * 查询单个订单详情
     */
    function findDetailsByOrdersId(ordersid) {
        layer.open({
            type: 2,
            area: ['700px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: 'orders-query.jsp?ordersid='+ordersid
        });
    }
})