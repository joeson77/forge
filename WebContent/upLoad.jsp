<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="js/jquery-2.2.3.min.js"></script>
<title>使用html5 FileReader获取图片，并异步上传到服务器(not iframe)</title>
<style type="text/css">
body {
	margin: 0px;
	background: #f2f2f0;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#img")
				.change(
						function() {
							var img = event.target.files[0];

							// 判断是否图片
							if (!img) {
								return;
							}

							// 判断图片格式
							if (!(img.type.indexOf('image') == 0 && img.type && /\.(?:jpg|png|gif)$/
									.test(img.name))) {
								alert('图片只能是jpg,gif,png');
								return;
							}

							var reader = new FileReader();
							reader.readAsDataURL(img);

							reader.onload = function(e) {
								//显示图片
								$('#showimg')
										.html(
												'<img src="' +this.result + '" width="100;">');
								$("#loadimg").click(function(){
									// ajax 上传图片
									$.post("UploadServlet", {
										img : e.target.result
									}, function(ret) {
										alert(ret);
										$("#imgpath").attr("value",ret);
									});
								});
							}
						})
	});
</script>

</head>

<body>
	<p class="title">使用html5 FileReader获取图片，并异步上传到服务器(not iframe)</p>
	<p>
		<input type="file" class="file" id="img">
	</p>
	<p class="showimg" id="showimg"></p>
	<input id="imgpath" name="proImg"
					class="easyui-validatebox" type="text">
	<button id="loadimg">上传</button>
</body>
</html>

<!-- url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				if (result == 0) {
					alert("inert error");
				} else {
					$('#dlg').dialog('close'); // close the dialog
					$('#dg').datagrid('reload'); // reload the user data
				}
			} -->