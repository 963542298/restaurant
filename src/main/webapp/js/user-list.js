layui.use(['table','laypage','layer'], function() {
    var table = layui.table;
    var laypage = layui.laypage
        ,layer = layui.layer;
    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload');
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {

                    userName: $("#demoReload").val()
                }
            },'data');
        }
    };
    //监听行工具事件
    table.on('toolbar(test)', function(obj){
        var data = obj.data;
        console.log(obj);

        switch(obj.event){
            case 'select':
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
                break;
            case 'reset':
                ptable();
                $("#demoReload").val('');
                break;
            case 'addUser':
                var index = layui.layer.open({
                    title: "添加用户",
                    area: ['500px', '480px'],
                    type: 2,
                    content: "userAdd.jsp"
                })


        };
    });

    table.on('tool(test)', function(obj) {
        var data = obj.data;
        //var checkStatus = table.checkStatus(obj.config.id);
        console.log(obj)
        if(obj.event === 'fle') {
            if(data.userstate==1){
                layer.confirm('确定将人员【'+data.username+'】锁定？',
                    {icon:3,title: '提示信息'},
                    function(index) {
                        $.ajax({
                            type:"post",
                            url: "http://localhost:8080/restaurant/updateUserState.action?userState=0"+"&userId="+data.userid,
                        });
                        layer.close(index);
                        ptable();
                    });
            }else if(data.userstate==0){
                layer.confirm('确定将人员【'+data.username+'】解锁？',
                    {icon:3,title: '提示信息'},
                    function(index) {
                        $.ajax({
                            type:"post",
                            url: "http://localhost:8080/restaurant/unlockUserState.action?userState=1"+"&userId="+data.userid,
                        });
                        layer.close(index);
                        ptable();
                    });
            }

        }

        if(obj.event==='del'){
            layer.confirm('确定将人员【'+data.username+'】删除？',
                {icon:3,title: '提示信息'},
                function(index) {
                    $.ajax({
                        type:"post",
                        url: "http://localhost:8080/restaurant/deleteUser.action?&userid="+data.userid,
                    });
                    layer.close(index);
                    ptable();
                });
        }

        if(obj.event==='edit'){
            var index = layui.layer.open({
                title: "编辑信息",
                area: ['500px', '480px'],
                type: 2,
                content: "userEdit.jsp?&userid="+data.userid
            })
        }

    });


    ptable=function(){
        table.render({
            elem: '#test',
            url: 'http://localhost:8080/restaurant/showUser.action',
            method:'post',
            toolbar: '#toolbarDemo',
            title: '用户数据表',
            theme: '#FFB800',
            parseData:function(res){
                console.log(res);
                return{
                    "data":res.list,
                    "code":0,
                    "msg":"",
                    "count":res.total
                };
            },

            cols: [
                [{
                    field: 'username',
                    title: '名字',
                    fixed: 'left',
                    align: 'center'
                }, {
                    field: 'userage',
                    title: '年龄',
                    align: 'center'
                }, {
                    field: 'usersex',
                    title: '性别',
                    //sort: true,
                    align: 'center'
                }, {
                    field: 'userbirthday',
                    title: '出生日期',
                    //sort: true,
                    align: 'center'
                }, {
                    field: 'userphone',
                    title: '电话',
                    //sort: true,
                    align: 'center'
                },{
                    field: 'userstate',
                    title: '状态',
                    //sort: true,
                    align: 'center'
                }, {
                    field: 'useraddress',
                    title: '地址',
                    //sort: true,
                    align: 'center'
                }, {
                    fixed: 'right',
                    title: '操作',
                    toolbar: '#barDemo',
                    width: 180,
                    align: 'center'
                }]
            ],
            id: 'testReload',
            page:{layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'],
                theme:'#1E9FFF'},

            done:function(data){
                $("[data-field='userstate']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("超级会员")
                    }else if($(this).text()=='0'){
                        $(this).text("普通用户")
                    }
                });
                $("[data-field='usersex']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("男")
                    }else if($(this).text()=='2'){
                        $(this).text("女")
                    }
                });

            }
        });
    }
    ptable();
});