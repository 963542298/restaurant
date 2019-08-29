$(function () {

    //选好了生成订单
    $("#ok").click(function () {
        var data = {};
        var foodList = new Array();
        foodList.push(1);
        foodList.push(2);
        foodList.push(3);

        var integerList = new Array();
        integerList.push(5);
        integerList.push(10);
        integerList.push(6)

        data.foodList = foodList;
        data.integerList = integerList;


        $.post("http://localhost:8080/restaurant/orders/addOrders.action",
            {"foodList":JSON.stringify(foodList),
            "integerList":JSON.stringify(integerList)},
            function (result) {
                console.log(result);
            })
    })
})

