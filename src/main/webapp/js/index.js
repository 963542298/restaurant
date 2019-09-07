
$(function () {
    $("#out").click(function logout(){
        $.post("http://localhost:8080/restaurant/logout.action",function () {
            location.href="/restaurant/login.jsp"
        })

        })
})
