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



    //根据出生日期算出年龄
    function jsGetAge(strBirthday){
        var returnAge;
        var strBirthdayArr=strBirthday.split("-");
        var birthYear = strBirthdayArr[0];
        var birthMonth = strBirthdayArr[1];
        var birthDay = strBirthdayArr[2];

        var d = new Date();
        var nowYear = d.getFullYear();
        var nowMonth = d.getMonth() + 1;
        var nowDay = d.getDate();

        if(nowYear == birthYear){
            returnAge = 0;//同年 则为0岁
        }
        else{
            var ageDiff = nowYear - birthYear ; //年之差
            if(ageDiff > 0){
                if(nowMonth == birthMonth) {
                    var dayDiff = nowDay - birthDay;//日之差
                    if(dayDiff < 0)
                    {
                        returnAge = ageDiff - 1;
                    }
                    else
                    {
                        returnAge = ageDiff ;
                    }
                }
                else
                {
                    var monthDiff = nowMonth - birthMonth;//月之差
                    if(monthDiff < 0)
                    {
                        returnAge = ageDiff - 1;
                    }
                    else
                    {
                        returnAge = ageDiff ;
                    }
                }
            }
            else
            {
                returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
            }
        }
        return returnAge;//返回周岁年龄
    }

    $("button[lay-filter='userAdd']").click(function () {
        var userName = $("#userName").val();

        var userPhone = $("#userPhone").val();
        var userBirthday = $(".userBirthday").val();
        var userAge = jsGetAge(userBirthday);
        var userAddress = $("#userAddress").val();
        var userSex = $("input[name='sex'][type='radio']:checked").val();


        var jsonObject = {
            "username": userName,
            "userage": userAge,
            "userphone": userPhone,
            "userbirthday":userBirthday,
            "useraddress": userAddress,
            "usersex": userSex,
            "userstate": 0
        }
        $.post("http://localhost:8080/restaurant/addUser.action",jsonObject
            , function(result){
                if(result.code==0){
//					layer.closeAll("iframe");
                    setTimeout(function(){//设置定时器
                        parent.location.reload(true);//刷新父级页面
                        var index = parent.layer.getFrameIndex(window.name);//获取当前弹窗的Id
                        parent.layer.close(index);//关闭
                    },500);
                    layer.msg(result.message);
                }else{
                    layer.msg(result.message);
                }

            });

    });
});