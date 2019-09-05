var url = "http://localhost:8080/restaurant/";
layui.use(['form', 'layer'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : parent.layer;


    /**
     * 点击事件(添加菜品)
     */
    $("#addFood").click(function () {
        var foodName = $(".foodName").val();
        var foodState = $(".foodState").val();
        var foodType = $(".foodType").val();
        var foodPath = $(".filePath").val();
        $.post(url+"food/addFood.action",{
            "foodName":foodName,
            "foodState":foodState,
            "foodType":foodType,
            "foodPath":foodPath
        },function(res) {
            if(res.code == 0){
                layer.msg("添加成功")
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }else{
                layer.msg("添加失败")
            }
        })
    })

    /**
     * 加载类型下拉框
     */
    $(function () {
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
    })

    /**
     * 点击事件(添加菜品类型)
     */
    $("button[lay-filter='addType']").click(function () {
        var typeName = $(".typeName").val();
        $.post(url+"type/addType.action",{
            "typeName":typeName
        },function (result) {
            if(result.code==0){
                layer.msg("添加成功");
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }else{
                layer.msg("添加失败:"+result.msg);
            }
        })
    })

})