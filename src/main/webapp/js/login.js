layui.use(['form', 'laydate'], function() {

	var form = layui.form,
		laydate = layui.laydate;

	$ = layui.jquery;

	laydate.render({
		elem: '.userBirthday'
	});




	//监听提交
	form.on('submit(login)', function(data) {
		//获取表单中的信息
		var name = $("input[name='accountname']").val();
		var pwd = $("input[name='accountpwd']").val();
		var jsonObject = {
				"accountname": name,
				"accountpwd": pwd,
				"m": "login",
				"alimit": 0
			}
		
		//1：请求提交的地址 2：数据  3：回调函数
		sendRequestNoJWT("POST", "restaurant/index.jsp", jsonObject, function(result) {
			//比较结果是否为0 正常
			if(result.code == 0) {
				//存储认证凭证
			} else {
				alert(result.msg);
			}
		});
		return false;
	});

	$("#btnRegister").click(function() {
		xadmin.open('注册', 'register.html', 490, 370);
	})

});