<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-28
  Time: 下午 7:10
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" import="java.lang.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加菜品</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">

</head>
<body>
<form class="layui-form" style="width: 80%;">
    <div class="layui-form-item">
        <label class="layui-form-label">菜品名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input foodName" style="width: 212px" placeholder="请输入菜品名" maxlength="12">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜品类型</label>
            <div class="layui-input-block">
                <select name="foodType" class="foodType" lay-filter="foodType">
                    <option value="-1"></option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜品状态</label>
            <div class="layui-input-block">
                <select name="foodState" class="foodState" lay-filter="foodState">
                    <option value="-1"></option>
                    <option value="0">直接上架</option>
                    <option value="1">暂时下架</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜品图片</label>
            <div class="layui-input-block">
                <div class="layui-col-xs8">
                    <input id="fileName" type="text" lay-verify="fileName" autocomplete="off" class="layui-input" disabled>
                </div>
                <div class="layui-col-xs4">
                    <input class="layui-btn" id="preview_img" type="button" value="上传图片">
                </div>
            </div>
        </div>
        <input id="credential_hide" name="credentialOne" type="hidden" lay-verify="credentialOne" autocomplete="off" class="layui-input filePath">
        <div class="layui-inline">
            <div class="layui-collapse" lay-accordion="" style="width: 399px;">
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title">展开图片</h2>
                    <div class="layui-colla-content layui" id="colla_img" style="">
                        <img class="layui-upload-img" id="demo1">
                    </div>
                    <button id="upload_img" type="button" hidden>确认提交</button>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="button" class="layui-btn" id="addFood" value="添加菜品"/>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../lib/layui/layui.all.js"></script>
<script type="text/javascript" src="../js/addFood.js"></script>
<script>
    layui.use(['form', 'layer', 'upload'], function () {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer,
            upload = layui.upload;

        /*上传图片*/
        upload.render({
            elem: '#preview_img'
            , url: 'http://localhost:8080/restaurant/food/uploadImage.action'
            , size: 1024
            , auto: false //不自动上传
            , bindAction: '#upload_img' //上传事件绑定到隐藏按钮
            , choose: function (obj) {
                //预读本地文件
                obj.preview(function (index, file, result) {
                    $('#fileName').val(file.name);  //展示文件名
                    $('#demo1').attr('src', result); //展示图片
                    $('#upload_img').removeAttr('hidden'); //显示隐藏按钮
                    $('#preview_img').attr('value','修改图片');
                })
            }
            , done: function (res) {
                if(res.code == 0){
                    layer.msg("上传成功");
                    $('#credential_hide').val("");//修改上传图片时先清空输入框
                    $('#credential_hide').val(res.data); //隐藏输入框赋值(文件路径)
                    $('#submitForm').click(); //上传成功后单击隐藏的提交按钮
                } else {
                    layer.msg("上传失败")
                }

            }
            , error: function (index, upload) {
                layer.msg('上传失败！' + index, {icon: 5});
            }
        });

        //确定按钮点击事件
        $('#fake').click(function () {
            $(this).attr({'disabled': 'disabled'});
            $('#upload_img').click();//单击隐藏的上传按钮
        });

        /*监听提交*/
        form.on('submit(add_recharge_submit)', function (data) {
            addRecharge(data.field);
            return false;
        });
    });

</script>
</body>
</html>
