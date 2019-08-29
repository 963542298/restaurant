layui.use(['carousel', 'form'], function(){
		  var carousel = layui.carousel
		  ,form = layui.form;
		  //图片轮播
		  carousel.render({
		    elem: '#test'
		    ,width: '1366px'
		    ,height: '400px'
		    ,interval: 4000
		  });
		  
		  var $ = layui.$, active = {
		    set: function(othis){
		      var THIS = 'layui-bg-normal'
		      ,key = othis.data('key')
		      ,options = {};
		      
		      othis.css('background-color', '#5FB878').siblings().removeAttr('style'); 
		      options[key] = othis.data('value');
		      ins3.reload(options);
		    }
		  };
		  
		  //监听开关
		  form.on('switch(autoplay)', function(){
		    ins3.reload({
		      autoplay: this.checked
		    });
		  });
		  
		  $('.demoSet').on('keyup', function(){
		    var value = this.value
		    ,options = {};
		    if(!/^\d+$/.test(value)) return;
		    
		    options[this.name] = value;
		    ins3.reload(options);
		  });
		  
		});