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

    $("button[lay-filter='userAdd']").click(function () {
        var userName = $("#userName").val();
        var userAge = $("#userAge").val();
        var userPhone = $("#userPhone").val();
        var userBirthday = $("#date").val();
        var userAddress = $("#userAddress").val();
        var userSex = $("input[name='sex'][type='radio']:checked").val();


        var jsonObject = {
            "username": userName,
            "userage": userAge,
            "userphone": userPhone,
            "userbirthday": userBirthday,
            "useraddress": userAddress,
            "usersex": userSex,
            "userstate": 0
        }


        $.post("http://localhost:8080/restaurant/addUser.action", jsonObject, function(result){





        });

    });
});