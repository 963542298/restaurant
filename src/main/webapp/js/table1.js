layui.use(['table','laypage','layer'], function() {
				var table = layui.table;
				var maxtime = 120 * 60;
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
				
				//解析location.href传来的地址
				var url = location.search
				var theRequest = new Object();	
				if(url.indexOf("?") != -1){
					str = url.substr(1);
					strs = str.split("&");
					 for ( var i = 0; i < strs.length; i++ ) {  
    					theRequest[strs[i].split("=")[0]] = (strs[i].split("=")[1]);
 					 }  
 					 console.log(theRequest);
				}
				
				
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
  					};
				});
				
				table.on('tool(test)', function(obj) {
					var data = obj.data;
					//var checkStatus = table.checkStatus(obj.config.id);
					console.log(obj)
					if(obj.event === 'fle') {
						layer.confirm('确定将桌号【'+data.tableCode+'】闲置？', 
						{icon:3,title: '提示信息'},
						function(index) {
							$.ajax({
								type:"post",
								url: "http://localhost:8080/restaurant/desk/updateTableState.action?tableState=0"+"&tableCode="+data.tableCode,
							});
							layer.close(index);
							location.href='table2.html';
						});
					} 
				});	
				
  				ptable=function(){	
					table.render({
						elem: '#test',
						url: 'http://localhost:8080/restaurant/desk/tables4.action?tableState=1',
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
								fixed: 'left',
								unresize:true,
								align: 'center'
							}, {
								field: 'tableState',
								title: '状态',
								unresize:true,
								align: 'center'
							}, {
								field: 'timer',
								title: '时间',
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
						
						done:function(data){
							$("[data-field='tableState']").children().each(function(){
								if($(this).text()=='1'){
									$(this).text("已使用")
								}else if($(this).text()=='0'){
									$(this).text("未使用")
								}
							});
							
							$("table>tbody>tr").each(function(){
								if($(this).find("td").eq(0).text() === theRequest.tableCode){
									setInterval("tim()", 1000);
									tim=function(){
					  					if(maxtime >= 0) {
											hours=Math.floor(maxtime / 3600);
											minutes = Math.floor(maxtime /60 %60 );
											seconds = Math.floor(maxtime % 60);
											msg = hours+"时"+ minutes + "分" + seconds +"秒";
											$(this).find("td").eq(2).text(msg);
											if(maxtime == 5 * 60) alert(theRequest.tableCode+"距离结束仅剩5分钟");
											--maxtime;
										} else {
											clearInterval(timer);
											alert("时间到，结束!");
										}
					  					
					  				};
									
								}
							});
							
						}
						
						
					});
					
				}

				ptable();
			});