layui.use(['form','laydate', 'layer','jquery'], function() {
    $ = layui.jquery;
    var form = layui.form,
        layer = layui.layer;
    form.render();
    var laydate = layui.laydate;
    laydate.render({
        elem: "#date",
        trigger: "click"
    });

    $("button[lay-filter='userEdit']").click(function () {

        var userName = $("#userName").val();
        var userAge = $("#userAge").val();
        var userPhone = $("#userPhone").val();
        var userBirthday = $(".userBirthday").val();
        var userAddress = $("#userAddress").val();
        var userSex = $("input[name='sex'][type='radio']:checked").val();


        var jsonObject = {
            "userid":etQueryString("userid"),
            "username": userName,
            "userage": userAge,
            "userphone": userPhone,
            "userbirthday":userBirthday,
            "useraddress": userAddress,
            "usersex": userSex,
            "userstate": 0
        }
        console.log(jsonObject);
        $.post("http://localhost:8080/restaurant/editUser.action",jsonObject
            , function(result){
                if(result.code==0){
//					layer.closeAll("iframe");
                    setTimeout(function(){//设置定时器
                        parent.location.reload(true);//刷新父级页面
                        var index = parent.layer.getFrameIndex(window.name);//获取当前弹窗的Id
                        parent.layer.close(index);//关闭
                    },500);
                    layer.msg(result.message);
                }
            });
    });

    $.post("http://localhost:8080/restaurant/findUserById.action" ,{"userid":getQueryString("userid")},function (result) {
        if(result.code == 0){//请求正常
            var user = result.data;
            $("#userName").val(user.username);
            $("#userAge").val(user.userage);
            $("input[name='sex'][value="+user.sex+"]").attr("checked",true);
            $(".userBirthday").val(user.userbirthday);
            $("#userPhone").val(user.userphone);
            $("#userAddress").val(user.useraddress);
        }else{
            layer.open({
                type: 1,
                title: false,
                closeBtn: 1,
                area: ['200px', '150px'],
                content: result.message
            });
        }
        
    })
});