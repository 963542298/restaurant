var url = "http://localhost:8080/restaurant/";
layui.use(['form', 'layer','upload'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        upload = layui.upload;

    //图片上传
    upload.render({
        elem: '#test8'
        ,url: 'addFood.action'
        ,auto: false
        //,multiple: true
        ,bindAction: '#test9'
        ,done: function(result){//获取响应的回调
            console.log(result)
            // 如果上传失败
            if(result.code != 0){
                return layer.msg('上传失败');
            }else{
                //上传成功
                return layer.msg('上传成功');
            }
        }
        ,error: function(){//错误回调
            // 演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });

    //创建VueApp
    var app = new Vue({
        el: "#addFoodApp", //app作用域
        data: {

        },
        methods: { //定义VUE中函数

        },
        created: function () {//创建时加载
            loadTypeList();
        }
    })

    /**
     * 点击事件(添加按钮)
     */
    $("button[lay-filter='addFood']").click(function () {
        var foodName = $(".foodName").val();
        var foodState = $(".foodState").val();
        var foodType = $(".foodType").val();
        $.post(url+"food/addFood.action",{
            "foodName":foodName,
            "foodState":foodState,
            "foodType":foodType
        },function (result) {
            if(result.code==0){
                layer.msg("添加成功");
            }else{
                layer.msg("添加失败:"+result.msg);
            }
        })
    })

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