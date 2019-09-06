layui.use([ 'layer', 'laypage'], function() {
    var
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage;
    var typeid
    var vue= new Vue({
        el: "#type",
        data: {
            typeList:{},
            foodList:{}
        },
        methods:{
            findFood:function(typeid) {
                findFood(typeid);

            },
            UpOrDown:function (foodid,foodstate,typeid) {
                UpOrDown(foodid,foodstate,typeid);
            }
        },
        created: function() {
            TypeLoardList();
            FoodLoardList(typeid);
        }
    })


    function TypeLoardList() {
        $.post("http://localhost:8080/restaurant/type/findAllTypeName.action",function(result){

            vue.typeList = result.data;
        })
    }

    function FoodLoardList(typeid) {
        if(typeid==undefined){
            typeid=0;
        }
        $.post("http://localhost:8080/restaurant/food/findFoodByTypeId.action",{"typeid":typeid},function(result){
            vue.foodList = result.data;
        })
    }

    function findFood(typeid) {
        FoodLoardList(typeid);
    }


    function UpOrDown(foodid,foodstate,typeid) {
        $.post("http://localhost:8080/restaurant/food/UpOrDownFoodState.action",{"foodid":foodid,"foodstate":foodstate},
            function (result) {
                if(result.code==0){
                    console.log(typeid);
                    FoodLoardList(typeid);
                }else {
                    layer.msg("失败");
                }
            })
    }
})