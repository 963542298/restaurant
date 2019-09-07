layui.use(['layer','form'], function() {
    var form = layui.form,
        layer = layui.layer;
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('main1'));//  饼数据
    var dataEchars = [];
    // 柱状图横轴
    var dataBottom = [];
    // 柱状图纵轴
    var dataHight = [];

    $.post("http://localhost:8080/restaurant/orders/queryOrder.action?type=1",function (result) {
        if(result.code == 0){
            var orderUtils = result.data;
            dataEchars = [];
            // 柱状图横轴
            dataBottom = [];
            // 柱状图纵轴
            dataHight = [];
            for (var i=0;i<orderUtils.length;i++) {
                var orderUtil = orderUtils[i];


                dataEchars.push({
                    value: orderUtil.count,
                    name: orderUtil.orders.ordertime
                });
                dataBottom.push(orderUtil.orders.ordertime);
                dataHight.push(orderUtil.count)
            }
            load();
        }
    })
    
    $("#query").click(function () {
        var type = $(".type").val();
        $.post("http://localhost:8080/restaurant/orders/queryOrder.action?type="+type,
            function (result) {
                if (result.code == 0 ){
                    var orderUtils = result.data;
                    dataEchars = [];
                    // 柱状图横轴
                    dataBottom = [];
                    // 柱状图纵轴
                    dataHight = [];
                    console.log(result.data)
                    for (var i=0;i<orderUtils.length;i++) {

                        var orderUtil = orderUtils[i];
                        dataEchars.push({
                            value: orderUtil.count,
                            name: orderUtil.orders.ordertime
                        });
                        dataBottom.push(orderUtil.orders.ordertime);
                        dataHight.push(orderUtil.count)
                    }
                }
                load();
            })
    })



    function load(){
        // 饼数据
        option = {
            //背景色
            backgroundColor: '#e2e2e2',
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            visualMap: {
                show: false,
                min: 10,
                max: 200,
                inRange: {
                    colorLightness: [0.5, 0.9]
                }
            },
            series: [{
                name: '',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: dataEchars.sort(function(a, b) {
                    return a.value - b.value
                }),
                roseType: 'angle',
                // 饼代表的名字
                label: {
                    normal: {
                        textStyle: {
                            color: '#808080'
                        }
                    }
                },
                // 饼线颜色
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: '#FF0000'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        // 饼的颜色
                        color: '#EE0000',
                        shadowBlur: 200,
                        //饼的阴影色
                        shadowColor: 'FFFACD'
                    }
                }
            }]
        };

        // 柱状图数据
        option1 = {
            //背景色
            backgroundColor: '#e2e2e2',
            xAxis: {
                type: 'category',
                boundaryGap : true,
                axisLabel:{
                    interval:0,  //类目全显
                    rotate:-45  //顺时针旋转45度
                },
                data: dataBottom
            },
            yAxis: {
                type: 'value'
            },
            series : [ {
                name : '数量',
                type : 'bar',
                barWidth : '50%',
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        textStyle: {
                            color: 'red'
                        }
                    }
                },
                data : dataHight,
            } ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        // 使用刚指定的配置项和数据显示图表。
        myChart1.setOption(option1);
    }
    form.render();
});