var url = "http://localhost:8080/restaurant/";
layui.use(['form', 'layer', 'laypage'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage;

    //创建VUEAPP
    var app = new Vue({
        el: "#app", //app作用域
        data: {
            datas:"",
        },
        methods: { //定义VUE中函数
            updateFoodState:function (foodId,foodName,foodState) {
                updateFoodState(foodId,foodName,foodState);
            },
            deleteFood:function (foodId,foodName) {
                deleteFood(foodId,foodName);
            },
            searchList:function () {
                searchList();
            },
            cleanForm:function () {
                cleanForm();
            },
            addFood:function () {
                addFood();
            },
            addType:function () {
                addType();
            }
        },
        created: function () {//创建时加载
            loadList();
            loadTypeList();
        }
    })

    /**
     * 查询菜品
     */
    var curr;
    function loadList(){

        if(curr == undefined){
            curr = 1;
        }

        var pageSize = 10;
        var foodName = $(".foodName").val();
        var foodState = $(".foodState").val();
        var foodType = $(".foodType").val();
        $.post(url+"food/showAllFood.action",{
            "foodName":foodName,
            "foodState":foodState,
            "foodType":foodType,
            "page":curr,
            "pageSize":pageSize
        },function (result){
            app.datas=result.list;
            laypage.render({
                elem: 'pageUtil'
                ,count: result.total
                ,curr:curr
                ,limit:pageSize
                ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
                ,jump: function(obj,first){
                    if(!first) { //判断是否为第一次
                        curr = obj.curr;
                        loadList();
                    }
                }
            });
        });
    }

    /**
     * 添加菜品
     */
    function addFood(){
        var index = layui.layer.open({
            title: "添加菜品",
            area: ['500px', '480px'],
            type: 2,
            content: "addFood.jsp"
        })
    }

    /**
     * 添加菜品类型
     */
    function addType(){
        var index = layui.layer.open({
            title: "添加菜品类型",
            area: ['200px', '140px'],
            type: 2,
            content: "addType.jsp"
        })
    }

    /**
     * 删除
     */
    function deleteFood(foodId,foodName){
        layer.confirm('确定删除[' + foodName + ']?', {
            icon: 3,
            title: '提示信息'
        }, function(index) {
            $.post(url+"food/deleteFood.action", {
                "foodId": foodId
            }, function(result) {
                if(result.code == 0) {
                    layer.msg("删除成功");
                    loadList();
                } else {
                    layer.msg("删除失败");
                }
                layer.close(index);
            });
        });
    }

    /**
     * 修改状态
     */
    function updateFoodState(foodId,foodName,foodState){
        //为0 则进行下架
        if(foodState == 0) {
            layer.confirm('确定下架[' + foodName + ']?', {
                icon: 3,
                title: '提示信息'
            }, function(index) {
                $.post(url+"food/updateFoodState.action", {
                    "foodId": foodId,
                    "foodState":foodState
                }, function(result) {
                    if(result.code == 0) {
                        layer.msg("下架成功");
                        loadList();
                    } else {
                        layer.msg("下架失败");
                    }
                    layer.close(index);
                })
            });
        } else { //其它为1则进行上架
            layer.confirm('确定上架[' + foodName + ']?', {
                icon: 3,
                title: '提示信息'
            }, function(index) {
                $.post(url+"food/updateFoodState.action", {
                    "foodId": foodId,
                    "foodState":foodState
                }, function(result) {
                    if(result.code == 0) {
                        layer.msg("上架成功");
                        loadList();
                    } else {
                        layer.msg("上架失败");
                    }
                    layer.close(index);
                })
            });
        }
    }

    /**
     * 查询
     */
    function searchList(){
        loadList();
    }

    /**
     * 重置
     */
    function cleanForm() {
        $(".foodName").val("");
        $(".foodState").val("");
        $(".foodType").val("");
        form.render();
        loadList();
    }

    /**
     * 加载菜品类型下拉框
     */
    function loadTypeList(){
        $.post(url+"type/showAllType.action",function (result) {
            if (result.code == 0){
                if(result.code == 0) {
                    //找到类型下拉框
                    var foodType = $("select[name='foodType']");
                    for(var i = 0; i < result.data.length; i++) {
                        var type = result.data[i];
                        //组装选项
                        var opt = "<option value='" + type.typeid + "'>" + type.typename + "</option>";
                        //添加到选项中
                        foodType.append(opt);
                    }
                    //表单重新渲染
                    form.render('select');
                } else if(result.code == 1) {
                    layer.msg("未找到分类数据");
                }
            }
        })
    }

})