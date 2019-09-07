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
					tableCode: $("#demoReload").val()
				}
			},'data');
		}

	};
	//监听行工具事件
	table.on('tool(test)', function(obj) {
		var data = obj.data;
		var timer = 1;
		//var checkStatus = table.checkStatus(obj.config.id);
		console.log(obj)
		if(obj.event === 'start') {
			layer.confirm('确定将桌号【'+data.tableCode+'】启用？',
				{icon:3,title: '提示信息'},
				function(index) {
					$.ajax({
						type:"post",
						url: "http://localhost:8080/restaurant/desk/updateTableState.action",
						data:{"tableState":1,"tableCode":data.tableCode},
					});
					layer.open({
						type:2,
						area:['290px','320px'],
						title:'桌号'+data.tableCode,
						content:'QRcode.jsp?tableCode='+data.tableCode,
						end:function(){
							location.href='tableFinish.jsp';
						}
					});
					layer.close(index);
				});
		}
	});


	//重置
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
		};
	});

	ptable=function(){
		table.render({
			elem: '#test',
			url: 'http://localhost:8080/restaurant/desk/tables4.action?tableState=0',
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
					field: 'tableCode',
					title: '桌号',
					unresize:true,
					fixed: 'left',
					align: 'center'
				}, {
					field: 'tableState',
					title: '状态',
					unresize:true,
					align: 'center'
				}, {
					fixed: 'right',
					title: '操作',
					unresize:true,
					toolbar: '#barDemo',
					width: 180,
					align: 'center'
				}]
			],
			id: 'testReload',
			page:{layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'],
				theme:'#1E9FFF'},

			done:function(res){
				$("[data-field='tableState']").children().each(function(){
					if($(this).text()=='1'){
						$(this).text("已使用")
					}else if($(this).text()=='0'){
						$(this).text("未使用")
					}
				});

				$("[data-field='timer']").children().each(function(){
					if($(this).text()==""){
						$(this).text("初始值为2小时");
					}
				});
			}
		});

	}
	ptable();
});